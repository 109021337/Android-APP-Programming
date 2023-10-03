package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int[] imgId={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,
            R.drawable.pic4,R.drawable.pic5,R.drawable.pic6};
    private ImageView imgV;
    int p = 0;
    int count = imgId.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("第1/6張");
        imgV=findViewById(R.id.imageView);
        imgV.setOnClickListener(imgVListener);
    }
    private View.OnClickListener imgVListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            p++;
            if(p>=count)
                p=0;
            imgV.setImageResource(imgId[p]);
            setTitle("第"+(p+1)+"/"+count+"張");
        }
    };
}