package com.example.ooosu.actionbartab;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

/**
 * Created by oOosu on 3/21/2016.
 */
public class AboutActivity extends AppCompatActivity {

    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        //lấy action bar
        actionBar = getSupportActionBar();
        // hiển thị nút Up ở Home icon
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            toggleActionBar();
        }
        return true;
    }

    private void toggleActionBar() {
        if (actionBar != null) {
            if (actionBar.isShowing()) {
                actionBar.hide();
            } else {
                actionBar.show();
            }
        }
    }
}
