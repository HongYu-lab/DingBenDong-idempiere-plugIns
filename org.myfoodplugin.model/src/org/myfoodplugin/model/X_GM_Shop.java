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

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for GM_Shop
 *  @author iDempiere (generated)
 *  @version Release 11 - $Id$ */
@org.adempiere.base.Model(table="GM_Shop")
public class X_GM_Shop extends PO implements I_GM_Shop, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250304L;

    /** Standard Constructor */
    public X_GM_Shop (Properties ctx, int GM_Shop_ID, String trxName)
    {
      super (ctx, GM_Shop_ID, trxName);
      /** if (GM_Shop_ID == 0)
        {
			setGM_MealType_ID (0);
			setGM_Shop_ID (0);
			setHasServed (false);
// N
			setName (null);
			setPhone (null);
        } */
    }

    /** Standard Constructor */
    public X_GM_Shop (Properties ctx, int GM_Shop_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, GM_Shop_ID, trxName, virtualColumns);
      /** if (GM_Shop_ID == 0)
        {
			setGM_MealType_ID (0);
			setGM_Shop_ID (0);
			setHasServed (false);
// N
			setName (null);
			setPhone (null);
        } */
    }

    /** Standard Constructor */
    public X_GM_Shop (Properties ctx, String GM_Shop_UU, String trxName)
    {
      super (ctx, GM_Shop_UU, trxName);
      /** if (GM_Shop_UU == null)
        {
			setGM_MealType_ID (0);
			setGM_Shop_ID (0);
			setHasServed (false);
// N
			setName (null);
			setPhone (null);
        } */
    }

    /** Standard Constructor */
    public X_GM_Shop (Properties ctx, String GM_Shop_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, GM_Shop_UU, trxName, virtualColumns);
      /** if (GM_Shop_UU == null)
        {
			setGM_MealType_ID (0);
			setGM_Shop_ID (0);
			setHasServed (false);
// N
			setName (null);
			setPhone (null);
        } */
    }

    /** Load Constructor */
    public X_GM_Shop (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_GM_Shop[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Image.
		@param AD_Image_ID Image or Icon
	*/
	public void setAD_Image_ID (int AD_Image_ID)
	{
		if (AD_Image_ID < 1)
			set_Value (COLUMNNAME_AD_Image_ID, null);
		else
			set_Value (COLUMNNAME_AD_Image_ID, Integer.valueOf(AD_Image_ID));
	}

	/** Get Image.
		@return Image or Icon
	  */
	public int getAD_Image_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Image_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Date Confirm.
		@param DateConfirm Date Confirm of this Order
	*/
	public void setDateConfirm (Timestamp DateConfirm)
	{
		set_Value (COLUMNNAME_DateConfirm, DateConfirm);
	}

	/** Get Date Confirm.
		@return Date Confirm of this Order
	  */
	public Timestamp getDateConfirm()
	{
		return (Timestamp)get_Value(COLUMNNAME_DateConfirm);
	}

	/** Set GM_MealType.
		@param GM_MealType_ID GM_MealType
	*/
	public void setGM_MealType_ID (int GM_MealType_ID)
	{
		if (GM_MealType_ID < 1)
			set_Value (COLUMNNAME_GM_MealType_ID, null);
		else
			set_Value (COLUMNNAME_GM_MealType_ID, Integer.valueOf(GM_MealType_ID));
	}

	/** Get GM_MealType.
		@return GM_MealType	  */
	public int getGM_MealType_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GM_MealType_ID);
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

	/** Set GM_Shop_UU.
		@param GM_Shop_UU GM_Shop_UU
	*/
	public void setGM_Shop_UU (String GM_Shop_UU)
	{
		set_Value (COLUMNNAME_GM_Shop_UU, GM_Shop_UU);
	}

	/** Get GM_Shop_UU.
		@return GM_Shop_UU	  */
	public String getGM_Shop_UU()
	{
		return (String)get_Value(COLUMNNAME_GM_Shop_UU);
	}

	/** Set HasServed.
		@param HasServed HasServed
	*/
	public void setHasServed (boolean HasServed)
	{
		set_Value (COLUMNNAME_HasServed, Boolean.valueOf(HasServed));
	}

	/** Get HasServed.
		@return HasServed	  */
	public boolean isHasServed()
	{
		Object oo = get_Value(COLUMNNAME_HasServed);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set Phone.
		@param Phone Identifies a telephone number
	*/
	public void setPhone (String Phone)
	{
		set_Value (COLUMNNAME_Phone, Phone);
	}

	/** Get Phone.
		@return Identifies a telephone number
	  */
	public String getPhone()
	{
		return (String)get_Value(COLUMNNAME_Phone);
	}
}