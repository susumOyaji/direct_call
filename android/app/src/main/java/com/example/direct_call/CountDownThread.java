package com.example.direct_call;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

public class CountDownThread extends Thread {
	
	public static final int MAX_COUNT = 10;
	
	private Context mContext = null;
	private Handler mHandler = null;

	public CountDownThread(Context context) {
		mContext = context;
		mHandler = new Handler();
	}

	@Override
	public void run() {
		try {
			for (int count = MAX_COUNT; count >= 0; count--) {
				mHandler.post(new ShowCountToastThread(mContext, count));
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// ServiceをIntentで停止する
		Intent intent = new Intent(mContext, CountDownService.class);
		mContext.stopService(intent);
	}

}
