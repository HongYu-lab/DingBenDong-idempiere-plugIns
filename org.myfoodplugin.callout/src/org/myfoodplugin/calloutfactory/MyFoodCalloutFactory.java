package org.myfoodplugin.calloutfactory;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.myfoodplugin.callout.FCOrderGMShiftCallout;
import org.myfoodplugin.callout.FCOrderlineGMCustomizedCallout;
import org.myfoodplugin.callout.FCOrderlineOrderedQtyCallout;
import org.myfoodplugin.callout.GMShopValidToCallout;
import org.myfoodplugin.callout.GMWeekMenuGMShopCallout;


public class MyFoodCalloutFactory implements IColumnCalloutFactory {

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName, String columnName) {

		List<IColumnCallout> list = new ArrayList<IColumnCallout>();
		// 變動欄位的tableName與columnName
		if (tableName.equalsIgnoreCase("FC_Orderline") && (columnName.indexOf("QtyOrdered") >= 0))
			list.add(new FCOrderlineOrderedQtyCallout());// 找剛剛所建立的class
		if (tableName.equalsIgnoreCase("FC_Order") && (columnName.indexOf("GM_Shift_ID") >= 0))
			list.add(new FCOrderGMShiftCallout());// 找剛剛所建立的class
		if (tableName.equalsIgnoreCase("FC_Orderline") && (columnName.indexOf("GM_Customized_ID") >= 0))
			list.add(new FCOrderlineGMCustomizedCallout());// 找剛剛所建立的class
		if (tableName.equalsIgnoreCase("GM_WeekMenu") && (columnName.indexOf("GM_Shop_ID") >= 0))
			list.add(new GMWeekMenuGMShopCallout());// 找剛剛所建立的class
		if (tableName.equalsIgnoreCase("GM_Shop") && (columnName.indexOf("GM_MealType_ID") >= 0))
			list.add(new GMShopValidToCallout());// 找剛剛所建立的class
		
		return list != null ? list.toArray(new IColumnCallout[0]) : new IColumnCallout[0];
	}

}
