package com.paowang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paowang.R;
import com.paowang.activity.ToastyActivity;
import com.paowang.activity.loaddata.LoadDataActivity;

public class ThirdFragment extends Fragment implements View.OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_third, container, false);
		view.findViewById(R.id.btn_Toasty).setOnClickListener(this);
		view.findViewById(R.id.btn_LoadData).setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
			case R.id.btn_Toasty:
				intent = new Intent(getActivity(), ToastyActivity.class);
				break;
			case R.id.btn_LoadData:
				intent = new Intent(getActivity(), LoadDataActivity.class);
				break;
			default:
				break;
		}
		startActivity(intent);
	}
}
