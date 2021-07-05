package com.techcom.mylist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class SingerItemView extends LinearLayout {
    TextView textView;
    TextView textView2;
    ImageView imageView;

    public SingerItemView(Context context) {
        super(context);
        init(context);
    }

    public SingerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);

        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        imageView = (ImageView)findViewById(R.id.imageview);
    }

    public void SetName(String name) {
        textView.setText(name);
    }

    public void SetMobile(String mobile) {
        textView2.setText(mobile);
    }

    public  void SetImage(int resId) {
        imageView.setImageResource(resId);
    }
}
