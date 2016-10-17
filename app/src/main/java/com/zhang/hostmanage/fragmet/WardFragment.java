package com.zhang.hostmanage.fragmet;


import android.animation.ValueAnimator;
import android.app.Fragment;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.zhang.hostmanage.R;
import com.zhang.hostmanage.adapter.MyAdapter;
import com.zhang.hostmanage.adapter.MySpinnerAdapter;

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
    private ImageView back;
    private ImageView hide;


    private ArrayList<String> spinner_list;
    private ImageView imgView;
    private TextView textView;
    private LinearLayout layout;
    private ListView listView;
    private MySpinnerAdapter spinner_adapter;
    private PopupWindow popupWindow;
    private LinearLayout spinnerlayout;
    int width;
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
        back = (ImageView) view.findViewById(R.id.back_bedcard);
        back.setOnClickListener(this);
        hide = (ImageView) view.findViewById(R.id.hide_all);
        hide.setOnClickListener(this);

        spinner_list = new ArrayList<String>();
        spinner_list.add("第一展厅");
        spinner_list.add("4展厅");
        spinner_list.add("第三展厅");
        spinner_adapter = new MySpinnerAdapter(getActivity(), spinner_list);
        textView = (TextView) view.findViewById(R.id.dropdown_text);
        textView.setText(spinner_list.get(0).toString());
        spinnerlayout = (LinearLayout) view.findViewById(R.id.spinnerid);
        // 点击右侧按钮，弹出下拉框
        imgView = (ImageView) view.findViewById(R.id.dropdown_imageview);
        imgView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (spinner_list.size() > 0) {
                    //spinnerlayout.setBackgroundResource(R.drawable.preference_first_item);
                }
                showWindow(spinnerlayout, textView);

            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.detail_show:
                float curTranslationX_detail = warddetail_layout.getTranslationX();
                ObjectAnimator animator_detail = ObjectAnimator.ofFloat(warddetail_layout, "translationX", curTranslationX_detail, -850f);
                ObjectAnimator animator_griddetial = ObjectAnimator.ofFloat(mGridView, "translationX", curTranslationX_detail, -850f);
                ObjectAnimator animator_patient = ObjectAnimator.ofFloat(detailshow_layout, "translationX", curTranslationX_detail, -850f);
                animator_detail.setDuration(500);
                animator_griddetial.setDuration(500);
                animator_patient.setDuration(500);
                AnimatorSet animSet_detail = new AnimatorSet();
                animSet_detail.setDuration(500);
                animSet_detail.setInterpolator(new LinearInterpolator());
                //两个动画同时执行
                animSet_detail.playTogether(animator_detail, animator_griddetial, animator_patient);
                // animSet.play();
                animSet_detail.start();
                showdetail_button.setVisibility(View.GONE);
                back.setVisibility(View.INVISIBLE);
                back.setClickable(false);
                break;
            case R.id.back_bedcard:
                float curTranslationX = warddetail_layout.getTranslationX();
                ObjectAnimator animator = ObjectAnimator.ofFloat(warddetail_layout, "translationX", curTranslationX, 0f);
                ObjectAnimator animator_grid = ObjectAnimator.ofFloat(mGridView, "translationX", curTranslationX, 0f);
                animator.setDuration(500);
                animator_grid.setDuration(500);
                AnimatorSet animSet = new AnimatorSet();
                animSet.setDuration(500);
                animSet.setInterpolator(new LinearInterpolator());
                //两个动画同时执行
                animSet.playTogether(animator, animator_grid);
                // animSet.play();
                animSet.start();
                right_show = false;
                break;
            case R.id.hide_all:
                float curTranslationXhide = warddetail_layout.getTranslationX();
                animator_detail = ObjectAnimator.ofFloat(warddetail_layout, "translationX", curTranslationXhide, 0f);
                animator_griddetial = ObjectAnimator.ofFloat(mGridView, "translationX", curTranslationXhide, 0f);
                animator_patient = ObjectAnimator.ofFloat(detailshow_layout, "translationX", curTranslationXhide, 0f);
                animator_detail.setDuration(500);
                animator_griddetial.setDuration(500);
                animator_patient.setDuration(500);
                AnimatorSet animSet_detailhide = new AnimatorSet();
                animSet_detailhide.setDuration(500);
                animSet_detailhide.setInterpolator(new LinearInterpolator());
                //两个动画同时执行
                animSet_detailhide.playTogether(animator_detail, animator_griddetial, animator_patient);
                // animSet.play();
                animSet_detailhide.start();
                showdetail_button.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
                back.setClickable(true);
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
            ObjectAnimator animator = ObjectAnimator.ofFloat(warddetail_layout, "translationX", curTranslationX, -550f);
            ObjectAnimator animator_grid = ObjectAnimator.ofFloat(mGridView, "translationX", curTranslationX, -550f);
            animator.setDuration(500);
            animator_grid.setDuration(500);
            AnimatorSet animSet = new AnimatorSet();
            animSet.setDuration(500);
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
/*
展示
 */
    public void showWindow(View position, final TextView txt) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.myspinner_dropdown, null);
        spinner_adapter = new MySpinnerAdapter(getActivity(), spinner_list);
        listView = (ListView) view.findViewById(R.id.dropdown_listView);
        listView.setAdapter(spinner_adapter);
        popupWindow = new PopupWindow(position);
        // 设置弹框的宽度为布局文件的宽
        popupWindow.setWidth(spinnerlayout.getWidth());
        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        // 设置一个透明的背景，不然无法实现点击弹框外，弹框消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        // 设置点击弹框外部，弹框消失
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setContentView(view);
        // 设置弹框出现的位置，在v的正下方横轴偏移textview的宽度，为了对齐~纵轴不偏移
        popupWindow.showAsDropDown(position,0,0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // TODO Auto-generated method stub
                //spinnerlayout.setBackgroundResource(R.drawable.preference_single_item);
            }

        });
        // listView的item点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                txt.setText(spinner_list.get(arg2));// 设置所选的item作为下拉框的标题
                // 弹框消失
                popupWindow.dismiss();
                popupWindow = null;
            }
        });

    }
}
