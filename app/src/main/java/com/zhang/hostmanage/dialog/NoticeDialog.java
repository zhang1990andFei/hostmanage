package com.zhang.hostmanage.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.hostmanage.R;

/**
 * 作者：Administrator on 2016/10/19 10:26
 * 描述：自定义对话框
 */

public class NoticeDialog extends Dialog implements View.OnClickListener {
    Context context;
    private NoticeDialogListener listener;

    //对话框事件监听接口，用于处理回调点击事件
    public interface NoticeDialogListener {
        public void onClick(View view);
    }

    public NoticeDialog(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    public NoticeDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    public NoticeDialog(Context context, int theme, NoticeDialogListener listener) {
        super(context, theme);
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView close = (ImageView) findViewById(R.id.dialog_close);//确定控件
        TextView cancel = (TextView) findViewById(R.id.dialog_sure);//取消控件
        TextView sure = (TextView) findViewById(R.id.dialog_cancel);
        if (sure != null && cancel != null) {//如果是不带确认选择框，不做事件监听操作
            sure.setOnClickListener(this);
            cancel.setOnClickListener(this);

        }
        if (close != null) {
            close.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        listener.onClick(v);
    }
}