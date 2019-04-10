package com.example.myrecipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseHelper(this);
    }


    public void registerProduct(View view) {
        Log.d(LOG_TAG,"Register Product Button is clicked");
        Intent intent = new Intent(this,RegisterProduct.class);
        startActivity(intent);

    }

    public void displayProduct(View view) {
        Log.d(LOG_TAG,"Display Product Button is clicked");
        Intent intent = new Intent(this,DataListDisplay.class);
        startActivity(intent);

    }

    public void availability(View view) {
        Log.d(LOG_TAG,"Availability Button is clicked");
    }

    public void editProduct(View view) {
        Log.d(LOG_TAG,"Edit Product Button is clicked");

        Intent intent = new Intent(this,ViewListContext.class);
        startActivity(intent);
    }

    public void search(View view) {
        Log.d(LOG_TAG,"Search Button is clicked");
        Intent intent = new Intent(this,SearchProduct.class);
        startActivity(intent);
    }

    public void recipes(View view) {
        Log.d(LOG_TAG,"Recipes Button is clicked");
    }
}
