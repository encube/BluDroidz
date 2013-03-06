package com.csc193.bluedroid;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fetchContactsThreader();
		fetchMessagesThreader();
		addContacts("bulra", "9984800");
	}

	private void fetchContactsThreader() {
		Thread fetchContactsThread = new Thread(new Runnable() {

			@Override
			public void run() {
				fetchContacts();
			}
		});
		fetchContactsThread.start();
	}

	private void fetchMessagesThreader() {
		Thread fetchMessagesThread = new Thread(new Runnable() {

			@Override
			public void run() {
				fetchMessages();
			}
		});
		fetchMessagesThread.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void onConnectClicked(View view) {

	}

	private void fetchContacts() {
		int contactDisplayNameIndex = 1, contactPhoneNumberIndex = 2;
		Cursor fetchContacts = getContentResolver().query(
				Data.CONTENT_URI,
				new String[] { Data._ID, Data.DISPLAY_NAME, Phone.NUMBER,
						Data.CONTACT_ID, Phone.TYPE, Phone.LABEL },
				Data.MIMETYPE + "='" + Phone.CONTENT_ITEM_TYPE + "'", null,
				Data.DISPLAY_NAME);

		int count = fetchContacts.getCount();
		for (int i = 0; i < count; i++) {
			fetchContacts.moveToPosition(i);
			Log.d(fetchContacts.getString(contactDisplayNameIndex),
					fetchContacts.getString(contactPhoneNumberIndex));
		}
		Log.d("contacts", "" + count);
	}

	private void fetchMessages() {
		int messageAddressIndex = 1, messageBodyIndex = 3;
		Uri uriSMSURI = Uri.parse("content://sms/inbox");
		Cursor fetchMessages = getContentResolver().query(uriSMSURI,
				new String[] { "_id", "address", "date", "body" }, null, null,
				"_id");
		int count = fetchMessages.getCount();
		for (int i = 0; i < count; i++) {
			fetchMessages.moveToPosition(i);
			Log.d(fetchMessages.getString(messageAddressIndex),
					fetchMessages.getString(messageBodyIndex));
		}
	}

	private void addContacts(String name, String contactNumber) {
		ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
		int rawContactInsertIndex = ops.size();

		ops.add(ContentProviderOperation.newInsert(RawContacts.CONTENT_URI)
				.withValue(RawContacts.ACCOUNT_TYPE, null)
				.withValue(RawContacts.ACCOUNT_NAME, null).build());
		ops.add(ContentProviderOperation
				.newInsert(Data.CONTENT_URI)
				.withValueBackReference(Data.RAW_CONTACT_ID,
						rawContactInsertIndex)
				.withValue(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE)
				.withValue(StructuredName.DISPLAY_NAME, name).build());
		ops.add(ContentProviderOperation
				.newInsert(Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID,
						rawContactInsertIndex)
				.withValue(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE)
				.withValue(Phone.NUMBER, contactNumber)
				.withValue(Phone.TYPE, Phone.TYPE_MOBILE).build());
		try {
			getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
			Log.d("add contacts", "contacts added");
		} catch (RemoteException e) {
			Log.d("add contacts", "remoteException");
		} catch (OperationApplicationException e) {
			Log.d("add contacts", "operation application");
		}
	}

	private void sendMessage(String recipient, String message) {

	}

}
