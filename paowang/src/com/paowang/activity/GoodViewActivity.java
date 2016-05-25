package com.paowang.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.paowang.R;
import com.paowang.view.GoodView;

/**
 * Demo
 *
 * @author venshine
 */
public class GoodViewActivity extends Activity {

    GoodView mGoodView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodview);
        mGoodView = new GoodView(this);
    }

    public void good(View view) {
        ((ImageView) view).setImageResource(R.drawable.good_checked);
        mGoodView.setText("+1");
        mGoodView.show(view);
    }

    public void good2(View view) {
        ((ImageView) view).setImageResource(R.drawable.good_checked);
        mGoodView.setImage(getResources().getDrawable(R.drawable.good_checked));
        mGoodView.show(view);
    }

    public void collection(View view) {
        ((ImageView) view).setImageResource(R.drawable.collection_checked);
        mGoodView.setTextInfo("收藏成功", Color.parseColor("#f66467"), 12);
        mGoodView.show(view);
    }

    public void bookmark(View view) {
        ((ImageView) view).setImageResource(R.drawable.bookmark_checked);
        mGoodView.setTextInfo("收藏成功", Color.parseColor("#ff941A"), 12);
        mGoodView.show(view);
    }

    public void reset(View view) {
        ((ImageView) findViewById(R.id.good)).setImageResource(R.drawable.good);
        ((ImageView) findViewById(R.id.good2)).setImageResource(R.drawable.good);
        ((ImageView) findViewById(R.id.collection)).setImageResource(R.drawable.collection);
        ((ImageView) findViewById(R.id.bookmark)).setImageResource(R.drawable.bookmark);
        mGoodView.reset();
    }

}
