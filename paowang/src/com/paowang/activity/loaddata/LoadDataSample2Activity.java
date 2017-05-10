package com.paowang.activity.loaddata;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import com.paowang.R;
import com.paowang.view.loaddata.SwipeLoadDataLayout;

/**
 *
 * Description : 仿zhihu样式Activity  <br/>
 * author : WangGanxin <br/>
 * date : 2017/3/31 <br/>
 * email : mail@wangganxin.me <br/>
 */
public class LoadDataSample2Activity extends Activity {

    private SwipeLoadDataLayout swipeLoadDataLayout;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_load_data_sample2);

        swipeLoadDataLayout = (SwipeLoadDataLayout) findViewById(R.id.swipeLoadDataLayout);
        swipeLoadDataLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeLoadDataLayout.setOnReloadListener(new SwipeLoadDataLayout.OnReloadListener() {
            @Override
            public void onReload(View v, int status) {
                Toast.makeText(LoadDataSample2Activity.this,R.string.reload_text, Toast.LENGTH_SHORT).show();
            }
        });
        swipeLoadDataLayout.setStatus(SwipeLoadDataLayout.LOADING);
        initHandler();
    }

    private void initHandler() {
        if(mHandler==null){
            mHandler=new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    switch (msg.what) {
                        case 0:
                            swipeLoadDataLayout.setStatus(SwipeLoadDataLayout.EMPTY);
                            mHandler.sendEmptyMessageDelayed(1,2000);
                            break;
                        case 1:
                            swipeLoadDataLayout.setStatus(SwipeLoadDataLayout.ERROR);
                            mHandler.sendEmptyMessageDelayed(2,2000);
                            break;
                        case 2:
                            swipeLoadDataLayout.setStatus(SwipeLoadDataLayout.NO_NETWORK);
                            mHandler.sendEmptyMessageDelayed(3,2000);
                            break;
                        case 3:
                            swipeLoadDataLayout.setStatus(SwipeLoadDataLayout.SUCCESS);
                            break;
                    }
                }
            };

            mHandler.sendEmptyMessageDelayed(0,2000);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mHandler!=null){
            mHandler.removeCallbacksAndMessages(null);
            mHandler=null;
        }
    }
}
