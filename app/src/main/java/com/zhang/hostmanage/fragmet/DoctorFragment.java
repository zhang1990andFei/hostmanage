package com.zhang.hostmanage.fragmet;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.zhang.hostmanage.R;

/**
 * 作者：Administrator on 2016/8/31 13:53
 * 描述：
 */
public class DoctorFragment extends Fragment {
    private SlidingMenu mLeftMenu;
    private SlidingMenu mRightMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nurse_fragment, container, false);
        // configure the SlidingMenu
        mLeftMenu = (SlidingMenu) view.findViewById(R.id.slidingmenulayout);
//        mRightMenu = (SlidingMenu) view.findViewById(R.id._slid_slidingmenulayout);
//        mRightMenu.setMode(SlidingMenu.RIGHT);
//        mRightMenu.setMenu(R.layout.bedcard_item);
        // configure the SlidingMenu
        // SlidingMenu menu = new SlidingMenu(this);
        mLeftMenu.setMode(SlidingMenu.RIGHT);
        // 设置触摸屏幕的模式
        //mLeftMenu.setShadowWidthRes(R.dimen.shadow_width);
        //mLeftMenu.setShadowDrawable(R.drawable.shadow);

        mLeftMenu.setMenu(R.layout.docotorgrid_item);

        mLeftMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (mLeftMenu.isMenuShowing())
//                    mLeftMenu.toggle();
            }
        });
        // 设置滑动菜单视图的宽度
        // 设置渐入渐出效果的值
        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        return view;
    }
}
