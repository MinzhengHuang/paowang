package com.paowang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.paowang.R;
import com.paowang.data.GossipItem;
import com.paowang.view.GossipView;
import com.paowang.view.RippleView;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2014/1115/1986.html
 *
 * GossipView：圆圈布局的自定义view
 */
public class GossipViewActivity extends Activity {

    private RippleView mRippleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gossipview);

        GossipView gossipView = (GossipView) findViewById(R.id.gossipview);
        mRippleView=(RippleView) findViewById(R.id.rippleview);
        mRippleView.stratRipple();

        String[] strs = {"安卓", "微软", "苹果", "谷歌", "百度", "腾讯"};

        final List<GossipItem> items = new ArrayList<GossipItem>();
        for (int i = 0; i < strs.length; i++) {
            GossipItem item = new GossipItem(strs[i], 3);
            items.add(item);
        }
        gossipView.setItems(items);
        gossipView.setNumber(3);
        gossipView.setOnPieceClickListener(new GossipView.OnPieceClickListener() {
            @Override
            public void onPieceClick(int index) {
                if (index != -1 && index != -2) {
                    Toast.makeText(GossipViewActivity.this, "你选择了" + items.get(index).getTitle(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        mRippleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GossipViewActivity.this, "haha", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
