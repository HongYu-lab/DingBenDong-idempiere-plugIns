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
package org.myfoodplugin.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for FC_OrderLine
 *  @author iDempiere (generated) 
 *  @version Release 11
 */
@SuppressWarnings("all")
public interface I_FC_OrderLine 
{

    /** TableName=FC_OrderLine */
    public static final String Table_Name = "FC_OrderLine";

    /** AD_Table_ID=1000039 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within tenant
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within tenant
	  */
	public int getAD_Org_ID();

    /** Column name AD_User_ID */
    public static final String COLUMNNAME_AD_User_ID = "AD_User_ID";

	/** Set User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID);

	/** Get User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID();

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException;

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name FC_OrderLine_ID */
    public static final String COLUMNNAME_FC_OrderLine_ID = "FC_OrderLine_ID";

	/** Set FC_OrderLine	  */
	public void setFC_OrderLine_ID (int FC_OrderLine_ID);

	/** Get FC_OrderLine	  */
	public int getFC_OrderLine_ID();

    /** Column name FC_OrderLine_UU */
    public static final String COLUMNNAME_FC_OrderLine_UU = "FC_OrderLine_UU";

	/** Set FC_OrderLine_UU	  */
	public void setFC_OrderLine_UU (String FC_OrderLine_UU);

	/** Get FC_OrderLine_UU	  */
	public String getFC_OrderLine_UU();

    /** Column name FC_Order_ID */
    public static final String COLUMNNAME_FC_Order_ID = "FC_Order_ID";

	/** Set FC_Order	  */
	public void setFC_Order_ID (int FC_Order_ID);

	/** Get FC_Order	  */
	public int getFC_Order_ID();

	public I_FC_Order getFC_Order() throws RuntimeException;

    /** Column name GM_Customized_ID */
    public static final String COLUMNNAME_GM_Customized_ID = "GM_Customized_ID";

	/** Set GM_Customized	  */
	public void setGM_Customized_ID (int GM_Customized_ID);

	/** Get GM_Customized	  */
	public int getGM_Customized_ID();

    /** Column name GM_FoodMenu_ID */
    public static final String COLUMNNAME_GM_FoodMenu_ID = "GM_FoodMenu_ID";

	/** Set GM_FoodMenu	  */
	public void setGM_FoodMenu_ID (int GM_FoodMenu_ID);

	/** Get GM_FoodMenu	  */
	public int getGM_FoodMenu_ID();

    /** Column name GM_FoodType_ID */
    public static final String COLUMNNAME_GM_FoodType_ID = "GM_FoodType_ID";

	/** Set GM_FoodType	  */
	public void setGM_FoodType_ID (int GM_FoodType_ID);

	/** Get GM_FoodType	  */
	public int getGM_FoodType_ID();

    /** Column name GM_Shop_ID */
    public static final String COLUMNNAME_GM_Shop_ID = "GM_Shop_ID";

	/** Set GM_Shop	  */
	public void setGM_Shop_ID (int GM_Shop_ID);

	/** Get GM_Shop	  */
	public int getGM_Shop_ID();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name LineNetAmt */
    public static final String COLUMNNAME_LineNetAmt = "LineNetAmt";

	/** Set Line Amount.
	  * Line Extended Amount (Quantity * Actual Price) without Freight and Charges
	  */
	public void setLineNetAmt (BigDecimal LineNetAmt);

	/** Get Line Amount.
	  * Line Extended Amount (Quantity * Actual Price) without Freight and Charges
	  */
	public BigDecimal getLineNetAmt();

    /** Column name PriceActual */
    public static final String COLUMNNAME_PriceActual = "PriceActual";

	/** Set Unit Price.
	  * Actual Price 
	  */
	public void setPriceActual (BigDecimal PriceActual);

	/** Get Unit Price.
	  * Actual Price 
	  */
	public BigDecimal getPriceActual();

    /** Column name QtyOrdered */
    public static final String COLUMNNAME_QtyOrdered = "QtyOrdered";

	/** Set Ordered Quantity.
	  * Ordered Quantity
	  */
	public void setQtyOrdered (BigDecimal QtyOrdered);

	/** Get Ordered Quantity.
	  * Ordered Quantity
	  */
	public BigDecimal getQtyOrdered();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name ValidTo */
    public static final String COLUMNNAME_ValidTo = "ValidTo";

	/** Set Valid to.
	  * Valid to including this date (last day)
	  */
	public void setValidTo (Timestamp ValidTo);

	/** Get Valid to.
	  * Valid to including this date (last day)
	  */
	public Timestamp getValidTo();
}
