package com.CSC193.bludroidz;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	private BluDroidzApplication bluDroidzApplication;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		bluDroidzApplication = new BluDroidzApplication();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void onConnectClicked(View view) {
		bluDroidzApplication.startBroadcastingDevice();
		Log.d("MAIN", "connect was clicked");
	}

	public void onSettingClicked(View view) {
		Log.d("MAIN", "settings was clicked");
		Intent intent = new Intent(this, SettingActivity.class);
		startActivity(intent);
	}
}
