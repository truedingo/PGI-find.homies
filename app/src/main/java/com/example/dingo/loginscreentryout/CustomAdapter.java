package com.example.dingo.loginscreentryout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tiagogomes on 29/12/17.
 */

public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    private List<user> mProductList;

    //Constructor
    public CustomAdapter(Context applicationContext, List<user> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.item, null);
        TextView tvName = (TextView)v.findViewById(R.id.tv_name);
        TextView tvDescription = (TextView)v.findViewById(R.id.tv_description);
        //Set text for TextView
        tvName.setText(mProductList.get(position).getName());
        tvDescription.setText(mProductList.get(position).getCurso());

        //Save product id to tag
        v.setTag(mProductList.get(position).getAge());

        return v;
    }
}
