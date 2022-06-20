package com.cricket.cricgame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;

public class Screen1 extends Activity
{
  RadioButton radio1;
  RadioButton radio2;
  RadioButton radio3,radio4;
  ImageView start;
  private SharedPreferences sp;


  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903048);
    this.start = ((ImageView)findViewById(2131230722));
    this.radio1 = ((RadioButton)findViewById(2131230752));
    this.radio2 = ((RadioButton)findViewById(2131230751));
    this.radio3 = ((RadioButton)findViewById(2131230750));
    this.radio4 = ((RadioButton)findViewById(R.id.radioButton4));

    sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	sp.edit().putString(code.KEY_OVER, "0.0D").commit();

    this.radio1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (Screen1.this.radio2.isChecked())
          Screen1.this.radio2.setChecked(false);
        code.gameType="single";
        code.score = 0;
        code.over = 0.0D;
        code.single = true;
        code.over_left = 0.0D;
        code.val1 = 1;

        Intent localIntent = new Intent(Screen1.this, Screen2.class);
        Screen1.this.startActivity(localIntent);
      }
    });
    this.radio2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
    	  code.gameType="team";
        code.single = false;
        code.score = 0;
        code.over = 0.0D;
        code.over_left = 0.0D;

        Intent localIntent = new Intent(Screen1.this, TeamNameA.class);
        Screen1.this.startActivity(localIntent);
      }
    });
    this.radio3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (Screen1.this.radio3.isChecked())
          Screen1.this.radio3.setChecked(false);
        code.gameType="challenge";
        code.score = 0;
        code.over = 0.0D;
        code.single = true;
        code.over_left = 0.0D;
        code.val1 = 1;
        code.challenge = 1;

        Intent localIntent = new Intent(Screen1.this, Screen2.class);
        Screen1.this.startActivity(localIntent);
      }
    });
    
    this.radio4.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (Screen1.this.radio2.isChecked())
          Screen1.this.radio2.setChecked(false);
        code.gameType="demo";
        code.score = 0;
        code.over = 0.0D;
        code.single = true;
        code.over_left = 0.0D;
        code.val1 = 1;
        code.name="DEMO GAME";
        

		
         code.bowlends = 1;
         code.bowlends = 6 * code.bowlends;
		float f = Float.parseFloat("1");
		code.over_left=f;

		  code.remBalls =  code.bowlends;
		  code.totalRem = code.remBalls*2;
	
	 
        
        Intent localIntent = new Intent(Screen1.this, Screen4.class);
        Screen1.this.startActivity(localIntent);
      }
    });
  }
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.Screen1
 * JD-Core Version:    0.6.2
 */