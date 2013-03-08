package com.csc193.bluedroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.app.Activity;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private BluetoothAdapter mBluetoothAdapter;
	private static final int REQUEST_ENABLE_BT = 1000;
	private static final int REQUEST_DISCOVERABLE_BT = 1001;
	private static String name = "client bluedroid";
	private static UUID uuid = UUID
			.fromString("00001101-0000-1000-8000-00805F9B34FB");;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (resultCode == RESULT_OK) {
			if (requestCode == REQUEST_ENABLE_BT) {
				Log.d("onActivityResult", "enabled");
			} else if (requestCode == REQUEST_DISCOVERABLE_BT) {
				Log.d("onActivityResult", "discoverable");
			}
		} else {
			if (requestCode == REQUEST_ENABLE_BT) {
				Log.d("onActivityResult", "not enabled");
			} else if (requestCode == REQUEST_DISCOVERABLE_BT) {
				Log.d("onActivityResult", "not discoverable");
			}
		}
	}

	private void checkBTState() {
		if (mBluetoothAdapter == null) {
			Log.d("bluetooth", "no adapter found");
		}
		if (!mBluetoothAdapter.isEnabled()) {
			Intent enableBtIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
		}
		if (!mBluetoothAdapter.isDiscovering()) {
			Intent discoverableIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
			startActivityForResult(discoverableIntent, REQUEST_DISCOVERABLE_BT);
		}
	}

	private void startListener() {
		Thread listener = new AcceptThread();
		listener.start();
	}

	public void onConnectClicked(View view) {
		Log.d("onClick", "connect clicked");
		fetchContactsThreader();
		fetchMessagesThreader();
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

	private void fetchMessagesThreader() {
		Thread fetchMessagesThread = new Thread(new Runnable() {

			@Override
			public void run() {
				fetchMessages();
			}
		});
		fetchMessagesThread.start();
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

	//TODO test this
	private void sendSMS(String phoneNumber, String message) {

		String SENT = "SMS_SENT";
		String DELIVERED = "SMS_DELIVERED";

		PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, new Intent(
				SENT), 0);

		PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
				new Intent(DELIVERED), 0);

		// —when the SMS has been sent—
		registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				switch (getResultCode()) {
				case Activity.RESULT_OK:
					Toast.makeText(getBaseContext(), "SENT", Toast.LENGTH_SHORT)
							.show();
					break;
				case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
					Toast.makeText(getBaseContext(), "Generic failure",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_NO_SERVICE:
					Toast.makeText(getBaseContext(), "No service",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_NULL_PDU:
					Toast.makeText(getBaseContext(), "Null PDU",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_RADIO_OFF:
					Toast.makeText(getBaseContext(), "Radio off",
							Toast.LENGTH_SHORT).show();
					break;
				}
			}
		}, new IntentFilter(SENT));

		// —when the SMS has been delivered—
		registerReceiver(new BroadcastReceiver() {
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				switch (getResultCode()) {
				case Activity.RESULT_OK:
					Toast.makeText(getBaseContext(), "SMS delivered",
							Toast.LENGTH_SHORT).show();
					break;
				case Activity.RESULT_CANCELED:
					Toast.makeText(getBaseContext(), "SMS not delivered",
							Toast.LENGTH_SHORT).show();
					break;
				}
			}
		}, new IntentFilter(DELIVERED));

		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);
	}

	private class AcceptThread extends Thread {
		private final BluetoothServerSocket mmServerSocket;

		public AcceptThread() {
			// Use a temporary object that is later assigned to mmServerSocket,
			// because mmServerSocket is final
			BluetoothServerSocket tmp = null;
			try {
				// MY_UUID is the app's UUID string, also used by the client
				// code
				tmp = mBluetoothAdapter.listenUsingRfcommWithServiceRecord(
						name, uuid);
			} catch (IOException e) {
			}
			mmServerSocket = tmp;
		}

		public void run() {
			BluetoothSocket socket = null;
			// Keep listening until exception occurs or a socket is returned
			while (true) {
				try {
					socket = mmServerSocket.accept();
				} catch (IOException e) {
					break;
				}
				// If a connection was accepted
				if (socket != null) {
					// Do work to manage the connection (in a separate thread)
					Log.d("listner", "accepted connection");
					try {
						mmServerSocket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
		}

		/** Will cancel the listening socket, and cause the thread to finish */
		public void cancel() {
			try {
				mmServerSocket.close();
			} catch (IOException e) {
			}
		}
	}
}
