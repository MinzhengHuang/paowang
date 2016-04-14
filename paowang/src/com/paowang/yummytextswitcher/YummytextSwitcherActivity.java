package com.paowang.yummytextswitcher;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import com.paowang.R;

public class YummytextSwitcherActivity extends Activity {

    YummyTextSwitcher yummyTextSwitcher;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yummytextswitcher);
        yummyTextSwitcher= (YummyTextSwitcher) findViewById(R.id.yummyTextSwitcher);
        yummyTextSwitcher.setTypeface(Typeface.createFromAsset(getAssets(), "HelveticaNeueLTPro.otf"));

        yummyTextSwitcher.setFrameInterpolator(new NumberFrameEvaluator(1,3023));
    }

    public void startAnim(View view ){
        yummyTextSwitcher.startAnim();
    }

    public void showDialog(View view ){
        NumberAnimDialog.showDialog(this);
    }
    
}
