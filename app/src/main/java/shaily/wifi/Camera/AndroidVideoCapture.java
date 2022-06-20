package shaily.wifi.Camera;

import java.io.IOException;

import com.cricket.cricgame.R;

import shaily.wifi.Camera.DeviceDetailFragment.FileServerAsyncTask;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AndroidVideoCapture extends Activity implements
ConnectionInfoListener {
	private Camera mCamera;
	private CameraPreview mPreview;
	private MediaRecorder mediaRecorder;
	private Button capture, switchCamera;
	private Context myContext;
	private LinearLayout cameraPreview;
	private boolean cameraFront = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera_recoding);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		myContext = this;
	//	recording = getIntent().getExtras().getBoolean(DeviceDetailFragment.FolderName);
		initialize();
		
		
	}

	private int findFrontFacingCamera() {
		int cameraId = -1;
		// Search for the front facing camera
		int numberOfCameras = Camera.getNumberOfCameras();
		for (int i = 0; i < numberOfCameras; i++) {
			CameraInfo info = new CameraInfo();
			Camera.getCameraInfo(i, info);
			if (info.facing == CameraInfo.CAMERA_FACING_FRONT) {
				cameraId = i;
				cameraFront = true;
				break;
			}
		}
		return cameraId;
	}

	private int findBackFacingCamera() {
		int cameraId = -1;
		// Search for the back facing camera
		// get the number of cameras
		int numberOfCameras = Camera.getNumberOfCameras();
		// for every camera check
		for (int i = 0; i < numberOfCameras; i++) {
			CameraInfo info = new CameraInfo();
			Camera.getCameraInfo(i, info);
			if (info.facing == CameraInfo.CAMERA_FACING_BACK) {
				cameraId = i;
				cameraFront = false;
				break;
			}
		}
		return cameraId;
	}

	public void onResume() {
		super.onResume();
		if (!hasCamera(myContext)) {
			Toast toast = Toast.makeText(myContext, "Sorry, your phone does not have a camera!", Toast.LENGTH_LONG);
			toast.show();
			finish();
		}
		if (mCamera == null) {
			// if the front facing camera does not exist
			if (findFrontFacingCamera() < 0) {
				Toast.makeText(this, "No front facing camera found.", Toast.LENGTH_LONG).show();
				switchCamera.setVisibility(View.GONE);
			}
			mCamera = Camera.open(findBackFacingCamera());
			mPreview.refreshCamera(mCamera);
		}
	}

	public void initialize() {
		cameraPreview = (LinearLayout) findViewById(R.id.camera_preview);

		mPreview = new CameraPreview(myContext, mCamera);
		cameraPreview.addView(mPreview);

		
			// work on UiThread for better performance
		/*	runOnUiThread(new Runnable() {
				public void run() {
					// If there are stories, add them to the table

					try {
						mediaRecorder.start();
					} catch (final Exception ex) {
						// Log.i("---","Exception in thread");
					}
				}
			});*/
		
			final Handler startHandler = new Handler();
			startHandler.postDelayed(new Runnable() {
			  @Override
			  public void run() {
			    //Do something after 100ms
				  try {
							if (!prepareMediaRecorder()) {
								Toast.makeText(AndroidVideoCapture.this, "Fail in prepareMediaRecorder()!\n - Ended -", Toast.LENGTH_LONG).show();
								finish();
							}
							else{
								Toast.makeText(AndroidVideoCapture.this, "Success in prepareMediaRecorder()!\n - Started -", Toast.LENGTH_LONG).show();
								mediaRecorder.start();
							}
						
					} catch (final Exception ex) {
						// Log.i("---","Exception in thread");
						Toast.makeText(AndroidVideoCapture.this, "Error occured falied to capture", Toast.LENGTH_LONG).show();

					}

			  }
			}, 5000);
			
			final Handler stopHandler = new Handler();
			stopHandler.postDelayed(new Runnable() {
			  @Override
			  public void run() {
					// stop recording and release camera
					mediaRecorder.stop(); // stop the recording
					releaseMediaRecorder(); // release the MediaRecorder object
					Toast.makeText(AndroidVideoCapture.this, "Video captured!", Toast.LENGTH_LONG).show();
	                 DeviceDetailFragment.sendFile =  true;
					finish();
			  }
			  }, 10000);
		 }
		
	

	

	public void chooseCamera() {
		// if the camera preview is the front
		if (cameraFront) {
			int cameraId = findBackFacingCamera();
			if (cameraId >= 0) {
				// open the backFacingCamera
				// set a picture callback
				// refresh the preview

				mCamera = Camera.open(cameraId);
				// mPicture = getPictureCallback();
				mPreview.refreshCamera(mCamera);
			}
		} else {
			int cameraId = findFrontFacingCamera();
			if (cameraId >= 0) {
				// open the backFacingCamera
				// set a picture callback
				// refresh the preview

				mCamera = Camera.open(cameraId);
				// mPicture = getPictureCallback();
				mPreview.refreshCamera(mCamera);
			}
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		// when on Pause, release camera in order to be used from other
		// applications
		releaseCamera();
	}

	private boolean hasCamera(Context context) {
		// check if the device has camera
		if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
			return true;
		} else {
			return false;
		}
	}

	

	private void releaseMediaRecorder() {
		if (mediaRecorder != null) {
			mediaRecorder.reset(); // clear recorder configuration
			mediaRecorder.release(); // release the recorder object
			mediaRecorder = null;
			mCamera.lock(); // lock camera for later use
		}
	}

	private boolean prepareMediaRecorder() {

		mediaRecorder = new MediaRecorder();

		mCamera.unlock();
		mediaRecorder.setCamera(mCamera);

		mediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
		mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);

		mediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_720P));

		mediaRecorder.setOutputFile("/sdcard/WiFiDirectDemo/myvideo.mp4");
		mediaRecorder.setMaxDuration(600000); // Set max duration 60 sec.
		mediaRecorder.setMaxFileSize(50000000); // Set max file size 50M

		try {
			mediaRecorder.prepare();
		} catch (IllegalStateException e) {
			releaseMediaRecorder();
			return false;
		} catch (IOException e) {
			releaseMediaRecorder();
			return false;
		}
		return true;

	}

	private void releaseCamera() {
		// stop and release camera
		if (mCamera != null) {
			mCamera.release();
			mCamera = null;
		}
	}

	@Override
	public void onConnectionInfoAvailable(WifiP2pInfo info) {
		// TODO Auto-generated method stub
		FileServerAsyncTask FileServerobj = new FileServerAsyncTask(
				this, FileTransferService.PORT);
		if (FileServerobj != null) {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
				FileServerobj.executeOnExecutor(
						AsyncTask.THREAD_POOL_EXECUTOR,
						new String[] { null });
				// FileServerobj.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,Void);
			} else
				FileServerobj.execute();
		}
	}
}