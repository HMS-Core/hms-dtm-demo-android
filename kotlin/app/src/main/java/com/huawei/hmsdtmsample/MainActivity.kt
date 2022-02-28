/*
 * Copyright 2022. Huawei Technologies Co., Ltd. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.huawei.hmsdtmsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.huawei.hms.analytics.HiAnalytics
import com.huawei.hms.analytics.HiAnalyticsInstance
import com.huawei.hms.analytics.HiAnalyticsTools

class MainActivity : AppCompatActivity() {
    private lateinit var instance: HiAnalyticsInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get HiAnalyticsInstance instance
        instance = HiAnalytics.getInstance(this)
        HiAnalyticsTools.enableLog()

        val button: Button = findViewById(R.id.testButton)
        button.setOnClickListener { sendEvent() }
    }

    fun sendEvent() {
        // developers can report custom event
        // event name is "Purchase"
        val eventName = "Purchase"

        // three fields in Bundle
        val bundle = Bundle()
        bundle.putDouble("price", 999.0)
        bundle.putLong("quantity", 100L)
        bundle.putString("currency", "CNY")

        // report
        instance.onEvent(eventName, bundle)
        Log.d("DTM-Test", "log event.")
    }
}