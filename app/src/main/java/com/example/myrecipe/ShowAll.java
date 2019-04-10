package com.example.myrecipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowAll extends AppCompatActivity {

    ListView listOfProducts;
    CustomAdaptor customAdaptor;
    ArrayList<DataProvider> arrayList;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        db = new DatabaseHelper(this);

        arrayList = new ArrayList<>();
        arrayList = db.getAllStudentData();

        customAdaptor = new CustomAdaptor(this,arrayList);
        listOfProducts.setAdapter(customAdaptor);
    }
}
