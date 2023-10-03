package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txt1,txt2;
    ConstraintLayout L;
    int TextSize = 34;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.TextView);
        txt2 = findViewById(R.id.TextView2);
        registerForContextMenu(txt1);
        registerForContextMenu(txt2);
        L = findViewById(R.id.L);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==txt1)
        {
            menu.add(0,1,1,"黑色背景");
            menu.add(0,2,2,"紅色背景");
        }
        else if(v==txt2)
        {
            menu.add(0,3,1,"較小字體");
            menu.add(0,4,2,"較大字體");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==1)
            L.setBackgroundColor(Color.BLACK);
        else if(item.getItemId()==2)
            L.setBackgroundColor(Color.RED);
        else if(item.getItemId()==3)
            TextSize-=3;
        else
            TextSize+=3;
        txt1.setTextSize(TextSize);
        txt2.setTextSize(TextSize);
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_about)
            Toast.makeText(MainActivity.this, "這是範例", Toast.LENGTH_LONG).show();
        else if(item.getItemId()==R.id.menu_quit)
            finishAndRemoveTask();
        return super.onOptionsItemSelected(item);
    }
}