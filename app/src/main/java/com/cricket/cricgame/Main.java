package com.cricket.cricgame;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import shaily.wifi.Camera.WiFiDirectActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cricket.dataBase.MainDataBase;
import com.cricket.listView.CustomizedListView;

public class Main extends Activity
{
  public static String androidId,t="Main";
  ImageView logo;
  TextView played,today,month,clientId;
  Button setting;
  String registerMsg="";
  MainDataBase sdb;
  ImageView start;
  private  AlertDialog mAlertDialog;
  static String KEY_SERVER_URL="server";
  SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy, HH:mm");
  private SharedPreferences sp;
  private double over=0.0D;


  static StringBuilder inputStreamToString(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    try
    {
      while (true)
      {
        String str = localBufferedReader.readLine();
        if (str == null)
          return localStringBuilder;
        localStringBuilder.append(str);
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return localStringBuilder;
  }

  public void onBackPressed()
  {
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    Log.d(t,"Oncreate"+Double.compare(code.over, 0.0D));
    this.start = ((ImageView)findViewById(2131230722));
    this.logo = ((ImageView)findViewById(2131230721));
    played = (TextView)findViewById(R.id.played);
    today = (TextView)findViewById(R.id.today);
    month = (TextView)findViewById(R.id.month);
    clientId = (TextView) findViewById(R.id.clientId);
    setting = (Button) findViewById(R.id.setting);
    
    sdb = new MainDataBase(getApplicationContext());
    sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    over = Float.parseFloat(sp.getString(code.KEY_OVER, "0.0D"));
    if(Double.compare(over, 0.0D)!=0){
    	//Log.i(t,"True "+code.over);
    	sdb.insertCounts("0");
  		code.flag=0;
  		sendBroadcast();
  		
  	}
    //Checking and updateing count 
   if(sdb.checkForCount()){
	   String date = df.format(Calendar.getInstance().getTime()); 
	   try{
	  // Log.i(t,"date Compare "+Integer.parseInt(sdb.getDate().substring(3,5))+" > "+ Integer.parseInt(date.substring(3,5))+" Date  "+Integer.parseInt(sdb.getDate().substring(0, 2)) +"< "+ Integer.parseInt(date.substring(0, 2)));
	   if(Integer.parseInt(sdb.getDate().substring(0, 2)) < Integer.parseInt(date.substring(0, 2)))
		   sdb.updateToday();
	   if(Integer.parseInt(sdb.getDate().substring(3,5)) < Integer.parseInt(date.substring(3,5))){
		   sdb.updateToday();
		   sdb.updateMonth();
	   }
    played.setText("Total games played :"+sdb.getPlayed());
    today.setText("Total games played today :"+sdb.getToday());
    month.setText("Total games played in this month :"+sdb.getMonth());
	   }
	   catch(Exception e){
		   Log.e(t,"Erro "+e);
	   }
    
   }
   
   if(sdb.checkForTables())
	   clientId.setText("Your Id: "+sdb.getclientId());
    code.deviceId = Settings.Secure.getString(getContentResolver(), "android_id");
    
    this.start.setOnLongClickListener(new View.OnLongClickListener() {
		@Override
		public boolean onLongClick(View v) {
			// TODO Auto-generated method stub
			onCreateDialog(4);
			return false;
		}
	});
    
    setting.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(getApplicationContext(), com.cricket.preference.PreferencesActivity.class);
			startActivity(intent);
		}
	});
    
    this.start.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
    	 
    	  startActivity(new Intent(Main.this,WiFiDirectActivity.class));
//        code.bowlends = 0;
//        code.fours = 0;
//        code.sixes = 0;
//        code.remBalls = 0;
//        code.screen6 = 0;
//        code.screen7 = 0;
//        code.totalaa = 0;
//        code.totalbb = 0;
//        code.totala = 0;
//        code.totalb = 0;
//        code.score = 0;
//        code.over = 0.0D;
//        code.over_left = 0.0D;
//        code.teamA[0] = " ";
//        code.teamA[1] = " ";
//        code.teamA[2] = " ";
//        code.teamA[3] = " ";
//        code.teamB[0] = " ";
//        code.teamB[1] = " ";
//        code.teamB[2] = " ";
//        code.teamB[3] = " ";
//        code.scoreA[0] = 0;
//        code.scoreA[1] = 0;
//        code.scoreA[2] = 0;
//        code.scoreA[3] = 0;
//        code.scoreB[0] = 0;
//        code.scoreB[1] = 0;
//        code.scoreB[2] = 0;
//        code.scoreB[3] = 0;
//        code.val = 0;
//        code.val1 = 0;
//        code.totala = 0;
//        code.totalb = 0;
//        code.a1 = Boolean.valueOf(false);
//        code.b1 = Boolean.valueOf(false);
//        code.a2 = Boolean.valueOf(false);
//        code.b2 = Boolean.valueOf(false);
//        code.a3 = Boolean.valueOf(false);
//        code.b3 = Boolean.valueOf(false);
//        code.a4 = Boolean.valueOf(false);
//        code.b4 = Boolean.valueOf(false);
//        code.a = Boolean.valueOf(false);
//        code.b = Boolean.valueOf(false);
//        code.challenge = 0;
//        code.target = " ";
//        code.newtarget = 0;
//       // code.reminning = " ";
//        code.six = "six.mp4";
//        code.four = "four.mp4";
//        code.out = "out.mp4";
//        code.bowler = "bowl1.mp4";
//		sp.edit().putString(code.KEY_OVER, "0.0D").commit();
//
//        NetworkInfo localNetworkInfo = ((ConnectivityManager)Main.this.getSystemService("connectivity")).getActiveNetworkInfo();
//        Main.this.sdb = new MainDataBase(Main.this.getApplicationContext());
//        boolean bool = Main.this.sdb.checkForTables();
//        Log.d("Main", "Rs " + bool);
//        if(((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) && (!bool)){
//        	Intent localIntent2 = new Intent(Main.this, Auth1.class);
//            Main.this.startActivity(localIntent2);
//        }
//        else if(!bool)
//        	new RegAsyncTask().execute(); 
//        else{
//        	//Log.i(t,"Login "+sdb.getAuth()+""+Calendar.getInstance().get(Calendar.DAY_OF_WEEK)+" "+Integer.parseInt(sdb.getValidity()));
//	        if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && sdb.getAuth().contains("login") && !code.oneTime){
//	        	code.oneTime=true;
//	        	onCreateDialog(1);
//	        	
//	        }
//	        
//	        else if(sdb.getAuth().contains("gameCount")){
//	        	if(Integer.parseInt(sdb.getValidity())<=Integer.parseInt(sdb.getPlayed()))
//	        		onCreateDialog(1);
//	        	else
//	        		gotoScreen0();
//	        }
//	        else
//	        	gotoScreen0();
//	        
//        }
      }
    });
    
    this.logo.setOnLongClickListener(new View.OnLongClickListener() {
        public boolean onLongClick(View arg0) {
           /* Toast.makeText(getApplicationContext(), "Long Clicked " ,
                  Toast.LENGTH_SHORT).show();*/
            onCreateDialog(0);
            return true;    // <- set to true
        }
    });
    
    this.clientId.setOnLongClickListener(new View.OnLongClickListener() {
        public boolean onLongClick(View arg0) {
        	onCreateDialog(3);
        	return true;
        }
    });
    
    this.logo.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (new File(Environment.getExternalStorageDirectory().toString() + "/Videos/Break").exists())
        {
          Intent localIntent = new Intent(Main.this, CustomizedListView.class);
          Main.this.startActivity(localIntent);
        }
        else
            Toast.makeText(getApplicationContext(), "No Videos found in /Videos/Break/", 1).show();
      }
    });
  }

  public void OnResume(){
	  Main.this.sdb = new MainDataBase(Main.this.getApplicationContext());
	 
	   /* played.setText("Total games played :"+sdb.getPlayed());
	    today.setText("Total games today :"+sdb.getToday());
	    month.setText("Total games month :"+sdb.getMonth());
      boolean bool = Main.this.sdb.checkForTables();
      Log.d(t, "OnResumes " + bool);
      if(!bool || Calendar.getInstance().equals(Calendar.MONDAY)){
      	onCreateDialog(1);
      }*/
      super.onResume();
  }
  
  public void OnPause(){
	  Log.d("Main", "OnPause ");
	  super.onPause();
  }
  
  public void OnRestart(){
	  Log.d("Main", "Onrestart ");
	  super.onRestart();
  }
  public void onStart(){
	  Log.d("Main", "OnStart ");
	  super.onStart();
  }
  
  @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		 menu.add(0,1,1,"Admin");
		return super.onCreateOptionsMenu(menu);
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		  switch(item.getItemId()){
		  case 1: onCreateDialog(0);
		  }
		  
		return super.onOptionsItemSelected(item);
	}
  
  public void gotoScreen0(){
	  Toast.makeText(getApplicationContext(), "Today you played "+sdb.getToday()+" Games", Toast.LENGTH_LONG).show();
	  	
  	startActivity(new Intent(getApplicationContext(),Pricing.class));
  }
  
  private void sendBroadcast() {
		Intent i = new Intent();
		i.setAction("com.cricket.upload");
		this.sendBroadcast(i);
	}
  
  public Dialog onCreateDialog(int id) {
	  switch (id) {
		case 1:
			  mAlertDialog = new AlertDialog.Builder(this).create();
		      mAlertDialog.setIcon(R.drawable.login);
		      mAlertDialog.setTitle("Enter Username and Password ");
		      final EditText user = new EditText(this);
		      final EditText pass = new EditText(this);
		      LinearLayout advanc = new LinearLayout(this);
		      advanc.setOrientation(1);
		      user.setHint("Username");
		      pass.setHint("Password");
		     
		      user.setInputType(InputType.TYPE_CLASS_TEXT);
		      pass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
		      pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
		      advanc.addView(user);
		      advanc.addView(pass);
		      mAlertDialog.setView(advanc,20,20,20,20);
		      DialogInterface.OnClickListener errorListen = new DialogInterface.OnClickListener() {
		          @Override
		          public void onClick(DialogInterface dialog, int i) {
		              switch (i) {
		                  case DialogInterface.BUTTON1:
		                	  String username,password;
		                	  if(user.getText().toString().length()<=0 || pass.getText().toString().length()<=0){
		                		   username="nothing";
		                		   password = "nothing";
		                	  }
		                	  else{	  
			                	   username = user.getText().toString();
			                	   password = pass.getText().toString();
		                	  }
		                	 Log.i("MAmin","Ok Button");
		                	 NetworkInfo localNetworkInfo = ((ConnectivityManager)Main.this.getSystemService("connectivity")).getActiveNetworkInfo();
		                     if(localNetworkInfo==null || !localNetworkInfo.isConnected())
		                    	 Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
		                     else
		                    	 new LoginAsyc().execute(username,password);
		                  	 
		                      break;
		                  case DialogInterface.BUTTON2:
		                  		mAlertDialog.dismiss();
		                  	break;
		              }
		          }
		      
		      };
		      mAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", errorListen);
		      mAlertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", errorListen);
		      mAlertDialog.show();
		      break;
		case 0:
			mAlertDialog = new AlertDialog.Builder(this).create();
		      mAlertDialog.setIcon(R.drawable.login);
		      mAlertDialog.setTitle("Enter Admin Password ");
		      final EditText admin = new EditText(this);
		      
		      LinearLayout menu = new LinearLayout(this);
		      menu.setOrientation(1);
		      admin.setHint("Password");
		     
		      admin.setTransformationMethod(PasswordTransformationMethod.getInstance());
		      menu.addView(admin);
		      mAlertDialog.setView(menu,20,20,20,20);
		      DialogInterface.OnClickListener btnListener = new DialogInterface.OnClickListener() {
		          @Override
		          public void onClick(DialogInterface dialog, int i) {
		              switch (i) {
		                  case DialogInterface.BUTTON1:
		                	  String adminPass;  
		                	  adminPass = admin.getText().toString();
		                	  Log.i(t,"adminPas "+adminPass);
		                	  if(adminPass.contains(sdb.getPass())){
		                		  Log.i(t,"Match");
		                		  onCreateDialog(2);
		                	  }
		                	  else
		                		  Toast.makeText(getApplicationContext(), "Invalid Password", Toast.LENGTH_LONG).show();
		                      break;
		                  case DialogInterface.BUTTON2:
		                  		mAlertDialog.dismiss();
		                  	break;
		              }
		          }
		      
		      };
		      mAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", btnListener);
		      mAlertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", btnListener);
		      mAlertDialog.show();
		      break;
		case 2:
			  mAlertDialog = new AlertDialog.Builder(this).create();
		      mAlertDialog.setIcon(R.drawable.login);
		      mAlertDialog.setTitle("Enter Admin Password ");
		      String price = sdb.getPrice();
		      if(price.equals("0"))
		    	  mAlertDialog.setMessage("Sorry No Pricing Details Available");
		      else
		    	  mAlertDialog.setMessage("Total Price is "+price);
		      LinearLayout menu1 = new LinearLayout(this);
		      menu1.setOrientation(1);
		      mAlertDialog.setView(menu1,20,20,20,20);
		      DialogInterface.OnClickListener btnListener1 = new DialogInterface.OnClickListener() {
		          @Override
		          public void onClick(DialogInterface dialog, int i) {
		              switch (i) {
		                  case DialogInterface.BUTTON1:
		                	  
		                      break;
		              }
		          }
		      
		      };
		      mAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", btnListener1);
		      mAlertDialog.show();
		      break;
		case 3:
			  mAlertDialog = new AlertDialog.Builder(this).create();
		      mAlertDialog.setIcon(R.drawable.login);
		      mAlertDialog.setTitle("Change Password ");
		      final EditText old = new EditText(this);
		      final EditText newPass = new EditText(this);
		      LinearLayout linear = new LinearLayout(this);
		      linear.setOrientation(1);
		      old.setHint("Enter Old Password");
		      newPass.setHint("Enter New Password");
		     
		      linear.addView(old);
		      linear.addView(newPass);
		      mAlertDialog.setView(linear,20,20,20,20);
		      DialogInterface.OnClickListener btnPass = new DialogInterface.OnClickListener() {
		          @Override
		          public void onClick(DialogInterface dialog, int i) {
		              switch (i) {
		                  case DialogInterface.BUTTON1:
		                	  String password;
		                	  if(old.getText().toString().length()<=0 || newPass.getText().toString().length()<=0){
		                		  Toast.makeText(getApplicationContext(), "Password Cannot Be Empty", Toast.LENGTH_LONG).show();
				                    
		                	  }
		                	  else{	
		                		  if(sdb.getPass().equals(old.getText().toString())){
		                			  sdb.deletePass();
		                			  password = newPass.getText().toString();
		                			  sdb.insertPass(password);
		                			  Toast.makeText(getApplicationContext(), "Password Changed Successfully", Toast.LENGTH_LONG).show();
					                     
		                		  }
		                		  else
		                			  Toast.makeText(getApplicationContext(), "Old Password do not match", Toast.LENGTH_LONG).show();
				                     
		                	  }
		                	 Log.i("MAmin","Ok Button");
		                		 
		                      break;
		                  case DialogInterface.BUTTON2:
		                  		mAlertDialog.dismiss();
		                  	break;
		              }
		          }
		      
		      };
		      mAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", btnPass);
		      mAlertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", btnPass);
		      mAlertDialog.show();
		      break;
		
		case 4:
			  mAlertDialog = new AlertDialog.Builder(this).create();
		      mAlertDialog.setIcon(R.drawable.www);
		      mAlertDialog.setTitle("Enter Server Link ");
		      final EditText admins = new EditText(this);
		      
		      LinearLayout menus = new LinearLayout(this);
		      menus.setOrientation(1);
		      //admins.setHint("Password");
		      SharedPreferences settings =
	    	            PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
	    	        String serverUrl =
	    	            settings.getString(Main.KEY_SERVER_URL,code.url);
	    	        admins.setText(serverUrl);
		    
		      menus.addView(admins);
		      mAlertDialog.setView(menus,20,20,20,20);
		      DialogInterface.OnClickListener btnListeners = new DialogInterface.OnClickListener() {
		          @Override
		          public void onClick(DialogInterface dialog, int i) {
		              switch (i) {
		                  case DialogInterface.BUTTON1:
		                	  String adminPass;  
		                	  adminPass = admins.getText().toString();
		                	  Log.i(t,"adminPas "+adminPass);
		                	  if(adminPass.contains("http://")){
		                		  Log.i(t,"Match");
		                		  SharedPreferences.Editor localEditor = PreferenceManager
		  								.getDefaultSharedPreferences(
		  										getApplicationContext()).edit();
		  						localEditor.putString(Main.KEY_SERVER_URL,adminPass);
		  						localEditor.commit();
		                		 // onCreateDialog(4);
		                	  }
		                	  else
		                		  Toast.makeText(getApplicationContext(), "Invalid URL", Toast.LENGTH_LONG).show();
		                      break;
		                  case DialogInterface.BUTTON2:
		                  		mAlertDialog.dismiss();
		                  	break;
		              }
		          }
		      
		      };
		      mAlertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", btnListeners);
		      mAlertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", btnListeners);
		      mAlertDialog.show();
		      break;
	  }
	return mAlertDialog;
  }

    

  public class RegAsyncTask extends AsyncTask<String, Integer, String>
  {
	  ProgressDialog  dialog1 = new ProgressDialog(Main.this);
	  
    protected String doInBackground(String[] paramArrayOfString)
    {

     
      return postData();
    }

    protected void onPostExecute(String regMsg)
    {
      try{
      dialog1.setMessage("Registered");
      dialog1.dismiss();
      Log.i("Main","Res "+regMsg);
      JSONObject jObject = new JSONObject(regMsg);
      if(jObject.getString("status").contains("Successfully Registered"))
      {
    	  Toast.makeText(getApplicationContext(), "Device Registered Successfully", Toast.LENGTH_LONG).show();
    	  clientId.setText("Your Id: "+jObject.getString("id"));
    	  onCreateDialog(1);
        return;
      }
      else
    	  Toast.makeText(getApplicationContext(), "Internet Connection Problem", Toast.LENGTH_LONG).show();
      }
      catch(Exception e){
    	  Log.i(t,"Error "+e);
    	  Toast.makeText(getApplicationContext(), "Internet Problem", Toast.LENGTH_LONG).show();
      }
    }

    protected void onPreExecute()
    {

		dialog1.setMessage("Checking please wait...");
	     dialog1.show();
    }

    protected void onProgressUpdate(Integer[] paramArrayOfInteger)
    {
      Log.i("Auth", "Loading ..... please wait");
    }

    public String postData()
    {
    	try
        {
    	  code.deviceId = androidId = Settings.Secure.getString(getContentResolver(), "android_id");
    	  HttpParams param = new BasicHttpParams();
    	  HttpConnectionParams.setConnectionTimeout(param, 3000);
    	  HttpConnectionParams.setSoTimeout(param, 3000);
	      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(param);
	      HttpPost localHttpPost = new HttpPost(code.url+"/send_data.php?andrId=" + Main.this.androidId);   
	      HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
	     
	      try {
	    	  registerMsg = EntityUtils.toString(localHttpResponse.getEntity());
	        } catch (ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            Log.i("Parse Exception", e + "");

	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            Log.i("IO Exception 2", e + "");

	        }
	        Log.i(t,"Response "+registerMsg);
	      return registerMsg;
      }
      catch (Exception localIOException)
      {
    	  Log.e(t,"Error "+localIOException);
    	  return "{'status':'Problem while Registering','id':'0'}";
      }
    }
  }
  
  public class LoginAsyc extends AsyncTask<String, Integer, String>{
	  ProgressDialog dialog = new ProgressDialog(Main.this);
	  
	@Override
	protected String doInBackground(String[] str) {
		// TODO Auto-generated method stub
		try{
			
			dialog.setTitle("Validating");
			dialog.setMessage("Checking please wait...");
			dialog.show();
			
		String androidId =  Settings.Secure.getString(getContentResolver(), "android_id");
		String gamesPlayed="0";
		if(sdb.checkForCount())
			gamesPlayed = sdb.getPlayed();
		HttpParams params = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(params, 3000);
		HttpConnectionParams.setSoTimeout(params, 3000);
		DefaultHttpClient httpClient = new DefaultHttpClient(params);
		HttpPost localPost = new HttpPost(code.url+"/login.php?name="+str[0]+"&password="+str[1]+"&andrId="+androidId+"&played="+gamesPlayed);
		BasicHttpResponse httpResponse = (BasicHttpResponse) httpClient.execute(localPost);
		//registerMsg = Main.inputStreamToString(httpResponse.getEntity().getContent()).toString();
		
          try {
        	  registerMsg = EntityUtils.toString(httpResponse.getEntity());
          } catch (ParseException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
              Log.i("Parse Exception", e + "");

          } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
              Log.i("IO Exception 2", e + "");

          }

		Log.i("Main","reg "+registerMsg+" URL "+code.url+"/login.php?name="+URLEncoder.encode(str[0], "UTF-8")+"&password="+URLEncoder.encode(str[1], "UTF-8")+"&andrId="+androidId);
		}
		catch(Exception e){
			// Toast.makeText(getApplicationContext(), "Internet Connection Problem", Toast.LENGTH_LONG).show();
			Log.e("Main","Eror in login back "+e);
			registerMsg = "{username:'',password:'',location:'',validity:'',auth:'',status:''}";
			
		}
		return registerMsg;
	}
	
	protected void onPostExecute(String param){
			Log.d("Main","Param "+param);
			try{
		  dialog.setMessage("Checking complete");
	      dialog.dismiss();
	     
	      JSONObject jObject = new JSONObject(registerMsg);
	      
		if(jObject.get("status").toString().contains("true")){
			  Main.this.sdb = new MainDataBase(Main.this.getApplicationContext());
			 
			  sdb.insertValue(jObject.get("id").toString(),jObject.get("username").toString(), jObject.get("password").toString(), jObject.get("location").toString(),jObject.get("validity").toString(),jObject.get("auth").toString());
			 
			  gotoScreen0();
		}
		else if(jObject.get("status").toString().contains("update")){
			sdb = new MainDataBase(Main.this.getApplicationContext());
			sdb.updateCounts(jObject.get("played").toString());
		}
		else
			Toast.makeText(getApplicationContext(), "Incorrect Username and Password", Toast.LENGTH_LONG).show();
			}
			catch(Exception e){
				Log.e(t,"Post Error "+e);
			}
	}
	
	protected void onPreExecute()
    {
      dialog.setMessage("Checking please wait...");
      dialog.show();
    }
	  
  }
  
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.Main
 * JD-Core Version:    0.6.2
 */