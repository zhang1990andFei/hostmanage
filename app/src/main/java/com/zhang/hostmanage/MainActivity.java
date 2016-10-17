package com.zhang.hostmanage;

import android.app.Activity;

import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.zhang.hostmanage.fragmet.DeviceFragment;
import com.zhang.hostmanage.fragmet.DoctorFragment;
import com.zhang.hostmanage.fragmet.NurseFragment;
import com.zhang.hostmanage.fragmet.SickBedFragment;
import com.zhang.hostmanage.fragmet.WardFragment;



import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    private RadioButton radio_ward;
    private RadioButton radio_sickbed;
    private RadioButton radio_doctor;
    private RadioButton radio_nurse;
    private RadioButton radio_device;
    private WardFragment wardFragment;
    private SickBedFragment sickBedFragment;
    private DoctorFragment doctorFragment;
    private NurseFragment nurseFragment;
    private DeviceFragment deviceFragment;

    private FrameLayout frameLayout;
    private LinearLayout bottom_layout;

    private LinearLayout extra_button;
    private LinearLayout constants_button;
    private LinearLayout remiand_button;
    private LinearLayout notice_button;
    private LinearLayout broadcast_button;
    private LinearLayout change_button;
    private LinearLayout restart_button;
    private TextView date_show;
    private String format;
    private static final int TIME_CHANGED = 1000;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TIME_CHANGED:
                    date_show.setText(getSystemTime());
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        initView();
        initEvents();
        initData();
        new TimeThread().start();
        //   registerReceiver(mTimeRefreshReceiver, new IntentFilter(Intent.ACTION_TIME_TICK));
        //首先 我们先选定一个

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // unregisterReceiver(mTimeRefreshReceiver);
    }

    //初始化  各种个 View
    private void initView() {
        radio_ward = (RadioButton) findViewById(R.id.radio_ward);
        radio_sickbed = (RadioButton) findViewById(R.id.radio_sickbed);
        radio_doctor = (RadioButton) findViewById(R.id.radio_doctor);
        radio_device = (RadioButton) findViewById(R.id.radio_device);
        radio_nurse = (RadioButton) findViewById(R.id.radio_nurse);
        frameLayout = (FrameLayout) findViewById(R.id.fragment_container);
        extra_button = (LinearLayout) findViewById(R.id.extrabed_button);
        constants_button = (LinearLayout) findViewById(R.id.contacts_button);
        remiand_button = (LinearLayout) findViewById(R.id.remind_button);
        notice_button = (LinearLayout) findViewById(R.id.notice_button);
        broadcast_button = (LinearLayout) findViewById(R.id.broadcast_button);
        change_button = (LinearLayout) findViewById(R.id.changebed_button);
        restart_button = (LinearLayout) findViewById(R.id.restart_button);
        date_show = (TextView) findViewById(R.id.main_date);
        restart_button.setVisibility(View.GONE);


    }


    //初始化 监听事件
    private void initEvents() {
        radio_ward.setOnClickListener(this);
        radio_sickbed.setOnClickListener(this);
        radio_doctor.setOnClickListener(this);
        radio_device.setOnClickListener(this);
        radio_nurse.setOnClickListener(this);
    }


    private void initData() {
        FragmentTransaction ft;
        ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, new WardFragment());
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction t;
        t = getFragmentManager().beginTransaction();
        final LayoutInflater inflater = LayoutInflater.from(this);
        switch (v.getId()) {
            case R.id.radio_ward:
                t.replace(R.id.fragment_container, new WardFragment());
                initButton(6);
                t.commit();
                break;
            case R.id.radio_sickbed:
                t.replace(R.id.fragment_container, new SickBedFragment());

                initButton(4);
                t.commit();
                break;
            case R.id.radio_doctor:
                t.replace(R.id.fragment_container, new DoctorFragment());
                initButton(3);
                t.commit();
                break;
            case R.id.radio_nurse:
                t.replace(R.id.fragment_container, new NurseFragment());
                initButton(3);
                t.commit();
                break;
            case R.id.radio_device:
                t.replace(R.id.fragment_container, new DeviceFragment());
                initButton(1);
                t.commit();
                break;

            default:
                break;
        }
    }

    private void initButton(int type) {
        switch (type) {
            case 1:
                restart_button.setVisibility(View.VISIBLE);
                extra_button.setVisibility(View.GONE);
                constants_button.setVisibility(View.GONE);
                remiand_button.setVisibility(View.GONE);
                notice_button.setVisibility(View.GONE);
                broadcast_button.setVisibility(View.GONE);
                change_button.setVisibility(View.GONE);
                break;
            case 3:
                restart_button.setVisibility(View.GONE);
                extra_button.setVisibility(View.GONE);
                constants_button.setVisibility(View.VISIBLE);
                remiand_button.setVisibility(View.VISIBLE);
                notice_button.setVisibility(View.VISIBLE);
                broadcast_button.setVisibility(View.GONE);
                change_button.setVisibility(View.GONE);
                break;
            case 4:
                restart_button.setVisibility(View.GONE);
                extra_button.setVisibility(View.GONE);
                constants_button.setVisibility(View.VISIBLE);
                remiand_button.setVisibility(View.VISIBLE);
                notice_button.setVisibility(View.VISIBLE);
                broadcast_button.setVisibility(View.VISIBLE);
                change_button.setVisibility(View.GONE);
                break;
            case 6:
                restart_button.setVisibility(View.GONE);
                extra_button.setVisibility(View.VISIBLE);
                constants_button.setVisibility(View.VISIBLE);
                remiand_button.setVisibility(View.VISIBLE);
                notice_button.setVisibility(View.VISIBLE);
                broadcast_button.setVisibility(View.VISIBLE);
                change_button.setVisibility(View.VISIBLE);
                break;

        }
    }

    //广播
    private BroadcastReceiver mTimeRefreshReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (Intent.ACTION_TIME_TICK.equals(intent.getAction())) {
                date_show.setText(getSystemTime());
            }
        }
    };

    //获取时间
    private CharSequence getSystemTime() {
        format = "yyyy年MM月dd日      HH:mm:ss";
        String date = new SimpleDateFormat(format).format(System.currentTimeMillis());
        long sysTime = System.currentTimeMillis();
        return date;
    }

    public class TimeThread extends Thread {
        @Override
        public void run() {
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = TIME_CHANGED;
                    mHandler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }
}
