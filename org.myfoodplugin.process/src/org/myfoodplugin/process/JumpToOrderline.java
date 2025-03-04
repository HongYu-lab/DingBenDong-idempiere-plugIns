package org.myfoodplugin.process;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.myfoodplugin.model.MFCOrder;

public class JumpToOrderline extends SvrProcess {

	private int recordID;
	private int floorId = 0;
	private int shiftId = 0;
	private int adUserId = 0;

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		recordID = getRecord_ID();
		adUserId = Env.getAD_User_ID(getCtx());

		// 取得參數
		ProcessInfoParameter[] params = getParameter();
		for (ProcessInfoParameter param : params) {
			String name = param.getParameterName();

			if (name.equals("GM_Floor_ID")) {
				floorId = param.getParameterAsInt();
			} else if (name.equals("GM_Shift_ID")) {
				shiftId = param.getParameterAsInt();
			}
		}

	}

	@Override
	protected String doIt() throws Exception {
		// TODO Auto-generated method stub

		if (recordID <= 0) {
			return "無效的記錄";
		}

		String shopSql = "SELECT GM_Shop_ID FROM GM_Shop WHERE HasServed='Y' LIMIT 1";
		int gmShopId = DB.getSQLValue(get_TrxName(), shopSql);
		String getValidToSql = "SELECT DateConfirm FROM GM_Shop WHERE GM_Shop_ID = ?";
		Timestamp validTo = DB.getSQLValueTS(get_TrxName(), getValidToSql, gmShopId);
		String sqlCoinAmt = "SELECT ValueNumber FROM GM_FoodCoin WHERE AD_User_ID=? FOR UPDATE";
		BigDecimal currentBalance = DB.getSQLValueBD(get_TrxName(), sqlCoinAmt, adUserId);
		Timestamp now = new Timestamp(System.currentTimeMillis());
		String getSubsidySql = "SELECT Subsidy FROM GM_Shift WHERE GM_Shift_ID = ?";
		BigDecimal subsidy = DB.getSQLValueBD(get_TrxName(), getSubsidySql, shiftId);
		
		/*驗證參數是否正確*/
		//取得相應的mealtype
		String mealTypeSql = "SELECT GM_MealType_ID FROM GM_Shop WHERE GM_Shop_ID = ?";
		int shopMealType = DB.getSQLValue(get_TrxName(), mealTypeSql, gmShopId);
		
		String shiftMealTypeSql = "SELECT GM_MealType_ID FROM GM_Shift WHERE GM_Shift_ID = ?";
		int shiftMealType = DB.getSQLValue(get_TrxName(), shiftMealTypeSql, shiftId);

		String floorMealTypeSql = "SELECT GM_MealType_ID FROM GM_Floor WHERE GM_Floor_ID = ?";
		int floorMealType = DB.getSQLValue(get_TrxName(), floorMealTypeSql, floorId);
		
		if (shiftMealType != shopMealType || floorMealType != shopMealType) {			
		    throw new AdempiereUserError("請確認輸入資料，或是重新整理清除快取");
		}

		
		MFCOrder order = new MFCOrder(getCtx(), 0, get_TrxName());
		order.setGM_Shop_ID(gmShopId);
		order.setGM_Floor_ID(floorId);
		order.setGM_Shift_ID(shiftId);
		order.setValueNumber(BigDecimal.ZERO);
		order.setValidTo(validTo);
		order.setSubsidy(BigDecimal.ZERO);
		order.setAD_User_ID(adUserId);
		order.setDateOrdered(now);
		order.setSubsidy(subsidy);

		try {
			order.saveEx(get_TrxName()); // 使用 saveEx() 以捕捉例外
		} catch (Exception e) {
			log.saveError("儲存失敗", e.getMessage()); // 記錄錯誤日誌
			throw new AdempiereUserError("訂單儲存失敗：" + e.getMessage()); // 顯示錯誤訊息給使用者
		}
//		System.out.println(shiftId);
//		String msg = Msg.parseTranslation(getCtx(), "@FC_Order_ID@ @Created@");
		String msg = "成功建立訂單，餘額為：" + currentBalance;
		if (currentBalance.compareTo(BigDecimal.ZERO) < 0) {

			msg = "成功建立訂單，餘額為：" + currentBalance + "您已負債請盡快儲值！！！您已負債請盡快儲值！！！您已負債請盡快儲值！！！";

		}
		addLog(order.getFC_Order_ID(), null, null, "點這裡選擇餐點！點這裡！", MFCOrder.Table_ID, order.getFC_Order_ID());
		return Msg.parseTranslation(getCtx(), msg);
	}

}
