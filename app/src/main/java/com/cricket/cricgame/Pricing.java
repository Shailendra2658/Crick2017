package com.cricket.cricgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Pricing extends Activity
{
  EditText price;
  ImageView next;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.pricing);
    this.next = ((ImageView)findViewById(2131230754));
    price = ((EditText)findViewById(2131230755));
    price.setKeyListener(new DigitsKeyListener()
    {
      protected char[] getAcceptedChars()
      {
        return new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
      }
    });
    this.next.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (price.getText().toString().length() > 0)
        {
          code.price = price.getText().toString();
          Intent localIntent = new Intent(Pricing.this, Screen0.class);
          Pricing.this.startActivity(localIntent);
          return;
        }
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramAnonymousView.getContext());
        localBuilder.setTitle("Invalid Input");
        localBuilder.setMessage("Please Enter Valid Game Price");
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
	  Log.i("Price","Key Pressed "+paramInt);
    if (paramKeyEvent.getAction() != 0)
      return true;
    if (paramInt == 66 || paramInt == 61)
    {

        if (!price.getText().toString().isEmpty())
        {
          code.price = price.getText().toString();
          Intent localIntent = new Intent(Pricing.this, Screen0.class);
          Pricing.this.startActivity(localIntent);
          return true;
        }
        Toast.makeText(getApplicationContext(), "Invalid Game Price", Toast.LENGTH_LONG).show();
       
  }
    return super.onKeyDown(paramInt, paramKeyEvent);
}
}
/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.Screen2
 * JD-Core Version:    0.6.2
 */