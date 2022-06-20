package com.cricket.cricgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class Screens1 extends Activity
{
  ImageView i;
  RadioButton r1;
  RadioButton r2;
  EditText t;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903059);
    this.t = ((EditText)findViewById(2131230756));
    this.r1 = ((RadioButton)findViewById(2131230792));
    this.r2 = ((RadioButton)findViewById(2131230791));
    this.r1.setText(code.teama);
    this.r2.setText(code.teamb);
    this.r1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (Screens1.this.t.getText().toString().length() > 0)
        {
          String str = Screens1.this.t.getText().toString();
          System.out.println("String s " + str);
          int i = Integer.parseInt(str);
          if ((i >= 2) && (i <= 8) && (i % 2 == 0))
          {
            code.no_of_player = Integer.parseInt(Screens1.this.t.getText().toString());
            Intent localIntent = new Intent(Screens1.this, Screens2.class);
            Screens1.this.startActivity(localIntent);
            return;
          }
          AlertDialog.Builder localBuilder2 = new AlertDialog.Builder(Screens1.this);
          localBuilder2.setTitle("Invalid Input");
          localBuilder2.setMessage("Please Enter Between 2 and 6 !! Must Be Either 2,4 or 6");
          localBuilder2.setPositiveButton("Ok", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
            }
          });
          localBuilder2.show();
          return;
        }
        AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(Screens1.this);
        localBuilder1.setTitle("Invalid Input");
        localBuilder1.setMessage("Please Enter The No Of Player !");
        localBuilder1.setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
          }
        });
        localBuilder1.show();
      }
    });
    this.r2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str1 = code.teama;
        code.teama = code.teamb;
        code.teamb = str1;
        if (Screens1.this.t.getText().toString().length() > 0)
        {
          String str2 = Screens1.this.t.getText().toString();
          System.out.println("String s " + str2);
          int i = Integer.parseInt(str2);
          if ((i >= 2) && (i <= 8) && (i % 2 == 0))
          {
            code.no_of_player = Integer.parseInt(Screens1.this.t.getText().toString());
          
            Intent localIntent = new Intent(Screens1.this, Screens2.class);
            Screens1.this.startActivity(localIntent);
            return;
          }
          AlertDialog.Builder localBuilder2 = new AlertDialog.Builder(Screens1.this);
          localBuilder2.setTitle("Invalid Input");
          localBuilder2.setMessage("Please Enter Between 2 and 6 !! Must Be Either 2,4 or 6");
          localBuilder2.setPositiveButton("Ok", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
            }
          });
          localBuilder2.show();
          return;
        }
        AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(Screens1.this);
        localBuilder1.setTitle("Invalid Input");
        localBuilder1.setMessage("Please Enter The No Of Player !");
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
 * Qualified Name:     com.cricket.cricgame.Screens1
 * JD-Core Version:    0.6.2
 */