package com.cricket.cricgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Screens2 extends Activity
{
  int a = 0;
  int b = 0;
  int c = 0;
  int d = 0;
  ImageView i;
  EditText t1;
  EditText t2;
  EditText t3;
  EditText t4;

  protected void onCreate(Bundle paramBundle)
  {
		super.onCreate(paramBundle);
		setContentView(R.layout.select_team_a);
		i=(ImageView)findViewById(R.id.next);
		
		t1=(EditText)findViewById(R.id.player1a);
		
		t2=(EditText)findViewById(R.id.player2a);
		
		t3=(EditText)findViewById(R.id.player3a);
		
		t4=(EditText)findViewById(R.id.player4a);
		
		Log.i("Screen2",""+code.no_of_player);
			
		if(code.no_of_player%2==0)
		{
			int temp = code.no_of_player/2;
			switch(temp)
			{
				case 1:
					t1.setVisibility(1);
					a=1;
					break;
				case 2:
					t2.setVisibility(1);
					t1.setVisibility(1);
					b=1;
					break;
				case 3:
					t1.setVisibility(1);
					t2.setVisibility(1);
					t3.setVisibility(1);
					c=1;
					break;
				case 4:
					t1.setVisibility(1);
					t2.setVisibility(1);
					t3.setVisibility(1);
					t4.setVisibility(1);
					d=1;
					break;
			}
			
		}
		
		i.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(a==1)
				{
					if(t1.getText().length()>1)
					{
						code.teamA[0]=t1.getText().toString();
						Intent x=new Intent(Screens2.this,Screens2b.class);
						startActivity(x);
					}
				}
				else if(b==1)
				{
					if(t1.getText().length()>1 && t2.getText().length()>1)
					{
						code.teamA[0]=t1.getText().toString();
						code.teamA[1]=t2.getText().toString();
						Intent x=new Intent(Screens2.this,Screens2b.class);
						startActivity(x);
					}
				}
				else if(c==1)
				{
					if(t1.getText().length()>1 && t2.getText().length()>1 && t3.getText().length()>1)
					{
						code.teamA[0]=t1.getText().toString();
						code.teamA[1]=t2.getText().toString();
						code.teamA[2]=t3.getText().toString();
						Intent x=new Intent(Screens2.this,Screens2b.class);
						startActivity(x);
					}
				}
				else if(d==1)
				{
					if(t1.getText().length()>1 && t2.getText().length()>1 && t3.getText().length()>1 && t4.getText().length()>1)
					{
						code.teamA[0]=t1.getText().toString();
						code.teamA[1]=t2.getText().toString();
						code.teamA[2]=t3.getText().toString();
						code.teamA[3]=t4.getText().toString();
						Intent x=new Intent(Screens2.this,Screens2b.class);
						startActivity(x);
					}
				}
				else
				{
					AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
          		alert.setTitle("Invalid Input");
          		alert.setMessage("Please Enter Names");           		
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

	

}


/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.Screens2
 * JD-Core Version:    0.6.2
 */