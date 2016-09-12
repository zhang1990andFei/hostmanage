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
    private List<String> mDatas = new ArrayList<String>(Arrays.asList("素还真",
            "倦收天", "温皇", "任飘渺", "黑白郎君", "100", "100", "100"));
    private NurseAdapter mAdapter;
private View layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nurse_fragment, container, false);
        mGridView = (GridView) view.findViewById(R.id.nurseview_gridview);
        mGridView.setAdapter(mAdapter = new NurseAdapter(getActivity(), mDatas));
        layout =view.findViewById(R.id.right_layout);
        Animation translateAnimation=new TranslateAnimation(0, 100, 0, 0);

        translateAnimation.setDuration(3000);//设置动画持续时间为3秒

        translateAnimation.setInterpolator(getActivity(), android.R.anim.cycle_interpolator);//设置动画插入器

        translateAnimation.setFillAfter(true);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）

        layout.startAnimation(translateAnimation);
        return view;

    }



}
