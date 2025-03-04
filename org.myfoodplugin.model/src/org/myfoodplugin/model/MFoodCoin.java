package org.myfoodplugin.model;

import java.sql.ResultSet;
import java.util.Properties;


public class MFoodCoin extends X_GM_FoodCoin {

	private static final long serialVersionUID = 1L;

	public MFoodCoin(Properties ctx, int GM_FoodCoin_ID, String trxName, String... virtualColumns) {
		super(ctx, GM_FoodCoin_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MFoodCoin(Properties ctx, int GM_FoodCoin_ID, String trxName) {
		super(ctx, GM_FoodCoin_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MFoodCoin(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MFoodCoin(Properties ctx, String GM_FoodCoin_UU, String trxName, String... virtualColumns) {
		super(ctx, GM_FoodCoin_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MFoodCoin(Properties ctx, String GM_FoodCoin_UU, String trxName) {
		super(ctx, GM_FoodCoin_UU, trxName);
		// TODO Auto-generated constructor stub
	}

}
