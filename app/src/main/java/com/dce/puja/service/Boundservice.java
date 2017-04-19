package com.dce.puja.service;

import android.app.Activity;
import android.app.Service;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.os.IBinder;
import android.content.Context;
import android.content.Intent;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.widget.TextView;

/**
 * Created by Devendra on 4/19/2017.
 */

public class Boundservice extends Service{

    private final IBinder myBinder = new MyLocalBinder();

    @Override
    public IBinder onBind(Intent arg0) {
// TODO Auto-generated method stub
        return myBinder;
    }

    public String getCurrentTime() {
        SimpleDateFormat dateformat =
                new SimpleDateFormat("HH:mm:ss MM/dd/yyyy",Locale.US);
        return (dateformat.format(new Date()));
    }

    public class MyLocalBinder extends Binder {
        Boundservice getService() {
            return Boundservice.this;
        }
    }
}






