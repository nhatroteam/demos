package com.example.noname.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Noname on 2/3/2016.
 */
public class SubActivity1 extends Activity {

    public final String Tag_SubActivity1 = "DML_SUB1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(Tag_SubActivity1, Tag_SubActivity1 + " onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onPause() {
        Log.d(Tag_SubActivity1, Tag_SubActivity1 + " onPause()");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(Tag_SubActivity1, Tag_SubActivity1 + " onDestroy()");
        super.onDestroy();
    }
}
