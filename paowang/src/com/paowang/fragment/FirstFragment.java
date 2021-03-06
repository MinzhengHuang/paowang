package com.paowang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.paowang.GridPasswordViewActivity;
import com.paowang.MaterialPatternLockViewActivity;
import com.paowang.R;
import com.paowang.TubatuViewPagerActivity;

public class FirstFragment extends Fragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        view.findViewById(R.id.btn_TubatuViewPager).setOnClickListener(this);
        view.findViewById(R.id.btn_MaterialPatternLockView).setOnClickListener(this);
        view.findViewById(R.id.btn_GridPasswordView).setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_TubatuViewPager:
                intent = new Intent(getActivity(), TubatuViewPagerActivity.class);
                break;
            case R.id.btn_MaterialPatternLockView:
                intent=new Intent(getActivity(), MaterialPatternLockViewActivity.class);
                break;
            case R.id.btn_GridPasswordView:
                intent=new Intent(getActivity(), GridPasswordViewActivity.class);
                break;

            default:
                break;
        }
        startActivity(intent);
    }
}
