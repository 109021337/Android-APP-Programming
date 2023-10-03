package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button[] btn;
    int[] btnId = {R.id.button, R.id.button2, R.id.button3, R.id.button4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = new Button[4];
        for(int i=0;i<4;i++)
        {
            btn[i] = findViewById(btnId[i]);
            btn[i].setOnClickListener(Listener);
        }
    }
    private View.OnClickListener Listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId()==btnId[0])
            {
                Uri uri = Uri.parse("mailto:xxxx@asia.edu.tw");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.putExtra(Intent.EXTRA_CC, new String[]{"yyyy@asia.edu.tw"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "信件主旨");
                intent.putExtra(Intent.EXTRA_TEXT, "信件內容");
                startActivity(intent);
            }
            else if(view.getId()==btnId[1])
            {
                Uri uri = Uri.parse("sms:0912345678?body=簡訊內容");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
            else if(view.getId()==btnId[2])
            {
                Uri uri = Uri.parse("geo:24.0465369,120.6842323");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
            else if(view.getId()==btnId[3])
            {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "亞洲大學");
                startActivity(intent);
            }
        }
    };
}