package com.cricket.cricgame;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.cricket.listView.CustomizedListView;

public class Screen8 extends Activity
{
  TextView balls;
  TextView bowl;
  TextView brek;
  TextView four;
  VideoView mVideoView;
  TextView anim;
  TextView one;
  TextView out;
  TextView palyername;
  ImageView restart;
  TextView six;
  TextView target;
  TextView wide;
  TextView zero;
  String animText;
  TextView demoanimation,demovideoanimation;


  private void showFourPopup3(Activity paramActivity)
  {
    Display localDisplay = ((WindowManager)getApplicationContext().getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    LinearLayout localLinearLayout = (LinearLayout)paramActivity.findViewById(2131230731);
    View localView = ((LayoutInflater)paramActivity.getSystemService("layout_inflater")).inflate(2130903044, localLinearLayout);
    final PopupWindow localPopupWindow = new PopupWindow(paramActivity);
    localPopupWindow.setContentView(localView);
    localPopupWindow.setWidth(i);
    localPopupWindow.setHeight(j);
    localPopupWindow.setFocusable(true);
    localPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    localPopupWindow.showAtLocation(localView, 17, 30, 30);
    final Dialog localDialog = new Dialog(this, 16973834);
    localDialog.setContentView(2130903044);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localDialog.show();
    Log.e("Screen4", "Popup3");
    this.anim = ((TextView)localDialog.findViewById(R.id.anim));
    this.demovideoanimation = ((TextView)localDialog.findViewById(R.id.demovideoanimation));

    anim.setTextSize(31);
    anim.setText(animText);
    Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/TIMES.TTF");
    anim.setTypeface(tf,1);
    anim.startAnimation(AnimationUtils.loadAnimation(this, R.anim.moving_text));
    if(code.gameType.equals("demo")){
  	  	demovideoanimation.setVisibility(View.VISIBLE);
  	  	demovideoanimation.startAnimation(AnimationUtils.loadAnimation(this, R.anim.blink));

    }
    this.mVideoView = ((VideoView)localDialog.findViewById(2131230730));
    this.mVideoView.setVideoPath(Environment.getExternalStorageDirectory().toString() + "/Videos/" + code.four);
    this.mVideoView.requestFocus();
    this.mVideoView.start();
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        localDialog.dismiss();
        localPopupWindow.dismiss();
      }
    }
    , 6100L);
  }

  private void showOutPopup3(Activity paramActivity)
  {
    Display localDisplay = ((WindowManager)getApplicationContext().getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    LinearLayout localLinearLayout = (LinearLayout)paramActivity.findViewById(2131230731);
    View localView = ((LayoutInflater)paramActivity.getSystemService("layout_inflater")).inflate(2130903044, localLinearLayout);
    final PopupWindow localPopupWindow = new PopupWindow(paramActivity);
    localPopupWindow.setContentView(localView);
    localPopupWindow.setWidth(i);
    localPopupWindow.setHeight(j);
    localPopupWindow.setFocusable(true);
    localPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    localPopupWindow.showAtLocation(localView, 17, 30, 30);
    final Dialog localDialog = new Dialog(this, 16973834);
    localDialog.setContentView(2130903044);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localDialog.show();
    Log.e("Screen4", "Popup3");
    this.anim = ((TextView)localDialog.findViewById(R.id.anim));
    this.demovideoanimation = ((TextView)localDialog.findViewById(R.id.demovideoanimation));

    anim.setTextSize(31);
    anim.setText(animText);
    Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/TIMES.TTF");
    anim.setTypeface(tf,1);
    anim.startAnimation(AnimationUtils.loadAnimation(this, R.anim.moving_text));
    if(code.gameType.equals("demo")){
  	  	demovideoanimation.setVisibility(View.VISIBLE);
  	  	demovideoanimation.startAnimation(AnimationUtils.loadAnimation(this, R.anim.blink));

    }
    this.mVideoView = ((VideoView)localDialog.findViewById(2131230730));
    this.mVideoView.setVideoPath(Environment.getExternalStorageDirectory().toString() + "/Videos/" + code.out);
    this.mVideoView.requestFocus();
    this.mVideoView.start();
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        localDialog.dismiss();
        localPopupWindow.dismiss();
      }
    }
    , 6100L);
  }

  private void showPopup0(Activity paramActivity,String str)
  {
    Display localDisplay = ((WindowManager)getApplicationContext().getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    LinearLayout localLinearLayout = (LinearLayout)paramActivity.findViewById(2131230840);
    View localView = ((LayoutInflater)paramActivity.getSystemService("layout_inflater")).inflate(2130903066, localLinearLayout);
    final PopupWindow localPopupWindow = new PopupWindow(paramActivity);
    localPopupWindow.setContentView(localView);
    localPopupWindow.setWidth(i);
    localPopupWindow.setHeight(j);
    localPopupWindow.setFocusable(true);
    localPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    localPopupWindow.showAtLocation(localView, 17, 0, 0);
    ((TextView)localView.findViewById(2131230734)).setText(str);
    if(code.gameType.equals("demo")){
  	  	demovideoanimation.setVisibility(View.VISIBLE);
  	  	demovideoanimation.startAnimation(AnimationUtils.loadAnimation(this, R.anim.blink));

    }
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        localPopupWindow.dismiss();
      }
    }
    , 3000L);
    ((Button)localView.findViewById(2131230735)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localPopupWindow.dismiss();
      }
    });
  }

  private void showPopup3(Activity paramActivity)
  {
    final Dialog localDialog = new Dialog(this, 16973834);
    localDialog.setContentView(2130903043);
    VideoView localVideoView = (VideoView)localDialog.findViewById(2131230730);
    String str = Environment.getExternalStorageDirectory().toString() + "/Videos/" + code.four;
    localDialog.show();
    localVideoView.setVideoPath(str);
    localVideoView.requestFocus();
    localVideoView.start();
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        localDialog.dismiss();
      }
    }
    , 6000L);
  }

  private void showPopup4(Activity paramActivity)
  {
    final Dialog localDialog = new Dialog(this, 16973834);
    localDialog.setContentView(2130903043);
    VideoView localVideoView = (VideoView)localDialog.findViewById(2131230730);
    String str = Environment.getExternalStorageDirectory().toString() + "/Videos/" + code.six;
    localDialog.show();
    localVideoView.setVideoPath(str);
    localVideoView.requestFocus();
    localVideoView.start();
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        localDialog.dismiss();
      }
    }
    , 6000L);
  }

  private void showPopup5(Activity paramActivity)
  {
    final Dialog localDialog = new Dialog(this, 16973834);
    localDialog.setContentView(2130903043);
    VideoView localVideoView = (VideoView)localDialog.findViewById(2131230730);
    String str = Environment.getExternalStorageDirectory().toString() + "/Videos/" + code.out;
    localDialog.show();
    localVideoView.setVideoPath(str);
    localVideoView.requestFocus();
    localVideoView.start();
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        localDialog.dismiss();
      }
    }
    , 6000L);
  }

  private void showPopup6(Activity paramActivity)
  {
    final Dialog localDialog = new Dialog(this, 16973834);
    localDialog.setContentView(2130903055);
    TextView anim = ((TextView)localDialog.findViewById(R.id.anim));
    this.demoanimation = ((TextView)localDialog.findViewById(R.id.demoanimation));

    anim.setTextSize(31);
    anim.setText(animText);
    Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/TIMES.TTF");
    anim.setTypeface(tf,1);
    anim.startAnimation(AnimationUtils.loadAnimation(this, R.anim.moving_text));
    if(code.gameType.equals("demo")){
  	  	demoanimation.setVisibility(View.VISIBLE);
  	  	demoanimation.startAnimation(AnimationUtils.loadAnimation(this, R.anim.blink));
    }
    VideoView localVideoView = (VideoView)localDialog.findViewById(2131230768);
    RelativeLayout localRelativeLayout = (RelativeLayout)localDialog.findViewById(2131230784);
    localVideoView.setVisibility(0);
    localRelativeLayout.setVisibility(0);
    String str = Environment.getExternalStorageDirectory().toString() + "/Videos/" + code.bowler;
    this.zero = ((TextView)localDialog.findViewById(2131230769));
    this.one = ((TextView)localDialog.findViewById(2131230775));
    this.four = ((TextView)localDialog.findViewById(2131230774));
    this.six = ((TextView)localDialog.findViewById(2131230776));
    this.out = ((TextView)localDialog.findViewById(2131230773));
    this.wide = ((TextView)localDialog.findViewById(2131230770));
    this.bowl = ((TextView)localDialog.findViewById(2131230771));
    this.brek = ((TextView)localDialog.findViewById(2131230772));
    this.bowl.setVisibility(8);
    this.brek.setVisibility(8);
   /* this.six.setVisibility(0);
    this.zero.setVisibility(0);
    this.one.setVisibility(0);
    this.four.setVisibility(0);
    this.out.setVisibility(0);
    this.wide.setVisibility(0);*/
    localDialog.getWindow().setSoftInputMode(4);
    localDialog.setOnKeyListener(new DialogInterface.OnKeyListener()
    {
      public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousKeyEvent.getAction() != 0)
          return true;
        if (paramAnonymousInt == 7)
        {
          Log.i("Dialog", "0 Pressed");
          paramAnonymousDialogInterface.dismiss();
          code.remBalls = -1 + code.remBalls;
          if (code.remBalls < 0)
          {
            Intent localIntent7 = new Intent(Screen8.this, Screen5.class);
            Screen8.this.startActivity(localIntent7);
            return true;
          }
          Screen8.this.balls.setText(Integer.toString(code.remBalls));
          return true;
        }
        if (paramAnonymousInt == 8)
        {
          Log.i("Dialog", "1 Pressed");
          paramAnonymousDialogInterface.dismiss();
          code.newtarget = 1 + code.newtarget;
          code.remBalls = -1 + code.remBalls;
          if (code.remBalls < 0)
          {
            Intent localIntent6 = new Intent(Screen8.this, Screen5.class);
            Screen8.this.startActivity(localIntent6);
            return true;
          }
          Screen8.this.balls.setText(Integer.toString(code.remBalls));
          Screen8.this.target.setText(Integer.toString(code.newtarget));
          return true;
        }
        if (paramAnonymousInt == 11)
        {
          Log.i("Dialog", "4 Pressed");
          code.fours = 1 + code.fours;
          code.newtarget = 4 + code.newtarget;
          code.remBalls = -1 + code.remBalls;
          if (code.remBalls < 0)
          {
            Intent localIntent5 = new Intent(Screen8.this, Screen5.class);
            Screen8.this.startActivity(localIntent5);
          }
          while (true)
          {
            paramAnonymousDialogInterface.dismiss();
            Screen8.this.showFourPopup3(Screen8.this);
           
            Screen8.this.balls.setText(Integer.toString(code.remBalls));
            Screen8.this.target.setText(Integer.toString(code.newtarget));
            return true;
          }
        }
        if (paramAnonymousInt == 13)
        {
          Log.i("Dialog", "6 Pressed");
          code.sixes = 1 + code.sixes;
          code.newtarget = 6 + code.newtarget;
          code.remBalls = -1 + code.remBalls;
          if (code.remBalls < 0)
          {
            Intent localIntent4 = new Intent(Screen8.this, Screen5.class);
            Screen8.this.startActivity(localIntent4);
          }
          while (true)
          {
            paramAnonymousDialogInterface.dismiss();
            Screen8.this.showSixPopup3(Screen8.this);
          
            Screen8.this.balls.setText(Integer.toString(code.remBalls));
            Screen8.this.target.setText(Integer.toString(code.newtarget));
            return true;
          }
        }
        if (paramAnonymousInt == 32)
        {
          Log.i("Dialog", "dead Pressed");
          paramAnonymousDialogInterface.dismiss();
         
         
          while (true)
          {
            Screen8.this.showPopup0(Screen8.this,"DEAD BALL");
            
            
            return true;
          }
        }
        if (paramAnonymousInt == 43)
        {
          Log.i("Screen8Dialog", "out Pressed");
          code.remBalls = -1 + code.remBalls;
          if (-5 + code.newtarget < 0)
            code.newtarget = 0;
          else
        	  code.newtarget = -5 + code.newtarget;
          
          if (code.remBalls < 0)
          {
            Intent localIntent2 = new Intent(Screen8.this, Screen5.class);
            Screen8.this.startActivity(localIntent2);
          }
          while (true)
          {
        	 paramAnonymousDialogInterface.dismiss();
            Screen8.this.showOutPopup3(Screen8.this);
            
            Screen8.this.balls.setText(Integer.toString(code.remBalls));
            Screen8.this.target.setText(Integer.toString(code.newtarget));
            return true;
          }
         /* code.remBalls = -1 + code.remBalls;
          if (-5 + code.newtarget < 0)
          {
            code.newtarget = 0;
           
            
          }
          else{
        	  code.newtarget = -5 + code.newtarget;
          }
          paramAnonymousDialogInterface.dismiss();
          Screen8.this.showOutPopup3(Screen8.this);
          Screen8.this.balls.setText(Integer.toString(code.remBalls));
          if (code.remBalls <= 0){
              Intent localIntent3 = new Intent(Screen8.this, Screen5.class);
              Screen8.this.startActivity(localIntent3);
              }
          while (true)
          {
            paramAnonymousDialogInterface.dismiss();
            Screen8.this.showOutPopup3(Screen8.this);
            return true;
            //code.newtarget = -5 + code.newtarget;
           // break;
           // label530: Screen8.this.balls.setText(Integer.toString(code.remBalls));
          }*/
        }
        if (paramAnonymousInt == 51)
        {
          Log.i("Dialog", "wide Pressed");
          paramAnonymousDialogInterface.dismiss();
          code.newtarget = 1 + code.newtarget;
          if (code.remBalls < 0)
          {
            Intent localIntent2 = new Intent(Screen8.this, Screen5.class);
            Screen8.this.startActivity(localIntent2);
          }
          while (true)
          {
            Screen8.this.showPopup0(Screen8.this,"WIDE BALL");
            
            Screen8.this.balls.setText(Integer.toString(code.remBalls));
            Screen8.this.target.setText(Integer.toString(code.newtarget));
            return true;
          }
        }
        if (paramAnonymousInt == 48)
        {
          Log.i("Dialog", "break Pressed");
          if (new File(Environment.getExternalStorageDirectory().toString() + "/Videos/Break/").exists())
          {
            Intent localIntent1 = new Intent(Screen8.this, CustomizedListView.class);
            Screen8.this.startActivity(localIntent1);
            return true;
          }
          Toast.makeText(Screen8.this.getApplicationContext(), "No Videos found in /Videos/Break/", 1).show();
          return true;
        }
        return false;
      }
    });
    
    //Onclick
    this.out.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
          localDialog.dismiss();
    	  code.remBalls = -1 + code.remBalls;
          
        if (-5 + code.newtarget < 0)
          code.newtarget = 0;
        else
          code.newtarget = -5 + code.newtarget;
        
        Screen8.this.showOutPopup3(Screen8.this);
        if (code.remBalls < 0){
            Intent localIntent = new Intent(Screen8.this, Screen5.class);
            Screen8.this.startActivity(localIntent);
            return;
            }
        balls.setText(Integer.toString(code.remBalls));
        target.setText(Integer.toString(code.newtarget));
      }
    });
    this.zero.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localDialog.dismiss();
        code.remBalls = -1 + code.remBalls;
        if (code.remBalls < 0)
        {
          Intent localIntent = new Intent(Screen8.this, Screen5.class);
          Screen8.this.startActivity(localIntent);
          return;
        }
        Screen8.this.balls.setText(Integer.toString(code.remBalls));
      }
    });
    this.one.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localDialog.dismiss();
        code.newtarget = 1 + code.newtarget;
        code.remBalls = -1 + code.remBalls;
        if (code.remBalls < 0)
        {
          Intent localIntent = new Intent(Screen8.this, Screen5.class);
          Screen8.this.startActivity(localIntent);
          return;
        }
        Screen8.this.balls.setText(Integer.toString(code.remBalls));
        Screen8.this.target.setText(Integer.toString(code.newtarget));
      }
    });
    this.wide.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localDialog.dismiss();
        code.newtarget = 1 + code.newtarget;
        if (code.remBalls < 0)
        {
          Intent localIntent = new Intent(Screen8.this, Screen5.class);
          Screen8.this.startActivity(localIntent);
        }
        else{
        	Screen8.this.showPopup0(Screen8.this,"WIDE BALL");
            
            Screen8.this.balls.setText(Integer.toString(code.remBalls));
            Screen8.this.target.setText(Integer.toString(code.newtarget));
        }
       /* while (true)
        {
          Screen8.this.showPopup0(Screen8.this);
         
          Screen8.this.balls.setText(Integer.toString(code.remBalls));
          Screen8.this.target.setText(Integer.toString(code.newtarget));
          return;
        }*/
      }
    });
    this.four.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        code.fours = 1 + code.fours;
        code.newtarget = 4 + code.newtarget;
        code.remBalls = -1 + code.remBalls;
        if (code.remBalls < 0)
        {
          Intent localIntent = new Intent(Screen8.this, Screen5.class);
          Screen8.this.startActivity(localIntent);
        }
        else{
        	localDialog.dismiss();
            Screen8.this.showFourPopup3(Screen8.this);
         //   return;
            Screen8.this.balls.setText(Integer.toString(code.remBalls));
            Screen8.this.target.setText(Integer.toString(code.newtarget));
        }
        /*while (true)
        {
          localDialog.dismiss();
          Screen8.this.showFourPopup3(Screen8.this);
          return;
          Screen8.this.balls.setText(Integer.toString(code.remBalls));
          Screen8.this.target.setText(Integer.toString(code.newtarget));
        }*/
      }
    });
    this.six.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        code.sixes = 1 + code.sixes;
        code.newtarget = 6 + code.newtarget;
        code.remBalls = -1 + code.remBalls;
        if (code.remBalls < 0)
        {
          Intent localIntent = new Intent(Screen8.this, Screen5.class);
          Screen8.this.startActivity(localIntent);
        }
        else{
        	localDialog.dismiss();
            Screen8.this.showSixPopup3(Screen8.this);
           // return;
            Screen8.this.balls.setText(Integer.toString(code.remBalls));
            Screen8.this.target.setText(Integer.toString(code.newtarget));
        }
        /*while (true)
        {
          localDialog.dismiss();
          Screen8.this.showSixPopup3(Screen8.this);
          return;
          Screen8.this.balls.setText(Integer.toString(code.remBalls));
          Screen8.this.target.setText(Integer.toString(code.newtarget));
        }*/
      }
    });
    localDialog.show();
    localVideoView.setVideoPath(str);
    localVideoView.requestFocus();
    localVideoView.start();
  }

  private void showSixPopup3(Activity paramActivity)
  {
    Display localDisplay = ((WindowManager)getApplicationContext().getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    LinearLayout localLinearLayout = (LinearLayout)paramActivity.findViewById(2131230731);
    View localView = ((LayoutInflater)paramActivity.getSystemService("layout_inflater")).inflate(2130903044, localLinearLayout);
    final PopupWindow localPopupWindow = new PopupWindow(paramActivity);
    localPopupWindow.setContentView(localView);
    localPopupWindow.setWidth(i);
    localPopupWindow.setHeight(j);
    localPopupWindow.setFocusable(true);
    localPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    localPopupWindow.showAtLocation(localView, 17, 0, 0);
    final Dialog localDialog = new Dialog(this, 16973834);
    localDialog.setContentView(2130903044);
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localDialog.show();
    Log.e("Screen4", "Popup3");
    this.anim = ((TextView)localDialog.findViewById(R.id.anim));
    this.demovideoanimation = ((TextView)localDialog.findViewById(R.id.demovideoanimation));

    anim.setTextSize(31);
    anim.setText(animText);
    Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/TIMES.TTF");
    anim.setTypeface(tf,1);
    anim.startAnimation(AnimationUtils.loadAnimation(this, R.anim.moving_text));
    if(code.gameType.equals("demo")){
  	  	demovideoanimation.setVisibility(View.VISIBLE);
  	  	demovideoanimation.startAnimation(AnimationUtils.loadAnimation(this, R.anim.blink));

    }
    this.mVideoView = ((VideoView)localDialog.findViewById(2131230730));
    this.mVideoView.setVideoPath(Environment.getExternalStorageDirectory().toString() + "/Videos/" + code.six);
    this.mVideoView.requestFocus();
    this.mVideoView.start();
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        localDialog.dismiss();
        localPopupWindow.dismiss();
      }
    }
    , 6100L);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903055);
    code.score = Integer.parseInt(code.target);
    this.balls = ((TextView)findViewById(2131230756));
    this.target = ((TextView)findViewById(2131230765));
    this.restart = ((ImageView)findViewById(2131230764));
    this.zero = ((TextView)findViewById(2131230769));
    this.one = ((TextView)findViewById(2131230775));
    this.four = ((TextView)findViewById(2131230774));
    this.six = ((TextView)findViewById(2131230776));
    this.out = ((TextView)findViewById(2131230773));
    this.wide = ((TextView)findViewById(2131230770));
    this.bowl = ((TextView)findViewById(2131230771));
    this.brek = ((TextView)findViewById(2131230772));
    this.palyername = ((TextView)findViewById(2131230763));
    this.demoanimation = ((TextView)findViewById(R.id.demoanimation));

    this.target.setText(Integer.toString(code.newtarget));
    this.balls.setText(Integer.toString(code.remBalls));
    this.palyername.setText(code.name.toUpperCase());
    
    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    animText = pref.getString("scroll", "Top Score");
    this.restart.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(Screen8.this);
        localBuilder.setMessage("Are you sure?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.cancel();
            Intent localIntent = new Intent(Screen8.this, Main.class);
            Screen8.this.finish();
            Screen8.this.startActivity(localIntent);
          }
        }).setNegativeButton("No", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.cancel();
          }
        });
        AlertDialog localAlertDialog = localBuilder.create();
        localAlertDialog.setTitle("Details");
        localAlertDialog.show();
      }
    });
    this.bowl.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (code.remBalls <= 0)
        {
          Intent localIntent = new Intent(Screen8.this, Screen5.class);
          Screen8.this.startActivity(localIntent);
          return;
        }
        Screen8.this.showPopup6(Screen8.this);
      }
    });
    this.brek.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (new File(Environment.getExternalStorageDirectory().toString() + "/Videos/").exists())
        {
          Intent localIntent = new Intent(Screen8.this, CustomizedListView.class);
          Screen8.this.startActivity(localIntent);
        }
      }
    });
    
    if(code.gameType.equals("demo")){
	  	demoanimation.setVisibility(View.VISIBLE);
	    demoanimation.startAnimation(AnimationUtils.loadAnimation(this, R.anim.blink));
	  	
  }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() != 0)
      return true;
    if (paramInt == 30)
      if (code.remBalls <= 0)
        startActivity(new Intent(this, Screen5.class));
    /*while (true)
    {*/
      Log.d("Scren8", "Key Down  :" + paramInt);
      
    //  continue;
      if (paramInt == 48)
      {
        if (new File(Environment.getExternalStorageDirectory().toString() + "/Videos/Break/").exists())
          startActivity(new Intent(this, CustomizedListView.class));
        else
          Toast.makeText(getApplicationContext(), "No Videos found in /Videos/Break/", 1).show();
      }
      else if (paramInt == 46)
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setMessage("Are you sure?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface.cancel();
            Intent localIntent = new Intent(Screen8.this, Main.class);
            Screen8.this.finish();
            Screen8.this.startActivity(localIntent);
          }
        }).setNegativeButton("No", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface.cancel();
          }
        });
        AlertDialog localAlertDialog = localBuilder.create();
        localAlertDialog.setTitle("Details");
        localAlertDialog.show();
      }
      else
    	  showPopup6(this);
    //}
      return super.onKeyDown(paramInt, paramKeyEvent);
  }
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.Screen8
 * JD-Core Version:    0.6.2
 */