package com.example.myrecipe;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewListContext extends AppCompatActivity {

    DatabaseHelper mydb;
    ListView listview ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        listview = findViewById(R.id.listView_products);
        mydb = new DatabaseHelper(this);

        ArrayList<String> arrayList = new ArrayList<>();
        Cursor data = mydb.getListContent();

        if (data.getCount() == 0 ){
            Toast.makeText(ViewListContext.this,"The Database is Empty :( " , Toast.LENGTH_LONG).show();
        }else {
            while (data.moveToNext()){
                arrayList.add(data.getString(1));
                ListAdapter listAdapter =  new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
                listview.setAdapter(listAdapter);

            }
        }


    }
}
