package org.myfoodplugin.modelfactory;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env;
import org.myfoodplugin.model.MFCOrder;
import org.myfoodplugin.model.MFCOrderLine;
import org.myfoodplugin.model.MFoodCoin;
import org.myfoodplugin.model.MFoodCoinLine;
import org.myfoodplugin.model.MGMShop;

public class FCmodelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		if (tableName.equals(MFCOrder.Table_Name))
			return MFCOrder.class;
		if (tableName.equals(MFCOrderLine.Table_Name))
			return MFCOrderLine.class;
		if (tableName.equals(MFoodCoinLine.Table_Name))
			return MFoodCoinLine.class;
		if (tableName.equals(MFoodCoin.Table_Name))
			return MFoodCoin.class;
		if (tableName.equals(MGMShop.Table_Name))
			return MGMShop.class;
	
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		if (tableName.equals(MFCOrder.Table_Name))
			return new MFCOrder(Env.getCtx(), Record_ID, trxName);
		if (tableName.equals(MFCOrderLine.Table_Name))
			return new MFCOrderLine(Env.getCtx(), Record_ID, trxName);
		if (tableName.equals(MFoodCoinLine.Table_Name))
			return new MFoodCoinLine(Env.getCtx(), Record_ID, trxName);
		if (tableName.equals(MFoodCoin.Table_Name))
			return new MFoodCoin(Env.getCtx(), Record_ID, trxName);
		if (tableName.equals(MGMShop.Table_Name))
			return new MGMShop(Env.getCtx(), Record_ID, trxName);

		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		if (tableName.equals(MFCOrder.Table_Name))
			return new MFCOrder(Env.getCtx(), rs, trxName);
		if (tableName.equals(MFCOrderLine.Table_Name))
			return new MFCOrderLine(Env.getCtx(), rs, trxName);
		if (tableName.equals(MFoodCoinLine.Table_Name))
			return new MFoodCoinLine(Env.getCtx(), rs, trxName);
		if (tableName.equals(MFoodCoin.Table_Name))
			return new MFoodCoin(Env.getCtx(), rs, trxName);
		if (tableName.equals(MGMShop.Table_Name))
			return new MGMShop(Env.getCtx(), rs, trxName);
		
		return null;
	}

}
