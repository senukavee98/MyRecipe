package com.example.myrecipe;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchProduct extends AppCompatActivity {

    TextView idSearch , nameSearch , weightSearch , priceSearch , descriptionSearch ;
    EditText editTextSearch;
    Button searchButton;
    DatabaseHelper databaseHelper;
    SQLiteDatabase myDb;
    String name,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);

        editTextSearch = findViewById(R.id.editText_search);
        searchButton = findViewById(R.id.button_search);
        idSearch = findViewById(R.id.id_search);
        nameSearch = findViewById(R.id.name_search);
        weightSearch = findViewById(R.id.weight_search);
        priceSearch = findViewById(R.id.price_search);
        descriptionSearch = findViewById(R.id.description_search);

    }
    

    public void searchProduct(View view) {

        name = editTextSearch.getText().toString();
        description = editTextSearch.getText().toString();
        databaseHelper = new DatabaseHelper(this);
        myDb = databaseHelper.getReadableDatabase();
        Cursor cursor1 = databaseHelper.getProductInfo(name,myDb);


        if (cursor1.moveToFirst()){
            String ID = cursor1.getString(0);
            String NAME = cursor1.getString(1);
            String WEIGHT = cursor1.getString(2);
            String PRICE = cursor1.getString(3);
            String DESCRIPTION = cursor1.getString(4);


            idSearch.setText(ID);
            nameSearch.setText(NAME);
            weightSearch.setText(WEIGHT);
            priceSearch.setText(PRICE);
            descriptionSearch.setText(DESCRIPTION);


        }

    }
}
