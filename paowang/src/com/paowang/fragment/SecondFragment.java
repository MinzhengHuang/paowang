package com.paowang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.paowang.R;
import com.paowang.activity.WaveViewActivity;
import com.paowang.indexrecyclerview.IndexRecyclerViewActivity;

public class SecondFragment extends Fragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        view.findViewById(R.id.btn_IndexRecyclerView).setOnClickListener(this);
        view.findViewById(R.id.btn_WaveView).setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_IndexRecyclerView:
                intent = new Intent(getActivity(), IndexRecyclerViewActivity.class);
            case R.id.btn_WaveView:
                intent = new Intent(getActivity(), WaveViewActivity.class);
            default:
                break;
        }
        startActivity(intent);
    }
}
