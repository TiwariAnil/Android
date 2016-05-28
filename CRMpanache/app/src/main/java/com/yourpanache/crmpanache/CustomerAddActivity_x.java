package com.yourpanache.crmpanache;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustomerAddActivity_x extends AppCompatActivity {


    private Button CustomerAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add_activity_x);

        CustomerAll = (Button) findViewById(R.id.CustomerAllData);
        final Toast toastMessage1 = Toast.makeText(this, " ", Toast.LENGTH_LONG );

        CustomerAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                1. Get Values from fields, including mobile number.
                2. Store back
                3. Go back to the CustomerAddActivity activity  (How to call back the intent)
                 */
                Bundle extras = getIntent().getExtras();
                String mobileNo = extras.getString("MobileNo");
                toastMessage1.setText(mobileNo);
                toastMessage1.show();
            }
        });
    }
}
