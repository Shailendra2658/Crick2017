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

public class Screen2 extends Activity
{
  EditText name;
  ImageView next;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903049);
    this.next = ((ImageView)findViewById(2131230754));
    this.name = ((EditText)findViewById(2131230755));
    this.next.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (Screen2.this.name.getText().toString().length() > 1)
        {
          code.name = Screen2.this.name.getText().toString();
          Intent localIntent = new Intent(Screen2.this, Screen3.class);
          Screen2.this.startActivity(localIntent);
          return;
        }
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramAnonymousView.getContext());
        localBuilder.setTitle("Invalid Input");
        localBuilder.setMessage("Please Enter Your Name");
        
        localBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
          }
        });
        localBuilder.show();
      }
    });
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() != 0)
      return true;
    if ((paramInt == 66) && (!this.name.getText().toString().isEmpty()) || (paramInt == 61 && (!this.name.getText().toString().isEmpty())))
    {

        if (Screen2.this.name.getText().toString().length() > 0)
        {
          code.name = Screen2.this.name.getText().toString();
          Intent localIntent = new Intent(Screen2.this, Screen3.class);
          Screen2.this.startActivity(localIntent);
         return true;
        }
        Toast.makeText(getApplicationContext(), "Name cannot be blank", Toast.LENGTH_LONG).show();
        
       
  }
    return super.onKeyDown(paramInt, paramKeyEvent);
}
}
/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.Screen2
 * JD-Core Version:    0.6.2
 */