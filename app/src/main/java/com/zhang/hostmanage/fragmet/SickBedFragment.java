package com.zhang.hostmanage.fragmet;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhang.hostmanage.R;
import com.zhang.hostmanage.adapter.MyAdapter;
import com.zhang.hostmanage.adapter.MyGridViewAdapter;
import com.zhang.hostmanage.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：Administrator on 2016/8/31 13:53
 * 描述：
 */
public class SickBedFragment extends Fragment {
    private GridView gridView;
    private MyGridViewAdapter adapter;
    private List<Map<String, Object>> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sickbed_layout, container, false);

        gridView = (GridView) view.findViewById(R.id.sickbed_grid);

        list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;

        map = new HashMap<String, Object>();
        map.put("text", 1 + "房");
        map.put("textname", "夔禺疆");
        //   map.put("Type",1);
        map.put("Type", Constants.NUMFIRST);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("text", 1 + "床");
        map.put("textname", "任平生");
        //  map.put("Type",2);
        map.put("Type", Constants.NUMSECONd);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("text", 2 + "床");
        map.put("textname", "墨倾池");
        // map.put("Type", 2);
        map.put("Type", 2);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("text", 4 + "床");
        map.put("textname", "玉梁皇");
        //  map.put("Type", 2);
        map.put("Type", 2);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("text", 5 + "床");
        map.put("textname", "红尘雪");

        //  map.put("Type", 2);
        map.put("Type", 2);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("text", 6 + "床");
        map.put("textname", "生命练习生");
        //  map.put("Type", 2);
        map.put("Type", 2);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("text", 7 + "床");
        map.put("textname", "剑非道");
        //  map.put("Type", 2);
        map.put("Type", 2);
        list.add(map);

        adapter = new MyGridViewAdapter(getActivity(), list);
        gridView.setAdapter(adapter);
        return view;
    }


}
