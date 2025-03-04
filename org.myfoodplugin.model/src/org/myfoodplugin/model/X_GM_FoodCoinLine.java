/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.myfoodplugin.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for GM_FoodCoinLine
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="GM_FoodCoinLine")
public class X_GM_FoodCoinLine extends PO implements I_GM_FoodCoinLine, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250218L;

    /** Standard Constructor */
    public X_GM_FoodCoinLine (Properties ctx, int GM_FoodCoinLine_ID, String trxName)
    {
      super (ctx, GM_FoodCoinLine_ID, trxName);
      /** if (GM_FoodCoinLine_ID == 0)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @SQL=SELECT NOW()
			setGM_FoodCoinLine_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_GM_FoodCoinLine (Properties ctx, int GM_FoodCoinLine_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, GM_FoodCoinLine_ID, trxName, virtualColumns);
      /** if (GM_FoodCoinLine_ID == 0)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @SQL=SELECT NOW()
			setGM_FoodCoinLine_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_GM_FoodCoinLine (Properties ctx, String GM_FoodCoinLine_UU, String trxName)
    {
      super (ctx, GM_FoodCoinLine_UU, trxName);
      /** if (GM_FoodCoinLine_UU == null)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @SQL=SELECT NOW()
			setGM_FoodCoinLine_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_GM_FoodCoinLine (Properties ctx, String GM_FoodCoinLine_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, GM_FoodCoinLine_UU, trxName, virtualColumns);
      /** if (GM_FoodCoinLine_UU == null)
        {
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @SQL=SELECT NOW()
			setGM_FoodCoinLine_ID (0);
        } */
    }

    /** Load Constructor */
    public X_GM_FoodCoinLine (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_GM_FoodCoinLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException
	{
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_ID)
			.getPO(getAD_User_ID(), get_TrxName());
	}

	/** Set User/Contact.
		@param AD_User_ID User within the system - Internal or Business Partner Contact
	*/
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1)
			set_ValueNoCheck (COLUMNNAME_AD_User_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get User/Contact.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Account Date.
		@param DateAcct Accounting Date
	*/
	public void setDateAcct (Timestamp DateAcct)
	{
		set_ValueNoCheck (COLUMNNAME_DateAcct, DateAcct);
	}

	/** Get Account Date.
		@return Accounting Date
	  */
	public Timestamp getDateAcct()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateAcct);
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set GM_FoodCoinLine.
		@param GM_FoodCoinLine_ID GM_FoodCoinLine
	*/
	public void setGM_FoodCoinLine_ID (int GM_FoodCoinLine_ID)
	{
		if (GM_FoodCoinLine_ID < 1)
			set_ValueNoCheck (COLUMNNAME_GM_FoodCoinLine_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_GM_FoodCoinLine_ID, Integer.valueOf(GM_FoodCoinLine_ID));
	}

	/** Get GM_FoodCoinLine.
		@return GM_FoodCoinLine	  */
	public int getGM_FoodCoinLine_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GM_FoodCoinLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set GM_FoodCoinLine_UU.
		@param GM_FoodCoinLine_UU GM_FoodCoinLine_UU
	*/
	public void setGM_FoodCoinLine_UU (String GM_FoodCoinLine_UU)
	{
		set_Value (COLUMNNAME_GM_FoodCoinLine_UU, GM_FoodCoinLine_UU);
	}

	/** Get GM_FoodCoinLine_UU.
		@return GM_FoodCoinLine_UU	  */
	public String getGM_FoodCoinLine_UU()
	{
		return (String)get_Value(COLUMNNAME_GM_FoodCoinLine_UU);
	}

	/** Set Value.
		@param ValueNumber Numeric Value
	*/
	public void setValueNumber (BigDecimal ValueNumber)
	{
		set_Value (COLUMNNAME_ValueNumber, ValueNumber);
	}

	/** Get Value.
		@return Numeric Value
	  */
	public BigDecimal getValueNumber()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ValueNumber);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}