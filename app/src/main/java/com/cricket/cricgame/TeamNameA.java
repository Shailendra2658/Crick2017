package com.cricket.cricgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

public class TeamNameA extends Activity
{
  ImageView i;
  EditText teama;
  EditText teamb;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903063);
    this.i = ((ImageView)findViewById(2131230808));
    teama = (EditText)findViewById(2131230809);
    teamb = (EditText)findViewById(2131230807);
    this.i.setOnClickListener(new teamname());
  }

  class teamname
    implements View.OnClickListener
  {
    teamname()
    {
    }

    public void onClick(View paramView)
    {
      code.teama = teama.getText().toString();
      code.teamb = teamb.getText().toString();
      Intent localIntent = new Intent();
      localIntent.setClass(TeamNameA.this.getApplicationContext(), Screens1.class);
      TeamNameA.this.startActivity(localIntent);
    }
  }
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.TeamNameA
 * JD-Core Version:    0.6.2
 */