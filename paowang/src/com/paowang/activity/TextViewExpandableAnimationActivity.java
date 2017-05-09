package com.paowang.activity;

import android.app.Activity;
import android.os.Bundle;

import com.paowang.R;
import com.paowang.view.TextViewExpandableAnimation;

public class TextViewExpandableAnimationActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview_expandable_animation);
        String text = getString(R.string.tips);

        TextViewExpandableAnimation tvExpand = (TextViewExpandableAnimation) findViewById(R.id.tv_expand);
        tvExpand.setText(text + text + text + text);

    }
}
