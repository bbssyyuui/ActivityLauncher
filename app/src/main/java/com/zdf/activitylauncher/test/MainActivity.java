package com.zdf.activitylauncher.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.zdf.activitylauncher.ActivityLauncher;

public class MainActivity extends AppCompatActivity {

    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        findViewById(R.id.btn_launcher).setOnClickListener(view -> {
            ActivityLauncher.init(this)
                    .startActivityForResult(TestActivity.class, (resultCode, data) -> {
                        Log.v("zdf", "TestActivity|onActivityResult: " + resultCode + ", " + data.toUri(0));

                        tvInfo.setText("resultCode: " + resultCode);
                        tvInfo.append("\n");
                        tvInfo.append("data: " + data.toUri(0));
                    });
        });

        findViewById(R.id.btn_launcher_intent).setOnClickListener(view -> {
            Intent intent = new Intent(this, TestActivity.class);
            intent.setAction("ACTION_TEST");
            intent.putExtra("key1", "lala");
            intent.putExtra("key2", 2);
            ActivityLauncher.init(this)
                    .startActivityForResult(intent, (resultCode, data) -> {
                        Log.v("zdf", "TestActivity|onActivityResult: " + resultCode + ", " + data.toUri(0));

                        tvInfo.setText("resultCode: " + resultCode);
                        tvInfo.append("\n");
                        tvInfo.append("data: " + data.toUri(0));
                    });
        });

        tvInfo = findViewById(R.id.tv_info);
    }
}
