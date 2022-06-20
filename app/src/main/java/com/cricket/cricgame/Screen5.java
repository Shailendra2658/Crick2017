package com.cricket.cricgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Screen5 extends Activity
{
  TextView balls;
  TextView fours;
  TextView over;
  ImageView restart;
  TextView score;
  TextView sixes;
  TextView demovideoanimation;
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.screen5);
    this.score = ((TextView)findViewById(2131230777));
    this.over = ((TextView)findViewById(2131230779));
    this.restart = ((ImageView)findViewById(2131230764));
    this.fours = ((TextView)findViewById(2131230780));
    this.sixes = ((TextView)findViewById(2131230781));
    this.balls = ((TextView)findViewById(2131230782));
    this.demovideoanimation = (TextView) findViewById(R.id.demovideoanimation);
    if(code.gameType.equals("demo")){
  	  	demovideoanimation.setVisibility(View.VISIBLE);
  	  	demovideoanimation.startAnimation(AnimationUtils.loadAnimation(this, R.anim.blink));

    }
    int i = (int)code.over_left*6;
    if (code.challenge == 1)
    {
      this.over.setText(Integer.toString(code.newtarget));
      this.fours.setText(Integer.toString(code.fours));
      this.sixes.setText(Integer.toString(code.sixes));
      this.balls.setText(Integer.toString(i * 6));
    }
    else
    	this.over.setText(Integer.toString(code.score));
    
    while (true)
    {
      this.score.setText(code.name + " your final score is :");
      ViewFlipper localViewFlipper = (ViewFlipper)findViewById(2131230778);
      localViewFlipper.startFlipping();
      localViewFlipper.setInAnimation(AnimationUtils.loadAnimation(getApplicationContext(), 17432576));
      localViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(getApplicationContext(), 17432577));
      this.restart.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent(Screen5.this, Main.class);
          Screen5.this.startActivity(localIntent);
        }
      });
     
      this.fours.setText(Integer.toString(code.fours));
      this.sixes.setText(Integer.toString(code.sixes));
      this.balls.setText(Integer.toString(i));
      
      return;
    }
  }
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.Screen5
 * JD-Core Version:    0.6.2
 */