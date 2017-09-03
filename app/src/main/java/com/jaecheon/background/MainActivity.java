package com.jaecheon.background;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play = (Button) findViewById(R.id.btn_play);

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 서비스 시작하기
                Log.d("test", "Activity Start");
                Intent intent = new Intent(
                        getApplicationContext(),// 현재 이 Activity 내에서 보여줘야 합니다. : getApplicationContext();
                        com.jaecheon.background.MyStartAndroidService.class); // 현재 이 Activity 에서 동작한 정보(onClick, input text)를 원하는 자바 클래스로 보내주는 역할.
                startService(intent); // 서비스 시작
            }
        });

        Button stop = (Button) findViewById(R.id.btn_stop);


        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 서비스 종료하기
                Log.d("test", "Activity End");
                Intent intent = new Intent(
                        getApplicationContext(),//현재제어권자
                        com.jaecheon.background.MyStartAndroidService.class); // 이동할 컴포넌트
                stopService(intent); // 서비스 종료
            }
        });
    }

}
