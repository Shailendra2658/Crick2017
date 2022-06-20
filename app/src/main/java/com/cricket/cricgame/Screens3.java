package com.cricket.cricgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class Screens3 extends Activity
{
  EditText e;
  ImageView i;
  CheckBox enableDemo;
  private SharedPreferences sp;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903060);
    this.e = ((EditText)findViewById(2131230756));
    this.i = ((ImageView)findViewById(2131230754));
    enableDemo = (CheckBox) findViewById(R.id.demo);
    sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

    this.i.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (Screens3.this.e.getText().toString().length() >= 1)
        {
          if (Screens3.this.e.getText().toString().length() < 2)
          {
        	  if(enableDemo.isChecked())
					 code.gameType="demo";
            int i = Integer.parseInt(Screens3.this.e.getText().toString());
            code.over_left = i;
			sp.edit().putString(code.KEY_OVER, e.getText().toString()).commit();

            code.remBalls = 6 * (i * (code.no_of_player / 2));
            code.totalRem = code.remBalls*2;
            Intent localIntent = new Intent(Screens3.this, Teamselectpayer2.class);
            Screens3.this.startActivity(localIntent);
            return;
          }
          AlertDialog.Builder localBuilder2 = new AlertDialog.Builder(paramAnonymousView.getContext());
          localBuilder2.setTitle("Invalid Input");
          localBuilder2.setMessage("Please Enter Valid Numbers of Overs");
          localBuilder2.setPositiveButton("Ok", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
            }
          });
          localBuilder2.show();
          return;
        }
        AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(paramAnonymousView.getContext());
        localBuilder1.setTitle("Invalid Input");
        localBuilder1.setMessage("Please Enter Valid Numbers of Overs");
        localBuilder1.setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
          }
        });
        localBuilder1.show();
      }
    });
  }
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.Screens3
 * JD-Core Version:    0.6.2
 */