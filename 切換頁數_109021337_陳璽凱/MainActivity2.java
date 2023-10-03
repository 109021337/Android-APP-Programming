package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txt1;
    Button btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt1 = findViewById(R.id.textView2);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn2.setOnClickListener(btnListener);
        btn3.setOnClickListener(btnListener);
    }
    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.button2)
            {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, MainActivity3.class);
                startActivity(intent);

            }
            else if(view.getId()==R.id.button3)
            {
                finish();
            }
        }
    };
}