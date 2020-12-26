package com.huawei.hmsdtmsample;

import android.app.Application;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.LogLevel;
import com.adjust.sdk.oaid.AdjustOaid;

public class AdjustApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        String appToken = "your token";
        String environment = AdjustConfig.ENVIRONMENT_SANDBOX;
        AdjustConfig config = new AdjustConfig(getApplicationContext(), appToken, environment);
        config.setLogLevel(LogLevel.VERBOSE);
        AdjustOaid.readOaid();

        Adjust.onCreate(config);
        registerActivityLifecycleCallbacks(new AdjustLifecycleCallbacks());

    }
}
