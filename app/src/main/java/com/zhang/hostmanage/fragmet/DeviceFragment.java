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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：Administrator on 2016/8/31 13:54
 * 描述：
 */
public class DeviceFragment extends Fragment {
    GridView lvnote;
    ArrayList<HashMap<String, String>> mynotelist = new ArrayList<HashMap<String, String>>();
    int colnum = 1;
private TextView anim_text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.device_fragment, container, false);
//        anim_text= (TextView) view.findViewById(R.id.anim_text);
//        Animation translateAnimation=new TranslateAnimation(0, -100, 0, 0);
//        translateAnimation.setDuration(1000);//设置动画持续时间为3秒
//      //  translateAnimation.setInterpolator(getActivity(), android.R.anim.cycle_interpolator);//设置动画插入器
//        translateAnimation.setFillAfter(true);//设置动画结束后保持当前的位置（即不返回到动画开始前的位置）
//        anim_text.startAnimation(translateAnimation);
//        lvnote = (GridView) view.findViewById(R.id.gridView1);
//        // The item width is about 200，项目宽度大概200像素
//        colnum = (int) (((getResources().getDisplayMetrics().widthPixels)) / 200);
//        lvnote.setNumColumns(colnum);
//
//        HashMap<String, String> mapitem1 = new HashMap<String, String>();
//        mapitem1.put("note", "Hello1...");
//        mapitem1.put("noteid", "1");
//        mynotelist.add(mapitem1);
//
//        HashMap<String, String> mapitem2 = new HashMap<String, String>();
//        mapitem2.put("note", "Hello2...");
//        mapitem2.put("noteid", "2");
//        mynotelist.add(mapitem2);
//
//        HashMap<String, String> mapitem3 = new HashMap<String, String>();
//        mapitem3.put("note", "Hello3...");
//        mapitem3.put("noteid", "3");
//        mynotelist.add(mapitem3);
//
//        HashMap<String, String> mapitem4 = new HashMap<String, String>();
//        mapitem4.put("note", "Hello4...");
//        mapitem4.put("noteid", "4");
//        mynotelist.add(mapitem4);
//
//        HashMap<String, String> mapitem5 = new HashMap<String, String>();
//        mapitem5.put("note", "Hello5...");
//        mapitem5.put("noteid", "5");
//        mynotelist.add(mapitem5);
//
//        HashMap<String, String> mapitem6 = new HashMap<String, String>();
//        mapitem6.put("note", "Hello6...");
//        mapitem6.put("noteid", "6");
//        mynotelist.add(mapitem6);
//
//        NoteAdapter adapter = new NoteAdapter(getActivity(), mynotelist, R.layout.note_item,
//                new String[]{"note"},
//                new int[]{R.id.tvNote});
//
//        lvnote.setAdapter(adapter);
        return view;
    }

    public class NoteAdapter extends SimpleAdapter {
        Context context = null;

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            // Inflate the note_item layout manually, and treat it as the item view
            // 重新填充note_item部局，并把它作为项的view返回
            convertView = LayoutInflater.from(context).inflate(R.layout.note_item, null);
            HashMap<String, String> theMap = (HashMap<String, String>) getItem(position);
            TextView txtNote = (TextView) convertView.findViewById(R.id.tvNote);
            txtNote.setText(theMap.get("note").toString());

            // Calculate the item width by the column number to let total width fill the screen width
            // 根据列数计算项目宽度，以使总宽度尽量填充屏幕
            int itemWidth = (int) (getResources().getDisplayMetrics().widthPixels - colnum * 10) / colnum;
            // Calculate the height by your scale rate, I just use itemWidth here
            // 下面根据比例计算您的item的高度，此处只是使用itemWidth
            int itemHeight = itemWidth;

            AbsListView.LayoutParams param = new AbsListView.LayoutParams(
                    itemWidth,
                    itemHeight);
            convertView.setLayoutParams(param);

            return convertView;
        }

        public NoteAdapter(Context context,
                           List<? extends Map<String, ?>> data, int resource,
                           String[] from, int[] to) {
            super(context, data, resource, from, to);
            this.context = context;
        }
    }
}
