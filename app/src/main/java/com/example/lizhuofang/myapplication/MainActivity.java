package com.example.lizhuofang.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView mImge;
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
        mZHBtu= (RadioButton) findViewById(R.id.main_ZongHeBtn);
        mZHBtu.setOnClickListener(this);
        mDTBtu= (RadioButton) findViewById(R.id.main_DongTanBtn);
        mDTBtu.setOnClickListener(this);
        mFindBtu= (RadioButton) findViewById(R.id.main_FaXianBtn);
        mFindBtu.setOnClickListener(this);
        mMineBtu= (RadioButton) findViewById(R.id.main_MineBtn);
        mMineBtu.setOnClickListener(this);
        mRoll= (RollPagerView) findViewById(R.id.main_FrameLayout_contentGroup);
        mRoll.setAnimationDurtion(500);
        mRoll.setPlayDelay(2000);
        mRoll.setAdapter(new MyAdapter());

    }



    class  MyAdapter extends StaticPagerAdapter{
        private int[] images={
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher
        };
        @Override
        public View getView(ViewGroup container, int position) {
            ImageView  imageView=new ImageView(getApplicationContext());
            imageView.setImageResource(images[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            return imageView;
        }

        @Override
        public int getCount() {
            return images.length;
        }
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
