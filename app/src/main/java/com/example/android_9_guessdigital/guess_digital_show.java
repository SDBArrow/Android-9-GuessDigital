package com.example.android_9_guessdigital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class guess_digital_show extends AppCompatActivity {
    static String ans = "";
    static int anstempor = 0;
    static String count = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_digital_show);
        TV_show();
    }
    private void TV_show(){
        final TextView mans = findViewById(R.id.TV_ans);
        final TextView mprompt = findViewById(R.id.TV_prompt);
        final TextView mcount = findViewById(R.id.TV_count);
        final Button mback = findViewById(R.id.btn_back);
        anstempor = 0;
        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null) {
            anstempor = Integer.parseInt(bundle.getString("anstempor"));
        }
        if(anstempor == 0){
            mans.setText("O");
            mprompt.setText("答對了");
            mcount.setText("總共花了"+count+"次");
            mback.setText("重新開始");
        }else if(anstempor == 1){
            mans.setText("X");
            mprompt.setText("太小了");
        }else if(anstempor == 2){
            mans.setText("X");
            mprompt.setText("太大了");
        }
        ans = bundle.getString("ans");
        count = bundle.getString("count");
    }
    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        if(anstempor != 0){
            Bundle bundle = new Bundle();
            bundle.putString("lastans",ans);
            bundle.putString("lastcount",count);
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}