package com.cricket.cricgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Screen7 extends Activity
{
  TextView chill;
  TextView over;
  ImageView restart;
  TextView score;
  TextView target;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903054);
    this.restart = ((ImageView)findViewById(2131230764));
    this.target = ((TextView)findViewById(2131230765));
    this.score = ((TextView)findViewById(2131230777));
    this.chill = ((TextView)findViewById(2131230783));
    this.target.setText(Integer.toString(code.newtarget));
    this.chill.setText("CHILL!  " + code.name);
    this.restart.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(Screen7.this, Main.class);
        Screen7.this.startActivity(localIntent);
      }
    });
  }
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.Screen7
 * JD-Core Version:    0.6.2
 */