package com.zhang.hostmanage.fragmet;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.zhang.hostmanage.R;
import com.zhang.hostmanage.adapter.DeviceGridViewAdapter;
import com.zhang.hostmanage.adapter.DeviceWardAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：Administrator on 2016/8/31 13:54
 * 描述：
 */
public class DeviceFragment extends Fragment {
    private GridView bed_gridview;
    private GridView ward_gridview;
    private List<String> mDatas = new ArrayList<String>(Arrays.asList("护师",
            "护师", "科主任", "主任医生", "副主任医师", "实习医生", "科主任", "主管护师"));
    private DeviceGridViewAdapter deviceGridViewAdapter;
    private DeviceWardAdapter deviceWardAdapter;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.device_fragment, container, false);
        bed_gridview = (GridView) view.findViewById(R.id.device_bedgrid);
        ward_gridview = (GridView) view.findViewById(R.id.device_wardgrid);
        deviceGridViewAdapter = new DeviceGridViewAdapter(getActivity(), mDatas);
        deviceWardAdapter = new DeviceWardAdapter(getActivity(),mDatas);
        bed_gridview.setAdapter(deviceGridViewAdapter);
        ward_gridview.setAdapter(deviceWardAdapter);
        return view;
    }


}
