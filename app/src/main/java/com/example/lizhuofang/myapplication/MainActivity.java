package com.example.lizhuofang.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView mImge;
    private FrameLayout mFrameLayout;
    private RadioGroup mRadioGroup;
    private RadioButton mZHBtu,mDTBtu,mFindBtu,mMineBtu;
    private RollPagerView mRoll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getinit();

    }
    private void getinit(){
        mImge= (ImageView) findViewById(R.id.main_Serch_Btn);
        mFrameLayout= (FrameLayout) findViewById(R.id.main_FrameLayout_contentGroup);
        mZHBtu= (RadioButton) findViewById(R.id.main_ZongHeBtn);
        mZHBtu.setOnClickListener(this);
        mDTBtu= (RadioButton) findViewById(R.id.main_DongTanBtn);
        mDTBtu.setOnClickListener(this);
        mFindBtu= (RadioButton) findViewById(R.id.main_FaXianBtn);
        mFindBtu.setOnClickListener(this);
        mMineBtu= (RadioButton) findViewById(R.id.main_MineBtn);
        mMineBtu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_ZongHeBtn:
                break;
            case R.id.main_DongTanBtn:
                break;
            case R.id.main_FaXianBtn:
                break;
            case R.id.main_MineBtn:
                break;
        }
    }
}
