package com.example.assignment.musicserviceactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MusicServiceActivity extends ActionBarActivity implements OnClickListener {
    private static final String TAG = "MusicService";
    Button start, stop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.start:
                Log.d(TAG, "onClick() start ");
                startService(new Intent(this, MusicService.class));
                break;
            case R.id.stop:
                Log.d(TAG, "onClick() stop");
                stopService(new Intent(this, MusicService.class));
                break;
        }
    }
}