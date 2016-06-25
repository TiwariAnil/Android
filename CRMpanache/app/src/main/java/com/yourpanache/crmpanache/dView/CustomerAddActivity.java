package com.yourpanache.crmpanache.dView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.yourpanache.crmpanache.R;
import com.yourpanache.crmpanache.aModel.Helper;
import com.yourpanache.crmpanache.cController.CustomerAddController;
import com.yourpanache.crmpanache.cController.CustomerCheckController;

public class CustomerAddActivity extends AppCompatActivity {

    private EditText mobileUser;
    private EditText nameUser;
    private Spinner genderUser;
    private EditText emailUser;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add);

        mobileUser = (EditText) findViewById(R.id.MobileNumber);
        nameUser = (EditText) findViewById(R.id.CustomerName);
        genderUser = (Spinner) findViewById(R.id.gender_spinner);
        emailUser = (EditText) findViewById(R.id.CustomerEmail);
        nextButton = (Button) findViewById(R.id.NextButton);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(CustomerAddActivity.this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        genderUser.setAdapter(adapter);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Check if use ris presert in server o r not
                checkUserOnServer();
                //If user is present then the flag value will change
//             if (1 == Helper.userStatusFlag) {
//                    //Add user server call here
//
//                 addUserToServer();
//             }
            }
        });
    }

    private void checkUserOnServer() {

         String customerMobile = mobileUser.getText().toString();

        CustomerCheckController checkControl = new CustomerCheckController(CustomerAddActivity.this);
        checkControl.CustomerCheckControl(customerMobile);

    }

    public void addUserToServer() {
        String customerMobile = mobileUser.getText().toString();
        String customerName = nameUser.getText().toString();
        String customerGender = genderUser.toString();
        String customerEmail = emailUser.getText().toString();

        CustomerAddController customAdd = new CustomerAddController(CustomerAddActivity.this);
        customAdd.CustomerAddControl(customerMobile, customerName, customerGender, customerEmail);

    }

    public void newUserViewDependency(){
         nameUser.setVisibility(View.VISIBLE);
         genderUser.setVisibility(View.VISIBLE);
         emailUser.setVisibility(View.VISIBLE);

    }


};

