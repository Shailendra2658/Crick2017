package com.cricket.listView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import com.cricket.cricgame.R;

public class CustomizedListView extends Activity {
	// All static variables
	static final String URL = "http://api.androidhive.info/music/music.xml";
	// XML node keys
	static final String KEY_SONG = "song"; // parent node
	static final String KEY_ID = "id";
	static final String KEY_TITLE = "title";
	static final String KEY_ARTIST = "artist";
	static final String KEY_DURATION = "duration";
	static final String KEY_THUMB_URL = "thumb_url";
	private static String Video = null;
	
	ListView list;
    LazyAdapter adapter;
    File f = new File(Environment.getExternalStorageDirectory().toString() + "/Videos/Break/");
	File[] files = this.f.listFiles();
	String [] videoFileList;

	 public String getDuration(String name){
		 try{
		 String path = Environment.getExternalStorageDirectory().toString() + "/Videos/Break/"+name;
		  MediaPlayer mp = MediaPlayer.create(this, Uri.fromFile(new File(path)));
		  int duration = mp.getDuration();
		  mp.release();
		  /*convert millis to appropriate time*/
		  return String.format("%d min, %d sec", 
		          TimeUnit.MILLISECONDS.toMinutes(duration),
		          TimeUnit.MILLISECONDS.toSeconds(duration) - 
		          TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
		      );
	  }
		 catch(Exception e){
			 Log.e("Cust ","Error "+e);
			 return "Error Cannot read this file...!";
		 }
	 }
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		videoFileList = new String[files.length];
		ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
		 
		// looping through all song nodes <song>
		for (int i = 0; i < files.length; i++) {
			// creating new HashMap
			File localFile = files[i];
			HashMap<String, String> map = new HashMap<String, String>();
			//Element e = (Element) nl.item(i);
			// adding each child node to HashMap key => value
			map.put(KEY_ID, i+"");
			map.put(KEY_TITLE, localFile.getName());
			map.put(KEY_ARTIST, localFile.getName());
			map.put(KEY_DURATION, getDuration(localFile.getName()));
			map.put(KEY_THUMB_URL, localFile.getPath());
			videoFileList[i] = localFile.getPath();
			// adding HashList to ArrayList
			songsList.add(map);
		}
		

		list=(ListView)findViewById(R.id.list);
		
		// Getting adapter by passing xml data ArrayList
        adapter=new LazyAdapter(this, songsList);        
        list.setAdapter(adapter);
        

        // Click event for single list row
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Video = videoFileList[position];			
				showPopup3(CustomizedListView.this);
			}
		});		
	}	
	
	  private void showPopup3(Activity paramActivity)
	  {
		  try{
	    final Dialog localDialog = new Dialog(this, 16973834);
	    localDialog.setContentView(2130903065);
	    VideoView localVideoView = (VideoView)localDialog.findViewById(2131230730);
	    Button localButton = (Button)localDialog.findViewById(2131230839);
	    TextView anim;
	    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	    String animText = pref.getString("scroll", "Top Score");
	    String str = this.Video;
	    localButton.setOnClickListener(new View.OnClickListener()
	    {
	      public void onClick(View paramAnonymousView)
	      {
	        localDialog.dismiss();
	        finish();
	      }
	    });
	    localDialog.show();
	    anim = ((TextView)localDialog.findViewById(R.id.anim));
	    anim.setTextSize(31);
	    anim.setText(animText);
	    Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/TIMES.TTF");
	    anim.setTypeface(tf,1);
	    anim.startAnimation(AnimationUtils.loadAnimation(this, R.anim.moving_text));
	    localVideoView.setVideoPath(str);
	    localVideoView.requestFocus();
	    localVideoView.start();
	    localVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
	    {
	      public void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
	      {
	        paramAnonymousMediaPlayer.setLooping(true);
	      }
	    });
		  }catch(Exception e){
			  Log.e("Custo...","Eeror ");
		  }
	  }
	  
	  
	  
	  
}