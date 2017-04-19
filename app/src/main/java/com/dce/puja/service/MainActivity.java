package com.dce.puja.service;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    Boundservice myService;
    boolean isBound = false;



        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        }
    @Override
    protected void onStart() {
        super.onStart();
// Bind to LocalService
        Intent intent = new Intent(this,MainActivity.class);
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
// Unbind from the service
        if (isBound) {
            unbindService(myConnection);
            isBound = false;
        }
    }

    public void showTime(View view)
    {
        if(isBound){
            String currentTime = myService.getCurrentTime();
            TextView myTextView = (TextView)findViewById(R.id.myTextView);
            myTextView.setText(currentTime);
        }
    }

    private ServiceConnection myConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            Boundservice.MyLocalBinder binder = (Boundservice.MyLocalBinder) service;
            myService = binder.getService();
            isBound = true;
        }
        public void onServiceDisconnected(ComponentName arg0) {
            isBound = false;
        }

    };
}