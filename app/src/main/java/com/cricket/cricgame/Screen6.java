package com.cricket.cricgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class Screen6 extends Activity
{
  TextView over;
  ImageView restart;
  TextView score;
  TextView demovideoanimation;
AbsoluteLayout awesome;
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903053);
    this.restart = ((ImageView)findViewById(2131230764));
    this.demovideoanimation = (TextView) findViewById(R.id.demovideoanimation);
    this.awesome = (AbsoluteLayout) findViewById(R.id.background);

    if(code.gameType.equals("demo")){
    	awesome.getBackground().setAlpha(128);
  	  	demovideoanimation.setVisibility(View.VISIBLE);
  	  	demovideoanimation.startAnimation(AnimationUtils.loadAnimation(this, R.anim.blink));

    }

    code.screen6 = 1;
    this.restart.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (code.remBalls > 0)
        {
          Intent localIntent1 = new Intent(Screen6.this, Screen8.class);
          Screen6.this.startActivity(localIntent1);
          return;
        }
        Intent localIntent2 = new Intent(Screen6.this, Main.class);
        Screen6.this.finish();
        Screen6.this.startActivity(localIntent2);
      }
    });
  }
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.Screen6
 * JD-Core Version:    0.6.2
 */