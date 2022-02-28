package com.huawei.hmsdtmsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.analytics.HiAnalyticsTools;

public class MainActivity extends AppCompatActivity {
    HiAnalyticsInstance mInstance;
    Button mTestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get HiAnalyticsInstance instance
        mInstance = HiAnalytics.getInstance(this);
        HiAnalyticsTools.enableLog();

        mTestBtn = findViewById(R.id.testButton);
        mTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEvent();
            }
        });
    }

    private void sendEvent() {
        if (mInstance != null) {
            mInstance.onEvent("FirebaseTest",new Bundle());
        }
    }
}