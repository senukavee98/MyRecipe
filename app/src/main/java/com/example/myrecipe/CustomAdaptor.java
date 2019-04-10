package com.example.myrecipe;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdaptor extends BaseAdapter {

    private Activity activity;
    private ArrayList<DataProvider> products;
    private LayoutInflater inflater;

    TextView idCustom , nameCustom;
    DataProvider dataProvider;

    public CustomAdaptor(Activity activity, ArrayList<DataProvider> products) {
        this.activity = activity;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public DataProvider getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null){
            convertView = inflater.inflate(R.layout.row , null);
        }

        idCustom   = convertView.findViewById(R.id.id_custom);
        nameCustom = convertView.findViewById(R.id.name_custom);

        dataProvider = products.get(position);
        idCustom.setText(dataProvider.getId());
        nameCustom.setText(dataProvider.getProductName());

        return convertView;
    }
}
