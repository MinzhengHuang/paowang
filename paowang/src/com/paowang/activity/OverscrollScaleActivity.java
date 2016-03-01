package com.paowang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.paowang.R;
import com.paowang.view.ListViewExt;

public class OverscrollScaleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overscrollscale);


        String[] strs = new String[30];
        for (int i = 0; i < 30; i++) {
            strs[i] = "title" + i;
        }
        ListViewExt lv = (ListViewExt) findViewById(R.id.view);
        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strs));
    }

}
