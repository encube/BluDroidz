package com.CSC193.bludroidz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.Application;
import android.util.Log;

public class BluDroidzApplication extends Application {

	private Settings settings = null;

	@Override
	public void onCreate() {
		try {
			FileInputStream fileIn = new FileInputStream("BluDroidz.Settings");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			settings = (Settings) in.readObject();
			in.close();
			fileIn.close();
			Log.d("settings loading: ", "loaded");
		} catch (IOException e) {
			File file = new File("BluDroidz.Settings");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		super.onCreate();
	}

	@Override
	public void onTerminate() {
		try {
			FileOutputStream fileOut = new FileOutputStream(
					"BluDroidz.Settings");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(settings);
			out.close();
			fileOut.close();
			Log.d("settings saving: ", "saved");
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.onTerminate();
	}

	public void startBroadcastingDevice() {
		Log.d("Application", "broadcasting device");
		// TODOconnect to bluetooth device
	}

	public void sendMessage() {
		Log.d("Application", "send message");
		// TODO send message
	}

	public void fetchInbox() {
		Log.d("Application", "fetch inbox messages");
		// TODO fetch inbox
	}

	public void fetchContacts() {
		Log.d("Application", "fetch contacts");
		// TODO fetch contacts
	}

	public void addContacts() {
		Log.d("Application", "add contacts");
		// TODO add contacts
	}

	public void saveSettings() {
		Log.d("Application", "save settings");
		// TODO save settings
	}
}
