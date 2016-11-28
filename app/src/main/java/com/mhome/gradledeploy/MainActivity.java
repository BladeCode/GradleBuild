package com.mhome.gradledeploy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String  API_URL = BuildConfig.API_URL;
    private boolean isDebug = BuildConfig.DEBUG;
    private TextView mTextView;
    private TextView mIsDebug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        mIsDebug = (TextView) findViewById(R.id.tv_debug);
        mTextView.setText(API_URL);
        if (isDebug) {
            mIsDebug.setText("这是测试版本，开启调试日志");
        } else {
            mIsDebug.setText("这是正式版本，关闭调试日志");
        }
    }
}
