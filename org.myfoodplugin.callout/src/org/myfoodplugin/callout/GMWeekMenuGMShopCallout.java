package org.myfoodplugin.callout;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;

public class GMWeekMenuGMShopCallout implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub

		if (value == null) {
			return null; // 如果新值為空，不執行
		}
		// 取得 GM_Shop_ID
		Integer shopId = (Integer) mTab.getValue("GM_Shop_ID");
		if (shopId == null || shopId <= 0) {
			return null;
		}

		Timestamp validTo = null;
		String dayMenu = "";
		Integer menuImage = null;
		String getValidToSql = "SELECT HasServed, DateConfirm,AD_Image_ID FROM GM_Shop WHERE GM_Shop_ID = ?";
		// 呼叫內建idempiere的api幫忙
		try (PreparedStatement pstmt = DB.prepareStatement(getValidToSql, null)) {
			pstmt.setInt(1, shopId); // 將foodMenuID塞到？
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) { // next()取值
					validTo = rs.getTimestamp("DateConfirm"); // 取得價格
					dayMenu = rs.getString("HasServed");
					menuImage = rs.getInt("AD_Image_ID");
				}
			}
		} catch (Exception e) {
			return "資料錯誤" + e.getMessage();
		}

		if(!menuImage.equals(0)) {
			mTab.setValue("AD_Image_ID",menuImage);
		}
		else {
			mTab.setValue("AD_Image_ID",null);
		}
		mTab.setValue("ValidTo", validTo);
		mTab.setValue("HasServed", dayMenu);

		return null;
	}

}
