package com.cricket.cricgame;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import com.cricket.cricgame.R;
import com.cricket.cricgame.R.id;
import com.cricket.cricgame.R.layout;
import com.cricket.dataBase.MainDataBase;
import com.cricket.reciever.NetworkReceiver;
import com.cricket.task.UploadListener;
import com.cricket.task.UploaderTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TryUpload extends Activity implements UploadListener {
	String registerMsg = "";
	ProgressDialog dialog;
	String androidId = null;
	Button tryAgain;
	String t = "tryUpload";
	MainDataBase sdb;
	UploaderTask mUploadTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.upload);
		ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = connectivityManager.getActiveNetworkInfo();
		sdb = new MainDataBase(getApplicationContext());
		dialog = new ProgressDialog(this);
		dialog.setMessage("Forcing to upload data.Please wait...");
		dialog.setCanceledOnTouchOutside(false);
		
		if (ni == null || !ni.isConnected()) {
			Toast.makeText(getApplicationContext(),
					"Please check your connectivity", Toast.LENGTH_SHORT)
					.show();
			finish();
		} else {
			Log.i(t, "Status " + sdb.getStatus());
			if (sdb.getStatus() != 0) {
				dialog.show();
				mUploadTask = new UploaderTask();
				mUploadTask.setLoginListener(TryUpload.this);
				mUploadTask.execute(sdb.getPlayed(), sdb.getToday(),
						sdb.getMonth(), sdb.getDetails().toString(),
						getApplicationContext(), "Trying to Upload Data\n");
			}
			else
				Toast.makeText(getApplicationContext(),
						"Please check your connectivity", Toast.LENGTH_SHORT)
						.show();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		if(!dialog.isShowing())
			finish();
	}
	@Override
	public void uploadComplete(int statusCode, String resMsg, Context context,
			String status) {
		// TODO Auto-generated method stub
		try {
			dialog.cancel();
			Toast t = new Toast(context);
			TextView tv = new TextView(context);
			tv.setPadding(10, 5, 10, 5);
			tv.setGravity(Gravity.CENTER);
			tv.setTextColor(Color.BLACK);
			tv.setBackgroundColor(Color.WHITE);
			tv.setTypeface(null, 1);
			t.setView(tv);
			if (statusCode == 200) {
				tv.setText(status + "Status: Success");
				t.show();
				JSONObject jObject = new JSONObject(resMsg);
				sdb.updateLogin(jObject.get("auth").toString(),
						jObject.get("validity").toString(),
						jObject.get("username").toString(),
						jObject.get("password").toString());// sdb.insertCounts("0");
				sdb.deleteDetail();
			} else {
				tv.setText(status + "Status: Failure");
				t.show();
			}
			finish();
		} catch (Exception e) {
			finish();
			Log.e(t, "Error " + e);
		}
	}

}
