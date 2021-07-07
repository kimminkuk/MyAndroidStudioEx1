package com.techcom.myparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                ArrayList<String> names = new ArrayList<String>();
                names.add("미미미");
                names.add("황수여ㅑㄴ");
                intent.putExtra("names",names);

                //parceble로 만든 객체는 intent.putextra로 넘겨 줄 수 있다.
                SimpleData data = new SimpleData(100, "Hello!");
                intent.putExtra("data", data);

                startActivityForResult(intent, 101);
            }
        });

    }
}