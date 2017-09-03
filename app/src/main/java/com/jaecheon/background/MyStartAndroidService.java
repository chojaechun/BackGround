package com.jaecheon.background;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyStartAndroidService extends Service {
    MediaPlayer mp;

    public MyStartAndroidService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("test", "서비스의 onCreate");
        mp = MediaPlayer.create(this, R.raw.kalimba); // 노래 제목
        mp.setLooping(false); // 반복재생

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 서비스가 호출될 때마다 실행
        Log.d("test", "서비스의 onStartCommand");
        mp.start(); // 노래 시작

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
        Log.d("test", "서비스의 onDestroy");

    }
}
