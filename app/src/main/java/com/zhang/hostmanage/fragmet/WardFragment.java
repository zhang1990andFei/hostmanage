package com.zhang.hostmanage.fragmet;


import android.animation.ValueAnimator;
import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
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
    private Boolean right_show = false;
    private Boolean detail_show;
    private TextView animation_text;

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
        animation_text = (TextView) view.findViewById(R.id.animation_text);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.detail_show:
                float curTranslationX = warddetail_layout.getTranslationX();
                ObjectAnimator animator = ObjectAnimator.ofFloat(warddetail_layout, "translationX", curTranslationX, 0f);
                ObjectAnimator animator_grid = ObjectAnimator.ofFloat(mGridView, "translationX", curTranslationX, 0f);
                animator.setDuration(1000);
                animator_grid.setDuration(1000);
                AnimatorSet animSet = new AnimatorSet();
                animSet.setDuration(1000);
                animSet.setInterpolator(new LinearInterpolator());
                //两个动画同时执行
                animSet.playTogether(animator, animator_grid);
                // animSet.play();
                animSet.start();
                right_show = false;
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (right_show) {

        } else {
//            //  warddetail_layout.setVisibility(View.VISIBLE);
//            Animation translateAnimation = new TranslateAnimation(0, -200, 0, 0);
//            Animation translationmleft = new TranslateAnimation(0, -200, 0, 0);
//            translationmleft.setDuration(1000);
//            translateAnimation.setDuration(1000);//设置动画持续时间为3秒
//            //  translateAnimation.setInterpolator(getActivity(), android.R.anim.cycle_interpolator);//设置动画插入器
//            translateAnimation.setFillAfter(true);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
//            translationmleft.setFillAfter(true);
//            warddetail_layout.startAnimation(translateAnimation);
//            mGridView.startAnimation(translationmleft);
//            ValueAnimator animator = ValueAnimator.ofFloat(200, 200);
//            animator.setTarget(warddetail_layout);
//            animator.setDuration(5000);
//            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                @Override
//                public void onAnimationUpdate(ValueAnimator animation) {
//                    warddetail_layout.setTranslationY((Float) animation.getAnimatedValue());
//                }
//            });
//            animator.start();
//            ObjectAnimator anim1 = ObjectAnimator.ofFloat(warddetail_layout, "scaleX",
//                    2.0f, 2.0f);
////            ObjectAnimator anim2 = ObjectAnimator.ofFloat(mBlueBall, "scaleY",
////                    1.0f, 2f);
//            AnimatorSet animSet = new AnimatorSet();
//            animSet.setDuration(2000);
//            animSet.setInterpolator(new LinearInterpolator());
//            //两个动画同时执行
//            //    animSet.playTogether(anim1, anim2);
//            animSet.play(anim1);
//            animSet.start();
            //设置自定义的TypeEvaluator，起始属性，终止属性
//            ValueAnimator valueAnimator = ValueAnimator.ofObject(new MyTypeEvaluator(), new Point(0, 0), new Point(0, 0));
//            //设置持续时间
//            valueAnimator.setDuration(2000);

            //开启动画
            //          valueAnimator.start();
//            warddetail_layout.getLeft();
//            warddetail_layout.getX();
//            warddetail_layout.getTranslationX();
//            ObjectAnimator oa= ObjectAnimator.ofFloat(warddetail_layout,"translationX", 200);
//            oa.setDuration(2000);
//          //  oa.start();
//            AnimatorSet animSet = new AnimatorSet();
//            animSet.setDuration(2000);
//            animSet.setInterpolator(new LinearInterpolator());
//            //两个动画同时执行
//            //    animSet.playTogether(anim1, anim2);
//            animSet.play(oa);
//            animSet.start();
//            //设置持续时间
//            valueAnimator.setDuration(2000);
//            ObjectAnimator anim = ObjectAnimator//
//                    .ofFloat(warddetail_layout, "zhy", 1.0F, 0.2F)//
//                    .setDuration(500);//
//            anim.start();
//
//            anim.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {
//                @Override
//                public void onAnimationUpdate(com.nineoldandroids.animation.ValueAnimator valueAnimator) {
//                    float cVal = (Float) valueAnimator.getAnimatedValue();
//                    warddetail_layout.setAlpha(cVal);
//                    warddetail_layout.setScaleX(cVal);
//                    warddetail_layout.setScaleY(cVal);
//                }
//            });
//        }
//            ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
//            anim.setDuration(300);
//            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                @Override
//                public void onAnimationUpdate(ValueAnimator animation) {
//                    float currentValue = (float) animation.getAnimatedValue();
//                    Log.e("anmimation", "cuurent value is " + currentValue);
//                }
//            });
            float curTranslationX = warddetail_layout.getTranslationX();
            ObjectAnimator animator = ObjectAnimator.ofFloat(warddetail_layout, "translationX", curTranslationX, -200f);
            ObjectAnimator animator_grid = ObjectAnimator.ofFloat(mGridView, "translationX", curTranslationX, -200f);
            animator.setDuration(1000);
            animator_grid.setDuration(1000);
            AnimatorSet animSet = new AnimatorSet();
            animSet.setDuration(1000);
            animSet.setInterpolator(new LinearInterpolator());
            //两个动画同时执行
            animSet.playTogether(animator, animator_grid);
            // animSet.play();
            animSet.start();
            // animator.start();
            //   anim.start();
            right_show = true;
        }

    }
}
