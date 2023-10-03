package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView LV;
    private TextView txt, txt1;
    private Button btn;
    String[] fruits = new String[]{"香蕉", "西瓜", "梨子", "蘋果", "水蜜桃"};
    int[] m = {50, 20, 30, 40, 60};
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LV = findViewById(R.id.ListView);
        txt = findViewById(R.id.textView4);
        txt1 = findViewById(R.id.textView5);
        btn = findViewById(R.id.button);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                            (this, android.R.layout.simple_list_item_multiple_choice, fruits);
        LV.setAdapter(adapter);
        count = adapter.getCount();
        LV.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //LV.setSelection(R.drawable.green);
        LV.setTextFilterEnabled(true);
        btn.setOnClickListener(btnListener);
        //LV.setOnItemClickListener(LVListener);
    }
    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String str="";
            int total = 0;
            for(int i=0;i<count;i++) {
                if (LV.isItemChecked(i)) {
                    str += fruits[i] + " ";
                    total += m[i];
                }
            }
            txt.setText(str);
            txt1.setText(String.valueOf(total));
        }
    };
}