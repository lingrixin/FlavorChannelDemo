package com.wuba.financial.demo.app;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_channel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_channel = findViewById(R.id.tv_channel);

        String channel = readChannel();
        if (!TextUtils.isEmpty(channel)) {
            tv_channel.setText("当前渠道为：" + channel);
        } else {
            Toast.makeText(MainActivity.this, "channel read error !", Toast.LENGTH_LONG).show();
        }
    }

    private String readChannel() {
        ApplicationInfo appInfo = null;
        try {
            appInfo = getApplication().getPackageManager().getApplicationInfo(
                    getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String msg = appInfo.metaData.getString("channel");
        return msg;
    }


}