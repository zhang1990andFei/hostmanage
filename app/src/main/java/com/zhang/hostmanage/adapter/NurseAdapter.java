package com.zhang.hostmanage.adapter;

import android.content.Context;
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
public class NurseAdapter extends BaseAdapter
{
    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;

    public NurseAdapter(Context context, List<String> mDatas)
    {
        mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount()
    {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder = null;
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.docotorgrid_item, parent,
                    false);
            viewHolder = new ViewHolder();

            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        viewHolder.mTextView.setText(mDatas.get(position));
        return convertView;
    }

    private final class ViewHolder
    {
        TextView mTextView;
    }

}