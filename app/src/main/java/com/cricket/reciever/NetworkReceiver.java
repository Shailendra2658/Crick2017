package com.cricket.reciever;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONObject;

import android.app.Notification.Style;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.cricket.cricgame.Screen4;
import com.cricket.cricgame.code;
import com.cricket.dataBase.MainDataBase;
import com.cricket.task.UploadListener;
import com.cricket.task.UploaderTask;

public class NetworkReceiver extends BroadcastReceiver implements UploadListener{

    // turning on wifi often gets two CONNECTED events. we only want to run one thread at a time
    public static boolean running = false;
    UploaderTask mUploadTask;
    MainDataBase sdb;
    String t = "Reciever";

   @Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		sdb = new MainDataBase(context);
		NetworkInfo currentNetworkInfo = (NetworkInfo) intent
				.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
		
		if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
			if (currentNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
				Toast.makeText(context, "Network Changed", Toast.LENGTH_SHORT).show();
				/*if (interfaceIsEnabled(context, currentNetworkInfo)) {
					uploadForms(context);
				}*/
				Log.i(t,"Status "+sdb.getStatus());
				if(sdb.getStatus()!=0){
					
					mUploadTask = new UploaderTask();
					mUploadTask.setLoginListener(NetworkReceiver.this);
					mUploadTask.execute(sdb.getPlayed(),sdb.getToday(),sdb.getMonth(),sdb.getDetails().toString(),context,"Trying to Upload Data\n");
				}
			}
		} else if (action.equals("com.cricket.upload")) {
			ConnectivityManager connectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			
			 SimpleDateFormat df = new SimpleDateFormat("d MM yyyy, HH:mm");
			 String date =  df.format(Calendar.getInstance().getTime()); 
			 String score = "0";
			 String chall = "Nil";
			 Log.i(t,"Remain "+code.remBalls);
			 if (code.challenge == 1){
				 score = code.newtarget+"";
				 chall = code.target;
			 }
			 else{
				 score = code.score+"";
				 chall = "Nil";
			 }
			sdb.insertDetails(code.deviceId, code.price,code.gameType+"", code.name+"", code.over_left+"",code.remBalls+"", score,chall, date);
			NetworkInfo ni = connectivityManager.getActiveNetworkInfo();

			if (ni == null || !ni.isConnected()) {
				// not connected, do nothing
				sdb.insertCounts("1");
				
			} else {
				//Toast.makeText(context, "ImpliciteIntent called", Toast.LENGTH_SHORT).show();
				/*if (interfaceIsEnabled(context, ni)) {
					uploadForms(context);
				}*/
				 int i=0;
				 String today = "1";
				 String played = "1";
				 String month = "1";
				 Log.d(t,"Net "+sdb.checkForCount());
				 	if(sdb.checkForCount()){
				 		
				  i = Integer.parseInt(sdb.getToday());
				   today = ""+i;
				  i = Integer.parseInt(sdb.getPlayed());
				   played = ""+i;
				  i=Integer.parseInt(sdb.getMonth());
				   month = ""+i;
				 	}
				 	SimpleDateFormat formates = new SimpleDateFormat("d MM yyyy, HH:mm");
					 String dates =  formates.format(Calendar.getInstance().getTime()); 
				mUploadTask = new UploaderTask();
				mUploadTask.setLoginListener(NetworkReceiver.this);
				mUploadTask.execute(played,today,month,sdb.getDetails().toString(),context,"Uploading\n");
			}
		}
		
	}


	@Override
	public void uploadComplete( int statusCode, String resMsg, Context context, String status) {
		// TODO Auto-generated method stub
		try{
		Log.i(t,"Upload Complete"+statusCode);
		Toast t = new Toast(context);
		TextView tv = new TextView(context);
		tv.setPadding(10, 5, 10, 5);
		tv.setGravity(Gravity.CENTER);
		tv.setTextColor(Color.BLACK);
		tv.setBackgroundColor(Color.WHITE);
		tv.setTypeface(null,1);
		t.setView(tv);
			if(statusCode==200){
				//String[] message = resMsg.split(",");
				//t.makeText(context, status+"Status: Success", Toast.LENGTH_SHORT).show();
				tv.setText(status+"Status: Success");
				t.show();
				JSONObject jObject = new JSONObject(resMsg);
				sdb.updateLogin(jObject.get("auth").toString(), jObject.get("validity").toString(), jObject.get("username").toString(),jObject.get("password").toString());//sdb.insertCounts("0");
				sdb.deleteDetail();
			}
			else{
				//Toast.makeText(context, status+"Status: Failure", Toast.LENGTH_SHORT).show();
				tv.setText(status+"Status: Failure");
				t.show();
				sdb.insertCounts("1");
			}
		}
		catch(Exception e){
			Log.e(t,"Error "+e);
		}
	}





}