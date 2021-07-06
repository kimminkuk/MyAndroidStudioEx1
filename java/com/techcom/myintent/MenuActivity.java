package com.techcom.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //메인->메뉴 데이터를 넘긴다.
                Intent intent = new Intent();
                intent.putExtra("name","mike");

                setResult(Activity.RESULT_OK, intent);

                finish(); //메뉴 화면 없앤다. ( 지금 액티비티 메뉴 화면, 메인화면은 뒤에 깔려있다., 스택 개념으로 밑에 쌓여있음)
            }
        });
    }
}