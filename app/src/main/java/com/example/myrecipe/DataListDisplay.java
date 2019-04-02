package com.example.myrecipe;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DataListDisplay extends AppCompatActivity {

    ListView productList;
    SQLiteDatabase myDb;
    DatabaseHelper databaseHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_display_layout);

        productList = findViewById(R.id.product_list);

     //------------------- connect with row layout ---------------//
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        productList.setAdapter(listDataAdapter);

        databaseHelper = new DatabaseHelper(getApplicationContext());
        myDb  = databaseHelper.getReadableDatabase();
        cursor = databaseHelper.getInfromatiom(myDb);

        //checking whether information available in cursor object
        if (cursor.moveToFirst()){
            do {

                String id,name,weight,price,description;
                id = cursor.getString(0);
                name = cursor.getString(1);
                weight = cursor.getString(2);
                price = cursor.getString(3);
                description = cursor.getString(3);

                //DataProvide constructor
                DataProvider dataProvider = new DataProvider(id,name,weight,price,description);

                listDataAdapter.add(dataProvider);

            }while (cursor.moveToNext()); //return whether another row is available
        }
    }
}
