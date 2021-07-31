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
        // 应用识别码（您可以在 Adjust 控制面板上找到自己的应用识别码）
        String appToken = "your token";
        // 测试环境使用SANDBOX,开发环境使用PRODUCTION
        String environment = AdjustConfig.ENVIRONMENT_SANDBOX;
        // 初始化AdjustConfig
        AdjustConfig config = new AdjustConfig(getApplicationContext(), appToken, environment);
        // 设置日志级别
        config.setLogLevel(LogLevel.VERBOSE);
        // 读取OAID
        AdjustOaid.readOaid();
        // 初始化Adjust
        Adjust.onCreate(config);
        // 注册ActivityLifecycleCallbacks
        registerActivityLifecycleCallbacks(new AdjustLifecycleCallbacks());
    }
}
