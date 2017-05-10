package com.paowang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.paowang.R;
import com.paowang.view.NumberAnimTextView;


public class NumberAnimTextViewActivity extends Activity {

    private NumberAnimTextView mNumberAnimTextView;
    private NumberAnimTextView mNumberAnimTextView1;
    private NumberAnimTextView mNumberAnimTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_anim_textview);
        mNumberAnimTextView = (NumberAnimTextView) findViewById(R.id.text);
        mNumberAnimTextView1 = (NumberAnimTextView) findViewById(R.id.text1);
        mNumberAnimTextView2 = (NumberAnimTextView) findViewById(R.id.text2);
    }

    public void start(View view) {
        mNumberAnimTextView.setPrefixString("¥");
        mNumberAnimTextView.setNumberString("99998.123456789");

//        mNumberAnimTextView1.setEnableAnim(true);
        mNumberAnimTextView1.setNumberString("1234567");

        mNumberAnimTextView2.setPostfixString("%");
        mNumberAnimTextView2.setNumberString("99.75");

    }
}
