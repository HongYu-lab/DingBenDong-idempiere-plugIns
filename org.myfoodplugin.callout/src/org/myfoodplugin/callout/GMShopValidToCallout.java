package org.myfoodplugin.callout;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DB;

public class GMShopValidToCallout implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		// TODO Auto-generated method stub

		if (value == null) {
			return null; // 如果新值為空，不執行
		}
		// 取得 GM_Shop_ID
		Integer mealTypeId = (Integer) mTab.getValue("GM_MealType_ID");
		if (mealTypeId == null || mealTypeId <= 0) {
			return null;
		}
		String mealType = "";
		String getMealTypeSql = "SELECT Name FROM GM_MealType WHERE GM_MealType_ID = ?";
		// 呼叫內建idempiere的api幫忙
		try (PreparedStatement pstmt = DB.prepareStatement(getMealTypeSql, null)) {
			pstmt.setInt(1, mealTypeId); // 將foodMenuID塞到？
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) { // next()取值
					mealType = rs.getString("Name");
				}
			}
		} catch (Exception e) {
			return "資料錯誤" + e.getMessage();
		}

		// 取得今天日期
		LocalDate today = LocalDate.now();
		// 設定時間為
		LocalDateTime morning930 = LocalDateTime.of(today, LocalTime.of(9, 30));
		LocalDateTime afternoon1530 = LocalDateTime.of(today, LocalTime.of(15, 25));
		Timestamp lunchtime = Timestamp.valueOf(morning930);
		Timestamp dinnertime = Timestamp.valueOf(afternoon1530);

		if (mealType.equals("午餐")) {
			mTab.setValue("DateConfirm", lunchtime);
		} else if (mealType.equals("晚餐")) {
			mTab.setValue("DateConfirm", dinnertime);
		}

		return null;
	}

}
