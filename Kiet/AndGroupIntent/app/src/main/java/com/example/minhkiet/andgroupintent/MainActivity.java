package com.example.minhkiet.andgroupintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_go, btn_google, btn_execute;
    EditText edt_name, edt_number;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_go = (Button) findViewById(R.id.btn_go);
        btn_go.setOnClickListener(this);

        btn_google = (Button) findViewById(R.id.btn_google);
        btn_google.setOnClickListener(this);

        btn_execute = (Button) findViewById(R.id.btn_execute);
        btn_execute.setOnClickListener(this);

        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_number = (EditText) findViewById(R.id.edt_number);

        tv_result = (TextView) findViewById(R.id.tv_result);

    }

    @Override
    public void onClick(View v) {
        if (v == btn_go) {
            String name = edt_name.getText().toString();

            Bundle bundle = new Bundle();
            bundle.putString("name", name);

            Intent intent = new Intent(this, HelloActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }

        if (v == btn_google) {
            String url = "http://google.com";
            Uri uri = Uri.parse(url);

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        }

        if (v == btn_execute) {
            String number = edt_number.getText().toString();

            // gói dữ liệu cần gửi
            Bundle bundle = new Bundle();
            bundle.putInt("number", Integer.parseInt(number));

            // khoi tao intent truyen du lieu, dùng phương thức startActivityForResult
            // để nhận kết quả trả về
            Intent intent = new Intent(this, HelloActivity.class);
            intent.putExtras(bundle);
            startActivityForResult(intent, 100);

            Intent intent2 = new Intent(this, Main2Activity.class);
            startActivityForResult(intent2, 110);

        }
    }

    // xu ly khi co ket qua tra ve khi goi startActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            // lay ket qua tra ve
            Bundle bundle = data.getExtras();
            int result = bundle.getInt("result");

            // kiem tra resultCode la binh phuong hay gap doi
            if (resultCode == 101) {
                tv_result.setText("Bình phương là: " + result);
            }

            if (resultCode == 102) {
                tv_result.setText("Nhân đôi là: " + result);
            }
        }
    }
}
