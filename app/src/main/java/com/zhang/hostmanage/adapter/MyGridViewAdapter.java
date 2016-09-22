package com.zhang.hostmanage.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.hostmanage.R;
import com.zhang.hostmanage.utils.Constants;

import java.util.List;
import java.util.Map;

/**
 * 作者：Administrator on 2016/9/18 16:08
 * 描述：
 */
public class MyGridViewAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, Object>> list;
    private LayoutInflater inflater;

    public MyGridViewAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(list.get(position).get("Type").toString());
    }

    @Override
    public int getViewTypeCount() {
        return Constants.TYPENUM_CONTENT;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        if (position >= getCount()) {
            return null;
        }
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int arg0, View convertView, ViewGroup arg2) {
        viewHolder viewHolder = null;
        Map<String, Object> map = list.get(arg0);
        if (convertView == null) {
            viewHolder = new viewHolder();
            int x = Integer.parseInt(map.get("Type").toString());
            Log.e("asd", x + "");
            switch (Integer.parseInt(map.get("Type").toString())) {

                case Constants.NUMFIRST:
                    convertView = inflater.inflate(R.layout.sickbed_item, null);
                    viewHolder.tv = (TextView) convertView.findViewById(R.id.sickbed_wardnumber);
                    //      viewHolder.sickbeditem_name = (TextView) convertView.findViewById(R.id.sickbed_name);
                    break;
                case Constants.NUMSECONd:
                    convertView = inflater.inflate(R.layout.sickbed_listitem, null);
                    viewHolder.tv = (TextView) convertView.findViewById(R.id.sickbed_bednumber);
                    viewHolder.sickbeditem_name = (TextView) convertView.findViewById(R.id.sickbed_name);
                    viewHolder.sickbeditem_name.setText(map.get("textname").toString());
                    break;

            }
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (viewHolder) convertView.getTag();
        }

        viewHolder.tv.setText(map.get("text").toString());


        return convertView;
    }

    public class viewHolder {
        public TextView tv;
        public TextView sickbeditem_name;
    }

    public int getDipConversionPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}