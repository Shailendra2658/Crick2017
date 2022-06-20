package com.cricket.cricgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Screen9 extends Activity
{
  TextView over;
  ImageView restart;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903056);
    this.restart = ((ImageView)findViewById(2131230764));
    this.over = ((TextView)findViewById(2131230785));
    this.over.setText(code.teama + " WON THE MATCH");
    this.restart.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(Screen9.this, Teamselectpayer2.class);
        Screen9.this.startActivity(localIntent);
      }
    });
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131165190, paramMenu);
    return true;
  }
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.Screen9
 * JD-Core Version:    0.6.2
 */