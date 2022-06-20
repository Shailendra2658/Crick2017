package com.cricket.cricgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.DigitsKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Screen3 extends Activity
{
  ImageView next;
  EditText over;
  private SharedPreferences sp;
  CheckBox enableDemo;


  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903050);
    this.next = ((ImageView)findViewById(2131230754));
    this.over = ((EditText)findViewById(2131230756));
    enableDemo = (CheckBox) findViewById(R.id.demo);
    sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    
    this.over.setKeyListener(new DigitsKeyListener()
    {
      protected char[] getAcceptedChars()
      {
        return new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
      }
    });
    
    next.setOnClickListener(new ImageView.OnClickListener() {
		
		public void onClick(View v) {
			
			if(over.getText().toString().length()>=1 )
			{
				 if( over.getText().toString().length()<2 )
				 {
					 if(enableDemo.isChecked())
						 code.gameType="demo";
					 String ball = Screen3.this.over.getText().toString();
			          code.bowlends = Integer.parseInt(ball);
			          code.bowlends = 6 * code.bowlends;
					float f = Float.parseFloat(over.getText().toString());
					code.over_left=f;
					sp.edit().putString(code.KEY_OVER, over.getText().toString()).commit();

					  code.remBalls =  code.bowlends;
					  code.totalRem = code.remBalls*2;
					if (code.challenge == 1)
			          {
			            Intent localIntent1 = new Intent(Screen3.this, ScreenChall.class);
			            Screen3.this.startActivity(localIntent1);
			          }
					else{
						Intent iv = new Intent(Screen3.this,Screen4.class);
						startActivity(iv);
					}
				 }
				 
				else
				{
						AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());

		            	alert.setTitle("Invalid Input");
		            	alert.setMessage("Please Enter Valid Numbers of Overs");

		            		              		
		            	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		            	public void onClick(DialogInterface dialog, int whichButton) {
		            		  //String value = input.getText();
		            		  // Do something with value!
		            		return;
		            			            		
		            	}
		            	});alert.show();
				}
			}
			else
			{
				AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());

        		alert.setTitle("Invalid Input");
        		alert.setMessage("Please Enter Valid Numbers of Overs");

        		              		
        		alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        		public void onClick(DialogInterface dialog, int whichButton) {
        		  //String value = input.getText();
        		  // Do something with value!
        			return;	            		
        		  }
        		});alert.show();
			}
		}
	});
  }
  

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && (!this.over.getText().toString().isEmpty()) || paramInt == 61)
    {
		
		if(over.getText().toString().length()>=1 )
		{
			 if( over.getText().toString().length()<2 )
			 {/*
				 String ball = Screen3.this.over.getText().toString();
		          code.bowlends = Integer.parseInt(ball);
		          code.bowlends = 6 * code.bowlends;
				float f = Float.parseFloat(over.getText().toString());
				code.over_left=f;
				if (code.challenge == 1)
		          {
		            Intent localIntent1 = new Intent(Screen3.this, ScreenChall.class);
		            Screen3.this.startActivity(localIntent1);
		          }
				else{
					Intent iv = new Intent(Screen3.this,Screen4.class);
					startActivity(iv);
				}
			 */
				 if(enableDemo.isChecked())
					 code.gameType="demo";
				 String ball = Screen3.this.over.getText().toString();
		          code.bowlends = Integer.parseInt(ball);
		          code.bowlends = 6 * code.bowlends;
				float f = Float.parseFloat(over.getText().toString());
				code.over_left=f;
				sp.edit().putString(code.KEY_OVER, over.getText().toString()).commit();
				  code.remBalls =  code.bowlends;
				  code.totalRem = (code.no_of_player/2)*code.remBalls;
				if (code.challenge == 1)
		          {
		            Intent localIntent1 = new Intent(Screen3.this, ScreenChall.class);
		            Screen3.this.startActivity(localIntent1);
		          }
				else{
					Intent iv = new Intent(Screen3.this,Screen4.class);
					startActivity(iv);
				}
			  
			 
			 }
			 
			else
			{
				 Toast.makeText(getApplicationContext(), "Enter Valid Numbers of Overs", Toast.LENGTH_LONG).show();
				/*
					AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());

	            	alert.setTitle("Invalid Input");
	            	alert.setMessage("Please Enter Valid Numbers of Overs");

	            		              		
	            	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	            	public void onClick(DialogInterface dialog, int whichButton) {
	            		  //String value = input.getText();
	            		  // Do something with value!
	            		return;
	            			            		
	            	}
	            	});alert.show();
			*/}
		}
		else
		{
			Toast.makeText(getApplicationContext(), "Enter Valid Numbers of Overs", Toast.LENGTH_LONG).show();/*
			AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());

    		alert.setTitle("Invalid Input");
    		alert.setMessage("Please Enter Valid Numbers of Overs");

    		              		
    		alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    		public void onClick(DialogInterface dialog, int whichButton) {
    		  //String value = input.getText();
    		  // Do something with value!
    			return;	            		
    		  }
    		});alert.show();
		*/}
	}

    return super.onKeyDown(paramInt, paramKeyEvent);
   }
  
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.Screen3
 * JD-Core Version:    0.6.2
 */