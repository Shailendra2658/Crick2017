package com.cricket.preference;

import shaily.wifi.Camera.CommonMethods;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceChangeListener;
import android.util.Log;

import com.cricket.cricgame.R;

public class WifiSettings extends PreferencesActivity  implements
OnPreferenceChangeListener{
	public static final String KEY_CONNECT = "connect";
	public static final int CHOOSE_FILE_RESULT_CODE = 10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.wifi_preferences);
		Preference filePicker = (Preference) findPreference(KEY_CONNECT);
	    filePicker.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
	        @Override
	        public boolean onPreferenceClick(Preference preference) {
	        	Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				intent.setType("text/*");
				startActivityForResult(intent, CHOOSE_FILE_RESULT_CODE);
	            return true;
	        }
	    });
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == CHOOSE_FILE_RESULT_CODE){
			if (resultCode == this.RESULT_OK) {
				setConnectPath(data.getData());
			} else {
				CommonMethods.DisplayToast(this, "Cancelled Request");
			}
		}
	}
	
	private void setConnectPath(Uri path) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();
		editor.putString(KEY_CONNECT, path.toString());
		editor.commit();

		Preference filePicker = (Preference) findPreference(KEY_CONNECT);
		filePicker.setSummary(path.toString());
	}
}
