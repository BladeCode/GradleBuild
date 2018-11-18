/*
 * Copyright (C) 2018 Jerry xu Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.incoder.gradledeploy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.incoder.gradledeploy.BuildConfig;
import com.incoder.gradledeploy.R;

/**
 * MainActivity
 *
 * @author Jerry xu
 * @date 11/19/2018 12:38 AM.
 */
public class MainActivity extends AppCompatActivity {

    private static final String API_URL = BuildConfig.API_URL;
    private static final boolean IS_DEBUG = BuildConfig.DEBUG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        TextView isDebug = findViewById(R.id.tv_debug);
        textView.setText(API_URL);
        if (IS_DEBUG) {
            isDebug.setText("这是测试版本，开启调试日志");
        } else {
            isDebug.setText("这是正式版本，关闭调试日志");
        }
    }
}
