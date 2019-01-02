package com.lyapinalex.android.medicineapp.core;

import android.app.Application;

import com.lyapinalex.android.medicineapp.net.INetManger;
import com.lyapinalex.android.medicineapp.net.NetManager;

public class App extends Application implements CoreApp {

    private INetManger mNetManger;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetManger = new NetManager();
    }

    @Override
    public INetManger getNetManager() {
        return mNetManger;
    }
}
