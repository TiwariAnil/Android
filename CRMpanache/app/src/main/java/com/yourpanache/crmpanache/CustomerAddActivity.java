package com.yourpanache.crmpanache;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yourpanache.crmpanache.aModel.USER;

public class CustomerAddActivity extends AppCompatActivity {



    private EditText mobileUser;
    private EditText nameUser;
    private Spinner genderUser;
    private EditText emailUser;
    private Button nextButton;

    private int userStatusFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add);

        mobileUser = (EditText) findViewById(R.id.MobileNumber);
        nameUser = (EditText) findViewById(R.id.CustomerName);
        genderUser = (Spinner) findViewById(R.id.gender_spinner);
        emailUser = (EditText) findViewById(R.id.CustomerEmail);
        nextButton = (Button) findViewById(R.id.NextButton);

//                    Spinner spinner = (Spinner) findViewById(R.id.gender_spinner);
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
                //If user is present then the flag value will change
                //If falg value changes to 1, then user gets added to server
                if (0 == userStatusFlag) {

                    checkUserOnServer();

                } else if (1 == userStatusFlag) {

                    USER user = getUserData();
                    //Add user server call here
                    addUserToServer(user);
                }

            }
        });
    }


    private void checkUserOnServer() {

        final Toast toastMessage1 = Toast.makeText(this, "", Toast.LENGTH_LONG);

        String customerMobile = mobileUser.getText().toString();
//                String customerName = nameUser.getText().toString();
//                String customerGender = genderUser.getText().toString();
//                String customerEmail = emailUser.getText().toString();;
//
        RequestQueue queue = Volley.newRequestQueue(CustomerAddActivity.this);
//        StringRequest req = new StringRequest(Request.Method.GET, "http://164.99.140.98:8080/isUser/" + customerMobile, new Response.Listener<String>() {
        StringRequest req = new StringRequest(Request.Method.GET, "http://192.168.1.6:8080/isUser/" + customerMobile, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                if (response.contains("True")) {
                    toastMessage1.setText("Response is: " + response);
                    Intent i = new Intent(CustomerAddActivity.this, SelectServiceActivity.class);
                    startActivity(i);
                } else {
                    toastMessage1.setText("It's a new User case!");

                    nameUser.setVisibility(View.VISIBLE);
                    genderUser.setVisibility(View.VISIBLE);
                    emailUser.setVisibility(View.VISIBLE);

                    //Set the flag
                    userStatusFlag = 1;
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                toastMessage1.setText("Error on userAdd Post Request!");
            }
        });
        queue.add(req);
        toastMessage1.show();
    }

    private USER getUserData() {

        String customerMobile = mobileUser.getText().toString();
        String customerName = nameUser.getText().toString();
        String customerGender = genderUser.toString();
        String customerEmail = emailUser.getText().toString();

        USER user = new USER(customerMobile, customerName, customerGender, customerEmail);
        return user;
    }

    private void addUserToServer(USER user) {
        final Toast toastMessage1 = Toast.makeText(this, "", Toast.LENGTH_LONG);
        Gson gson = new Gson();
        final String jsonInString = gson.toJson(user);
        RequestQueue queue = Volley.newRequestQueue(CustomerAddActivity.this);
//        StringRequest req = new StringRequest(Request.Method.POST, "http://164.99.140.98:8080/addUser", new Response.Listener<String>() {
        StringRequest req = new StringRequest(Request.Method.POST, "http://192.168.1.6:8080/addUser", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.contains("True")) {
                    toastMessage1.setText("User added! : " + response);
                    Intent i = new Intent(CustomerAddActivity.this, SelectServiceActivity.class);
                    startActivity(i);
                } else {
                    toastMessage1.setText("User addition didn't work!");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                toastMessage1.setText("Error on userAdd Post Request!");
            }
        }) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                return jsonInString.getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };
        queue.add(req);
        toastMessage1.show();
    }};

