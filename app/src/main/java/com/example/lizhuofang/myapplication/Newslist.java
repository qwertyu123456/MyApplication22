package com.example.lizhuofang.myapplication;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lizhuofang.myapplication.adapter.MyAdapter;
import com.example.lizhuofang.myapplication.bean.News;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhuofang on 2017/5/9.
 */

public class Newslist extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup mRadiogroup;
    private TextView mText;
    private RadioButton mzh,mdt,mfx,mmine;
    private ImageView mImage;
    private ArrayList<View> mList = new ArrayList<View>();
    private FrameLayout mFrame;
    private FragmentManager fm;
    private FragmentTransaction tra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText= (TextView) findViewById(R.id.zonghe_Title_Text);
        mRadiogroup= (RadioGroup) findViewById(R.id.main_Main_RadioGroup);
        mRadiogroup.setOnCheckedChangeListener(this);
        mzh= (RadioButton) findViewById(R.id.main_ZongHeBtn);
        mdt= (RadioButton) findViewById(R.id.main_DongTanBtn);
        mfx= (RadioButton) findViewById(R.id.main_FaXianBtn);
        mmine= (RadioButton) findViewById(R.id.main_MineBtn);
        mImage= (ImageView) findViewById(R.id.main_AddBtn);
        mFrame = (FrameLayout) findViewById(R.id.main_frame);
        fm = getSupportFragmentManager();
        tra = fm.beginTransaction();
        tra.replace(R.id.main_frame,new MyFragment());
        tra.commit();

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
       switch (checkedId){
           case R.id.main_ZongHeBtn:
               fm = getSupportFragmentManager();
               tra = fm.beginTransaction();
               tra.replace(R.id.main_frame,new MyFragment());
               tra.commit();

               break;
           case R.id.main_DongTanBtn:
               mText.setText("动弹");
               tra = fm.beginTransaction();
               tra.replace(R.id.main_frame,new MyFragment());
               tra.commit();
               break;
           case R.id.main_FaXianBtn:
               break;
           case R.id.main_MineBtn:
               break;
       }
    }
//    private void getvolley(){
//        String url="http://www.oschina.net/action/api/news_list?catalog=1&&pageIndex=0&&pageSize=20";
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        StringRequest request=new StringRequest(url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String s) {
//                Log.e("newsactivity","请求成功"+s);
//                XStream xstream=new XStream();
//                xstream.alias("oschina", News.class);
//                xstream.alias("news",News.NewsBean.class);
//                News o= (News) xstream.fromXML(s);
//                mList.addAll(o.getNewslist());
//                myAdapter=new MyAdapter(mList,mCon);
//                mListview.setAdapter(myAdapter);
//                myAdapter.notifyDataSetChanged();
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//
//            }
//        });
//        requestQueue.add(request);
//    }
}
