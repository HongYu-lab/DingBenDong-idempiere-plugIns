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

/** Generated Model for FC_Order
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="FC_Order")
public class X_FC_Order extends PO implements I_FC_Order, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250227L;

    /** Standard Constructor */
    public X_FC_Order (Properties ctx, int FC_Order_ID, String trxName)
    {
      super (ctx, FC_Order_ID, trxName);
      /** if (FC_Order_ID == 0)
        {
			setFC_Order_ID (0);
			setGM_Floor_ID (0);
// @SQL=SELECT GM_Floor_ID FROM FC_Order WHERE AD_User_ID=@AD_User_ID@ ORDER BY FC_Order_ID DESC LIMIT 1

			setGM_Shift_ID (0);
// @SQL=SELECT GM_Shift_ID FROM FC_Order WHERE AD_User_ID=@AD_User_ID@ ORDER BY FC_Order_ID DESC LIMIT 1

			setGM_Shop_ID (0);
// @SQL=SELECT GM_Shop_ID FROM GM_Shop WHERE HasServed='Y' ORDER BY GM_Shop_ID LIMIT 1
			setValidTo (new Timestamp( System.currentTimeMillis() ));
// @SQL=SELECT DateConfirm FROM GM_Shop WHERE HasServed='Y'  ORDER BY GM_Shop_ID LIMIT 1
        } */
    }

    /** Standard Constructor */
    public X_FC_Order (Properties ctx, int FC_Order_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, FC_Order_ID, trxName, virtualColumns);
      /** if (FC_Order_ID == 0)
        {
			setFC_Order_ID (0);
			setGM_Floor_ID (0);
// @SQL=SELECT GM_Floor_ID FROM FC_Order WHERE AD_User_ID=@AD_User_ID@ ORDER BY FC_Order_ID DESC LIMIT 1

			setGM_Shift_ID (0);
// @SQL=SELECT GM_Shift_ID FROM FC_Order WHERE AD_User_ID=@AD_User_ID@ ORDER BY FC_Order_ID DESC LIMIT 1

			setGM_Shop_ID (0);
// @SQL=SELECT GM_Shop_ID FROM GM_Shop WHERE HasServed='Y' ORDER BY GM_Shop_ID LIMIT 1
			setValidTo (new Timestamp( System.currentTimeMillis() ));
// @SQL=SELECT DateConfirm FROM GM_Shop WHERE HasServed='Y'  ORDER BY GM_Shop_ID LIMIT 1
        } */
    }

    /** Standard Constructor */
    public X_FC_Order (Properties ctx, String FC_Order_UU, String trxName)
    {
      super (ctx, FC_Order_UU, trxName);
      /** if (FC_Order_UU == null)
        {
			setFC_Order_ID (0);
			setGM_Floor_ID (0);
// @SQL=SELECT GM_Floor_ID FROM FC_Order WHERE AD_User_ID=@AD_User_ID@ ORDER BY FC_Order_ID DESC LIMIT 1

			setGM_Shift_ID (0);
// @SQL=SELECT GM_Shift_ID FROM FC_Order WHERE AD_User_ID=@AD_User_ID@ ORDER BY FC_Order_ID DESC LIMIT 1

			setGM_Shop_ID (0);
// @SQL=SELECT GM_Shop_ID FROM GM_Shop WHERE HasServed='Y' ORDER BY GM_Shop_ID LIMIT 1
			setValidTo (new Timestamp( System.currentTimeMillis() ));
// @SQL=SELECT DateConfirm FROM GM_Shop WHERE HasServed='Y'  ORDER BY GM_Shop_ID LIMIT 1
        } */
    }

    /** Standard Constructor */
    public X_FC_Order (Properties ctx, String FC_Order_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, FC_Order_UU, trxName, virtualColumns);
      /** if (FC_Order_UU == null)
        {
			setFC_Order_ID (0);
			setGM_Floor_ID (0);
// @SQL=SELECT GM_Floor_ID FROM FC_Order WHERE AD_User_ID=@AD_User_ID@ ORDER BY FC_Order_ID DESC LIMIT 1

			setGM_Shift_ID (0);
// @SQL=SELECT GM_Shift_ID FROM FC_Order WHERE AD_User_ID=@AD_User_ID@ ORDER BY FC_Order_ID DESC LIMIT 1

			setGM_Shop_ID (0);
// @SQL=SELECT GM_Shop_ID FROM GM_Shop WHERE HasServed='Y' ORDER BY GM_Shop_ID LIMIT 1
			setValidTo (new Timestamp( System.currentTimeMillis() ));
// @SQL=SELECT DateConfirm FROM GM_Shop WHERE HasServed='Y'  ORDER BY GM_Shop_ID LIMIT 1
        } */
    }

    /** Load Constructor */
    public X_FC_Order (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_FC_Order[")
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

	/** Set Date Ordered.
		@param DateOrdered Date of Order
	*/
	public void setDateOrdered (Timestamp DateOrdered)
	{
		set_ValueNoCheck (COLUMNNAME_DateOrdered, DateOrdered);
	}

	/** Get Date Ordered.
		@return Date of Order
	  */
	public Timestamp getDateOrdered()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateOrdered);
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_ValueNoCheck (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set FC_Order.
		@param FC_Order_ID FC_Order
	*/
	public void setFC_Order_ID (int FC_Order_ID)
	{
		if (FC_Order_ID < 1)
			set_ValueNoCheck (COLUMNNAME_FC_Order_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_FC_Order_ID, Integer.valueOf(FC_Order_ID));
	}

	/** Get FC_Order.
		@return FC_Order	  */
	public int getFC_Order_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_FC_Order_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set FC_Order_UU.
		@param FC_Order_UU FC_Order_UU
	*/
	public void setFC_Order_UU (String FC_Order_UU)
	{
		set_Value (COLUMNNAME_FC_Order_UU, FC_Order_UU);
	}

	/** Get FC_Order_UU.
		@return FC_Order_UU	  */
	public String getFC_Order_UU()
	{
		return (String)get_Value(COLUMNNAME_FC_Order_UU);
	}


	/** Set GM_Floor.
		@param GM_Floor_ID GM_Floor
	*/
	public void setGM_Floor_ID (int GM_Floor_ID)
	{
		if (GM_Floor_ID < 1)
			set_ValueNoCheck (COLUMNNAME_GM_Floor_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_GM_Floor_ID, Integer.valueOf(GM_Floor_ID));
	}

	/** Get GM_Floor.
		@return GM_Floor	  */
	public int getGM_Floor_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GM_Floor_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set GM_Shift.
		@param GM_Shift_ID GM_Shift
	*/
	public void setGM_Shift_ID (int GM_Shift_ID)
	{
		if (GM_Shift_ID < 1)
			set_ValueNoCheck (COLUMNNAME_GM_Shift_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_GM_Shift_ID, Integer.valueOf(GM_Shift_ID));
	}

	/** Get GM_Shift.
		@return GM_Shift	  */
	public int getGM_Shift_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GM_Shift_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set GM_Shop.
		@param GM_Shop_ID GM_Shop
	*/
	public void setGM_Shop_ID (int GM_Shop_ID)
	{
		if (GM_Shop_ID < 1)
			set_ValueNoCheck (COLUMNNAME_GM_Shop_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_GM_Shop_ID, Integer.valueOf(GM_Shop_ID));
	}

	/** Get GM_Shop.
		@return GM_Shop	  */
	public int getGM_Shop_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GM_Shop_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Invoice net Amount.
		@param NetAmtToInvoice Net amount of this Invoice
	*/
	public void setNetAmtToInvoice (BigDecimal NetAmtToInvoice)
	{
		set_ValueNoCheck (COLUMNNAME_NetAmtToInvoice, NetAmtToInvoice);
	}

	/** Get Invoice net Amount.
		@return Net amount of this Invoice
	  */
	public BigDecimal getNetAmtToInvoice()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_NetAmtToInvoice);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Subsidy.
		@param Subsidy Subsidy
	*/
	public void setSubsidy (BigDecimal Subsidy)
	{
		set_ValueNoCheck (COLUMNNAME_Subsidy, Subsidy);
	}

	/** Get Subsidy.
		@return Subsidy	  */
	public BigDecimal getSubsidy()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Subsidy);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Total Amount.
		@param TotalAmt Total Amount
	*/
	public void setTotalAmt (BigDecimal TotalAmt)
	{
		set_ValueNoCheck (COLUMNNAME_TotalAmt, TotalAmt);
	}

	/** Get Total Amount.
		@return Total Amount
	  */
	public BigDecimal getTotalAmt()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TotalAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Valid to.
		@param ValidTo Valid to including this date (last day)
	*/
	public void setValidTo (Timestamp ValidTo)
	{
		set_ValueNoCheck (COLUMNNAME_ValidTo, ValidTo);
	}

	/** Get Valid to.
		@return Valid to including this date (last day)
	  */
	public Timestamp getValidTo()
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidTo);
	}

	/** Set Value.
		@param ValueNumber Numeric Value
	*/
	public void setValueNumber (BigDecimal ValueNumber)
	{
		set_ValueNoCheck (COLUMNNAME_ValueNumber, ValueNumber);
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