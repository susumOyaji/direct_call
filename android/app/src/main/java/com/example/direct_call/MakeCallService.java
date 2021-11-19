package com.example.direct_call;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import android.net.Uri;


import static android.Manifest.permission.CALL_PHONE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static android.telecom.TelecomManager.ACTION_CHANGE_DEFAULT_DIALER;
import static android.telecom.TelecomManager.EXTRA_CHANGE_DEFAULT_DIALER_PACKAGE_NAME;


public class MakeCallService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Toast.makeText(this, "Service has been started.", Toast.LENGTH_SHORT).show();
		CountDownThread thread = new CountDownThread(this);
		thread.start();
	}
	
	@Override
	public void onDestroy() {
		Toast.makeText(this, "Service has been terminated.", Toast.LENGTH_SHORT).show();
	}
	
}