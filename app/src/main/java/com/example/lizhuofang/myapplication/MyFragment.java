package com.example.lizhuofang.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * Created by lizhuofang on 2017/5/10.
 */

public class MyFragment extends Fragment {
    private RollPagerView mRollViewPager;
    private ListView mListview;
    private List<News.NewsBean> mList=new ArrayList<>();
    private MyAdapter myAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragm, null);
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_rollviewpager,null);

        mRollViewPager = (RollPagerView) v.findViewById(R.id.fram_FrameLayout_contentGroup);
        mListview= (ListView) view.findViewById(R.id.fram_listview);
        mListview.addHeaderView(v);
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
        mRollViewPager.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW, Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));  
        //mRollViewPager.setHintView(null);  
//        myAdapter=new MyAdapter();
//        mListview.setAdapter(myAdapter);
        return view;
    }
    private class TestNormalAdapter extends StaticPagerAdapter {
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
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest request=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e("newsactivity","请求成功"+s);
                XStream xstream=new XStream();
                xstream.alias("oschina", News.class);
                xstream.alias("news",News.NewsBean.class);
                News o= (News) xstream.fromXML(s);
                mList.addAll(o.getNewslist());
                myAdapter=new MyAdapter(mList,getActivity());
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

