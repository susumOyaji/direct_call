package com.example.direct_call;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

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