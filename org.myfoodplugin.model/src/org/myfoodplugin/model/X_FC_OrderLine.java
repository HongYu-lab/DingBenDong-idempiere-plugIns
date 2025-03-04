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

/** Generated Model for FC_OrderLine
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="FC_OrderLine")
public class X_FC_OrderLine extends PO implements I_FC_OrderLine, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250227L;

    /** Standard Constructor */
    public X_FC_OrderLine (Properties ctx, int FC_OrderLine_ID, String trxName)
    {
      super (ctx, FC_OrderLine_ID, trxName);
      /** if (FC_OrderLine_ID == 0)
        {
			setFC_OrderLine_ID (0);
			setFC_Order_ID (0);
			setGM_Customized_ID (0);
			setGM_FoodMenu_ID (0);
			setQtyOrdered (Env.ZERO);
        } */
    }

    /** Standard Constructor */
    public X_FC_OrderLine (Properties ctx, int FC_OrderLine_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, FC_OrderLine_ID, trxName, virtualColumns);
      /** if (FC_OrderLine_ID == 0)
        {
			setFC_OrderLine_ID (0);
			setFC_Order_ID (0);
			setGM_Customized_ID (0);
			setGM_FoodMenu_ID (0);
			setQtyOrdered (Env.ZERO);
        } */
    }

    /** Standard Constructor */
    public X_FC_OrderLine (Properties ctx, String FC_OrderLine_UU, String trxName)
    {
      super (ctx, FC_OrderLine_UU, trxName);
      /** if (FC_OrderLine_UU == null)
        {
			setFC_OrderLine_ID (0);
			setFC_Order_ID (0);
			setGM_Customized_ID (0);
			setGM_FoodMenu_ID (0);
			setQtyOrdered (Env.ZERO);
        } */
    }

    /** Standard Constructor */
    public X_FC_OrderLine (Properties ctx, String FC_OrderLine_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, FC_OrderLine_UU, trxName, virtualColumns);
      /** if (FC_OrderLine_UU == null)
        {
			setFC_OrderLine_ID (0);
			setFC_Order_ID (0);
			setGM_Customized_ID (0);
			setGM_FoodMenu_ID (0);
			setQtyOrdered (Env.ZERO);
        } */
    }

    /** Load Constructor */
    public X_FC_OrderLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_FC_OrderLine[")
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

	/** Set FC_OrderLine.
		@param FC_OrderLine_ID FC_OrderLine
	*/
	public void setFC_OrderLine_ID (int FC_OrderLine_ID)
	{
		if (FC_OrderLine_ID < 1)
			set_ValueNoCheck (COLUMNNAME_FC_OrderLine_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_FC_OrderLine_ID, Integer.valueOf(FC_OrderLine_ID));
	}

	/** Get FC_OrderLine.
		@return FC_OrderLine	  */
	public int getFC_OrderLine_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_FC_OrderLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set FC_OrderLine_UU.
		@param FC_OrderLine_UU FC_OrderLine_UU
	*/
	public void setFC_OrderLine_UU (String FC_OrderLine_UU)
	{
		set_Value (COLUMNNAME_FC_OrderLine_UU, FC_OrderLine_UU);
	}

	/** Get FC_OrderLine_UU.
		@return FC_OrderLine_UU	  */
	public String getFC_OrderLine_UU()
	{
		return (String)get_Value(COLUMNNAME_FC_OrderLine_UU);
	}

	public I_FC_Order getFC_Order() throws RuntimeException
	{
		return (I_FC_Order)MTable.get(getCtx(), I_FC_Order.Table_ID)
			.getPO(getFC_Order_ID(), get_TrxName());
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


	/** Set GM_Customized.
		@param GM_Customized_ID GM_Customized
	*/
	public void setGM_Customized_ID (int GM_Customized_ID)
	{
		if (GM_Customized_ID < 1)
			set_Value (COLUMNNAME_GM_Customized_ID, null);
		else
			set_Value (COLUMNNAME_GM_Customized_ID, Integer.valueOf(GM_Customized_ID));
	}

	/** Get GM_Customized.
		@return GM_Customized	  */
	public int getGM_Customized_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GM_Customized_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set GM_FoodMenu.
		@param GM_FoodMenu_ID GM_FoodMenu
	*/
	public void setGM_FoodMenu_ID (int GM_FoodMenu_ID)
	{
		if (GM_FoodMenu_ID < 1)
			set_ValueNoCheck (COLUMNNAME_GM_FoodMenu_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_GM_FoodMenu_ID, Integer.valueOf(GM_FoodMenu_ID));
	}

	/** Get GM_FoodMenu.
		@return GM_FoodMenu	  */
	public int getGM_FoodMenu_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GM_FoodMenu_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}


	/** Set GM_FoodType.
		@param GM_FoodType_ID GM_FoodType
	*/
	public void setGM_FoodType_ID (int GM_FoodType_ID)
	{
		if (GM_FoodType_ID < 1)
			set_ValueNoCheck (COLUMNNAME_GM_FoodType_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_GM_FoodType_ID, Integer.valueOf(GM_FoodType_ID));
	}

	/** Get GM_FoodType.
		@return GM_FoodType	  */
	public int getGM_FoodType_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GM_FoodType_ID);
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

	/** Set Line Amount.
		@param LineNetAmt Line Extended Amount (Quantity * Actual Price) without Freight and Charges
	*/
	public void setLineNetAmt (BigDecimal LineNetAmt)
	{
		set_ValueNoCheck (COLUMNNAME_LineNetAmt, LineNetAmt);
	}

	/** Get Line Amount.
		@return Line Extended Amount (Quantity * Actual Price) without Freight and Charges
	  */
	public BigDecimal getLineNetAmt()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LineNetAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Unit Price.
		@param PriceActual Actual Price 
	*/
	public void setPriceActual (BigDecimal PriceActual)
	{
		set_ValueNoCheck (COLUMNNAME_PriceActual, PriceActual);
	}

	/** Get Unit Price.
		@return Actual Price 
	  */
	public BigDecimal getPriceActual()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_PriceActual);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Ordered Quantity.
		@param QtyOrdered Ordered Quantity
	*/
	public void setQtyOrdered (BigDecimal QtyOrdered)
	{
		set_Value (COLUMNNAME_QtyOrdered, QtyOrdered);
	}

	/** Get Ordered Quantity.
		@return Ordered Quantity
	  */
	public BigDecimal getQtyOrdered()
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyOrdered);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Valid to.
		@param ValidTo Valid to including this date (last day)
	*/
	public void setValidTo (Timestamp ValidTo)
	{
		set_Value (COLUMNNAME_ValidTo, ValidTo);
	}

	/** Get Valid to.
		@return Valid to including this date (last day)
	  */
	public Timestamp getValidTo()
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidTo);
	}
}