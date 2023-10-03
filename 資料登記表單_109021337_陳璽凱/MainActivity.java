package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private Button[] btn;
    private ListView LV;
    private EditText edt1,edt2,edt3;
    private SQLiteDatabase db=null;
    SimpleCursorAdapter adapter;
    int[] buttonList={R.id.button,R.id.button2,R.id.button3,R.id.button4,R.id.button5};
    int count=1;
    static final String[] COL=new String[]{"name","phone","address"};
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=new Button[5];
        for(int i=0;i<5;i++)
        {
            btn[i]=findViewById(buttonList[i]);
            btn[i].setOnClickListener(Listener);
        }
        edt1=findViewById(R.id.editText);
        edt2=findViewById(R.id.editText2);
        edt3=findViewById(R.id.editText3);
        LV=findViewById(R.id.LV);
        db=openOrCreateDatabase("db1.db",MODE_PRIVATE,null);
        db.execSQL("DROP TABLE IF EXISTS table01");
        String createTable="CREATE TABLE table01(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, address TEXT)";
        db.execSQL(createTable);
        cursor=db.rawQuery("SELECT * FROM table01",null);
        adapter=new SimpleCursorAdapter(this,R.layout.item,cursor,COL,new int[]{R.id.textView5,R.id.textView6,R.id.textView7},0);
        LV.setAdapter(adapter);
        LV.setOnItemClickListener(LVListener);
    }
    private Button.OnClickListener Listener=new Button.OnClickListener()
    {
        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.button)
            {
                String name=edt1.getText().toString();
                String phone=edt2.getText().toString();
                String address=edt3.getText().toString();
                addData(name,phone,address);
                UpdateAdapter();
            }
            else if(view.getId()==R.id.button2)
            {
                String name=edt1.getText().toString();
                String phone=edt2.getText().toString();
                String address=edt3.getText().toString();
                update(name,phone,address,cursor.getInt(0));
                UpdateAdapter();
                btn[1].setEnabled(false);
                btn[2].setEnabled(false);
                btn[3].setEnabled(false);
            }
            else if(view.getId()==R.id.button3)
            {
                db.delete("table01","_id="+cursor.getInt(0),null);
                //System.out.println(cursor.getInt(0));
                UpdateAdapter();
                btn[1].setEnabled(false);
                btn[2].setEnabled(false);
                btn[3].setEnabled(false);
            }
            else if(view.getId()==R.id.button4)
            {
                String str="tel:"+cursor.getString(cursor.getColumnIndex("phone"));
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse(str));
                startActivity(intent);
            }
            else if(view.getId()==R.id.button5)
                finish();
        }
    };
    public ListView.OnItemClickListener LVListener=new ListView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            cursor.moveToPosition(i);
            edt1.setText(cursor.getString(cursor.getColumnIndex("name")));
            edt2.setText(cursor.getString(cursor.getColumnIndex("phone")));
            edt3.setText(cursor.getString(cursor.getColumnIndex("address")));
            btn[1].setEnabled(true);
            btn[2].setEnabled(true);
            btn[3].setEnabled(true);
        }
    };
    @Override
    public void finish() {
        super.finish();
        db.execSQL("DROP TABLE table01");
        db.close();
    }
    public void addData(String name,String phone,String address)
    {
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("phone",phone);
        cv.put("address",address);
        db.insert("table01",null,cv);
    }
    public void update(String name,String phone,String address,int id)
    {
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("phone",phone);
        cv.put("address",address);
        db.update("table01",cv,"_id="+id,null);
    }
    public void UpdateAdapter()
    {
        cursor=db.rawQuery("SELECT * FROM table01",null);
        adapter.changeCursor(cursor);
    }
}