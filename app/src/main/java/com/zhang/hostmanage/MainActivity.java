package com.zhang.hostmanage;

import android.app.Activity;

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.zhang.hostmanage.fragmet.DeviceFragment;
import com.zhang.hostmanage.fragmet.DoctorFragment;
import com.zhang.hostmanage.fragmet.NurseFragment;
import com.zhang.hostmanage.fragmet.SickBedFragment;
import com.zhang.hostmanage.fragmet.WardFragment;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvents();
        initData();
        //首先 我们先选定一个

    }

    //初始化  各种个 View
    private void initView() {
        radio_ward = (RadioButton) findViewById(R.id.radio_ward);
        radio_sickbed = (RadioButton) findViewById(R.id.radio_sickbed);
        radio_doctor = (RadioButton) findViewById(R.id.radio_doctor);
        radio_device = (RadioButton) findViewById(R.id.radio_device);
        radio_nurse = (RadioButton) findViewById(R.id.radio_nurse);
        frameLayout = (FrameLayout) findViewById(R.id.fragment_container);
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
        ft =getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, new WardFragment());
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction t;
        t =getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.radio_ward:

                t.replace(R.id.fragment_container, new WardFragment());
                Toast.makeText(this,"点击",Toast.LENGTH_SHORT).show();
                t.commit();
                break;
            case R.id.radio_sickbed:
                t.replace(R.id.fragment_container, new SickBedFragment());
                t.commit();
                break;
            case R.id.radio_doctor:
                t.replace(R.id.fragment_container, new DoctorFragment());
                t.commit();
                break;
            case R.id.radio_nurse:
                t.replace(R.id.fragment_container, new NurseFragment());
                t.commit();
                break;
            case R.id.radio_device:
                t.replace(R.id.fragment_container, new DeviceFragment());
                t.commit();
                break;

            default:
                break;
        }
    }
}
