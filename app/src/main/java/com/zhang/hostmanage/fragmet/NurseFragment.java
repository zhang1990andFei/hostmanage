package com.zhang.hostmanage.fragmet;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.GridView;

import com.zhang.hostmanage.MainActivity;
import com.zhang.hostmanage.R;
import com.zhang.hostmanage.adapter.MyAdapter;
import com.zhang.hostmanage.adapter.NurseAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 作者：Administrator on 2016/8/31 13:53
 * 描述：
 */
public class NurseFragment extends Fragment {
    private GridView mGridView;
    private List<String> mDatas = new ArrayList<String>(Arrays.asList("护师",
            "护师", "科主任", "主任医生", "副主任医师", "实习医生", "科主任", "主管护师"));
    private NurseAdapter mAdapter;
    private View layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nurse_fragment, container, false);
        mGridView = (GridView) view.findViewById(R.id.nurseview_gridview);
        mAdapter = new NurseAdapter(getActivity(), mDatas);
        mGridView.setAdapter(mAdapter);
        return view;

    }


}
