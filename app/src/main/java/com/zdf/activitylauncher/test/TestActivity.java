package com.zdf.activitylauncher.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Log.v("zdf", "TestActivity|getIntent(): " + getIntent().toUri(0));
    }

    @Override
    public void finish() {
        setResult();
        super.finish();
    }

    private void setResult() {
        Intent intent = new Intent();
        intent.putExtra("key1", "hehe");
        intent.putExtra("key2", 2);
        setResult(11, intent);
    }
}
