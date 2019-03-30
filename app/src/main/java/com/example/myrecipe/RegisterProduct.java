package com.example.myrecipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterProduct extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText productName,productWeight,productPrice,productDescription;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);

        myDb = new DatabaseHelper(this);

        productName = findViewById(R.id.product_name_editbox);
        productWeight = findViewById(R.id.weight_editbox);
        productPrice = findViewById(R.id.price_editbox);
        productDescription = findViewById(R.id.description_editbox);
        saveButton = findViewById(R.id.rp_button);

        addData();

    }

    public void addData(){

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(productName.getText().toString(),
                                                    productWeight.getText().toString(),
                                                    productPrice.getText().toString(),
                                                    productDescription.getText().toString());

                if (isInserted == true){
                    Toast.makeText(RegisterProduct.this,"Data Inserted !",Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(RegisterProduct.this,"Data is not Inserted !",Toast.LENGTH_LONG).show();
            }
        });
    }
}
