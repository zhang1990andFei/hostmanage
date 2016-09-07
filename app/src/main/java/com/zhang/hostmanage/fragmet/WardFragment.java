package com.zhang.hostmanage.fragmet;


import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhang.hostmanage.R;
import com.zhang.hostmanage.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 作者：Administrator on 2016/8/31 13:52
 * 描述：
 */
public class WardFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    private GridView mGridView;
    private List<String> mDatas = new ArrayList<String>(Arrays.asList("素还真",
            "倦收天", "温皇", "任飘渺", "黑白郎君", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100"));
    private MyAdapter mAdapter;
    private RelativeLayout warddetail_layout;
    private RelativeLayout detailshow_layout;
    private TextView showdetail_button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wardfragment_view, container, false);
        mGridView = (GridView) view.findViewById(R.id.wardview_gridview);
        mGridView.setAdapter(mAdapter = new MyAdapter(getActivity(), mDatas));
        mGridView.setOnItemClickListener(this);
        warddetail_layout = (RelativeLayout) view.findViewById(R.id.warddetail_rlayout);
        detailshow_layout = (RelativeLayout) view.findViewById(R.id.detailshow_rlayout);
        showdetail_button = (TextView) view.findViewById(R.id.detail_show);
        showdetail_button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        detailshow_layout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        warddetail_layout.setVisibility(View.VISIBLE);
    }
}