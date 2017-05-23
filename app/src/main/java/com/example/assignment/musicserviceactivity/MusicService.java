package com.example.assignment.musicserviceactivity;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by 608 on 2017-05-23.
 */

public class MusicService extends Service {
    private static final String TAG = "MusicService";
    MediaPlayer player;

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate()");

        player = MediaPlayer.create(this, R.raw.old_pop);
        player.setLooping(false); // Set looping
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Music Service가 중지되었습니다.“, Toast.LENGTH_LONG).show();
                Log.d(TAG, "onDestroy()");
        player.stop();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Music Service가 시작되었습니다.“, Toast.LENGTH_LONG).show();
                Log.d(TAG,"onStart()");
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }
}