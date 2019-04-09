package com.example.myrecipe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListDataAdapter extends ArrayAdapter {

    List list = new ArrayList();
    Context context;
    SQLiteDatabase myDb;
    DatabaseHelper databaseHelper;

    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
        TextView ID,NAME,WEIGHT,PRICE,DESCRIPTION;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;

        //CheckBox
       // CheckBox tickBox = row.findViewById(R.id.tick_box);
        //setTag for the checkbox
        //tickBox.setTag(position);

         //check whether row is null
        if (row==null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.rowlist_layout,parent,false);
            layoutHandler = new LayoutHandler();

            layoutHandler.ID = row.findViewById(R.id.product_id_ep);
            layoutHandler.NAME = row.findViewById(R.id.product_name_ep);
            layoutHandler.WEIGHT = row.findViewById(R.id.product_weight_ep);
            layoutHandler.PRICE = row.findViewById(R.id.product_price_ep);
            layoutHandler.DESCRIPTION = row.findViewById(R.id.product_description_ep);

            //adding the data to the row in the layout
            row.setTag(layoutHandler);

        }
        else {
            layoutHandler = (LayoutHandler)row.getTag();
        }

        DataProvider dataProvider = (DataProvider) this.getItem(position);
        layoutHandler.ID.setText(dataProvider.getId());
        layoutHandler.NAME.setText(dataProvider.getProductName());
        layoutHandler.WEIGHT.setText(dataProvider.getWeight());
        layoutHandler.PRICE.setText(dataProvider.getPrice());
        layoutHandler.DESCRIPTION.setText(dataProvider.getDescription());

      
        return row;
    }
}
