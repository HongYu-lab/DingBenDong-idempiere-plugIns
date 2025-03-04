package org.myfoodplugin.process;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.myfoodplugin.model.MFCOrder;

public class JumpToOrderline extends SvrProcess {

	private int recordID;
	private int floorId = 0;
	private int shiftId = 0;

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		recordID = getRecord_ID();

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

		int adUserId = Env.getAD_User_ID(getCtx());

		String shopSql = "SELECT GM_Shop_ID FROM GM_Shop WHERE HasServed='Y' LIMIT 1";
		int gmShopId = DB.getSQLValue(get_TrxName(), shopSql);
		String getValidToSql = "SELECT DateConfirm FROM GM_Shop WHERE GM_Shop_ID = ?";
		Timestamp validTo = DB.getSQLValueTS(get_TrxName(), getValidToSql, gmShopId);
		String sqlCoinAmt = "SELECT ValueNumber FROM GM_FoodCoin WHERE AD_User_ID=? FOR UPDATE";
		BigDecimal currentBalance = DB.getSQLValueBD(get_TrxName(), sqlCoinAmt, 100);
		Timestamp now = new Timestamp(System.currentTimeMillis());

		MFCOrder order = new MFCOrder(getCtx(), 0, get_TrxName());
		order.setGM_Shop_ID(gmShopId);
		order.setGM_Floor_ID(floorId);
		order.setGM_Shift_ID(shiftId);
		order.setValueNumber(currentBalance);
		order.setValidTo(validTo);
		order.setSubsidy(BigDecimal.ZERO);
		order.setAD_User_ID(adUserId);
		order.setDateOrdered(now);

		order.save(get_TrxName());
//		System.out.println(shiftId);
//		String msg = Msg.parseTranslation(getCtx(), "@FC_Order_ID@ @Created@");
		addLog(order.getFC_Order_ID(), null, null, "點這裡選擇餐點！點這裡！", MFCOrder.Table_ID, order.getFC_Order_ID());
		return null;
	}

}
