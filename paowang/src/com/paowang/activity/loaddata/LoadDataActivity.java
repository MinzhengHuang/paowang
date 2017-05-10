package com.paowang.activity.loaddata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.paowang.R;

/**
 *
 * Description : MainActivity  <br/>
 * author : WangGanxin <br/>
 * date : 2017/3/31 <br/>
 * email : mail@wangganxin.me <br/>
 */
public class LoadDataActivity extends Activity implements View.OnClickListener {

    private TextView normalBtn, zhihuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_load_data);

        normalBtn = (TextView) findViewById(R.id.normalBtn);
        zhihuBtn = (TextView) findViewById(R.id.zhihuBtn);

        normalBtn.setOnClickListener(this);
        zhihuBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.normalBtn:
                intent = new Intent(LoadDataActivity.this, LoadDataSample1Activity.class);
                break;
            case R.id.zhihuBtn:
                intent = new Intent(LoadDataActivity.this, LoadDataSample2Activity.class);
                break;
        }

        startActivity(intent);
    }
}
