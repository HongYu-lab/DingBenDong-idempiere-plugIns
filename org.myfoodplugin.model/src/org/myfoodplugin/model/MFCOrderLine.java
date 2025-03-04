package org.myfoodplugin.model;

import java.math.BigDecimal;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Properties;

import org.compiere.model.MSysConfig;
import org.compiere.util.DB;
import org.compiere.util.Env;

import java.sql.PreparedStatement;

public class MFCOrderLine extends X_FC_OrderLine {

	private static final long serialVersionUID = 1L;

	public MFCOrderLine(Properties ctx, int FC_OrderLine_ID, String trxName, String... virtualColumns) {
		super(ctx, FC_OrderLine_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MFCOrderLine(Properties ctx, int FC_OrderLine_ID, String trxName) {
		super(ctx, FC_OrderLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MFCOrderLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MFCOrderLine(Properties ctx, String FC_OrderLine_UU, String trxName, String... virtualColumns) {
		super(ctx, FC_OrderLine_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MFCOrderLine(Properties ctx, String FC_OrderLine_UU, String trxName) {
		super(ctx, FC_OrderLine_UU, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean beforeDelete() {
		log.saveError("Error", "無法刪除菜單！若要刪除請直接刪除相應的訂單資訊！");
		return false; // 禁止刪除

//		return super.beforeDelete();
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
	    Timestamp now = new Timestamp(System.currentTimeMillis());
	    int orderId = getFC_Order_ID();

	    // 取得 GM 管理員的 User ID
	    int gmUserId = MSysConfig.getIntValue("GM_ADMIN_USER_ID", 100, getAD_Client_ID());
	    int adUserId = Env.getAD_User_ID(getCtx());

	    // 查詢 ValidTo
	    String getValidToSql = "SELECT ValidTo FROM FC_Order WHERE FC_Order_ID = ?";
	    Timestamp validTo = DB.getSQLValueTS(get_TrxName(), getValidToSql, orderId);

	    if (validTo != null) {
	        // 計算 validTo 隔天凌晨 00:00
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(validTo);
	        cal.add(Calendar.DAY_OF_MONTH, 1);
	        cal.set(Calendar.HOUR_OF_DAY, 0);
	        cal.set(Calendar.MINUTE, 0);
	        cal.set(Calendar.SECOND, 0);
	        cal.set(Calendar.MILLISECOND, 0);
	        Timestamp validToNextDayMidnight = new Timestamp(cal.getTimeInMillis());

	        // 一般使用者無法修改超過 validTo 的訂單
	        if (now.after(validTo)) {
	            if (gmUserId == adUserId && now.before(validToNextDayMidnight)) {
//	                log.warning("管理員 " + adUserId + " 在有效期限後的隔天凌晨 00:00 前修改了訂單。");
	            } else {
	                log.saveError("Error", "此次訂餐時間已過，無法修改與新增！ 有效期限：" + validTo);
	                return false; // 禁止儲存
	            }
	        }
	    }

	    return super.beforeSave(newRecord);
	}


	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {

		if (!success) {
			return false; // 如果存檔失敗，不執行後續操作
		}

		boolean result = super.afterSave(newRecord, success); // 確保 OrderLine 先儲存
		// 取得 `FC_Order_ID`
		int orderId = getFC_Order_ID();
		if (orderId <= 0) {
			return result; // 無效的 Order ID，直接返回
		}
		BigDecimal totalAmt = BigDecimal.ZERO;

		String getOldAmtSql = "SELECT COALESCE(TotalAmt, 0) FROM FC_Order WHERE FC_Order_ID=?";
		BigDecimal oldAmt = DB.getSQLValueBD(get_TrxName(), getOldAmtSql, orderId);

		if (oldAmt == null) {
			oldAmt = BigDecimal.ZERO; // 確保 oldAmt 不為 null
		}

		String getSubsidySql = "SELECT COALESCE(Subsidy, 0) FROM FC_Order WHERE FC_ORDER_ID = ?";
		BigDecimal subsidy = DB.getSQLValueBD(get_TrxName(), getSubsidySql, orderId);
		if (subsidy == null) {
			subsidy = BigDecimal.ZERO; // 確保 subsidy 不為 null
		}
		// 計算 FC_Order 內所有 OrderLine 的 LineNetAmt 總額
		String sql = "SELECT COALESCE(SUM(LineNetAmt), 0) FROM FC_OrderLine WHERE FC_Order_ID=?";
		BigDecimal netAmt = DB.getSQLValueBD(get_TrxName(), sql, orderId);
		if (netAmt == null) {
			netAmt = BigDecimal.ZERO; // 確保 netAmt 不為 null
		}
		// 減去補助額
		if (netAmt.compareTo(subsidy) > 0) {
			totalAmt = netAmt.subtract(subsidy);
		}

		// 取得訂單資料並印在備註上
		StringBuilder description = new StringBuilder();
		String getMenuSql = "SELECT GM_FoodMenu_ID, GM_Customized_ID, QtyOrdered FROM FC_OrderLine WHERE FC_Order_ID=? AND QtyOrdered > 0";

		try (PreparedStatement pstmt = DB.prepareStatement(getMenuSql, get_TrxName())) {
			pstmt.setInt(1, orderId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int foodMenuId = rs.getInt("GM_FoodMenu_ID");
				String getFoodMenuSql = "SELECT Name FROM GM_FoodMenu WHERE GM_FoodMenu_ID=? ";
				String foodMenu = DB.getSQLValueString(get_TrxName(), getFoodMenuSql, foodMenuId);

				BigDecimal Qty = rs.getBigDecimal("QtyOrdered");

				int customizedId = rs.getInt("GM_Customized_ID");
				String getCustomSql = "SELECT Name FROM GM_Customized WHERE GM_Customized_ID=? ";
				String customized = DB.getSQLValueString(get_TrxName(), getCustomSql, customizedId);
				description.append(foodMenu).append(": ").append(Qty.toString());

				if (!"無".equals(customized)) { // 當 customized 不是 "無" 才加上
					description.append("（").append(customized).append("）");
				}

				description.append("｜");

			}
		} catch (Exception e) {
			System.out.println("取得訂單資料失敗：" + e.getMessage());
			return true;
		}

		// 取得店家與儲值的ID
		String getDepositIdSql = "SELECT GM_Shop_ID FROM GM_Shop WHERE Name =? LIMIT 1";
		Integer depositId = DB.getSQLValue(get_TrxName(), getDepositIdSql, "*");
		String getShopIdSql = "SELECT GM_Shop_ID FROM FC_Order WHERE FC_Order_ID =? ";
		Integer shopId = DB.getSQLValue(get_TrxName(), getShopIdSql, orderId);

		// 更新Order
		String updateSql = "UPDATE FC_Order SET TotalAmt=? WHERE FC_Order_ID=?";
		DB.executeUpdate(updateSql, new Object[] { totalAmt, orderId }, false, get_TrxName());

		String updateSqlnetAmt = "UPDATE FC_Order SET NetAmtToInvoice=? WHERE FC_Order_ID=?";
		DB.executeUpdate(updateSqlnetAmt, new Object[] { netAmt, orderId }, false, get_TrxName());

		// 不是儲值的狀況才更新
		if (!shopId.equals(depositId)) {
			String updateSqlDescription = "UPDATE FC_Order SET Description=? WHERE FC_Order_ID=?";
			DB.executeUpdate(updateSqlDescription, new Object[] { description.toString(), orderId }, false,
					get_TrxName());
		}

		// 便當金

		int userId = getAD_User_ID();
		// 取得當前便當金
		String sqlCoinAmt = "SELECT ValueNumber FROM GM_FoodCoin WHERE AD_User_ID=? FOR UPDATE";
		BigDecimal currentBalance = DB.getSQLValueBD(get_TrxName(), sqlCoinAmt, userId);

		if (currentBalance == null) {
			log.saveError("Error", "找不到使用者的便當金！");
			return false;
		}

		// 計算餘額
		BigDecimal newBalance = currentBalance.subtract(totalAmt).add(oldAmt);

		if (newBalance.compareTo(new BigDecimal("-2000")) < 0) {
			log.saveError("Error", "餘額不足！您的可用餘額為：" + currentBalance + "，但訂單金額為：" + totalAmt + "已大量負債請盡快儲值！");
			return false;
		}

		// 更新order跟foodcoin
		String updateCoinSql = "UPDATE GM_FoodCoin SET ValueNumber=? WHERE AD_User_ID=?";
		DB.executeUpdate(updateCoinSql, new Object[] { newBalance, userId }, false, get_TrxName());
		String updateOrderCoinSql = "UPDATE FC_Order SET ValueNumber=? WHERE FC_Order_ID=?";
		DB.executeUpdate(updateOrderCoinSql, new Object[] { newBalance, orderId }, false, get_TrxName());

		Timestamp now = new Timestamp(System.currentTimeMillis());
		String updateNowSql = "UPDATE FC_Order SET updated=? WHERE FC_Order_ID=?";
		DB.executeUpdate(updateNowSql, new Object[] { now, orderId }, false, get_TrxName());

		return result;
	}

}
