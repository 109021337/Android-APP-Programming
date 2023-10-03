package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    private Spinner spn1, spn2, spn3, spn4;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.textView8);
        spn1=findViewById(R.id.spinner);
        spn2=findViewById(R.id.spinner6);
        spn3=findViewById(R.id.spinner7);
        spn4=findViewById(R.id.spinner8);
        btn=findViewById(R.id.button);

        btn.setOnClickListener(btnListener);

    }
    private View.OnClickListener btnListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String str = txt.getText().toString();
            str+=spn1.getSelectedItem().toString()+"到"+spn2.getSelectedItem().toString()+"、"+spn3.getSelectedItem().toString()+spn4.getSelectedItem().toString()+"張"+"\n";
            txt.setText(str);
        }
    };
}