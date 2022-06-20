/*
 * Copyright (C) 2011 University of Washington
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.cricket.preference;

import java.util.ArrayList;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.provider.MediaStore.Images;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.widget.Toast;

public class PreferencesActivity extends PreferenceActivity implements
		OnPreferenceChangeListener {
	private final static String t = "PreferencesActivity";
	protected static final int IMAGE_CHOOSER = 0;
	


	public static final String KEY_SCROLL = "scroll";

	
	private EditTextPreference mScrollPreference;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e(t, "onCreate");
		addPreferencesFromResource(com.cricket.cricgame.R.xml.preferences);
		setTitle("Top Score > Settings");

		// not super safe, but we're just putting in this mode to help
		// administrate
		// would require code to access it
		
		mScrollPreference = (EditTextPreference) findPreference(KEY_SCROLL);
		mScrollPreference
				.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
					@Override
					public boolean onPreferenceChange(Preference preference,
							Object newValue) {
						String url = newValue.toString();
							preference.setSummary(newValue.toString());
							return true;
						
					}
				});
		mScrollPreference.setSummary(mScrollPreference.getText());
		mScrollPreference.getEditText().setFilters(
				new InputFilter[] { getReturnFilter() });

	}

	

	/**
	 * Disallows whitespace from user entry
	 * 
	 * @return
	 */
	private InputFilter getWhitespaceFilter() {
		InputFilter whitespaceFilter = new InputFilter() {
			public CharSequence filter(CharSequence source, int start, int end,
					Spanned dest, int dstart, int dend) {
				for (int i = start; i < end; i++) {
					if (Character.isWhitespace(source.charAt(i))) {
						return "";
					}
				}
				return null;
			}
		};
		return whitespaceFilter;
	}

	/**
	 * Disallows carriage returns from user entry
	 * 
	 * @return
	 */
	private InputFilter getReturnFilter() {
		InputFilter returnFilter = new InputFilter() {
			public CharSequence filter(CharSequence source, int start, int end,
					Spanned dest, int dstart, int dend) {
				for (int i = start; i < end; i++) {
					if (Character.getType((source.charAt(i))) == Character.CONTROL) {
						return "";
					}
				}
				return null;
			}
		};
		return returnFilter;
	}

	/**
	 * Generic listener that sets the summary to the newly selected/entered
	 * value
	 */
	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue) {
		preference.setSummary((CharSequence) newValue);
		return true;
	}

}
