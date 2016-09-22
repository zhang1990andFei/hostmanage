package com.zhang.hostmanage.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhang.hostmanage.R;

import java.util.List;

/**
 * 作者：Administrator on 2016/9/1 16:43
 * 描述：
 */
public class NurseAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;

    public NurseAdapter(Context context, List<String> mDatas) {
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
            convertView = mInflater.inflate(R.layout.nursecard_layout, parent,
                    false);
            viewHolder = new ViewHolder();
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.nurse_position);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String nurse_positon = mDatas.get(position).toString();
        Log.e("Asd",nurse_positon.length()+"");
        switch (nurse_positon.length()) {
            case 2 | 3:
                viewHolder.mTextView.setText(mDatas.get(position));
              //  viewHolder.mTextView.setText("asd"+"\n"+"a");
                //  viewHolder.mTextView.getWidth()
                break;
            case 4:
                viewHolder.mTextView.setText(mDatas.get(position).substring(0, 2) + "\n" + mDatas.get(position).substring(2, 4));
                Log.e("Asd", mDatas.get(position).toString().substring(0,2));

                break;
            case 5:
                viewHolder.mTextView.setText(mDatas.get(position).substring(0, 3) + "\n" + mDatas.get(position).substring(3, 5));
                break;

        }
      //  viewHolder.mTextView.setText(mDatas.get(position));
        return convertView;
    }

    private final class ViewHolder {
        TextView mTextView;
    }

}