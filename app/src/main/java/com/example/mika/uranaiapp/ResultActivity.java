package com.example.mika.uranaiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //レイアウト（activity_result.xml）より名前と結果のテキストビューを取得
        TextView txvName = (TextView) findViewById(R.id.result_txv_name);
        TextView txvDivine = (TextView) findViewById(R.id.result_txv_divine);
        TextView txvDivineItem = (TextView) findViewById(R.id.result_txv_item);

        //遷移元（MainActivity）から送られてきたインテントを取得
        Intent intent = getIntent();

        //// 遷移元でセットした氏名を取得し、TextViewに設定する
        String name = intent.getStringExtra(MainActivity.INPUT_NAME);
        txvName.setText(name);

        //遷移元でセットした結果番号を取得する
        //defaultValue:キーに対応するデータが見つからなかったときに返す値
        int resultNumber = intent.getIntExtra(MainActivity.RESULT_NUMBER,0);
        String[] divineDate = getResources().getStringArray(R.array.result_txv_divine_date);
        txvDivine.setText(divineDate[resultNumber]);


        int resultItemNumber = intent.getIntExtra(MainActivity.RESULT_ITEM_NUMBER, 0);
        String[] divineData = getResources().getStringArray(R.array.result_txv_divineItem_data);
        txvDivineItem.setText(divineData[resultItemNumber]);




        Button retry = (Button) findViewById(R.id.result_btn_retry);
        retry.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);




        startActivity(intent);
    }
}
