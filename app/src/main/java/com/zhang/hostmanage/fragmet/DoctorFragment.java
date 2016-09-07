package com.zhang.hostmanage.fragmet;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhang.hostmanage.R;

/**
 * 作者：Administrator on 2016/8/31 13:53
 * 描述：
 */
public class DoctorFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nurse_fragment, container, false);

        return view;
    }
}
