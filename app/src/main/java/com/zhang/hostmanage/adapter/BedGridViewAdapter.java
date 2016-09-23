package com.zhang.hostmanage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.zhang.hostmanage.R;
import com.zhang.hostmanage.utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：Administrator on 2016/9/21 16:59
 * 描述：
 */
public class BedGridViewAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;
    private MyGridViewAdapter myGridViewAdapter;
    private List<Map<String, Object>> list;

    public BedGridViewAdapter(Context context, List<String> mDatas) {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.bedcard_itemlayout, parent,
                    false);
            viewHolder = new ViewHolder();
            viewHolder.gridView = (GridView) convertView.findViewById(R.id.sickbedgridview_grid);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        viewHolder.mTextView.setText(mDatas.get(position));
        list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;
        map = new HashMap<String, Object>();
        map.put("text", 1 +"");
        map.put("textname", "夔禺疆");
        //   map.put("Type",1);
        map.put("Type", Constants.NUMFIRST);
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("text", 1 + "床");
        map.put("textname", "任平生");
        //  map.put("Type",2);
        map.put("Type", Constants.NUMSECONd);

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
        list.add(map);
        myGridViewAdapter = new MyGridViewAdapter(mContext, list);

        viewHolder.gridView.setAdapter(myGridViewAdapter);
        return convertView;
    }

    private final class ViewHolder {
        TextView mTextView;
        GridView gridView;
    }

}