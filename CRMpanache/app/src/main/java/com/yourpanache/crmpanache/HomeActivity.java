package com.yourpanache.crmpanache;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button newCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        newCustomer = (Button) findViewById(R.id.newCustomerButton);

        newCustomer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i = new Intent(HomeActivity.this,CustomerAddActivity.class);
                startActivity(i);

            }
        });


    }
}
