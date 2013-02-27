package com.CSC193.bludroidz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SettingActivity extends Activity {
	
	private BluDroidzApplication bluDroidzApplication;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		bluDroidzApplication = new BluDroidzApplication();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
	}

	public void onSaveClicked(View view) {
		bluDroidzApplication.saveSettings();
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
