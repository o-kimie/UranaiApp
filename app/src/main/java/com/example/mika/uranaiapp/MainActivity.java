package com.example.mika.uranaiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



//activity画面という意味
//メイン画面の制御を行うためのクラス
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //入力された名前に対するキー名（定数）final二度と書き換えられない定数
    public static final String INPUT_NAME = "InputName";
    //占い結果の計算値に対応するキー名を書く。
    public static final String RESULT_NUMBER = "ResultNumber";

    public static final String RESULT_ITEM_NUMBER = "ResultItemNumber";

    @Override//上書き

    protected void onCreate(Bundle savedInstanceState) {
        // 継承元クラス（AppCompactActivity）onCreateメソッドを呼び出す
        super.onCreate(savedInstanceState);
        //activity_main.xmlを読みこんでいる。→画面が表示
        setContentView(R.layout.activity_main);
        // ログ ・・・履歴、情報を残す
        // system.out.Printnlみたいなもの
        Log.d("LifeCycle","onCreate");

        // レイアウト(activity_main.xml)より、「占う」ボタン(IDがmain_btn_divine)を取得
        Button divineBtn = (Button) findViewById(R.id.main_btn_divine);

        //占うボタンにリスナーを設定
        divineBtn.setOnClickListener(this);

        // レイアウト(activity_main.xml)より、「占う」ボタン(IDがmain_btn_divine)を取得
        Button not = (Button) findViewById(R.id.main_btn_not);

        //占うボタンにリスナーを設定
        not.setOnClickListener(this);


    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","onDestroy");
    }

    //押されたView（テキスト、ボタンなど）の情報
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_btn_not:
                Intent intent = new Intent(this,NotActivity.class);

                startActivity(intent);
                break;
            case R.id.main_btn_divine:
                //占うボタンが押されたときの処理を書く
                //インテントクラスのオブジェクトを作成
                //thisは遷移元、ResultActivity.class遷移先のクラス
                Intent intent2 = new Intent(this,ResultActivity.class);


                // レイアウト(activity_main.xml)より、「占う」ボタン(IDがmain_btn_divine)を取得
                EditText etx = (EditText) findViewById(R.id.main_etx_name);

                //入力されている名前を文字列（string）として取得
                //toString()を使うとEditableからStringへ変換。
                String inputName = etx.getText().toString();
                inputName += "さんの運勢は・・・";

                //intent・・・遷移先に渡すデータをセット
                //1、取り出すときに指定するキー
                //2,実際のデータ
                intent2.putExtra(INPUT_NAME,inputName);

                //0-9までのランダムな値を生成する。
                int resultNumber = new java.util.Random().nextInt(10);
                intent2.putExtra(RESULT_NUMBER,resultNumber);

                int resultItemNumber = new java.util.Random().nextInt(10);
                intent2.putExtra(RESULT_ITEM_NUMBER,resultItemNumber);





                //画面遷移開始
                startActivity(intent2);
                break;
        }

    }
}
