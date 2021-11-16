package com.example.direct_call;

import android.content.Context;
import android.widget.Toast;

class ShowCountToastThread implements Runnable {

	private Context mContext = null;
	private int mCount;

	public ShowCountToastThread(Context context, int count) {
		mContext = context;
		mCount = count;
	}

	@Override
	public void run() {
		String text = String.valueOf(mCount);
		Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
	}
}
