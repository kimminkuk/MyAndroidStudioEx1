package com.techcom.mylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate() Call", Toast.LENGTH_LONG).show();
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //현재 화면 닫기
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart() Call", Toast.LENGTH_LONG).show();
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        //hash table과 같다.
        editor.putString("name", "잇지...굿");

        //이때 저장된다.
        editor.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop() Call", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy() Call", Toast.LENGTH_LONG).show();
    }

    //중지 될 때, 바로 동작
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause() Call", Toast.LENGTH_LONG).show();


        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        //hash table과 같다.
        editor.putString("name", "오마이걸");

        //이때 저장된다.
        editor.commit();
    }

    //다시 화면 Call
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume() Call", Toast.LENGTH_LONG).show();

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if (pref != null) {
            String name = pref.getString("name", ""); //name이 비어있으면 공백으로 리턴
            Toast.makeText(this, "복구된 이름: " + name, Toast.LENGTH_LONG).show();
        }
    }
}