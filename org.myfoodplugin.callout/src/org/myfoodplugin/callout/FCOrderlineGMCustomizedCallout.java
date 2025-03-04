package org.myfoodplugin.callout;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;

public class FCOrderlineGMCustomizedCallout implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub
		if (value == null) {
			return null; // 如果新值為空，不執行
		}

		// 取得 FC_Order_ID
		Integer orderId = (Integer) mTab.getValue("FC_Order_ID");
		if (orderId == null || orderId <= 0) {
			return null;
		}
		
		BigDecimal OrderedQty = (BigDecimal)mTab.getValue("QtyOrdered");
		
		BigDecimal priceCustom = BigDecimal.ZERO;
		
		// 下SQL(避免SQL injection所以用?去替換變數)
		String sql = "SELECT Price FROM GM_Customized WHERE GM_Customized_ID = ?";

	    // 呼叫內建idempiere的api幫忙
		try (PreparedStatement pstmt = DB.prepareStatement(sql, null)) {
	        pstmt.setInt(1, (Integer)value); // 將foodMenuID塞到？
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) { // next()取值
					priceCustom = rs.getBigDecimal("Price"); // 取得價格
				}			}
		} catch (Exception e) {
			return "資料錯誤" + e.getMessage();
		}
		
		BigDecimal priceCurrent = (BigDecimal) mTab.getValue("PriceActual");
		BigDecimal priceActual = priceCurrent.add(priceCustom);

		BigDecimal subAmount = priceActual.multiply(OrderedQty);
		if (value != null && priceActual != null && subAmount.compareTo(BigDecimal.ZERO) >= 0) {
			mTab.setValue("LineNetAmt", subAmount);
		}
		return null;
	}

}
