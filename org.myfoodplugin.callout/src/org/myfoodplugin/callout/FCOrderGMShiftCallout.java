package org.myfoodplugin.callout;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;

public class FCOrderGMShiftCallout implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {

		if (value == null) {
			return null; // 如果新值為空，不執行
		}
		
        // 取得 GM_Shift_ID
        Integer shiftId = (Integer) mTab.getValue("GM_Shift_ID");
        if (shiftId == null || shiftId <= 0) {
            return null;
        }
        
		BigDecimal subsidy = BigDecimal.ZERO; // 初始化避免型別錯誤
		BigDecimal totalAmt = BigDecimal.ZERO; // 初始化避免型別錯誤
		BigDecimal netAmt = (BigDecimal) mTab.getValue("NetAmtToInvoice"); // 初始化避免型別錯誤
				
		String sql = "SELECT Subsidy FROM GM_Shift WHERE GM_Shift_ID = ?";

		try (PreparedStatement pstmt = DB.prepareStatement(sql, null)) {
			pstmt.setInt(1, shiftId); // 將foodMenuID塞到？
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) { // next()取值
					subsidy = rs.getBigDecimal("Subsidy"); // 取得補助
					
					if (netAmt.compareTo(subsidy) > 0) {
						totalAmt = netAmt.subtract(subsidy);
					} 
					mTab.setValue("TotalAmt", totalAmt);
					mTab.setValue("Subsidy", subsidy); // 設定補助
				}
			}
		} catch (Exception e) {
			return "資料錯誤" + e.getMessage();
		}
		
		return null;
	}

}
