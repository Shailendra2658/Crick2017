package com.cricket.cricgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
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
import android.view.Window;
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
import android.widget.ViewFlipper;
import java.io.File;
import java.io.PrintStream;

import com.cricket.listView.CustomizedListView;

public class Screen4 extends Activity
{
  TextView bowl;
  TextView brek;
  Dialog dialog;
  int done = 0;
  TextView four;
  ViewFlipper mFlipper;
  ImageView mImageView;
  VideoView mVideoView;
  TextView anim;
  ImageView next;
  TextView one;
  TextView out;
  TextView over;
  double overs = 0.0D;
  TextView palyername;
  ImageView restart;
  ImageView rscore;
  TextView score;
  TextView scorea;
  TextView scoreb;
  TextView six;
  TextView teama;
  TextView teamb;
  int tscore = 0;
  TextView wide;
  TextView zero;
  String t="Screen4";
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
    this.mVideoView = ((VideoView)localDialog.findViewById(2131230730));
    this.anim = ((TextView)localDialog.findViewById(R.id.anim));
    this.demovideoanimation = ((TextView)localDialog.findViewById(R.id.demovideoanimation));

    anim.setText(animText);
    anim.setTextSize(31);
    Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/TIMES.TTF");
    anim.setTypeface(tf,1);
    anim.startAnimation(AnimationUtils.loadAnimation(this, R.anim.moving_text));
    if(code.gameType.equals("demo")){
  	  	demovideoanimation.setVisibility(View.VISIBLE);
  	  	demovideoanimation.startAnimation(AnimationUtils.loadAnimation(this, R.anim.blink));

    }
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

  private void showPopup(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Display localDisplay = ((WindowManager)getApplicationContext().getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    LinearLayout localLinearLayout = (LinearLayout)paramActivity.findViewById(2131230733);
    View localView = ((LayoutInflater)paramActivity.getSystemService("layout_inflater")).inflate(2130903046, localLinearLayout);
    final PopupWindow localPopupWindow = new PopupWindow(paramActivity);
    localPopupWindow.setContentView(localView);
    localPopupWindow.setWidth(i);
    localPopupWindow.setHeight(j);
    localPopupWindow.setFocusable(true);
    localPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    localPopupWindow.showAtLocation(localView, 17, 0, 0);
    TextView localTextView = (TextView)localView.findViewById(2131230734);
    localTextView.setText("Need " + paramInt1 + " Runs \nFrom\n" + paramInt2 + " Balls To Win");
    localTextView.setTextSize(100.0F);
    ((Button)localView.findViewById(2131230735)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localPopupWindow.dismiss();
      }
    });
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        localPopupWindow.dismiss();
      }
    }
    , 6000L);
  }

  private void showPopup0(Activity paramActivity)
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
    ((TextView)localView.findViewById(2131230734)).setText("WIDE BALL");
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
  
  private void showPopup00(Activity paramActivity)
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
    ((TextView)localView.findViewById(2131230734)).setText("DEAD BALL");
    
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

  private void showPopup2(Activity paramActivity)
  {
    Display localDisplay = ((WindowManager)getApplicationContext().getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    LinearLayout localLinearLayout = (LinearLayout)paramActivity.findViewById(2131230733);
    View localView = ((LayoutInflater)paramActivity.getSystemService("layout_inflater")).inflate(2130903046, localLinearLayout);
    final PopupWindow localPopupWindow = new PopupWindow(paramActivity);
    localPopupWindow.setContentView(localView);
    localPopupWindow.setWidth(i);
    localPopupWindow.setHeight(j);
    localPopupWindow.setFocusable(true);
    localPopupWindow.setBackgroundDrawable(new BitmapDrawable());
    localPopupWindow.showAtLocation(localView, 17, 30, 30);
    TextView localTextView = (TextView)localView.findViewById(2131230734);
    if (code.totalaa == code.totalbb)
      localTextView.setText("\t DRAW \n MATCH\n ");
    while (true)
    {
      ((Button)localView.findViewById(2131230735)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localPopupWindow.dismiss();
        }
      });
    
      if (code.totalaa < code.totalbb)
        localTextView.setText(code.teamb + "\n WON\n");
      else
        localTextView.setText(code.teama + "\n WON\n");
      return;
    }
    
  }

  private void showPopup6(Activity paramActivity)
  {
    this.dialog = new Dialog(this, 16973834);
    this.dialog.setContentView(2130903051);
    this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(-16776961));
    this.mVideoView = ((VideoView)this.dialog.findViewById(2131230768));
    this.anim = ((TextView)this.dialog.findViewById(R.id.anim));
    this.demovideoanimation = ((TextView)this.dialog.findViewById(R.id.demovideoanimation));

    anim.setTextSize(31);
    anim.setText(animText);
    Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/TIMES.TTF");
    anim.setTypeface(tf,1);
    anim.startAnimation(AnimationUtils.loadAnimation(this, R.anim.moving_text));
    if(code.gameType.equals("demo")){
  	  	demovideoanimation.setVisibility(View.VISIBLE);
  	  	demovideoanimation.startAnimation(AnimationUtils.loadAnimation(this, R.anim.blink));

    }
    ImageView localImageView = (ImageView)this.dialog.findViewById(2131230767);
    localImageView.setVisibility(0);
   // localImageView.setBackgroundResource(2130837507);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.dialog.findViewById(2131230766);
    this.mVideoView.setVisibility(0);
    localRelativeLayout.setVisibility(0);
    
   
   
    String str = Environment.getExternalStorageDirectory().toString() + "/Videos/" + code.bowler;
    this.six = ((TextView)this.dialog.findViewById(2131230776));
    this.zero = ((TextView)this.dialog.findViewById(2131230769));
    this.one = ((TextView)this.dialog.findViewById(2131230775));
    this.four = ((TextView)this.dialog.findViewById(2131230774));
    this.out = ((TextView)this.dialog.findViewById(2131230773));
    this.wide = ((TextView)this.dialog.findViewById(2131230770));
    this.bowl = ((TextView)this.dialog.findViewById(2131230771));
    this.brek = ((TextView)this.dialog.findViewById(2131230772));
    this.bowl.setVisibility(8);
    this.brek.setVisibility(8);
    /*new Handler().postDelayed(new Runnable()
    {
      public void run()
      {*/
        /*Screen4.this.six.setVisibility(0);
        Screen4.this.zero.setVisibility(0);
        Screen4.this.one.setVisibility(0);
        Screen4.this.four.setVisibility(0);
        Screen4.this.out.setVisibility(0);
        Screen4.this.wide.setVisibility(0);*/
      /*}
    }
    , 6000L);*/
    this.dialog.getWindow().setSoftInputMode(4);
    this.dialog.setOnKeyListener(new DialogInterface.OnKeyListener()
    {
      public boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousKeyEvent.getAction() != 0)
          return true;
        Log.i(t,"Key "+paramAnonymousInt);
        if (paramAnonymousInt == 7)
        {
        	
          Log.i("Dialog", "0 Pressed");
          paramAnonymousDialogInterface.dismiss();

          double d1 = Screen4.this.overs;
          double d2 = code.over_left;
          String str1 = Double.toString(d1);
          String str2 = Double.toString(d2);
          System.out.println(Screen4.this.overs);
          System.out.println(code.over_left);
          if (str1.startsWith(str2))
            Screen4.this.done = 1;
          if (Screen4.this.done == 0)
          {
            int i = (int)(10.0D * Screen4.this.overs) % 10;
            Log.i("MEssage", "Message");
            if (i == 5)
            {
              Screen4 localScreen42 = Screen4.this;
              localScreen42.overs -= 0.5D;
              Screen4 localScreen43 = Screen4.this;
              localScreen43.overs = (1.0D + localScreen43.overs);
            }
            else{
          	  System.out.println(Screen4.this.overs);
                Screen4 localScreen41 = Screen4.this;
                localScreen41.overs = (0.1D + localScreen41.overs);
                System.out.println(Screen4.this.overs);
            }
            if (!code.WhichTeam.booleanValue()){
                code.remBalls = -1 + code.remBalls;
                code.totalRem--;
            }
              Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
              Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
           /* while (true)
            {
              if (!code.WhichTeam.booleanValue())
                code.remBalls = -1 + code.remBalls;
              Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
              Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
              return;
              System.out.println(Screen4.this.overs);
              Screen4 localScreen41 = Screen4.this;
              localScreen41.overs = (0.1D + localScreen41.overs);
              System.out.println(Screen4.this.overs);
            }*/
          }
          else
          	Screen4.this.fun();
        }
        if (paramAnonymousInt == 8)
        {
        	dialog.dismiss();
          Log.i("Dialog", "1 Pressed");
          paramAnonymousDialogInterface.dismiss();
          double d10 = Screen4.this.overs;
          double d11 = code.over_left;
          String str9 = Double.toString(d10);
          String str10 = Double.toString(d11);
          System.out.println(Screen4.this.overs);
          System.out.println(code.over_left);
          if (str9.startsWith(str10))
            Screen4.this.done = 1;
          if (Screen4.this.done == 0)
          {
            double d12 = Double.parseDouble(Double.toString(Screen4.this.overs).substring(0, 3));
            System.out.println("S" + d12);
            int i1 = (int)(10.0D * d12);
            System.out.println("TEMP" + i1);
            int i2 = i1 % 10;
            System.out.println("t" + i2);
            Log.i("MEssage", "Message");
            if (i2 == 5)
            {
              Screen4 localScreen416 = Screen4.this;
              localScreen416.overs -= 0.5D;
              Screen4 localScreen417 = Screen4.this;
              localScreen417.overs = (1.0D + localScreen417.overs);
            }
            else
            {
           	 System.out.println(Screen4.this.overs);
                Screen4 localScreen414 = Screen4.this;
                localScreen414.overs = (0.1D + localScreen414.overs);
                System.out.println(Screen4.this.overs);
           }
              if (code.WhichTeam.booleanValue())
              //  break label713;
            	  code.totalaa = 1 + code.totalaa;
              else
            	  code.totalbb = 1 + code.totalbb;
              code.score = 1 + code.score;
              code.remBalls = -1 + code.remBalls;
              code.totalRem--;
              Screen4 localScreen415 = Screen4.this;
              localScreen415.tscore = (1 + localScreen415.tscore);
              Screen4.this.over.setText(""+Double.toString(Screen4.this.overs).substring(0, 3));
              Screen4.this.score.setText(""+Integer.toString(Screen4.this.tscore));
              if (code.val1 == 0)
                Screen4.this.fun3();
              Screen4.this.fun2();
            
          }
          else{
        	   System.out.println(Screen4.this.overs);
               //  break;
                // label713: code.totalbb = 1 + code.totalbb;
               
        	  Screen4.this.fun();
          }
          /*while (true)
          {
            
            System.out.println(Screen4.this.overs);
            Screen4 localScreen414 = Screen4.this;
            localScreen414.overs = (0.1D + localScreen414.overs);
            System.out.println(Screen4.this.overs);
          //  break;
           // label713: code.totalbb = 1 + code.totalbb;
            code.remBalls = -1 + code.remBalls;
           // break label571;
            Screen4.this.fun();
            return true;
          }*/
        }
        if (paramAnonymousInt == 11)
        {
          Log.i("Dialog", "4 Pressed");
          paramAnonymousDialogInterface.dismiss();
          Screen4.this.dialog.dismiss();
          Screen4.this.showFourPopup3(Screen4.this);
          code.fours = 1 + code.fours;
          double d1 = Screen4.this.overs;
          double d2 = code.over_left;
          String str1 = Double.toString(d1);
          String str2 = Double.toString(d2);
          System.out.println(Screen4.this.overs);
          System.out.println(code.over_left);
          if (str1.startsWith(str2))
            Screen4.this.done = 1;
          if (Screen4.this.overs == code.over_left)
            Screen4.this.done = 1;
          if (Screen4.this.done == 0)
          {
            int i = (int)(10.0D * Screen4.this.overs % 10.0D);
            Log.i("MEssage", "Message");
            if (i == 5)
            {
              Screen4 localScreen43 = Screen4.this;
              localScreen43.overs -= 0.5D;
              Screen4 localScreen44 = Screen4.this;
              localScreen44.overs = (1.0D + localScreen44.overs);
            }
            else {	
  					System.out.println(overs);
  					overs = overs + 0.1;
  					System.out.println(overs);
            }
            if (!code.WhichTeam.booleanValue())
            	code.totalbb = 4 + code.totalbb;
            else
            	code.totalaa = 4 + code.totalaa;
            
            Screen4 localScreen42 = Screen4.this;
            localScreen42.tscore = (4 + localScreen42.tscore);
            
            Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
            Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
            code.remBalls = -1 + code.remBalls;
            code.totalRem--;
            
            if (code.val1 == 0)
                Screen4.this.fun3();
              Screen4.this.fun2();
           
          }
          else
          Screen4.this.fun();
        }
        if (paramAnonymousInt == 13)
        {
          Log.i("Dialog", "6 Pressed");
          paramAnonymousDialogInterface.dismiss();

          Screen4.this.dialog.dismiss();
          Screen4.this.showSixPopup3(Screen4.this);
          double d1 = Screen4.this.overs;
          double d2 = code.over_left;
          String str1 = Double.toString(d1);
          String str2 = Double.toString(d2);
          code.sixes = 1 + code.sixes;
          System.out.println(Screen4.this.overs);
          System.out.println(code.over_left);
          if (str1.startsWith(str2))
            Screen4.this.done = 1;
          if (Screen4.this.done == 0)
          {
            int i = (int)(10.0D * Screen4.this.overs % 10.0D);
            Log.i("MEssage", i+"");
            if (i == 5)
            {
              Screen4 localScreen43 = Screen4.this;
              localScreen43.overs -= 0.5D;
              Screen4 localScreen44 = Screen4.this;
              localScreen44.overs = (1.0D + localScreen44.overs);
             
            }
            else{
          	  System.out.println(Screen4.this.overs);
                Screen4 localScreen41 = Screen4.this;
                localScreen41.overs = (0.1D + localScreen41.overs);
                System.out.println(Screen4.this.overs);
            }
            Screen4 localScreen42 = Screen4.this;
            localScreen42.tscore = (6 + localScreen42.tscore);
            if (!code.WhichTeam.booleanValue())
            	code.totalbb = 6 + code.totalbb;
            else
            	code.totalaa = 6 + code.totalaa;
            /*while (true)
            {
              Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
              Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
              if (code.val1 == 0)
                Screen4.this.fun3();
              Screen4.this.fun2();
              return;
              System.out.println(Screen4.this.overs);
              Screen4 localScreen41 = Screen4.this;
              localScreen41.overs = (0.1D + localScreen41.overs);
              System.out.println(Screen4.this.overs);
              break;
             // label340: code.totalbb = 6 + code.totalbb;
              code.remBalls = -1 + code.remBalls;
            }*/
            Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
            Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
            code.remBalls = -1 + code.remBalls;
            code.totalRem--;
            if (code.val1 == 0)
              Screen4.this.fun3();
            Screen4.this.fun2();
          }
          else
          Screen4.this.fun();
        }
        if (paramAnonymousInt == 43)
        {
          Log.i("Dialog", "out Pressed");
          paramAnonymousDialogInterface.dismiss();
          Screen4.this.showOutPopup3(Screen4.this);
          double d1 = Screen4.this.overs;
          double d2 = code.over_left;
          String str1 = Double.toString(d1);
          String str2 = Double.toString(d2);
          //code.sixes = 1 + code.sixes;
          System.out.println(Screen4.this.overs);
          System.out.println(code.over_left);
          if (str1.startsWith(str2))
            Screen4.this.done = 1;
          if (Screen4.this.done == 0)
          {
            int i = (int)(10.0D * Screen4.this.overs % 10.0D);
            Log.i("MEssage", i+"");
            Screen4 localScreen42 = Screen4.this;
            double chk= localScreen42.tscore-5;
            if(chk>=0)
            	localScreen42.tscore = (localScreen42.tscore-5);
            else
            	localScreen42.tscore = 0;
            if (!code.WhichTeam.booleanValue()){
            	double check = code.totalbb-5;
            	if(check>0)
            		code.totalbb = code.totalbb-5;
            	else
            		code.totalbb = 0;
            }
            else{
            	double check = code.totalaa-5;
            	if(check>0)
            		code.totalaa = code.totalaa-5;
            	else
            		code.totalaa = 0;
            	
            }
            if (i == 5)
            {
              Screen4 localScreen43 = Screen4.this;
              localScreen43.overs -= 0.5D;
              Screen4 localScreen44 = Screen4.this;
              localScreen44.overs = (1.0D + localScreen44.overs);
              
            }
            else{
          	  System.out.println(Screen4.this.overs);
                Screen4 localScreen41 = Screen4.this;
                localScreen41.overs = (0.1D + localScreen41.overs);
                System.out.println(Screen4.this.overs);
            }
            /*while (true)
            {
              Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
              Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
              if (code.val1 == 0)
                Screen4.this.fun3();
              Screen4.this.fun2();
              return;
              System.out.println(Screen4.this.overs);
              Screen4 localScreen41 = Screen4.this;
              localScreen41.overs = (0.1D + localScreen41.overs);
              System.out.println(Screen4.this.overs);
              break;
             // label340: code.totalbb = 6 + code.totalbb;
              code.remBalls = -1 + code.remBalls;
            }*/
            Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
            Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
            code.remBalls = -1 + code.remBalls;
            code.totalRem--;
            if (code.val1 == 0)
              Screen4.this.fun3();
            Screen4.this.fun2();
          }
          else
          Screen4.this.fun();
        }
        if (paramAnonymousInt == 51)
        {
          Log.i("Dialog", "wide Pressed");
          paramAnonymousDialogInterface.dismiss();
          double d1 = Screen4.this.overs;
          double d2 = code.over_left;
          String str1 = Double.toString(d1);
          String str2 = Double.toString(d2);
          System.out.println(Screen4.this.overs);
          System.out.println(code.over_left);
          showPopup0(Screen4.this);
          if (str1.startsWith(str2))
            Screen4.this.done = 1;
          if (Screen4.this.done == 0)
          {
            double d3 = Double.parseDouble(Double.toString(Screen4.this.overs).substring(0, 3));
            System.out.println("S" + d3);
            int i = (int)(10.0D * d3);
            System.out.println("TEMP" + i);
            int j = i % 10;
            System.out.println("t" + j);
            Log.i("MEssage", "Message");
            if (j != 5)
            {
              System.out.println(Screen4.this.overs);
              System.out.println(Screen4.this.overs);
            }
            if (code.WhichTeam.booleanValue())
           // {
              code.totalaa = 1 + code.totalaa;
            else
            	code.totalbb = 1 + code.totalbb;
              code.score = 1 + code.score;
              Screen4 localScreen41 = Screen4.this;
              localScreen41.tscore = (1 + localScreen41.tscore);
              Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
              Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
              if (code.val1 == 0)
                Screen4.this.fun3();
              Screen4.this.fun2();
         //   }
          }
          else
        	  Screen4.this.fun();
          
         /* while (true)
          {
            Screen4.this.showPopup0(Screen4.this);
            return true;
            code.totalbb = 1 + code.totalbb;
            break;
            Screen4.this.fun();
          }*/
        }
        
        if(paramAnonymousInt == 32){

            Log.i("Dialog", "Dead ball Pressed");
            paramAnonymousDialogInterface.dismiss();
            double d1 = Screen4.this.overs;
            double d2 = code.over_left;
            String str1 = Double.toString(d1);
            String str2 = Double.toString(d2);
            System.out.println(Screen4.this.overs);
            System.out.println(code.over_left);
            showPopup00(Screen4.this);
            if (str1.startsWith(str2))
              Screen4.this.done = 1;
            if (Screen4.this.done == 0)
            {
              double d3 = Double.parseDouble(Double.toString(Screen4.this.overs).substring(0, 3));
              System.out.println("S" + d3);
              int i = (int)(10.0D * d3);
              System.out.println("TEMP" + i);
              int j = i % 10;
              System.out.println("t" + j);
              Log.i("MEssage", "Message");
              if (j != 5)
              {
                System.out.println(Screen4.this.overs);
                System.out.println(Screen4.this.overs);
              }
             /* if (code.WhichTeam.booleanValue())
             // {
                code.totalaa = 1 + code.totalaa;
              else
              	code.totalbb = 1 + code.totalbb;
                code.score = 1 + code.score;*/
                Screen4 localScreen41 = Screen4.this;
               /*// localScreen41.tscore = (1 + localScreen41.tscore);
                Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
                Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));*/
                if (code.val1 == 0)
                  Screen4.this.fun3();
                Screen4.this.fun2();
           //   }
            }
            else
          	  Screen4.this.fun();
            
           /* while (true)
            {
              Screen4.this.showPopup0(Screen4.this);
              return true;
              code.totalbb = 1 + code.totalbb;
              break;
              Screen4.this.fun();
            }*/
          
        }
        if (paramAnonymousInt == 48)
        {
          Log.i("Dialog", "break Pressed");
          if (new File(Environment.getExternalStorageDirectory().toString() + "/Videos/Break/").exists())
          {
            Intent localIntent = new Intent(Screen4.this, CustomizedListView.class);
            Screen4.this.startActivity(localIntent);
          }
          else{
        	  Toast.makeText(Screen4.this.getApplicationContext(), "No Videos found in /Videos/Break/", 1).show();
          }
          /*while (true)
          {
            return true;
            Toast.makeText(Screen4.this.getApplicationContext(), "No Videos found in /Videos/Break/", 1).show();
          }*/
        }
        return false;
      }
    });
    
    
    this.six.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Screen4.this.dialog.dismiss();
        Screen4.this.showSixPopup3(Screen4.this);
        double d1 = Screen4.this.overs;
        double d2 = code.over_left;
        String str1 = Double.toString(d1);
        String str2 = Double.toString(d2);
        code.sixes = 1 + code.sixes;
        System.out.println(Screen4.this.overs);
        System.out.println(code.over_left);
        if (str1.startsWith(str2))
          Screen4.this.done = 1;
        if (Screen4.this.done == 0)
        {
          int i = (int)(10.0D * Screen4.this.overs % 10.0D);
          Log.i("MEssage", i+"");
          if (i == 5)
          {
            Screen4 localScreen43 = Screen4.this;
            localScreen43.overs -= 0.5D;
            Screen4 localScreen44 = Screen4.this;
            localScreen44.overs = (1.0D + localScreen44.overs);
           
          }
          else{
        	  System.out.println(Screen4.this.overs);
              Screen4 localScreen41 = Screen4.this;
              localScreen41.overs = (0.1D + localScreen41.overs);
              System.out.println(Screen4.this.overs);
          }
          Screen4 localScreen42 = Screen4.this;
          localScreen42.tscore = (6 + localScreen42.tscore);
          if (!code.WhichTeam.booleanValue())
          	code.totalbb = 6 + code.totalbb;
          else
          	code.totalaa = 6 + code.totalaa;
          /*while (true)
          {
            Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
            Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
            if (code.val1 == 0)
              Screen4.this.fun3();
            Screen4.this.fun2();
            return;
            System.out.println(Screen4.this.overs);
            Screen4 localScreen41 = Screen4.this;
            localScreen41.overs = (0.1D + localScreen41.overs);
            System.out.println(Screen4.this.overs);
            break;
           // label340: code.totalbb = 6 + code.totalbb;
            code.remBalls = -1 + code.remBalls;
          }*/
          Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
          Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
          code.remBalls = -1 + code.remBalls;
          code.totalRem--;
          if (code.val1 == 0)
            Screen4.this.fun3();
          Screen4.this.fun2();
        }
        else
        Screen4.this.fun();
      }
    });
    this.four.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Screen4.this.dialog.dismiss();
        Screen4.this.showFourPopup3(Screen4.this);
        code.fours = 1 + code.fours;
        double d1 = Screen4.this.overs;
        double d2 = code.over_left;
        String str1 = Double.toString(d1);
        String str2 = Double.toString(d2);
        System.out.println(Screen4.this.overs);
        System.out.println(code.over_left);
        if (str1.startsWith(str2))
          Screen4.this.done = 1;
        if (Screen4.this.overs == code.over_left)
          Screen4.this.done = 1;
        if (Screen4.this.done == 0)
        {
          int i = (int)(10.0D * Screen4.this.overs % 10.0D);
          Log.i("MEssage", "Message");
          if (i == 5)
          {
            Screen4 localScreen43 = Screen4.this;
            localScreen43.overs -= 0.5D;
            Screen4 localScreen44 = Screen4.this;
            localScreen44.overs = (1.0D + localScreen44.overs);
            
            
          }
          else {	
					System.out.println(overs);
					overs = overs + 0.1;
					System.out.println(overs);
          }
          if (!code.WhichTeam.booleanValue())
          	code.totalbb = 4 + code.totalbb;
          else
          	code.totalaa = 4 + code.totalaa;
          
          Screen4 localScreen42 = Screen4.this;
          localScreen42.tscore = (4 + localScreen42.tscore);
          
          Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
          Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
          code.remBalls = -1 + code.remBalls;
          code.totalRem--;
          if (code.val1 == 0)
              Screen4.this.fun3();
            Screen4.this.fun2();
         /* while (true)
          {
            Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
            Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
            if (code.val1 == 0)
              Screen4.this.fun3();
            Screen4.this.fun2();
            return;
            System.out.println(Screen4.this.overs);
            Screen4 localScreen41 = Screen4.this;
            localScreen41.overs = (0.1D + localScreen41.overs);
            System.out.println(Screen4.this.overs);
            break;
            label347: code.totalbb = 4 + code.totalbb;
            code.remBalls = -1 + code.remBalls;
          }*/
        }
        else
        Screen4.this.fun();
      }
    });
    this.out.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
          Log.i("Dialog", "out Pressed");
          Screen4.this.dialog.dismiss();
          Screen4.this.showOutPopup3(Screen4.this);
          double d1 = Screen4.this.overs;
          double d2 = code.over_left;
          String str1 = Double.toString(d1);
          String str2 = Double.toString(d2);
          //code.sixes = 1 + code.sixes;
          System.out.println(Screen4.this.overs);
          System.out.println(code.over_left);
          if (str1.startsWith(str2))
            Screen4.this.done = 1;
          if (Screen4.this.done == 0)
          {
            int i = (int)(10.0D * Screen4.this.overs % 10.0D);
            Log.i("MEssage", i+"");
            if (i == 5)
            {
              Screen4 localScreen43 = Screen4.this;
              localScreen43.overs -= 0.5D;
              Screen4 localScreen44 = Screen4.this;
              localScreen44.overs = (1.0D + localScreen44.overs);
             
            }
            else{
          	  System.out.println(Screen4.this.overs);
                Screen4 localScreen41 = Screen4.this;
                localScreen41.overs = (0.1D + localScreen41.overs);
                System.out.println(Screen4.this.overs);
            }
            Screen4 localScreen42 = Screen4.this;
            double chk= localScreen42.tscore-5;
            if(chk>=0)
            	localScreen42.tscore = (localScreen42.tscore-5);
            else
            	localScreen42.tscore = 0;
            if (!code.WhichTeam.booleanValue()){
            	double check = code.totalbb-5;
            	if(check>0)
            		code.totalbb = code.totalbb-5;
            	else
            		code.totalbb = 0;
            }
            else{
            	double check = code.totalaa-5;
            	if(check>0)
            		code.totalaa = code.totalaa-5;
            	else
            		code.totalaa = 0;
            	
            }
            /*while (true)
            {
              Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
              Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
              if (code.val1 == 0)
                Screen4.this.fun3();
              Screen4.this.fun2();
              return;
              System.out.println(Screen4.this.overs);
              Screen4 localScreen41 = Screen4.this;
              localScreen41.overs = (0.1D + localScreen41.overs);
              System.out.println(Screen4.this.overs);
              break;
             // label340: code.totalbb = 6 + code.totalbb;
              code.remBalls = -1 + code.remBalls;
            }*/
            Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
            Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
            code.remBalls = -1 + code.remBalls;
            code.totalRem--;
            if (code.val1 == 0)
              Screen4.this.fun3();
            Screen4.this.fun2();
          }
          else
          Screen4.this.fun();
        }
    });
    this.zero.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Screen4.this.dialog.dismiss();
        double d1 = Screen4.this.overs;
        double d2 = code.over_left;
        String str1 = Double.toString(d1);
        String str2 = Double.toString(d2);
        System.out.println(Screen4.this.overs);
        System.out.println(code.over_left);
        if (str1.startsWith(str2))
          Screen4.this.done = 1;
        if (Screen4.this.done == 0)
        {
          int i = (int)(10.0D * Screen4.this.overs) % 10;
          Log.i("MEssage", "Message");
          if (i == 5)
          {
            Screen4 localScreen42 = Screen4.this;
            localScreen42.overs -= 0.5D;
            Screen4 localScreen43 = Screen4.this;
            localScreen43.overs = (1.0D + localScreen43.overs);
          }
          else{
        	  System.out.println(Screen4.this.overs);
              Screen4 localScreen41 = Screen4.this;
              localScreen41.overs = (0.1D + localScreen41.overs);
              System.out.println(Screen4.this.overs);
          }
          if (!code.WhichTeam.booleanValue()){
              code.remBalls = -1 + code.remBalls;
              code.totalRem--;
          }
            Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
            Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
         /* while (true)
          {
            if (!code.WhichTeam.booleanValue())
              code.remBalls = -1 + code.remBalls;
            Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
            Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
            return;
            System.out.println(Screen4.this.overs);
            Screen4 localScreen41 = Screen4.this;
            localScreen41.overs = (0.1D + localScreen41.overs);
            System.out.println(Screen4.this.overs);
          }*/
        }
        else
        	Screen4.this.fun();
      }
    });
    this.one.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
          Log.i("Clicked", "1 Pressed");
          dialog.dismiss();
          double d10 = overs;
          double d11 = code.over_left;
          String str9 = Double.toString(d10);
          String str10 = Double.toString(d11);
          System.out.println(Screen4.this.overs);
          System.out.println(code.over_left);
          if (str9.startsWith(str10))
            Screen4.this.done = 1;
          if (Screen4.this.done == 0)
          {
            double d12 = Double.parseDouble(Double.toString(Screen4.this.overs).substring(0, 3));
            System.out.println("S" + d12);
            int i1 = (int)(10 * d12);
            System.out.println("TEMP" + i1);
            int i2 = i1 % 10;
            System.out.println("t" + i2);
            Log.i("MEssage", "Message");
            if (i2 == 5){
            	Screen4 localScreen416 = Screen4.this;
                localScreen416.overs -= 0.5D;
                Screen4 localScreen417 = Screen4.this;
                localScreen417.overs = (1.0D + localScreen417.overs);
            }
            else
            {
            	 System.out.println(Screen4.this.overs);
                 Screen4 localScreen414 = Screen4.this;
                 localScreen414.overs = (0.1D + localScreen414.overs);
                 System.out.println(Screen4.this.overs);
            }
              if (code.WhichTeam.booleanValue())
              //  break label713;
            	  code.totalaa = 1 + code.totalaa;
              else
            	  code.totalbb = 1 + code.totalbb;
              code.score = 1 + code.score;
              code.remBalls = -1 + code.remBalls;
              code.totalRem--;
              Screen4 localScreen415 = Screen4.this;
              localScreen415.tscore = 1 + localScreen415.tscore;
              Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
              Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
              if (code.val1 == 0)
                Screen4.this.fun3();
              Screen4.this.fun2();
            
          }
          else{
        	   System.out.println(Screen4.this.overs);
               //  break;
                // label713: code.totalbb = 1 + code.totalbb;
               
        	  Screen4.this.fun();
          }
          /*while (true)
          {
            
            System.out.println(Screen4.this.overs);
            Screen4 localScreen414 = Screen4.this;
            localScreen414.overs = (0.1D + localScreen414.overs);
            System.out.println(Screen4.this.overs);
          //  break;
           // label713: code.totalbb = 1 + code.totalbb;
            code.remBalls = -1 + code.remBalls;
           // break label571;
            Screen4.this.fun();
            return true;
          }*/
        }
    });
    this.wide.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Screen4.this.dialog.dismiss();
        double d1 = Screen4.this.overs;
        double d2 = code.over_left;
        String str1 = Double.toString(d1);
        String str2 = Double.toString(d2);
        System.out.println(Screen4.this.overs);
        System.out.println(code.over_left);
        if (str1.startsWith(str2))
          Screen4.this.done = 1;
        if (Screen4.this.done == 0)
        {
          double d3 = Double.parseDouble(Double.toString(Screen4.this.overs).substring(0, 3));
          System.out.println("S" + d3);
          int i = (int)(10.0D * d3);
          System.out.println("TEMP" + i);
          int j = i % 10;
          System.out.println("t" + j);
          Log.i("MEssage", "Message");
          if (j != 5)
          {
            System.out.println(Screen4.this.overs);
            System.out.println(Screen4.this.overs);
          }
          if (code.WhichTeam.booleanValue())
            code.totalaa = 1 + code.totalaa;
          else
        	  code.totalbb = 1 + code.totalbb;
            code.score = 1 + code.score;
            Screen4 localScreen4 = Screen4.this;
            localScreen4.tscore = (1 + localScreen4.tscore);
            Screen4.this.over.setText(Double.toString(Screen4.this.overs).substring(0, 3));
            Screen4.this.score.setText(Integer.toString(Screen4.this.tscore));
            Screen4.this.showPopup0(Screen4.this);
            if (code.val1 == 0)
              Screen4.this.fun3();
            Screen4.this.fun2();
          
        }
        else{
        	Screen4.this.fun();
        }
       /* while (true)
        {
          Screen4.this.showPopup0(Screen4.this);
         // return;
          code.totalbb = 1 + code.totalbb;
          break;
          Screen4.this.fun();
        }*/
      }
    });
    
   
    this.dialog.show();
    this.mVideoView.setVideoPath(str);
    this.mVideoView.requestFocus();
    this.mVideoView.start();
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

  public void fun()
  {
		if (!code.single) {
			if (code.WhichTeam) {
				code.totala = code.totala + tscore;
			} else {
				code.totalb = code.totalb + tscore;
			}
			code.score = tscore;
			Intent iv = new Intent(Screen4.this, Teamselectpayer2.class);
			startActivity(iv);
		} else {
			Log.i("Screen4","Enter Single");
			code.score = tscore;
			Intent iv = new Intent(Screen4.this, Screen5.class);
			startActivity(iv);
		}
	}

  public void fun2()
  {
    if (!code.single)
    {
      code.score = this.tscore;
      this.scorea.setText(""+code.totalaa);
      this.scoreb.setText(""+code.totalbb);
    }
  }

  public void fun3()
  {
    if (code.totalbb > code.totalaa)
    {
      code.val1 = 1;
      showPopup2(this);
    }
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
        Intent localIntent = new Intent(Screen4.this, Main.class);
        Screen4.this.finish();
        Screen4.this.startActivity(localIntent);
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

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903051);
    code.score = 0;
    
    Log.d(t,"Oncreate");
    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    animText = pref.getString("scroll", "Top Score");
    
    this.mFlipper = ((ViewFlipper)findViewById(2131230778));
    this.next = ((ImageView)findViewById(2131230754));
    this.restart = ((ImageView)findViewById(2131230764));
    this.over = ((TextView)findViewById(2131230756));
    this.score = ((TextView)findViewById(2131230765));
    this.palyername = ((TextView)findViewById(2131230763));
    this.teama = ((TextView)findViewById(2131230758));
    this.teamb = ((TextView)findViewById(2131230761));
    this.scorea = ((TextView)findViewById(2131230759));
    this.scoreb = ((TextView)findViewById(2131230760));
    this.zero = ((TextView)findViewById(2131230769));
    this.one = ((TextView)findViewById(2131230775));
    this.four = ((TextView)findViewById(2131230774));
    this.six = ((TextView)findViewById(2131230776));
    this.out = ((TextView)findViewById(2131230773));
    this.bowl = ((TextView)findViewById(2131230771));
    this.brek = ((TextView)findViewById(2131230772));
    this.wide = ((TextView)findViewById(2131230770));
    this.rscore = ((ImageView)findViewById(2131230762));
    this.demoanimation = ((TextView)findViewById(R.id.demoanimation));
    this.demovideoanimation = ((TextView)findViewById(R.id.demovideoanimation));


    if (!code.single)
    {
      this.teama.setVisibility(1);
      this.teamb.setVisibility(1);
      this.scorea.setVisibility(1);
      this.scoreb.setVisibility(1);
      this.teama.setText(""+code.teama);
      this.teamb.setText(""+code.teamb);
      this.scorea.setText(""+code.totalaa);
      this.scoreb.setText(""+code.totalbb);
    }
    else
    	code.flag=1;
    if ((!code.single) && (!code.WhichTeam.booleanValue()))
      this.rscore.setVisibility(1);
    this.score.setText(""+Integer.toString(this.tscore));
    if (!code.single)
      this.palyername.setText(""+code.selectedPlayer.toUpperCase());
    else
    	 this.palyername.setText(""+code.name.toUpperCase());
   /* while (true)
    {*/
      this.rscore.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          int i = code.totalaa;
          int j = code.totalbb;
          if (i > j);
          for (int k = i - j; ; k = -1)
          {
            double d1 = 6.0D * code.over_left;
            double d2 = 10.0D * Screen4.this.overs;
            int m = (int)d2 % 10 + 6 * ((int)d2 / 10);
            code.remBalls=((int)d1 - m);
           // code.totalRem = code.totalRem - (6-code.remBalls);
         
            if (k <= 0)
              break;
            Screen4.this.showPopup(Screen4.this, k + 1,  code.totalRem );
            return;
          }
          Screen4.this.showPopup2(Screen4.this);
        }
      });
      this.restart.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AlertDialog.Builder localBuilder = new AlertDialog.Builder(Screen4.this);
          localBuilder.setMessage("Are you sure?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              paramAnonymous2DialogInterface.cancel();
              Intent localIntent = new Intent(Screen4.this, Main.class);
              Screen4.this.finish();
              Screen4.this.startActivity(localIntent);
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
      this.next.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
			if(!code.single)
			{
				if(code.WhichTeam)
				{
					code.totala = code.totala + tscore;
				}
				else
				{
					code.totalb = code.totalb + tscore;
				}
				code.score=tscore;
				Intent iv = new Intent(Screen4.this,Teamselectpayer2.class);
				startActivity(iv);
			}
			else
			{
				code.score=tscore;
				Intent iv = new Intent(Screen4.this,Screen5.class);
				startActivity(iv);
			}
			}
      });
      this.bowl.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          double d1 = Screen4.this.overs;
          double d2 = code.over_left;
          if (Double.toString(d1).startsWith(Double.toString(d2)))
            Screen4.this.done = 1;
          if (Screen4.this.done == 1)
          {
            Screen4.this.fun();
            return;
          }
          Screen4.this.showPopup6(Screen4.this);
        }
      });
      this.brek.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (new File(Environment.getExternalStorageDirectory().toString() + "/Videos/Break/").exists())
          {
            Intent localIntent = new Intent(Screen4.this, CustomizedListView.class);
            Screen4.this.startActivity(localIntent);
          }
        }
      });
      
      if(code.gameType.equals("demo")){
    	  	demoanimation.setVisibility(View.VISIBLE);
    	    demoanimation.startAnimation(AnimationUtils.loadAnimation(this, R.anim.blink));
    	  	
      }
      
     /* return;
      this.palyername.setText(code.name.toUpperCase());*/
    //}
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 30)
    {
      double d3 = this.overs;
      double d4 = code.over_left;
      if (Double.toString(d3).startsWith(Double.toString(d4)))
        this.done = 1;
      if (this.done == 1)
        fun();
    }
    while (true)
    {
      Log.d("TEST", "Key Down  :" + paramInt);
      
      //showPopup6(this);
      //continue;
      if (paramInt == 48)
      {
    	  if (new File(Environment.getExternalStorageDirectory().toString() + "/Videos/Break/").exists())
          {
            Intent localIntent = new Intent(Screen4.this, CustomizedListView.class);
            Screen4.this.startActivity(localIntent);
          }
        else
          Toast.makeText(getApplicationContext(), "No Videos found in /Videos/Break/", 1).show();
      }
      else if (paramInt == 47)
      {
        int i = code.totalaa;
        int j = code.totalbb;
        if (i > j);
        for (int k = i - j; ; k = -1)
        {
          double d1 = 6.0D * code.over_left;
          double d2 = 10.0D * this.overs;
          int m = (int)d2 % 10 + 6 * ((int)d2 / 10);
          code.remBalls=((int)d1 - m);
         // code.totalRem = code.totalRem - (6-code.remBalls);
          if (k <= 0)
        	  showPopup2(this);
            //break label268;
          showPopup(this, k + 1, code.totalRem);
          break;
        }
        label268: showPopup2(this);
      }
      else if (paramInt == 46)
      {
        AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this);
        AlertDialog.Builder localBuilder2 = localBuilder1.setMessage("Are you sure?").setCancelable(false);
        DialogInterface.OnClickListener local6 = new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface.cancel();
            Intent localIntent = new Intent(Screen4.this, Main.class);
            Screen4.this.finish();
            Screen4.this.startActivity(localIntent);
          }
        };
        AlertDialog.Builder localBuilder3 = localBuilder2.setPositiveButton("Yes", local6);
        DialogInterface.OnClickListener local7 = new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface.cancel();
          }
        };
        localBuilder3.setNegativeButton("No", local7);
        AlertDialog localAlertDialog = localBuilder1.create();
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
 * Qualified Name:     com.cricket.cricgame.Screen4
 * JD-Core Version:    0.6.2
 */