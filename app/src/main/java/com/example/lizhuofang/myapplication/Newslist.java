package com.example.lizhuofang.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

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

public class Newslist extends Activity {
    private RollPagerView mRollViewPager;
    private ListView mListview;
    private MyAdapter myAdapter;
    private Context mCon;
    private List<News.NewsBean> mList=new ArrayList<>();
//    private
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCon=Newslist.this;
        mRollViewPager= (RollPagerView) findViewById(R.id.main_FrameLayout_contentGroup);
        mListview= (ListView) findViewById(R.id.main_listview);

        getvolley();
        //设置播放时间间隔  
        mRollViewPager.setPlayDelay(2000);
        //设置透明度  
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器  
        mRollViewPager.setAdapter(new TestNormalAdapter());

        //设置指示器（顺序依次）  
        //自定义指示器图片  
        //设置圆点指示器颜色  
        //设置文字指示器  
        //隐藏指示器  
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));  
        mRollViewPager.setHintView(new ColorPointHintView(this, Color.YELLOW,Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));  
        //mRollViewPager.setHintView(null);  
//        myAdapter=new MyAdapter();
//        mListview.setAdapter(myAdapter);
    }
    private class TestNormalAdapter extends StaticPagerAdapter{
        private int[] images={
               R.drawable.qiaoba,
                R.drawable.qiaobaone,
                R.drawable.qiaobathree
        };
        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(images[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getCount() {
            return images.length;
        }
    }
    private void getvolley(){
        String url="http://www.oschina.net/action/api/news_list?catalog=1&&pageIndex=0&&pageSize=20";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e("newsactivity","请求成功"+s);
                XStream xstream=new XStream();
                xstream.alias("oschina", News.class);
                xstream.alias("news",News.NewsBean.class);
                News o= (News) xstream.fromXML(s);
                mList.addAll(o.getNewslist());
                myAdapter=new MyAdapter(mList,mCon);
                mListview.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        requestQueue.add(request);
    }
}
