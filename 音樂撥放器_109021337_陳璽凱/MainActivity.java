package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4,btn5,btn6;
    private TextView txt;
    private ListView LV;
    private MediaPlayer mediaPlayer;
    private int nowMUSIC=0;
    private boolean flagPause=false;
    int[] SongList={R.raw.music1,R.raw.music2,R.raw.music3,R.raw.music4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.button); //Previous
        btn2=findViewById(R.id.button2);//Next
        btn3=findViewById(R.id.button3);//Stop
        btn4=findViewById(R.id.button4);//Pause
        btn5=findViewById(R.id.button5);//Play
        btn6=findViewById(R.id.button6);//End
        txt=findViewById(R.id.textView2);
        LV=findViewById(R.id.LV);
        btn1.setOnClickListener(Listener);
        btn2.setOnClickListener(Listener);
        btn3.setOnClickListener(Listener);
        btn4.setOnClickListener(Listener);
        btn5.setOnClickListener(Listener);
        btn6.setOnClickListener(Listener);
        LV.setOnItemClickListener(LVListener);
    }
    private ListView.OnItemClickListener LVListener=new ListView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if(mediaPlayer!=null)
                mediaPlayer.reset();
            nowMUSIC=i;
            PlaySong(nowMUSIC);
        }
    };
    private Button.OnClickListener Listener=new Button.OnClickListener()
    {
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.button)
            {
                if(mediaPlayer!=null)
                    mediaPlayer.reset();
                nowMUSIC--;
                if(nowMUSIC<0)
                    nowMUSIC=LV.getCount()-1;
                PlaySong(nowMUSIC);
            }
            else if(view.getId()==R.id.button2)
            {
                if(mediaPlayer!=null)
                    mediaPlayer.reset();
                nowMUSIC++;
                if(nowMUSIC>=LV.getCount())
                    nowMUSIC=0;
                PlaySong(nowMUSIC);
            }
            else if(view.getId()==R.id.button3)
            {
                if(mediaPlayer!=null)
                    mediaPlayer.stop();
            }
            else if(view.getId()==R.id.button4)
            {
                if(mediaPlayer!=null) {
                    mediaPlayer.pause();
                    flagPause = true;
                }
            }
            else if(view.getId()==R.id.button5)
            {
                if(flagPause)
                {
                    mediaPlayer.start();
                    flagPause=false;
                }
                else
                    PlaySong(nowMUSIC);
            }
            else if(view.getId()==R.id.button6)
            {
                if(mediaPlayer!=null) {
                    mediaPlayer.release();
                    finish();
                }
            }
        }
    };
    private void PlaySong(int n)
    {
        mediaPlayer=MediaPlayer.create(this,SongList[n]);
        mediaPlayer.start();
        txt.setText("music"+(n+1));
        mediaPlayer.setOnCompletionListener(NEXT);
        flagPause=false;
    }
    private MediaPlayer.OnCompletionListener NEXT=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            nowMUSIC++;
            if(nowMUSIC>=LV.getCount())
                nowMUSIC=0;
            PlaySong(nowMUSIC);
        }
    };
}
