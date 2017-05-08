package com.paowang.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.paowang.R;
import com.paowang.tubatu.ClipViewPager;
import com.paowang.tubatu.RecyclingPagerAdapter;
import com.paowang.tubatu.ScalePageTransformer;

import java.util.ArrayList;
import java.util.List;

public class TubatuViewPagerActivity extends Activity {

    private ClipViewPager mViewPager;
    private TubatuAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tubatu_viewpager);

        mViewPager = (ClipViewPager) findViewById(R.id.viewpager);
        mViewPager.setPageTransformer(true, new ScalePageTransformer());

        findViewById(R.id.page_container).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mViewPager.dispatchTouchEvent(event);
            }
        });

        mPagerAdapter = new TubatuAdapter(this);
        mViewPager.setAdapter(mPagerAdapter);

        initData();
    }

    private void initData() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(R.drawable.style_xiandai);
        list.add(R.drawable.style_jianyue);
        list.add(R.drawable.style_oushi);
        list.add(R.drawable.style_zhongshi);
        list.add(R.drawable.style_meishi);
        list.add(R.drawable.style_dzh);
        list.add(R.drawable.style_dny);
        list.add(R.drawable.style_rishi);

        //设置OffscreenPageLimit
        mViewPager.setOffscreenPageLimit(list.size());//限定预加载的页面个数
        mPagerAdapter.addAll(list);
    }

    public static class TubatuAdapter extends RecyclingPagerAdapter {

        private final List<Integer> mList;
        private final Context mContext;

        public TubatuAdapter(Context context) {
            mList = new ArrayList<Integer>();
            mContext = context;
        }

        public void addAll(List<Integer> list) {
            mList.addAll(list);
            notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            ImageView imageView = null;
            if (convertView == null) {
                imageView = new ImageView(mContext);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setTag(position);
            imageView.setImageResource(mList.get(position));
            return imageView;
        }

        @Override
        public int getCount() {
            return mList.size();
        }
    }


}
