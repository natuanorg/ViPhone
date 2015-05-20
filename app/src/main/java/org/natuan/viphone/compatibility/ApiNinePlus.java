package org.natuan.viphone.compatibility;

import android.annotation.TargetApi;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.text.TextUtils;

import org.linphone.core.LinphoneAddress;
import org.natuan.viphone.Contact;
import org.natuan.viphone.LinphoneUtils;
import org.natuan.viphone.R;

import java.util.ArrayList;
import java.util.List;

/*
ApiNinePlus.java
Copyright (C) 2012  Belledonne Communications, Grenoble, France

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/
/**
 * @author Sylvain Berfini
 */
@TargetApi(9)
public class ApiNinePlus {

	public static void addSipAddressToContact(Context context, ArrayList<ContentProviderOperation> ops, String sipAddress) {
		ops.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
						.withValueBackReference(Data.RAW_CONTACT_ID, 0)
						.withValue(Data.MIMETYPE, CommonDataKinds.SipAddress.CONTENT_ITEM_TYPE)
						.withValue(CommonDataKinds.SipAddress.DATA, sipAddress)
						.withValue(CommonDataKinds.SipAddress.TYPE, CommonDataKinds.SipAddress.TYPE_CUSTOM)
						.withValue(CommonDataKinds.SipAddress.LABEL, context.getString(R.string.addressbook_label))
						.build()
		);
	}
	
	public static void addSipAddressToContact(Context context, ArrayList<ContentProviderOperation> ops, String sipAddress, String rawContactID) {
		ops.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
		    .withValue(Data.RAW_CONTACT_ID, rawContactID)
	        .withValue(Data.MIMETYPE, CommonDataKinds.SipAddress.CONTENT_ITEM_TYPE)
	        .withValue(CommonDataKinds.SipAddress.DATA, sipAddress)
			.withValue(CommonDataKinds.SipAddress.TYPE, CommonDataKinds.SipAddress.TYPE_CUSTOM)
			.withValue(CommonDataKinds.SipAddress.LABEL, context.getString(R.string.addressbook_label))
	        .build()
	    );
	}
	
	public static void updateSipAddressForContact(ArrayList<ContentProviderOperation> ops, String oldSipAddress, String newSipAddress, String contactID) {
		String select = Data.CONTACT_ID + "=? AND "
				+ Data.MIMETYPE + "='" + CommonDataKinds.SipAddress.CONTENT_ITEM_TYPE +  "' AND "
				+ CommonDataKinds.SipAddress.SIP_ADDRESS + "=?";
		String[] args = new String[] { String.valueOf(contactID), oldSipAddress };
		
        ops.add(ContentProviderOperation.newUpdate(Data.CONTENT_URI)
    		.withSelection(select, args)
			.withValue(Data.MIMETYPE, CommonDataKinds.SipAddress.CONTENT_ITEM_TYPE)
			.withValue(CommonDataKinds.SipAddress.SIP_ADDRESS, newSipAddress)
            .build()
        );
	}
	
	public static void deleteSipAddressFromContact(ArrayList<ContentProviderOperation> ops, String oldSipAddress, String contactID) {
		String select = Data.CONTACT_ID + "=? AND "
				+ Data.MIMETYPE + "='" + CommonDataKinds.SipAddress.CONTENT_ITEM_TYPE +  "' AND "
				+ CommonDataKinds.SipAddress.SIP_ADDRESS + "=? ";
		String[] args = new String[] { String.valueOf(contactID), oldSipAddress };
		
        ops.add(ContentProviderOperation.newDelete(Data.CONTENT_URI)
    		.withSelection(select, args) 
            .build()
        );
	}
	
	public static List<String> extractContactNumbersAndAddresses(String id, ContentResolver cr) {
		List<String> list = new ArrayList<String>();

		Uri uri = Data.CONTENT_URI;
		String[] projection;

		// Phone Numbers
		Cursor c = cr.query(Phone.CONTENT_URI, new String[] { Phone.NUMBER }, Phone.CONTACT_ID + " = " + id, null, null);
		if (c != null) {
	        while (c.moveToNext()) {
	            String number = c.getString(c.getColumnIndex(Phone.NUMBER));
	            list.add(number); 
	        }
	        c.close();
		}

		// SIP addresses
		String selection2 = new StringBuilder()
			.append(Data.CONTACT_ID)
			.append(" = ? AND ")
			.append(Data.MIMETYPE)
			.append(" = '")
			.append(CommonDataKinds.SipAddress.CONTENT_ITEM_TYPE)
			.append("'")
			.toString();
		projection = new String[] {CommonDataKinds.SipAddress.SIP_ADDRESS};
		c = cr.query(uri, projection, selection2, new String[]{id}, null);
		if (c != null) {
			int nbid = c.getColumnIndex(CommonDataKinds.SipAddress.SIP_ADDRESS);
			while (c.moveToNext()) {
				list.add("sip:" + c.getString(nbid)); 
			}
			c.close();
		}

		return list;
	}

	public static Cursor getContactsCursor(ContentResolver cr, String search, List<String> ids) {
		String req;
		if(ids != null && ids.size() > 0) {
			req = "(" + Data.MIMETYPE + " = '" + Phone.CONTENT_ITEM_TYPE
				+ "' AND " + Phone.NUMBER + " IS NOT NULL "
				+ " OR (" + Data.MIMETYPE + " = '" + CommonDataKinds.SipAddress.CONTENT_ITEM_TYPE
				+ "' AND " + CommonDataKinds.SipAddress.SIP_ADDRESS + " IS NOT NULL)"
				+ " OR (" + Data.CONTACT_ID + " IN (" + TextUtils.join(" , ", ids) + ")))";
		} else {
			req = "(" + Data.MIMETYPE + " = '" + Phone.CONTENT_ITEM_TYPE
				+ "' AND " + Phone.NUMBER + " IS NOT NULL "
				+ " OR (" + Data.MIMETYPE + " = '" + CommonDataKinds.SipAddress.CONTENT_ITEM_TYPE
				+ "' AND " + CommonDataKinds.SipAddress.SIP_ADDRESS + " IS NOT NULL))";
		}

		if (search != null) {
			req += " AND " + Data.DISPLAY_NAME + " LIKE '%" + search + "%'";
		}

		return ApiFivePlus.getGeneralContactCursor(cr, req, true);
	}

	public static Cursor getSIPContactsCursor(ContentResolver cr, String search, List<String> ids) {

		String req = "(" + Data.MIMETYPE + " = '" + CommonDataKinds.SipAddress.CONTENT_ITEM_TYPE
					+ "' AND " + CommonDataKinds.SipAddress.SIP_ADDRESS + " IS NOT NULL) ";

		if(ids != null && ids.size() > 0) {
			req += " OR (" + Data.CONTACT_ID + " IN (" + TextUtils.join(" , ", ids) + "))";
		}

		if (search != null) {
			req += " AND " + Data.DISPLAY_NAME + " LIKE '%" + search + "%'";
		}

		return ApiFivePlus.getGeneralContactCursor(cr, req, true);
	}

	private static Cursor getSIPContactCursor(ContentResolver cr, String id) {
		String req = null;
    	req = Contacts.Data.MIMETYPE + " = '" + CommonDataKinds.SipAddress.CONTENT_ITEM_TYPE
                + "' AND " + CommonDataKinds.SipAddress.SIP_ADDRESS + " LIKE '" + id + "'";
    	
		return ApiFivePlus.getGeneralContactCursor(cr, req, false);
	}

	public static Uri findUriPictureOfContactAndSetDisplayName(LinphoneAddress address, ContentResolver cr) {
		String username = address.getUserName();
		String domain = address.getDomain();
		String sipUri = username + "@" + domain;
		
		Cursor cursor = getSIPContactCursor(cr, sipUri);
		Contact contact = ApiFivePlus.getContact(cr, cursor, 0);
		if (contact != null && contact.getNumbersOrAddresses().contains(sipUri)) {
			address.setDisplayName(contact.getName());
			cursor.close();
			return contact.getPhotoUri();
		}

		cursor.close();
		return null;
	}

	//Linphone Contacts Tag
	public static void addLinphoneContactTag(Context context, ArrayList<ContentProviderOperation> ops, String newAddress, String rawContactId){
		if(rawContactId != null) {
			ops.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
					.withValue(Data.RAW_CONTACT_ID, rawContactId)
					.withValue(Data.MIMETYPE, context.getString(R.string.sync_mimetype))
					.withValue(Data.DATA1, newAddress)
					.withValue(Data.DATA2, context.getString(R.string.app_name))
					.withValue(Data.DATA3, newAddress)
					.build()
			);
		}
	}
	public static void updateLinphoneContactTag(Context context, ArrayList<ContentProviderOperation> ops, String newAddress, String oldAddress, String rawContactId){
		if(rawContactId != null) {
			ops.add(ContentProviderOperation.newUpdate(Data.CONTENT_URI)
					.withSelection(Data.RAW_CONTACT_ID + "=? AND " + Data.DATA1 + "=? ", new String[]{rawContactId, oldAddress})
					.withValue(Data.DATA1, newAddress)
					.withValue(Data.DATA2, context.getString(R.string.app_name))
					.withValue(Data.DATA3, newAddress)
					.build());
		}
	}

	public static void deleteLinphoneContactTag(ArrayList<ContentProviderOperation> ops , String oldAddress, String rawContactId){
		if(rawContactId != null) {
			String select = Data.RAW_CONTACT_ID + "=? AND "
					+ Data.DATA1 + "= ?";
			String[] args = new String[]{rawContactId, oldAddress};

			ops.add(ContentProviderOperation.newDelete(Data.CONTENT_URI)
					.withSelection(select, args)
					.build());
		}
	}

	public static void createLinphoneContactTag(Context context, ContentResolver contentResolver, Contact contact, String rawContactId){
		ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();

		if (contact != null) {
			ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
				.withValue(ContactsContract.RawContacts.AGGREGATION_MODE, ContactsContract.RawContacts.AGGREGATION_MODE_DEFAULT)
				.withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, context.getString(R.string.sync_account_type))
				.withValue(ContactsContract.RawContacts.ACCOUNT_NAME, context.getString(R.string.sync_account_name))
				.build()
			);

			ops.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
							.withValueBackReference(Data.RAW_CONTACT_ID, 0)
							.withValue(Data.MIMETYPE, CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
							.withValue(CommonDataKinds.StructuredName.DISPLAY_NAME, contact.getName())
							.build()
			);

			List<String> numbersOrAddresses = contact.getNumbersOrAddresses();
			for (String numberOrAddress : numbersOrAddresses) {
				if (LinphoneUtils.isSipAddress(numberOrAddress)) {
					if (numberOrAddress.startsWith("sip:")){
						numberOrAddress = numberOrAddress.substring(4);
					}

					ops.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
						.withValueBackReference(Data.RAW_CONTACT_ID, 0)
						.withValue(Data.MIMETYPE, context.getString(R.string.sync_mimetype))
						.withValue(Data.DATA1, numberOrAddress)
						.withValue(Data.DATA2, context.getString(R.string.app_name))
						.withValue(Data.DATA3, numberOrAddress)
						.build()
					);
				}
			}

			ops.add(ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI)
				.withValue(ContactsContract.AggregationExceptions.TYPE, ContactsContract.AggregationExceptions.TYPE_KEEP_TOGETHER)
				.withValue(ContactsContract.AggregationExceptions.RAW_CONTACT_ID1, rawContactId)
				.withValueBackReference(ContactsContract.AggregationExceptions.RAW_CONTACT_ID2, 0).build());

			try {
				contentResolver.applyBatch(ContactsContract.AUTHORITY, ops);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
