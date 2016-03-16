package com.paowang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.paowang.R;
import com.paowang.data.GossipItem;
import com.paowang.view.GossipView;

import java.util.ArrayList;
import java.util.List;

public class GossipViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gossipview);
		GossipView gossipView = (GossipView)findViewById(R.id.gossipview);
		String[] strs = {"安卓","微软","苹果","谷歌","百度","腾讯"} ;
				 
		final List<GossipItem> items =new ArrayList<GossipItem>();
		for(int i = 0; i < strs.length; i++) { 
			GossipItem item = new GossipItem(strs[i],3);
			items.add(item);
		}
		gossipView.setItems(items);
		gossipView.setNumber(3);
		gossipView.setOnPieceClickListener( new GossipView.OnPieceClickListener(){
			@Override
			public void onPieceClick(int index) {
			  if(index != -1 &&  index != -2) {
				  Toast.makeText(GossipViewActivity.this, "你选择了" + items.get(index).getTitle(), Toast.LENGTH_SHORT).show();
			  }
		    }
		});
	}

}
