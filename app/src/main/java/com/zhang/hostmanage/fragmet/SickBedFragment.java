package com.zhang.hostmanage.fragmet;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhang.hostmanage.R;
import com.zhang.hostmanage.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 作者：Administrator on 2016/8/31 13:53
 * 描述：
 */
public class SickBedFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sickbedfragment_view, container, false);

        return view;
    }


}
