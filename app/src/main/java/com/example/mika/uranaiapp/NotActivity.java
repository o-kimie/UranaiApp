package com.example.mika.uranaiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NotActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not);

        Button back = (Button) findViewById(R.id.not_btn_back);

        // イベントを取得するためのリスナーを設定
        // this:このクラス自身(MainActivity
        back.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent3 = new Intent(this, MainActivity.class);


        startActivity(intent3);

    }
}
