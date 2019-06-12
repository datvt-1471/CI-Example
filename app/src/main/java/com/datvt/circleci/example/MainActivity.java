package com.datvt.circleci.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valueX, valueY;
    private TextView result;
    private Button btnSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                if (TextUtils.isDigitsOnly(valueX.getText()) && TextUtils.isDigitsOnly(valueY.getText()))
                {
                    Toast.makeText(MainActivity.this, "Tinh Tong", Toast.LENGTH_SHORT).show();
                    sum();
                }
            }
        });
    }

    private void initView() {
        valueX = (EditText) findViewById(R.id.edt_x);
        valueY = (EditText) findViewById(R.id.edt_y);
        result = (TextView) findViewById(R.id.tv_sum);
        btnSum = (Button) findViewById(R.id.btn_ok);
    }

    private void sum() {
        int val1 = Integer.parseInt(valueX.getText().toString());
        int val2 = Integer.parseInt(valueY.getText().toString());
        int answer = val1 + val2;
        result.setText(answer + "");
    }
}
