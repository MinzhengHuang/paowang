package com.paowang.activity;

import android.app.Activity;
import android.os.Bundle;

import com.paowang.R;
import com.paowang.view.FlowViewVertical;

public class StepViewVerticalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_view_vertical);
        FlowViewVertical vFlow = (FlowViewVertical) findViewById(R.id.vflow);
        vFlow.setProgress(9, 10, getResources().getStringArray(R.array.vflow), null);
    }
}
