package com.example.android_9_guessdigital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static int Answer = 0;
    static int Count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randommake();
    }
    //個數字按鈕
    public void click1(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        mchose.setText("1");
    }
    public void click2(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        mchose.setText("2");
    }
    public void click3(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        mchose.setText("3");
    }
    public void click4(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        mchose.setText("4");
    }
    public void click5(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        mchose.setText("5");
    }
    public void click6(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        mchose.setText("6");
    }
    public void click7(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        mchose.setText("7");
    }
    public void click8(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        mchose.setText("8");
    }
    public void click9(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        mchose.setText("9");
    }
    //確認數字
    public void check(View v) {
        final TextView mchose = findViewById(R.id.TV_chose);
        //確認有數字
        if (Integer.parseInt(mchose.getText().toString())!=0){
            Count++;
            Intent intent = new Intent(this, guess_digital_show.class);
            Bundle bundle = new Bundle();
            //判斷大小
            if(Integer.parseInt(mchose.getText().toString())==Answer){
                bundle.putString("anstempor","0");
            }else if(Integer.parseInt(mchose.getText().toString())<Answer){
                bundle.putString("anstempor","1");
            }else if(Integer.parseInt(mchose.getText().toString())>Answer){
                bundle.putString("anstempor","2");
            }
            //傳值
            bundle.putString("ans", String.valueOf(Answer));
            bundle.putString("count",String.valueOf(Count));
            intent.putExtras(bundle);
            startActivity(intent);
        }else{
            showToast("請選擇一個數字");
        }
    }
    //重新開始
    public void restart(View v) {
        Answer = (int)(Math.random()*9)+1;
        Count = 0;
        showToast("已重新計算");
    }
    //生產亂數
    private void randommake(){
        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null) {
            String lastans = bundle.getString("lastans");
            Answer = Integer.parseInt(lastans);
            String lastcount = bundle.getString("lastcount");
            Count = Integer.parseInt(lastcount);
        }else{
            Answer = (int)(Math.random()*9)+1;
            Count = 1;
        }
    }
    //提示
    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}