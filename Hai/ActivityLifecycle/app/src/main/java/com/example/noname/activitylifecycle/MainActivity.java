package com.example.noname.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    public final String Tag_MainActivity = "DML_MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(Tag_MainActivity, Tag_MainActivity + " onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // btn sub 1
        Button btnSubActivity1 = (Button) findViewById(R.id.btnShowSubActivity1);
        btnSubActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "SubActivity1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SubActivity1.class);
                startActivity(intent);
            }
        });

        // btn sub 2
        Button btnSubActivity2 = (Button) findViewById(R.id.btnShowSubActivity2);
        btnSubActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "SubActivity2", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SubActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d(Tag_MainActivity, Tag_MainActivity + " onStart()");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d(Tag_MainActivity, Tag_MainActivity + " onRestart()");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d(Tag_MainActivity, Tag_MainActivity + " onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(Tag_MainActivity, Tag_MainActivity + " onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(Tag_MainActivity, Tag_MainActivity + " onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(Tag_MainActivity, Tag_MainActivity + " onDestroy()");
        super.onDestroy();
    }
}
