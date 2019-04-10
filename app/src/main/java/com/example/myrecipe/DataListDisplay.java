package com.example.myrecipe;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DataListDisplay extends AppCompatActivity {

    ListView productList;
    SQLiteDatabase myDb;
    DatabaseHelper databaseHelper;
    DataProvider dataProvider;
    Cursor cursor;
    ListDataAdapter listDataAdapter;
    public static boolean isActionMode = false;
    public static List<String> userSelection = new ArrayList<>(); // selected items
    public static ActionMode actionMode = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_display_layout);

        productList = findViewById(R.id.product_list);
        productList.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        productList.setMultiChoiceModeListener(modeListener);

     //------------------- connect with row layout ---------------//
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.rowlist_layout);
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
                description = cursor.getString(4);

                //DataProvide constructor
                DataProvider dataProvider = new DataProvider(id,name,weight,price,description);

                listDataAdapter.add(dataProvider);


            }while (cursor.moveToNext()); //return whether another row is available
        }


        productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dataProvider = (DataProvider) listDataAdapter.getItem(position);
                Intent intent = new Intent(DataListDisplay.this,ShowInformation.class);
                startActivity(intent);

            }
        });
    }

    AbsListView.MultiChoiceModeListener modeListener = new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    };


    public void showSelctedItems(View view) {
    }
}
