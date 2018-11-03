package com.example.darabsingh.googleapidemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.darabsingh.googleapidemo.pojos.Places;

public class MyAdapter extends BaseAdapter {
    MainActivity mActivity;
    Places places1;
    public MyAdapter(MainActivity mainActivity, Places places1) {
        this.mActivity=mainActivity;
        this.places1=places1;
    }

    @Override
    public int getCount() {
        return places1.getList().size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater=LayoutInflater.from(mActivity);
        View view1=layoutInflater.inflate(R.layout.indi_view,null);
        TextView tv1=(TextView) view1.findViewById(R.id.textView1);
        TextView tv2=(TextView) view1.findViewById(R.id.textView2);
        tv1.setText(places1.getList().get(i).getName());
        tv2.setText(places1.getList().get(i).getVicinity());

        return view1;
    }
}
