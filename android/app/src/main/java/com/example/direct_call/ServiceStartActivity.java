package com.example.direct_call;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import android.widget.TextView;
import android.net.Uri;

public class ServiceStartActivity extends Activity implements OnClickListener{
    private Button mStartServiceButton = null;
	String phonestate;
    TextView callinfo;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_start);
		mStartServiceButton = (Button)findViewById(R.id.service_start_button);
		mStartServiceButton.setOnClickListener(this);

		//リスナー設定
        //PhoneStateListener = Androidの通話状態が変わる度に通知してくれるイベント
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        telephonyManager.listen(mListener, PhoneStateListener.LISTEN_CALL_STATE);


	}


	PhoneStateListener mListener = new PhoneStateListener(){
        @Override
        public void onCallStateChanged(int state, String callNumber) {
            //Log.d(TAG, ":" + state+"-PhoneNumber:"+callNumber);
            switch(state){
                case TelephonyManager.CALL_STATE_IDLE:      //待ち受け（終了時）
                    Toast.makeText(ServiceStartActivity.this, "通話終了\nCALL_STATE_IDLE", Toast.LENGTH_LONG).show();
                     phonestate  = "INPUT to DIALING-Number";
                    break;
                case TelephonyManager.CALL_STATE_RINGING:   //着信*
                    if(callNumber==null){
                        callNumber="";
                    }
                    Toast.makeText(ServiceStartActivity.this, "着信中\nCALL_STATE_RINGING: " + callNumber, Toast.LENGTH_SHORT).show();
                    callinfo.setText("着信："+callNumber);
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:   //通話
                    Toast.makeText(ServiceStartActivity.this, "通話中\nCALL_STATE_OFFHOOK", Toast.LENGTH_SHORT).show();
                     phonestate  = "通話中\nCALL_STATE_OFFHOOK";
                    break;
            }
           
        }
    };

	
	@Override
	public void onClick(View v) {
		// ServiceをIntentで起動する
		Intent intent = new Intent(ServiceStartActivity.this, MakeCallService.class);
		startService(intent);
        
        //暗黙的インテント
        //Intent intent = new Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:0123456789"));
        //startActivity(intent);
	}
	
}