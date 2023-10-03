package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    List<Map<String, Object>> items;
    SimpleAdapter adapter;
    private GridView gridView;
    private int[] image = {
            R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6
    };
    int[] now = {0, 1, 2, 3, 4, 5};
    private String[] imgText = {"三合一礠怪", "大舌貝", "暴鯉龍", "夢幻", "三地鼠", "可達鴨"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < image.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("image", image[i]);
            item.put("text", imgText[i]);
            items.add(item);
        }
        adapter = new SimpleAdapter(this,
                items, R.layout.grid_item, new String[]{"image", "text"},
                new int[]{R.id.image, R.id.text});
        gridView = findViewById(R.id.GridView);
        gridView.setNumColumns(3);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(gvListener);
    }
    private  AdapterView.OnItemClickListener gvListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            now[i]++;
            if(now[i]>=image.length)
                now[i] = 0;
            items.get(i).put("text",imgText[now[i]]);
            items.get(i).put("image",image[now[i]]);
            adapter.notifyDataSetChanged();
        }
    };
}