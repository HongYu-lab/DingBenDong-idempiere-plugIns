package org.myfoodplugin.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.util.DB;

public class MFoodCoinLine extends X_GM_FoodCoinLine {

	private static final long serialVersionUID = 1L;

	public MFoodCoinLine(Properties ctx, int GM_FoodCoinLine_ID, String trxName, String... virtualColumns) {
		super(ctx, GM_FoodCoinLine_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MFoodCoinLine(Properties ctx, int GM_FoodCoinLine_ID, String trxName) {
		super(ctx, GM_FoodCoinLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MFoodCoinLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MFoodCoinLine(Properties ctx, String GM_FoodCoinLine_UU, String trxName, String... virtualColumns) {
		super(ctx, GM_FoodCoinLine_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MFoodCoinLine(Properties ctx, String GM_FoodCoinLine_UU, String trxName) {
		super(ctx, GM_FoodCoinLine_UU, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {

		if (!success) {
			return false; // 如果存檔失敗，不執行後續操作
		}

		int userId = getAD_User_ID();
		BigDecimal deposit = getValueNumber();
		Timestamp dateAcc = getDateAcct();

		// 取得當前便當金
		String sqlCoinAmt = "SELECT ValueNumber FROM GM_FoodCoin WHERE AD_User_ID=? FOR UPDATE";
		BigDecimal currentBalance = DB.getSQLValueBD(get_TrxName(), sqlCoinAmt, userId);

		if (currentBalance == null) {
			currentBalance = BigDecimal.ZERO;
		}
		BigDecimal newBalance = currentBalance.add(deposit);


		String updateCoinSql = "UPDATE GM_FoodCoin SET ValueNumber=?,DateAcct = ? WHERE AD_User_ID=?";
		DB.executeUpdate(updateCoinSql, new Object[] { newBalance, dateAcc, userId }, false, get_TrxName());

		String getFloorSql = "SELECT GM_Floor_ID FROM GM_Floor WHERE Name='*' LIMIT 1";
		int floorId = DB.getSQLValue(get_TrxName(), getFloorSql);

		String getShiftSql = "SELECT GM_Shift_ID FROM GM_Shift WHERE Name='*' LIMIT 1";
		int shiftId = DB.getSQLValue(get_TrxName(), getShiftSql);

		String getShopSql = "SELECT GM_Shop_ID FROM GM_Shop WHERE Name='*' LIMIT 1";
		int shopId = DB.getSQLValue(get_TrxName(), getShopSql);

		String getValidToSql = "SELECT DateConfirm FROM GM_Shop WHERE Name='*' LIMIT 1";
		Timestamp validTo = DB.getSQLValueTS(get_TrxName(), getValidToSql);

		MFCOrder order = new MFCOrder(getCtx(), 0, get_TrxName());
		order.setDescription("儲值金額：" + deposit);
		order.setAD_User_ID(userId);
		order.setGM_Floor_ID(floorId);
		order.setGM_Shift_ID(shiftId);
		order.setGM_Shop_ID(shopId);
		order.setValidTo(validTo);
		order.setDateOrdered(dateAcc);
		order.saveEx(); // 儲存 FC_Order 記錄
		
		return super.afterSave(newRecord, success);
	}

}
