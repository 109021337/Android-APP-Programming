package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView TP1, TP2, TP3;
    private Button BTN_START, BTN_FINISH;
    private TextView RESULT;
    private int[] img = {R.drawable.z1, R.drawable.z2, R.drawable.z3};
    Random a = new Random();//亂數
    int b, c, d;

    Handler handler= new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            //要做的事情

            b = a.nextInt(3);
            c = a.nextInt(3);
            d = a.nextInt(3);

            TP1.setImageResource(img[b]);//放置隨機圖片
            TP2.setImageResource(img[c]);
            TP3.setImageResource(img[d]);

            handler.postDelayed(this, 20);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show();

        BTN_START.setOnClickListener(new View.OnClickListener() { //開始按鈕監聽事件
            @Override
            public void onClick(View view) {

                handler.postDelayed(runnable, 20);//定時器啟動

            }
        });

        BTN_FINISH.setOnClickListener(new View.OnClickListener() { //結束按鈕監聽事件
            @Override
            public void onClick(View view) {

                handler.removeCallbacks(runnable);//定時器結束

                if (img[b] == img[c] && img[b] == img[d] && img[c] == img[d] ) {
                    if(img[b]==img[0]){
                        RESULT.setText("太厲害了，今日的您運氣爆棚，不要猶豫直接來個十連抽吧！");}
                    else if(img[b]==img[1]){
                        RESULT.setText("您今日的運氣還算不錯，若是寶石有餘裕，可以丟一些試試水溫");
                    }else if(img[b]==img[2]){
                        RESULT.setText("您今日的運氣較差，不妨多做些善事並擇日再抽");
                    }
                } else
                if (img[b] == img[c]) {
                    if(img[b]==img[0]){
                        RESULT.setText("恭喜您,您今日的運氣不錯，可以考慮來個十連抽喔");
                    }
                    if(img[b]==img[1]){
                        RESULT.setText("您今日的運氣普通，抽卡不宜過度");
                    }
                    if(img[b]==img[2]){
                        RESULT.setText("您今日的運氣極差，建議留在家中，若非必要就不要出門");
                    }

                }
                else
                if (img[b] == img[d]) {
                    if (img[b] == img[0]) {
                        RESULT.setText("恭喜您,您今日的運氣不錯，可以考慮來個十連抽喔");
                    }
                    if (img[b] == img[1]) {
                        RESULT.setText("您今日的運氣普通，抽卡不宜過度");
                    }
                    if (img[b] == img[2]) {
                        RESULT.setText("您今日的運氣極差，建議留在家中，若非必要就不要出門");
                    }

                }
                else
                if (img[c] == img[d]) {
                    if (img[c] == img[0]) {
                        RESULT.setText("恭喜您,您今日的運氣不錯，可以考慮來個十連抽喔");
                    }
                    if (img[c] == img[1]) {
                        RESULT.setText("您今日的運氣普通，抽卡不宜過度");
                    }
                    if (img[c] == img[2]) {
                        RESULT.setText("您今日的運氣極差，建議留在家中，若非必要就不要出門");
                    }

                }

                else {
                    RESULT.setText("手氣也太差了吧！投幣再來一次吧。");
                }


            }
        });

    }

    private void show() {
        TP1 = findViewById(R.id.tp1);
        TP2 = findViewById(R.id.tp2);
        TP3 = findViewById(R.id.tp3);

        BTN_START = findViewById(R.id.btn_start);
        BTN_FINISH = findViewById(R.id.btn_finish);

        RESULT = findViewById(R.id.result);

    }
}