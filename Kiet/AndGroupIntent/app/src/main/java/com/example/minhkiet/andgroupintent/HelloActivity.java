package com.example.minhkiet.andgroupintent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Minh Kiet on 3/22/2016.
 */
public class HelloActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_hello, tv_message;
    Button btn_BinhPhuong, btn_nhanDoi;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_activity);

        tv_hello = (TextView) findViewById(R.id.tv_hello);
        tv_message = (TextView) findViewById(R.id.tv_message);

        btn_BinhPhuong = (Button) findViewById(R.id.btn_binhPhuong);
        btn_BinhPhuong.setOnClickListener(this);
        btn_nhanDoi = (Button) findViewById(R.id.btn_gapDoi);
        btn_nhanDoi.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");

        if (name != null)
            tv_hello.setText("Chào " + name + "!");

        // nhan du lieu number
        number = bundle.getInt("number");

        // thong bao nhan du lieu
        tv_message.setText("Dữ liệu số nhận được là: " + number);

    }

    @Override
    public void onClick(View v) {
        if (v == btn_BinhPhuong) {
            int binhPhuong = number * number;
            sendToMain(binhPhuong, 101);
        }

        if (v == btn_nhanDoi) {
            int nhanDoi = number * 2;
            sendToMain(nhanDoi, 102);
        }
    }

    private void sendToMain(int result, int resultCode) {
        Bundle bundle = new Bundle();
        bundle.putInt("result", result);

        getIntent().putExtras(bundle);
        setResult(resultCode, getIntent());
        finish();
    }
}
