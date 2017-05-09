package com.example.lizhuofang.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lizhuofang.myapplication.R;
import com.example.lizhuofang.myapplication.bean.News;

import java.util.List;
import java.util.jar.JarEntry;

/**
 * Created by lizhuofang on 2017/5/9.
 */

public class MyAdapter extends BaseAdapter {
    private List<News.NewsBean> mList;
    private Context mCon;

    public MyAdapter(List<News.NewsBean> mList, Context mCon) {
        this.mList = mList;
        this.mCon = mCon;
    }

    @Override
    public int getCount() {
        return mList.isEmpty()?0:mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=null;
        if(convertView==null){
            holder=new Holder();
            convertView= LayoutInflater.from(mCon).inflate(R.layout.adapter,null);
            holder.one= (TextView) convertView.findViewById(R.id.adapter_text);
            holder.two= (TextView) convertView.findViewById(R.id.adapter_textone);
            holder.three= (TextView) convertView.findViewById(R.id.adapter_textthree);
            convertView.setTag(holder);
        }else{
            holder= (Holder) convertView.getTag();
        }
        holder.one.setText(mList.get(position).getNewstype().getAuthoruid2());
        holder.two.setText(mList.get(position).getBody());
        holder.three.setText(mList.get(position).getNewstype().getAttachment());
        return convertView;
    }



    class Holder{
        private TextView one,two,three;
    }
}
