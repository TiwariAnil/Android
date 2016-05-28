package com.yourpanache.crmpanache;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CustomerAddActivity extends AppCompatActivity {

    private EditText MobileNo;
    private Button CustomerInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add);

        MobileNo = (EditText) findViewById(R.id.MobileNumber);
        CustomerInput = (Button) findViewById(R.id.EnterMobileButton);

        CustomerInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String CustomerMobile = MobileNo.getText().toString();
                /*

                Match if mobile number exists.
                 */
                // If does not exists.
                if( 1 == 1){
                    // Just pop up below it or new intent

                    Intent i = new Intent(CustomerAddActivity.this,CustomerAddActivity_x.class);
                    i.putExtra("MobileNo", CustomerMobile);
                    startActivity(i);
                }

                /*
                After Above intent is done or not needed!
                All data is added already ( Can we have those here?)
                Go below ( the service activity)

                 */
                if( 1 == 1){
                    // Just pop up below it or new intent

                    Intent j = new Intent(CustomerAddActivity.this,CustomerAddActivity_x.class);
                    startActivity(j);
                }



            }
        });
    }
}
