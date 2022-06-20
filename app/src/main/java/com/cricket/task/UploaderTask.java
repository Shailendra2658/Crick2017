/*
 * Copyright (C) 2009 University of Washington
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.cricket.task;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.net.ParseException;
import android.os.AsyncTask;
import android.util.Log;

import com.cricket.cricgame.code;

/**
 * Background task for uploading completed forms.
 *
 * @author Shailendra (shailendrarao17@gmail.com)
 */
public class UploaderTask extends AsyncTask<String, Integer, Integer> {

    private static final String t = "UploaderTask";
    // it can take up to 27 seconds to spin up Aggregate
   
    private static final String fail = "Error: ";
    UploadListener mStateListener;
    String resMsg = "nothing";
    String played;
    String today ;
    String month ;
    String jArray,status;
    Context context;

    @Override
    protected void onPostExecute(Integer outcome) {
    	//
    	 if (mStateListener != null) {
             mStateListener.uploadComplete(outcome,resMsg,context,status);
         }
    }

   
   
    public void setLoginListener(UploadListener sl) {
        synchronized (this) {
            mStateListener = sl;
        }
    }

	@Override
	protected Integer doInBackground(String... arg0) {
		// TODO Auto-generated method stub
        
        String played = this.played;
        String today = this.today;
        String month = this.month;
        String jArray = this.jArray;
        try{
        	Log.i(t,"jArray "+jArray);
        HttpParams httpParam = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParam, 15000);
        HttpConnectionParams.setSoTimeout(httpParam, 15000);
        DefaultHttpClient httpDefault = new DefaultHttpClient(httpParam);
        HttpPost post = new HttpPost(code.url+"/update.php?andrId="+code.deviceId+"&played="+played+"&today="+today+"&month="+month+"&gameType="+URLEncoder.encode(jArray));
        HttpResponse res = httpDefault.execute(post);
        //resMsg = Entity.(res.getEntity());

        try {
        	resMsg = EntityUtils.toString(res.getEntity());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.i("Parse Exception", e + "");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.i("IO Exception 2", e + "");

        }
        Log.i(t,"Response "+resMsg);
        return res.getStatusLine().getStatusCode();
        }
        catch(Exception e){
        	Log.i(t,"Error "+e);
        	return 400;
        }
        
	}



	public void execute(String played, String today, String month,
			String string, Context context, String status) {
		// TODO Auto-generated method stub
		 this.played = played;
	        this.today = today;
	        this.month = month;
	        this.jArray = string;
	        this.context = context;
	        this.status = status;
	        execute("");
	}


}
