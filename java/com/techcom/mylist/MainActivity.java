package com.techcom.mylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SingerAdapter adapter;
    EditText editText1;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText)findViewById(R.id.editTextTextPersonName);
        editText2 = (EditText)findViewById(R.id.editTextTextPersonName2);

        ListView listView = (ListView)findViewById(R.id.listview);

        //어댑터 설정
        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("우주소녀", "010-1000-1000", R.drawable.ic_12));
        adapter.addItem(new SingerItem("잇지", "010-2000-1000", R.drawable.ic_15));
        adapter.addItem(new SingerItem("스테이시", "010-3000-1000", R.drawable.ic_19));
        adapter.addItem(new SingerItem("오마이걸", "010-4000-1000", R.drawable.ic_appimage));
        adapter.addItem(new SingerItem("마마무", "010-5000-1000", R.drawable.ic_gundo));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택: " + item.getName(), Toast.LENGTH_LONG).show();

            }
        });

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();
                String mobile = editText2.getText().toString();
                adapter.addItem(new SingerItem(name,mobile,R.drawable.ic_19));
                adapter.notifyDataSetChanged();
            }
        });
    }

    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SingerItemView view = null;
            if( convertView == null ) {
                view = new SingerItemView(getApplicationContext()); //어떤 뷰던 안드로이드컨텍스트로 받음
            } else {
                view = (SingerItemView)convertView;
            }
            SingerItem item = items.get(position);
            view.SetName(item.getName());
            view.SetMobile(item.getMobile());
            view.SetImage(item.getResId());
            return view;
        }
    }


}