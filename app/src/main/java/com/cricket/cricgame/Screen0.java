package com.cricket.cricgame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import java.io.File;

public class Screen0 extends Activity
{
  Bitmap bitmap;
  Bitmap bitmap1;
  Bitmap bitmap2;
  Bitmap bitmap22;
  Bitmap bitmap3;
  Bitmap bitmap33;
  Bitmap bitmap4;
  Bitmap bitmap44;
  Bitmap bitmap5;
  Bitmap bitmap55;
  Bitmap bitmap6;
  Bitmap bitmap66;
  ImageView bowl;
  ImageView bowl1;
  ImageView bowl2;
  ImageView bowl3;
  ImageView bowl4;
  ImageView bowl5;
  ImageView bowl6;
  RadioGroup rg;
  int val = 0;
  int val1 = 0;
  int val2 = 0;
  int val3 = 0;
  int val4 = 0;
  int val5 = 0;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903047);
    String str1 = Environment.getExternalStorageDirectory().toString() + "/Stanley/1.png";
    String str2 = Environment.getExternalStorageDirectory().toString() + "/Stanley/11.png";
    String str3 = Environment.getExternalStorageDirectory().toString() + "/Stanley/2.png";
    String str4 = Environment.getExternalStorageDirectory().toString() + "/Stanley/22.png";
    String str5 = Environment.getExternalStorageDirectory().toString() + "/Stanley/3.png";
    String str6 = Environment.getExternalStorageDirectory().toString() + "/Stanley/33.png";
    String str7 = Environment.getExternalStorageDirectory().toString() + "/Stanley/4.png";
    String str8 = Environment.getExternalStorageDirectory().toString() + "/Stanley/44.png";
    String str9 = Environment.getExternalStorageDirectory().toString() + "/Stanley/5.png";
    String str10 = Environment.getExternalStorageDirectory().toString() + "/Stanley/55.png";
    String str11 = Environment.getExternalStorageDirectory().toString() + "/Stanley/6.png";
    String str12 = Environment.getExternalStorageDirectory().toString() + "/Stanley/66.png";
    this.bitmap = BitmapFactory.decodeFile(str1);
    this.bitmap1 = BitmapFactory.decodeFile(str2);
    this.bitmap2 = BitmapFactory.decodeFile(str3);
    this.bitmap22 = BitmapFactory.decodeFile(str4);
    this.bitmap3 = BitmapFactory.decodeFile(str5);
    this.bitmap33 = BitmapFactory.decodeFile(str6);
    this.bitmap4 = BitmapFactory.decodeFile(str7);
    this.bitmap44 = BitmapFactory.decodeFile(str8);
    this.bitmap5 = BitmapFactory.decodeFile(str9);
    this.bitmap55 = BitmapFactory.decodeFile(str10);
    this.bitmap6 = BitmapFactory.decodeFile(str11);
    this.bitmap66 = BitmapFactory.decodeFile(str12);
    this.bowl = ((ImageView)findViewById(2131230738));
    this.bowl1 = ((ImageView)findViewById(2131230741));
    this.bowl2 = ((ImageView)findViewById(2131230739));
    this.bowl3 = ((ImageView)findViewById(2131230744));
    this.bowl4 = ((ImageView)findViewById(2131230745));
    this.bowl5 = ((ImageView)findViewById(2131230743));
    this.rg = ((RadioGroup)findViewById(2131230746));
    this.bowl.setImageBitmap(this.bitmap);
    this.bowl1.setImageBitmap(this.bitmap2);
    this.bowl2.setImageBitmap(this.bitmap3);
    this.bowl3.setImageBitmap(this.bitmap4);
    this.bowl4.setImageBitmap(this.bitmap5);
    this.bowl5.setImageBitmap(this.bitmap6);
    code.bowler = "bowl1.mp4";
    code.four = "four1.mp4";
    code.six = "six1.mp4";
    code.out = "out1.mp4";
    this.bowl.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Screen0.this.bowl.setImageBitmap(Screen0.this.bitmap1);
        Screen0.this.bowl1.setImageBitmap(Screen0.this.bitmap2);
        Screen0.this.bowl2.setImageBitmap(Screen0.this.bitmap3);
        Screen0.this.bowl3.setImageBitmap(Screen0.this.bitmap4);
        Screen0.this.bowl4.setImageBitmap(Screen0.this.bitmap5);
        Screen0.this.bowl5.setImageBitmap(Screen0.this.bitmap6);
        code.bowler = "bowl1.mp4";
        code.four = "four1.mp4";
        code.six = "six1.mp4";
        code.out = "out1.mp4";
      }
    });
    this.bowl1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Screen0.this.bowl.setImageBitmap(Screen0.this.bitmap);
        Screen0.this.bowl1.setImageBitmap(Screen0.this.bitmap22);
        Screen0.this.bowl2.setImageBitmap(Screen0.this.bitmap3);
        Screen0.this.bowl3.setImageBitmap(Screen0.this.bitmap4);
        Screen0.this.bowl4.setImageBitmap(Screen0.this.bitmap5);
        Screen0.this.bowl5.setImageBitmap(Screen0.this.bitmap6);
        code.bowler = "bowl2.mp4";
        code.four = "four2.mp4";
        code.six = "six2.mp4";
        code.out = "out2.mp4";
      }
    });
    this.bowl2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Screen0.this.bowl.setImageBitmap(Screen0.this.bitmap);
        Screen0.this.bowl1.setImageBitmap(Screen0.this.bitmap2);
        Screen0.this.bowl2.setImageBitmap(Screen0.this.bitmap33);
        Screen0.this.bowl3.setImageBitmap(Screen0.this.bitmap4);
        Screen0.this.bowl4.setImageBitmap(Screen0.this.bitmap5);
        Screen0.this.bowl5.setImageBitmap(Screen0.this.bitmap6);
        code.bowler = "bowl3.mp4";
        code.four = "four3.mp4";
        code.six = "six3.mp4";
        code.out = "out3.mp4";
      }
    });
    this.bowl3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Screen0.this.bowl.setImageBitmap(Screen0.this.bitmap);
        Screen0.this.bowl1.setImageBitmap(Screen0.this.bitmap2);
        Screen0.this.bowl2.setImageBitmap(Screen0.this.bitmap3);
        Screen0.this.bowl3.setImageBitmap(Screen0.this.bitmap44);
        Screen0.this.bowl4.setImageBitmap(Screen0.this.bitmap5);
        Screen0.this.bowl5.setImageBitmap(Screen0.this.bitmap6);
        code.bowler = "bowl4.mp4";
        code.four = "four4.mp4";
        code.six = "six4.mp4";
        code.out = "out4.mp4";
      }
    });
    this.bowl4.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Screen0.this.bowl.setImageBitmap(Screen0.this.bitmap);
        Screen0.this.bowl1.setImageBitmap(Screen0.this.bitmap2);
        Screen0.this.bowl2.setImageBitmap(Screen0.this.bitmap3);
        Screen0.this.bowl3.setImageBitmap(Screen0.this.bitmap4);
        Screen0.this.bowl4.setImageBitmap(Screen0.this.bitmap55);
        Screen0.this.bowl5.setImageBitmap(Screen0.this.bitmap6);
        code.bowler = "bowl5.mp4";
        code.four = "four5.mp4";
        code.six = "six5.mp4";
        code.out = "out5.mp4";
      }
    });
    this.bowl5.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Screen0.this.bowl.setImageBitmap(Screen0.this.bitmap);
        Screen0.this.bowl1.setImageBitmap(Screen0.this.bitmap2);
        Screen0.this.bowl2.setImageBitmap(Screen0.this.bitmap3);
        Screen0.this.bowl3.setImageBitmap(Screen0.this.bitmap4);
        Screen0.this.bowl4.setImageBitmap(Screen0.this.bitmap5);
        Screen0.this.bowl5.setImageBitmap(Screen0.this.bitmap66);
        code.bowler = "bowl6.mp4";
        code.four = "four6.mp4";
        code.six = "six6.mp4";
        code.out = "out6.mp4";
      }
    });
    this.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 2131230747:
          Intent localIntent3 = new Intent(Screen0.this, Screen1.class);
          Screen0.this.startActivity(localIntent3);
          return;
        case 2131230748:
          Intent localIntent2 = new Intent(Screen0.this, Screen1.class);
          Screen0.this.startActivity(localIntent2);
          return;
        case 2131230749:
        }
        Intent localIntent1 = new Intent(Screen0.this, Screen1.class);
        Screen0.this.startActivity(localIntent1);
      }
    });
  }
}

/* Location:           H:\Company\Alitum\Stanley\Apk\classes_dex2jar.jar
 * Qualified Name:     com.cricket.cricgame.Screen0
 * JD-Core Version:    0.6.2
 */