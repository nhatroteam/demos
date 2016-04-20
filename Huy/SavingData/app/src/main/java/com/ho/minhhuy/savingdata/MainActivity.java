package com.ho.minhhuy.savingdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ImageView imageView;
    private ArrayList<Person> alPersons;
    MyAdapter adapter;
    EditText edName, edAge;
    Button btRead, btWrite,btKT;


    public MainActivity() {
//        alPersons = FileManager.readDataBNT();
        alPersons=new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        edAge = (EditText) findViewById(R.id.sdt);
        edName = (EditText) findViewById(R.id.name);
        btRead = (Button) findViewById(R.id.btXoa);
        btWrite = (Button) findViewById(R.id.btWrite);
        btKT=(Button) findViewById(R.id.btXoa);
        setAdapter();
        btRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FileManager(MainActivity.this).readDataBNT();
            }
        });
       
        btWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edName.getText().toString();
                String age=edAge.getText().toString();
            Person p=new Person(age,name);
       new FileManager(MainActivity.this).writeDataBNT(p);
             //  new FileManager(MainActivity.this).doWork();
        setAdapter();

            }
        });
        btKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FileManager(MainActivity.this).doWork();

            }
        });

    }

    public void setAdapter() {
        alPersons= new FileManager(MainActivity.this).readDataBNT();
        adapter = new MyAdapter(this, R.layout.activity_item, alPersons);
        listView.removeAllViewsInLayout();
        listView.setAdapter(adapter);

    }

}
