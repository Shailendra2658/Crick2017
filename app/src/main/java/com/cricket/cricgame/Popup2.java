package com.cricket.cricgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.widget.VideoView;
import java.io.File;

public class Popup2 extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903043);
    VideoView localVideoView = (VideoView)findViewById(2131230730);
    localVideoView.setVideoPath(Environment.getExternalStorageDirectory().toString() + "/Videos/6.mp4");
    localVideoView.requestFocus();
    localVideoView.start();
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        Intent localIntent = new Intent(Popup2.this, Screen4.class);
        Popup2.this.startActivity(localIntent);
      }
    }
    , 4000L);
  }
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.Popup2
 * JD-Core Version:    0.6.2
 */