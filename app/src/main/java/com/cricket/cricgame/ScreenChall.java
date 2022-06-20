package com.cricket.cricgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ScreenChall extends Activity
{
  ImageView next;
  ImageView restart;
  EditText target;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903057);
    code.flag=1;
    this.next = ((ImageView)findViewById(2131230754));
    this.target = ((EditText)findViewById(2131230786));
    this.restart = ((ImageView)findViewById(2131230764));
    this.next.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!ScreenChall.this.target.getText().toString().isEmpty())
        {
          code.target = ScreenChall.this.target.getText().toString();
          Intent localIntent = new Intent(ScreenChall.this, ScreenChall1.class);
          ScreenChall.this.startActivity(localIntent);
        }
        else
        	 Toast.makeText(getApplicationContext(), "Target cannot be empty", Toast.LENGTH_LONG).show();
      }
    });
    this.restart.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(ScreenChall.this);
        localBuilder.setMessage("Are you sure?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.cancel();
            Intent localIntent = new Intent(ScreenChall.this, Main.class);
            ScreenChall.this.finish();
            ScreenChall.this.startActivity(localIntent);
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
    
    
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
	  Log.i("Price","Key Pressed "+paramInt);
    if (paramKeyEvent.getAction() != 0)
      return true;
    if (paramInt == 66 || paramInt == 61)
    {
        if (!ScreenChall.this.target.getText().toString().isEmpty())
        {
          code.target = ScreenChall.this.target.getText().toString();
          Intent localIntent = new Intent(ScreenChall.this, ScreenChall1.class);
          ScreenChall.this.startActivity(localIntent);
          return true;
        }
        Toast.makeText(getApplicationContext(), "Target cannot be empty", Toast.LENGTH_LONG).show();
        	
      }
    return super.onKeyDown(paramInt, paramKeyEvent);
}
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.ScreenChall
 * JD-Core Version:    0.6.2
 */