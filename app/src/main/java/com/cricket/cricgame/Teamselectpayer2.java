package com.cricket.cricgame;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

public class Teamselectpayer2 extends Activity {
ImageView start;
TextView pl1,pl2,pl3,pl4,pl5,pl6,r1,r2,r3,r4,r5,r6;
TextView result;
int a=0,b=0,c=0,d=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teamselectpayer2);
		
		TextView teamnamea = (TextView)findViewById(R.id.TextView12);
		TextView teamnameb = (TextView)findViewById(R.id.TextView13);
		TextView team_a_total = (TextView)findViewById(R.id.totala);
		TextView team_b_total = (TextView)findViewById(R.id.totalb);
		TableRow r1 = (TableRow)findViewById(R.id.R1);
		TableRow r2 = (TableRow)findViewById(R.id.R2);
		TableRow r3 = (TableRow)findViewById(R.id.R3);
		TableRow r4 = (TableRow)findViewById(R.id.R4);
		
		this.result = ((TextView)findViewById(R.id.result));
		this.result.setTextSize(44.0F);
		
		ImageView i = (ImageView)findViewById(R.id.next);
		
		i.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent iv = new Intent(Teamselectpayer2.this,Main.class);
				startActivity(iv);
				
			}
		});
		
		teamnamea.setText(code.teama.toUpperCase());
	    teamnameb.setText(code.teamb.toUpperCase());
		team_a_total.setText(""+code.totala);
		team_b_total.setText(""+code.totalb);
		
		code.val = code.no_of_player / 2;
		if(code.no_of_player%2==0)
		{
			int temp = code.no_of_player/2;
			switch(temp)
			{
				case 1:
					r1.setVisibility(1);
					a=1;
					break;
				case 2:
					r2.setVisibility(1);
					r1.setVisibility(1);
					b=1;
					break;
				case 3:
					r1.setVisibility(1);
					r2.setVisibility(1);
					r3.setVisibility(1);
					c=1;
					break;
				case 4:
					r1.setVisibility(1);
					r2.setVisibility(1);
					r3.setVisibility(1);
					r4.setVisibility(1);
					d=1;
					break;
			}
			
		}
		//Name
		TextView player1_a = (TextView) findViewById(R.id.player1_a);
		player1_a.setText(code.teamA[0]);
		TextView player1_b = (TextView) findViewById(R.id.player1_b);
		player1_b.setText(code.teamB[0]);
		TextView player2_a = (TextView) findViewById(R.id.player2_a);
		player2_a.setText(code.teamA[1]);
		TextView player2_b = (TextView) findViewById(R.id.player2_b);
		player2_b.setText(code.teamB[1]);
		TextView player3_a = (TextView) findViewById(R.id.player3_a);
		player3_a.setText(code.teamA[2]);
		TextView player3_b = (TextView) findViewById(R.id.player3_b);
		player3_b.setText(code.teamB[2]);
		TextView player4_a = (TextView) findViewById(R.id.player4_a);
		player4_a.setText(code.teamA[3]);
		TextView player4_b = (TextView) findViewById(R.id.player4_b);
		player4_b.setText(code.teamB[3]);
		//Score
		TextView p1_a = (TextView) findViewById(R.id.p1_a);
		TextView p2_a = (TextView) findViewById(R.id.p2_a);
		TextView p3_a = (TextView) findViewById(R.id.p3_a);
		TextView p4_a = (TextView) findViewById(R.id.p4_a);
		TextView p1_b = (TextView) findViewById(R.id.p1_b);
		TextView p2_b = (TextView) findViewById(R.id.p2_b);
		TextView p3_b = (TextView) findViewById(R.id.p3_b);
		TextView p4_b = (TextView) findViewById(R.id.p4_b);
		
		 	  if (code.ref == "player1_a")
		        code.scoreA[0] = code.score;
		      if (code.ref == "player2_a")
		        code.scoreA[1] = code.score;
		      if (code.ref == "player3_a")
		        code.scoreA[2] = code.score;
		      if (code.ref == "player4_a")
		        code.scoreA[3] = code.score;
		      if (code.ref == "player1_b")
		        code.scoreB[0] = code.score;
		      if (code.ref == "player2_b")
		        code.scoreB[1] = code.score;
		      if (code.ref == "player3_b")
		        code.scoreB[2] = code.score;
		      if (code.ref == "player4_b")
		        code.scoreB[3] = code.score;
		
		
		
		p1_a.setText(""+code.scoreA[0]);
		p2_a.setText(""+code.scoreA[1]);
		p3_a.setText(""+code.scoreA[2]);
		p4_a.setText(""+code.scoreA[3]);
		
		p1_b.setText(""+code.scoreB[0]);
		p2_b.setText(""+code.scoreB[1]);
		p3_b.setText(""+code.scoreB[2]);
		p4_b.setText(""+code.scoreB[3]);
		
		 if(code.a1)
			{
				player1_a.setClickable(false);
				player1_a.setEnabled(false);
				player1_a.setBackgroundColor(Color.rgb(255, 0, 0));
				//p1_a.setText("OUT");
				//p1_a.setTextColor(color)
			}
			if(code.a2)
			{
				player2_a.setClickable(false);
				player2_a.setEnabled(false);
				player2_a.setBackgroundColor(Color.rgb(255, 0, 0));
				//p2_a.setText("OUT");

				
			}
			if(code.a3)
			{
				player3_a.setClickable(false);
				player3_a.setEnabled(false);
				player3_a.setBackgroundColor(Color.rgb(255, 0, 0));
				//p3_a.setText("OUT");

			}
			if(code.a4)
			{
				player4_a.setClickable(false);
				player4_a.setEnabled(false);
				player4_a.setBackgroundColor(Color.rgb(255, 0, 0));
				//p4_a.setText("OUT");

			}
			

			if ((!player1_a.isEnabled()) && (code.val == 1))
		      {
				player1_b.setClickable(true);
				player1_b.setEnabled(true);
		      }
			 if ((!player1_a.isEnabled()) && (!player2_a.isEnabled()) && (code.val == 2))
		      {
				 player1_b.setClickable(true);
			        player1_b.setEnabled(true);
			        player2_b.setClickable(true);
			        player2_b.setEnabled(true);
		        //break label1155;
		      }
		      if ((!player2_a.isEnabled()) && (!player3_a.isEnabled()) && (code.val == 3))
		      {
		    	  player1_b.setClickable(true);
			        player1_b.setEnabled(true);
			        player2_b.setClickable(true);
			        player2_b.setEnabled(true);
			        player3_b.setClickable(true);
			        player3_b.setEnabled(true);
		       // break label1155;
		      }
		      if ((!player2_a.isEnabled()) && (!player3_a.isEnabled()) && (!player4_a.isEnabled()) && (code.val == 4))
		      {
		    	  player1_b.setClickable(true);
			      player1_b.setEnabled(true);
			      player2_b.setClickable(true);
			      player2_b.setEnabled(true);
			      player3_b.setClickable(true);
			      player3_b.setEnabled(true);
			      player4_b.setClickable(true);
			      player4_b.setEnabled(true);
		      }
			
			if(code.b1)
			{
				player1_b.setClickable(false);
				player1_b.setEnabled(false);
				player1_b.setBackgroundColor(Color.rgb(255, 0, 0));
				//p1_b.setText("OUT");

			}
			if(code.b2)
			{
				player2_b.setClickable(false);
				player2_b.setEnabled(false);
				player2_b.setBackgroundColor(Color.rgb(255, 0, 0));
				//p2_b.setText("OUT");

			}
			if(code.b3)
			{
				player3_b.setClickable(false);
				player3_b.setEnabled(false);
				player3_b.setBackgroundColor(Color.rgb(255, 0, 0));
				//p3_b.setText("OUT");

			}
			if(code.b4)
			{
				player4_b.setClickable(false);
				player4_b.setEnabled(false);
				player4_b.setBackgroundColor(Color.rgb(255, 0, 0));
				//p4_b.setText("OUT");

			}
			
		
		
	      
	     
		if(a==1)
		{
			if(code.a1 && code.b1  && (code.val == 1))
			{
				i.setVisibility(1);
				//result.setVisibility(1);
				if (code.totala > code.totalb)
	            {
	              if (code.val1 == 0)
	              {
	                code.val1 = 1;
	                startActivity(new Intent(this, Screen9.class));
	              }
	              this.result.setText("Congratulations " + code.teama + " You Have Won The Match");
	            }
	            else if (code.totala < code.totalb)
	            {
	              this.result.setText("Congratulations " + code.teamb + " You Have Won The Match");
	            }
	            else
	            {
	              this.result.setText("Tie Match");
	            }
			
			}
		}
		else if(b==1)
		{
			if(code.a1 && code.b1 && code.a2 && code.b2 && (code.val == 2))
			{
				
				i.setVisibility(1);
				if (code.totala > code.totalb)
	            {
	              if (code.val1 == 0)
	              {
	                code.val1 = 1;
	                startActivity(new Intent(this, Screen9.class));
	              }
	              this.result.setText("Congratulations " + code.teama + " You Have Won The Match");
	            }
	            else if (code.totala < code.totalb)
	            {
	              this.result.setText("Congratulations " + code.teamb + " You Have Won The Match");
	            }
	            else
	            {
	              this.result.setText("Tie Match");
	            }
			}
		}
		else if(c==1)
		{
			if(!player1_a.isEnabled() && !player1_b.isEnabled() && !player2_a.isEnabled() && !player2_b.isEnabled()
					&& !player3_a.isEnabled() && !player3_b.isEnabled() && (code.val == 3))
			{
				
				i.setVisibility(1);
				if (code.totala > code.totalb)
	            {
	              if (code.val1 == 0)
	              {
	                code.val1 = 1;
	                startActivity(new Intent(this, Screen9.class));
	              }
	              this.result.setText("Congratulations " + code.teama + " You Have Won The Match");
	            }
	            else if (code.totala < code.totalb)
	            {
	              this.result.setText("Congratulations " + code.teamb + " You Have Won The Match");
	            }
	            else
	            {
	              this.result.setText("Tie Match");
	            }
			}
		}
		else if(d==1)
		{
			if(!player1_a.isEnabled() && !player1_b.isEnabled() && !player2_a.isEnabled() && !player2_b.isEnabled()
					&& !player3_a.isEnabled() && !player3_b.isEnabled() && !player4_a.isEnabled() && !player4_b.isEnabled() && (code.val == 4))
			{
				
				i.setVisibility(1);
				 if (code.totala > code.totalb)
		            {
		              if (code.val1 == 0)
		              {
		                code.val1 = 1;
		                startActivity(new Intent(this, Screen9.class));
		              }
		              this.result.setText("Congratulations " + code.teama + " You Have Won The Match");
		            }
		            else if (code.totala < code.totalb)
		            {
		              this.result.setText("Congratulations " + code.teamb + " You Have Won The Match");
		            }
		            else
		            {
		              this.result.setText("Tie Match");
		            }
			}
		}
		else
		{
			
		}
		
		
		
		player1_a.setOnClickListener(new TextView.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				code.a1=true;
			//	player1_a.setEnabled(true);
				code.selectedPlayer = code.teamA[0];
				code.WhichTeam=true;
				code.ref="player1_a";
				Intent iv = new Intent(Teamselectpayer2.this,Screen4.class);
				startActivity(iv);
				
			}
		});
		
		player2_a.setOnClickListener(new TextView.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				code.a2=true;
				code.selectedPlayer = code.teamA[1];
				code.WhichTeam=true;
				code.ref="player2_a";
				Intent iv = new Intent(Teamselectpayer2.this,Screen4.class);
				startActivity(iv);
				
			}
		});
		player3_a.setOnClickListener(new TextView.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				code.a3=true;
				code.WhichTeam=true;
				code.selectedPlayer = code.teamA[2];
				code.ref="player3_a";
				Intent iv = new Intent(Teamselectpayer2.this,Screen4.class);
				startActivity(iv);
				
			}
		});
		player4_a.setOnClickListener(new TextView.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				code.a4=true;
				code.WhichTeam=true;
				code.selectedPlayer = code.teamA[3];
				code.ref="player4_a";
				Intent iv = new Intent(Teamselectpayer2.this,Screen4.class);
				startActivity(iv);
				
			}
		});
		
		player1_b.setOnClickListener(new TextView.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				code.b1=true;
				code.WhichTeam=false;
				code.selectedPlayer = code.teamB[0];
				code.ref="player1_b";
				Intent iv = new Intent(Teamselectpayer2.this,Screen4.class);
				startActivity(iv);
				
			}
		});
		
		player2_b.setOnClickListener(new TextView.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				code.b2=true;
				code.WhichTeam=false;
				code.selectedPlayer = code.teamB[1];
				code.ref="player2_b";
				Intent iv = new Intent(Teamselectpayer2.this,Screen4.class);
				startActivity(iv);
				
			}
		});
		player3_b.setOnClickListener(new TextView.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				code.b3=true;
				code.WhichTeam=false;
				code.ref="player3_b";
				code.selectedPlayer = code.teamB[2];
				Intent iv = new Intent(Teamselectpayer2.this,Screen4.class);
				startActivity(iv);
				
			}
		});
		player4_b.setOnClickListener(new TextView.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				code.b4=true;
				code.WhichTeam=false;
				code.ref="player4_b";
				code.selectedPlayer = code.teamB[3];
				Intent iv = new Intent(Teamselectpayer2.this,Screen4.class);
				startActivity(iv);
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
