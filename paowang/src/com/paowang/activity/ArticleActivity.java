package com.paowang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.paowang.R;
import com.paowang.view.MixtureTextView;

/**
 * Created by huangminzheng on 16/4/13.
 */
public class ArticleActivity extends Activity implements View.OnClickListener {
    MixtureTextView mixtureTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        mixtureTextView = (MixtureTextView) findViewById(R.id.id_mixtureTextview);
        findViewById(R.id.tv_size_add).setOnClickListener(this);
        findViewById(R.id.tv_size_del).setOnClickListener(this);
        findViewById(R.id.tv_toggleText).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_size_add:
                mixtureTextView.setTextSize(mixtureTextView.getTextSize() + 2);
                break;
            case R.id.tv_size_del:
                mixtureTextView.setTextSize(mixtureTextView.getTextSize() - 2);
                break;
            case R.id.tv_toggleText:
                String text = mixtureTextView.getText();
                if (text.equals(getString(R.string.text1))) {
                    mixtureTextView.setText(getString(R.string.text2));
                } else {
                    mixtureTextView.setText(getString(R.string.text1));
                }
                break;
            default:
                break;
        }
    }

}
