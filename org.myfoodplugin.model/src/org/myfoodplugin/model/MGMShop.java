package org.myfoodplugin.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.CacheMgt;

public class MGMShop extends X_GM_Shop {

	private static final long serialVersionUID = 1L;

	public MGMShop(Properties ctx, int GM_Shop_ID, String trxName, String... virtualColumns) {
		super(ctx, GM_Shop_ID, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MGMShop(Properties ctx, int GM_Shop_ID, String trxName) {
		super(ctx, GM_Shop_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MGMShop(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MGMShop(Properties ctx, String GM_Shop_UU, String trxName, String... virtualColumns) {
		super(ctx, GM_Shop_UU, trxName, virtualColumns);
		// TODO Auto-generated constructor stub
	}

	public MGMShop(Properties ctx, String GM_Shop_UU, String trxName) {
		super(ctx, GM_Shop_UU, trxName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean afterSave(boolean newRecord, boolean success) {
		// TODO Auto-generated method stub
		
        CacheMgt.get().reset();

		return super.afterSave(newRecord, success);
	}

}
