package org.myfoodplugin.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.sql.PreparedStatement;

import org.compiere.model.MSysConfig;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.zkoss.zk.ui.util.Clients;

public class MFCOrder extends X_FC_Order {

	private static final long serialVersionUID = 1L;

	public MFCOrder(Properties ctx, int FC_Order_ID, String trxName, String... virtualColumns) {
		super(ctx, FC_Order_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MFCOrder(Properties ctx, int FC_Order_ID, String trxName) {
		super(ctx, FC_Order_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MFCOrder(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MFCOrder(Properties ctx, String FC_Order_UU, String trxName, String... virtualColumns) {
		super(ctx, FC_Order_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MFCOrder(Properties ctx, String FC_Order_UU, String trxName) {
		super(ctx, FC_Order_UU, trxName);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected boolean beforeDelete() {
		    int gmUserId = MSysConfig.getIntValue("GM_ADMIN_USER_ID", 100, getAD_Client_ID());
		    int iTUserId = MSysConfig.getIntValue("GM_IT_USER_ID", 101, getAD_Client_ID());
		    int adUserId = Env.getAD_User_ID(getCtx());
		    Timestamp now = new Timestamp(System.currentTimeMillis());
		    int userId = getAD_User_ID();
		    
		    // 取得 `ValidTo`
		    Timestamp validTo = getValidTo();

		    String getShopSql = "SELECT GM_Shop_ID FROM GM_Shop WHERE Name='*' LIMIT 1";
		    int shopId = DB.getSQLValue(get_TrxName(), getShopSql);
		    if (shopId == (int) getGM_Shop_ID()) {
		        log.saveError("Error", "儲值紀錄不可刪除！");
		        return false;
		    }

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

		        // 檢查刪除條件
		        if (now.after(validTo)) {
		            if ((gmUserId == adUserId || iTUserId == adUserId) && now.before(validToNextDayMidnight)) {
		                log.warning("管理員 " + adUserId + " 在有效期限後的隔天凌晨 00:00 前刪除了記錄。");
		            } else {
		                log.saveError("Error", "此次訂單已鎖定，無法刪除！ 有效期限：" + validTo);
		                return false; // 禁止刪除
		            }
		        }
		    }

		    if (getNetAmtToInvoice().compareTo(BigDecimal.ZERO) > 0) {
		        log.saveError("Error", "請先清空訂單(數量皆改為0)");
		        return false; // 禁止刪除
		    }

		    // 先刪除所有 `FC_OrderLine`
		    String deleteOrderLineSql = "DELETE FROM FC_OrderLine WHERE FC_Order_ID=?";
		    int deletedRows = DB.executeUpdate(deleteOrderLineSql, new Object[] { getFC_Order_ID() }, false, get_TrxName());
		    log.warning("使用者：" + userId + " 刪除了 " + deletedRows + " 筆訂單明細");

		    return super.beforeDelete(); // 允許刪除 `FC_Order`
	}

	@Override
	protected boolean beforeSave(boolean newRecord) {
	    Timestamp now = new Timestamp(System.currentTimeMillis());
	    Timestamp validTo = getValidTo();

	    // 取得 GM 管理員的 User ID
	    int gmUserId = MSysConfig.getIntValue("GM_ADMIN_USER_ID", 100, getAD_Client_ID());
	    int iTUserId = MSysConfig.getIntValue("GM_IT_USER_ID", 101, getAD_Client_ID());
	    int adUserId = Env.getAD_User_ID(getCtx());

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

	        // 檢查是否允許儲存
	        if (now.after(validTo)) {
	            if ((gmUserId == adUserId || iTUserId == adUserId) && now.before(validToNextDayMidnight)) {
//	                log.warning("管理員 " + adUserId + " 在有效期限後的隔天凌晨 00:00 前新增/修改了訂單。");
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

		if (!success)
			return false; // 如果存檔失敗，不執行後續操作
		int orderId = getFC_Order_ID();
		
		// 如果該orderline已存在跳過新增
		String sql = "SELECT COUNT(*) FROM FC_OrderLine WHERE FC_Order_ID=?";
		int count = DB.getSQLValue(get_TrxName(), sql, orderId);
		if (count > 0) {
//			System.out.println("FC_OrderLine 已存在，跳過自動新增");
			return true;
		}

		// 取得 GM_Shop_ID
		int gmShopId = getGM_Shop_ID();

		if (gmShopId <= 0) {
			log.saveError("Error", "尚未開放訂餐！");
//			System.out.println("未找到 GM_Shop_ID，無法新增訂單明細");
			return true;
		}

		BigDecimal priceValue = (BigDecimal) getValueNumber();
		if (priceValue.compareTo(BigDecimal.ZERO) < 0) {
			Clients.evalJavaScript("alert('餘額小於0，已負債請盡快儲值！！')");
		}

		// 取得 GM_FoodMenu_ID 和 Price
		String menuSql = "SELECT GM_FoodMenu_ID, Price, GM_FoodType_ID FROM GM_FoodMenu WHERE GM_Shop_ID=?";
		List<Integer> menuList = new ArrayList<>();
		Map<Integer, BigDecimal> priceMap = new HashMap<>();
		Map<Integer, Integer> foodTypeIdMap = new HashMap<>();

		try (PreparedStatement pstmt = DB.prepareStatement(menuSql, get_TrxName())) {
			pstmt.setInt(1, gmShopId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int foodMenuId = rs.getInt("GM_FoodMenu_ID");
				BigDecimal price = rs.getBigDecimal("Price");
				int foodTypeID = rs.getInt("GM_FoodType_ID");
				menuList.add(foodMenuId);
				priceMap.put(foodMenuId, price);
				foodTypeIdMap.put(foodMenuId, foodTypeID);

			}
		} catch (Exception e) {
//			System.out.println("取得 GM_FoodMenu 失敗：" + e.getMessage());
			return true;
		}

		// 沒找到東西
		if (menuList.isEmpty()) {
//			System.out.println("沒有找到 GM_FoodMenu，無法新增訂單明細");
			return true;
		}
//		System.out.println("找到 GM_FoodMenu：" + menuList.size() + " 筆");
		BigDecimal qtyOrdered = BigDecimal.ZERO; // 預設數量 0
		BigDecimal LineNetAmt = BigDecimal.ZERO; // 預設數量 0
		String getCustomizedSql = "SELECT GM_Customized_ID FROM GM_Customized WHERE Name='無' LIMIT 1";
		Integer customizedId = DB.getSQLValue(get_TrxName(), getCustomizedSql);

		Timestamp validTo = getValidTo();
		int userId = getAD_User_ID();
		int shopId = getGM_Shop_ID();

		for (Integer foodMenuId : menuList) {
			MFCOrderLine orderLine = new MFCOrderLine(getCtx(), 0, get_TrxName());
			BigDecimal price = priceMap.get(foodMenuId);
			int foodTypeId = foodTypeIdMap.get(foodMenuId);

			orderLine.setFC_Order_ID(orderId); // 關聯 FC_Order
			orderLine.setGM_FoodMenu_ID(foodMenuId); // 設定 GM_FoodMenu_ID
			orderLine.setPriceActual(price); // 設定價格
			orderLine.setQtyOrdered(qtyOrdered);
			orderLine.setLineNetAmt(LineNetAmt);
			orderLine.setAD_User_ID(userId);
			orderLine.setGM_FoodType_ID(foodTypeId);
			orderLine.setIsActive(true);
			orderLine.setGM_Customized_ID(customizedId);
			orderLine.setValidTo(validTo);
			orderLine.setGM_Shop_ID(shopId);
			orderLine.saveEx(); // 儲存 `FC_OrderLine`
		}

		return super.afterSave(newRecord, success);
	}

}
