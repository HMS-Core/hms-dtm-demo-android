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

import android.app.Application
import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustConfig
import com.adjust.sdk.LogLevel
import com.adjust.sdk.oaid.AdjustOaid

class AdjustApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // application token (get from adjust)
        val appToken = "your token"
        // test environment: SANDBOX, product environment: PRODUCTION
        val environment = AdjustConfig.ENVIRONMENT_SANDBOX
        // initial AdjustConfig
        val config = AdjustConfig(applicationContext, appToken, environment)
        // set log level
        config.setLogLevel(LogLevel.VERBOSE)
        // get OAID
        AdjustOaid.readOaid()
        // initial Adjust
        Adjust.onCreate(config)
    }
}