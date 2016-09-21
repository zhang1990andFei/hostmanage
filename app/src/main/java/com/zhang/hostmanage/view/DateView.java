package com.zhang.hostmanage.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhang.hostmanage.R;

import java.text.SimpleDateFormat;

/**
 * 作者：Administrator on 2016/9/21 09:05
 * 描述：
 */
public class DateView extends LinearLayout {
    private Context mContext;
    private TextView textViewNcs;
    private String format;
    private View linearLayout;
    private LayoutInflater inflater;

    public DateView(Context context) {
        super(context);
        this.mContext = context;
    }

    public DateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        this.mContext = context;
    }

    public void initView() {
        inflater = LayoutInflater.from(mContext);
        linearLayout = inflater.inflate(R.layout.ncsview_text, this, true);
        textViewNcs = (TextView) linearLayout.findViewById(R.id.text_date);
        format = "yy/MM/dd HH:mm:ss";
        String date = new SimpleDateFormat(format).format(System.currentTimeMillis());
        if (!date.equals("") & !date.equals(null)) {
            textViewNcs.setText(date);
        } else {
            textViewNcs.setText("");
        }
        IntentFilter updateIntent = new IntentFilter();
        updateIntent.addAction("android.intent.action.TIME_TICK");
        mContext.getApplicationContext().registerReceiver(minBroadcast, updateIntent);

    }


    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (minBroadcast != null) {
                mContext.unregisterReceiver(minBroadcast);

            }
        } catch (IllegalArgumentException e) {

        }
    }

    private BroadcastReceiver minBroadcast = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            //update time every minute
            updateTime(context);
        }
    };

    public void updateTime(Context context) {
        String date = new SimpleDateFormat(format).format(System.currentTimeMillis());
        textViewNcs.setText(date);
    }
}
