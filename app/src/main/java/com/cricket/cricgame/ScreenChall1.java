package com.cricket.cricgame;

import java.io.File;

import com.cricket.listView.CustomizedListView;

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

public class ScreenChall1 extends Activity
{
  TextView balls;
  TextView bowl;
  TextView brek;
  int done = 0;
  TextView four;
  VideoView mVideoView;
  TextView anim;
  TextView newtarget;
  TextView one;
  TextView out;
  double overs = 0.0D;
  TextView palyername;
  ImageView restart;
  TextView scoreb;
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

  private void showPopup0(Activity paramActivity, String str)
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
    	((TextView)localView.findViewById(R.id.demovideoanimation)).setVisibility(View.VISIBLE);
    	((TextView)localView.findViewById(R.id.demovideoanimation)).startAnimation(AnimationUtils.loadAnimation(this, R.anim.blink));

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

  private void showPopup6(Activity paramActivity)
  {
    final Dialog localDialog = new Dialog(this, 16973834);
    localDialog.setContentView(2130903058);
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
    RelativeLayout localRelativeLayout = (RelativeLayout)localDialog.findViewById(2131230790);
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
   /* new Handler().postDelayed(new Runnable()
    {
      public void run()
      {*/
       /* ScreenChall1.this.six.setVisibility(0);
        ScreenChall1.this.zero.setVisibility(0);
        ScreenChall1.this.one.setVisibility(0);
        ScreenChall1.this.four.setVisibility(0);
        ScreenChall1.this.out.setVisibility(0);
        ScreenChall1.this.wide.setVisibility(0);*/
      //}
    /*}
    , 6000L);*/
    localDialog.show();
    localVideoView.setVideoPath(str);
    localVideoView.requestFocus();
    localVideoView.start();
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
          if (code.score <= 0)
          {
            Intent localIntent13 = new Intent(ScreenChall1.this, Screen6.class);
            ScreenChall1.this.startActivity(localIntent13);
            return true;
          }
          if (code.remBalls < 0)
          {
            Intent localIntent14 = new Intent(ScreenChall1.this, Screen7.class);
            ScreenChall1.this.startActivity(localIntent14);
            return true;
          }
          ScreenChall1.this.balls.setText(Integer.toString(code.remBalls));
          return true;
        }
        if (paramAnonymousInt == 8)
        {
          Log.i("Dialog", "1 Pressed");
          paramAnonymousDialogInterface.dismiss();
          code.score = -1 + code.score;
          code.newtarget = 1 + code.newtarget;
          code.remBalls = -1 + code.remBalls;
          if ((code.score <= 0) && (code.screen6 == 0))
          {
            Intent localIntent12 = new Intent(ScreenChall1.this, Screen6.class);
            ScreenChall1.this.startActivity(localIntent12);
            return true;
          }
          if (code.remBalls < 0)
          {
            Intent localIntent11 = new Intent(ScreenChall1.this, Screen7.class);
            ScreenChall1.this.startActivity(localIntent11);
            return true;
          }
          ScreenChall1.this.newtarget.setText(Integer.toString(code.newtarget));
          ScreenChall1.this.balls.setText(Integer.toString(code.remBalls));
          ScreenChall1.this.target.setText(Integer.toString(code.score));
          return true;
        }
        if (paramAnonymousInt == 11)
        {
          Log.i("Dialog", "4 Pressed");
          code.fours = 1 + code.fours;
          code.score = -4 + code.score;
          code.newtarget = 4 + code.newtarget;
          code.remBalls = -1 + code.remBalls;
          if (code.score <= 0)
          {
            Intent localIntent9 = new Intent(ScreenChall1.this, Screen6.class);
            ScreenChall1.this.startActivity(localIntent9);
            return true;
          }
          if (code.remBalls < 0)
          {
            Intent localIntent10 = new Intent(ScreenChall1.this, Screen7.class);
            ScreenChall1.this.startActivity(localIntent10);
            return true;
          }
          paramAnonymousDialogInterface.dismiss();
          ScreenChall1.this.showFourPopup3(ScreenChall1.this);
          ScreenChall1.this.newtarget.setText(Integer.toString(code.newtarget));
          ScreenChall1.this.balls.setText(Integer.toString(code.remBalls));
          ScreenChall1.this.target.setText(Integer.toString(code.score));
          return true;
        }
        if (paramAnonymousInt == 13)
        {
          Log.i("Dialog", "6 Pressed");
          code.sixes = 1 + code.sixes;
          code.score = -6 + code.score;
          code.newtarget = 6 + code.newtarget;
          code.remBalls = -1 + code.remBalls;
          if (code.score <= 0)
          {
            Intent localIntent7 = new Intent(ScreenChall1.this, Screen6.class);
            ScreenChall1.this.startActivity(localIntent7);
            return true;
          }
          if (code.remBalls < 0)
          {
            Intent localIntent8 = new Intent(ScreenChall1.this, Screen7.class);
            ScreenChall1.this.startActivity(localIntent8);
            return true;
          }
          paramAnonymousDialogInterface.dismiss();
          ScreenChall1.this.showSixPopup3(ScreenChall1.this);
          ScreenChall1.this.newtarget.setText(Integer.toString(code.newtarget));
          ScreenChall1.this.balls.setText(Integer.toString(code.remBalls));
          ScreenChall1.this.target.setText(Integer.toString(code.score));
          return true;
        }
        if(paramAnonymousInt == 32){

            Log.i("Dialog", "Dead ball Pressed");

            paramAnonymousDialogInterface.dismiss();
            
              ScreenChall1.this.showPopup0(ScreenChall1.this,"DEAD BALL");
              
              return true;
        }
        if (paramAnonymousInt == 43)
        {
          Log.i("Dialog", "out Pressed");
          code.remBalls = -1 + code.remBalls;
          
          if (-5 + code.newtarget < 0){
        	  code.score = code.newtarget + code.score;
        	  code.newtarget=0;
          }
          else{
        	  code.newtarget = -5 + code.newtarget;
        	  code.score = 5 + code.score;
              
          }
        	  
          /*for (code.newtarget = 0; code.score <= 0; code.newtarget = -5 + code.newtarget)
          {
            Intent localIntent4 = new Intent(ScreenChall1.this, Screen6.class);
            ScreenChall1.this.startActivity(localIntent4);
            return true;
          }*/
          if (code.remBalls < 0)
          {
            Intent localIntent5 = new Intent(ScreenChall1.this, Screen7.class);
            ScreenChall1.this.startActivity(localIntent5);
            return true;
          }
          if (code.score <= 0)
          {
            Intent localIntent6 = new Intent(ScreenChall1.this, Screen6.class);
            ScreenChall1.this.startActivity(localIntent6);
            return true;
          }
          paramAnonymousDialogInterface.dismiss();
          ScreenChall1.this.showOutPopup3(ScreenChall1.this);
          ScreenChall1.this.target.setText(Integer.toString(code.score));
          ScreenChall1.this.balls.setText(Integer.toString(code.remBalls));
          ScreenChall1.this.newtarget.setText(Integer.toString(code.newtarget));
          return true;
        }
        if (paramAnonymousInt == 51)
        {
          Log.i("Dialog", "wide Pressed");
          paramAnonymousDialogInterface.dismiss();
          code.score = -1 + code.score;
          code.newtarget = 1 + code.newtarget;
          if ((code.score <= 0) && (code.screen6 == 0))
          {
            Intent localIntent3 = new Intent(ScreenChall1.this, Screen6.class);
            ScreenChall1.this.startActivity(localIntent3);
          }
          while (true)
          {
            ScreenChall1.this.showPopup0(ScreenChall1.this,"WIDE BALL");
            
            if (code.remBalls < 0)
            {
              Intent localIntent2 = new Intent(ScreenChall1.this, Screen7.class);
              ScreenChall1.this.startActivity(localIntent2);
            }
            else
            {
              ScreenChall1.this.newtarget.setText(Integer.toString(code.newtarget));
              ScreenChall1.this.balls.setText(Integer.toString(code.remBalls));
              ScreenChall1.this.target.setText(Integer.toString(code.score));
            }
            return true;
          }
        }
        if (paramAnonymousInt == 48)
        {
          Log.i("Dialog", "break Pressed");
          if (new File(Environment.getExternalStorageDirectory().toString() + "/Videos/Break/").exists())
          {
            Intent localIntent1 = new Intent(ScreenChall1.this, CustomizedListView.class);
            ScreenChall1.this.startActivity(localIntent1);
            return true;
          }
          Toast.makeText(ScreenChall1.this.getApplicationContext(), "No Videos found in /Videos/Break/", 1).show();
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
        code.remBalls = -1 + code.remBalls;
        code.score = 5 + code.score;
        if (-5 + code.newtarget < 0);
        for (code.newtarget = 0; code.score <= 0; code.newtarget = -5 + code.newtarget)
        {
          Intent localIntent1 = new Intent(ScreenChall1.this, Screen6.class);
          ScreenChall1.this.startActivity(localIntent1);
          return;
        }
        if (code.remBalls < 0)
        {
          Intent localIntent2 = new Intent(ScreenChall1.this, Screen7.class);
          ScreenChall1.this.startActivity(localIntent2);
          return;
        }
        if (code.score <= 0)
        {
          Intent localIntent3 = new Intent(ScreenChall1.this, Screen6.class);
          ScreenChall1.this.startActivity(localIntent3);
          return;
        }
        localDialog.dismiss();
        ScreenChall1.this.showOutPopup3(ScreenChall1.this);
        ScreenChall1.this.target.setText(Integer.toString(code.score));
        ScreenChall1.this.balls.setText(Integer.toString(code.remBalls));
        ScreenChall1.this.newtarget.setText(Integer.toString(code.newtarget));
      }
    });
    
    this.zero.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localDialog.dismiss();
        code.remBalls = -1 + code.remBalls;
        if (code.score <= 0)
        {
          Intent localIntent1 = new Intent(ScreenChall1.this, Screen6.class);
          ScreenChall1.this.startActivity(localIntent1);
          return;
        }
        if (code.remBalls < 0)
        {
          Intent localIntent2 = new Intent(ScreenChall1.this, Screen7.class);
          ScreenChall1.this.startActivity(localIntent2);
          return;
        }
        ScreenChall1.this.balls.setText(Integer.toString(code.remBalls));
      }
    });
    
    this.one.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localDialog.dismiss();
        code.score = -1 + code.score;
        code.newtarget = 1 + code.newtarget;
        code.remBalls = -1 + code.remBalls;
        if ((code.score <= 0) && (code.screen6 == 0))
        {
          Intent localIntent2 = new Intent(ScreenChall1.this, Screen6.class);
          ScreenChall1.this.startActivity(localIntent2);
          return;
        }
        if (code.remBalls < 0)
        {
          Intent localIntent1 = new Intent(ScreenChall1.this, Screen7.class);
          ScreenChall1.this.startActivity(localIntent1);
          return;
        }
        ScreenChall1.this.newtarget.setText(Integer.toString(code.newtarget));
        ScreenChall1.this.balls.setText(Integer.toString(code.remBalls));
        ScreenChall1.this.target.setText(Integer.toString(code.score));
      }
    });
    
    this.wide.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localDialog.dismiss();
        code.score = -1 + code.score;
        code.newtarget = 1 + code.newtarget;
        if ((code.score <= 0) && (code.screen6 == 0))
        {
          Intent localIntent2 = new Intent(ScreenChall1.this, Screen6.class);
          ScreenChall1.this.startActivity(localIntent2);
        }
        while (true)
        {
          ScreenChall1.this.showPopup0(ScreenChall1.this,"WIDE BALL");
          
          if (code.remBalls < 0)
          {
            Intent localIntent1 = new Intent(ScreenChall1.this, Screen7.class);
            ScreenChall1.this.startActivity(localIntent1);
          }
          else
          {
            ScreenChall1.this.newtarget.setText(Integer.toString(code.newtarget));
            ScreenChall1.this.balls.setText(Integer.toString(code.remBalls));
            ScreenChall1.this.target.setText(Integer.toString(code.score));
          }
          return;
        }
      }
    });
    
    this.four.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        code.fours = 1 + code.fours;
        code.score = -4 + code.score;
        code.newtarget = 4 + code.newtarget;
        code.remBalls = -1 + code.remBalls;
        if (code.score <= 0)
        {
          Intent localIntent1 = new Intent(ScreenChall1.this, Screen6.class);
          ScreenChall1.this.startActivity(localIntent1);
          return;
        }
        if (code.remBalls < 0)
        {
          Intent localIntent2 = new Intent(ScreenChall1.this, Screen7.class);
          ScreenChall1.this.startActivity(localIntent2);
          return;
        }
        localDialog.dismiss();
        ScreenChall1.this.showFourPopup3(ScreenChall1.this);
        ScreenChall1.this.newtarget.setText(Integer.toString(code.newtarget));
        ScreenChall1.this.balls.setText(Integer.toString(code.remBalls));
        ScreenChall1.this.target.setText(Integer.toString(code.score));
      }
    });
    this.six.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        code.sixes = 1 + code.sixes;
        code.score = -6 + code.score;
        code.newtarget = 6 + code.newtarget;
        code.remBalls = -1 + code.remBalls;
        if (code.score <= 0)
        {
          Intent localIntent1 = new Intent(ScreenChall1.this, Screen6.class);
          ScreenChall1.this.startActivity(localIntent1);
          return;
        }
        if (code.remBalls < 0)
        {
          Intent localIntent2 = new Intent(ScreenChall1.this, Screen7.class);
          ScreenChall1.this.startActivity(localIntent2);
          return;
        }
        localDialog.dismiss();
        ScreenChall1.this.showSixPopup3(ScreenChall1.this);
        ScreenChall1.this.newtarget.setText(Integer.toString(code.newtarget));
        ScreenChall1.this.balls.setText(Integer.toString(code.remBalls));
        ScreenChall1.this.target.setText(Integer.toString(code.score));
      }
    });
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

  public void onBackPressed()
  {
    Log.i("Screen4", "Back Pressed");
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setMessage("Are you sure?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
        Intent localIntent = new Intent(ScreenChall1.this, Main.class);
        ScreenChall1.this.finish();
        ScreenChall1.this.startActivity(localIntent);
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

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903058);
    code.flag=1;
    code.score = Integer.parseInt(code.target);
  //  code.remBalls = Integer.parseInt(code.reminning);
   // code.remBalls = 6 * code.remBalls;
    this.balls = ((TextView)findViewById(2131230782));
    this.target = ((TextView)findViewById(2131230786));
    this.palyername = ((TextView)findViewById(2131230763));
    this.zero = ((TextView)findViewById(2131230769));
    this.one = ((TextView)findViewById(2131230775));
    this.wide = ((TextView)findViewById(2131230770));
    this.four = ((TextView)findViewById(2131230774));
    this.six = ((TextView)findViewById(2131230776));
    this.out = ((TextView)findViewById(2131230773));
    this.brek = ((TextView)findViewById(2131230772));
    this.bowl = ((TextView)findViewById(2131230771));
    this.newtarget = ((TextView)findViewById(2131230789));
    this.restart = ((ImageView)findViewById(2131230764));
    this.demoanimation = ((TextView)findViewById(R.id.demoanimation));

    this.target.setText(Integer.toString(code.score));
    this.balls.setText(Integer.toString(code.remBalls));
    this.palyername.setText(code.name.toUpperCase());
    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    animText = pref.getString("scroll", "Top Score");
    this.restart.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(ScreenChall1.this);
        localBuilder.setMessage("Are you sure?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.cancel();
            Intent localIntent = new Intent(ScreenChall1.this, Main.class);
            ScreenChall1.this.finish();
            ScreenChall1.this.startActivity(localIntent);
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
        	Log.i("ScreenChall", "RemBalss"+code.remBalls);
          Intent localIntent = new Intent(ScreenChall1.this, Screen7.class);
          ScreenChall1.this.startActivity(localIntent);
          return;
        }
        ScreenChall1.this.showPopup6(ScreenChall1.this);
      }
    });
    this.brek.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (new File(Environment.getExternalStorageDirectory().toString() + "/Videos/").exists())
        {
          Intent localIntent = new Intent(ScreenChall1.this, CustomizedListView.class);
          ScreenChall1.this.startActivity(localIntent);
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
        startActivity(new Intent(this, Screen7.class));
    while (true)
    {
      Log.d("ScrenChall1", "Key Down  :" + paramInt);
      
    
     //continue;
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
            Intent localIntent = new Intent(ScreenChall1.this, Main.class);
            ScreenChall1.this.finish();
            ScreenChall1.this.startActivity(localIntent);
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
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
  }
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.ScreenChall1
 * JD-Core Version:    0.6.2
 */