package com.zhang.hostmanage.fragmet;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
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
import com.zhang.hostmanage.adapter.PatientAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 作者：Administrator on 2016/10/18 15:44
 * 描述：
 */

public class PatientFragment extends Fragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    private GridView mGridView;
    private List<String> mDatas = new ArrayList<String>(Arrays.asList("素还真",
            "倦收天", "温皇", "任飘渺", "黑白郎君", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100", "100"));
    private PatientAdapter mAdapter;
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
        mGridView.setAdapter(mAdapter = new PatientAdapter(getActivity(), mDatas));
        mGridView.setOnItemClickListener(this);
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

        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

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
        // popupWindow.setBackgroundDrawable(new BitmapDrawable());
        // 设置点击弹框外部，弹框消失
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setContentView(view);
        // 设置弹框出现的位置，在v的正下方横轴偏移textview的宽度，为了对齐~纵轴不偏移
        popupWindow.showAsDropDown(position, 0, 0);
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
