package com.yourpanache.crmpanache;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LoginActivity extends AppCompatActivity {

    class SALON {
        private String username;
        private String password;

        // constructor
        public SALON(String name, String pass) {
            this.username = name;
            this.password = pass;
        }};

    private EditText email;
    private EditText password;
    private Button submit;
    private Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.emailText);
        password = (EditText) findViewById(R.id.passwordText);
        submit = (Button) findViewById(R.id.submitButton);
        cancel = (Button) findViewById(R.id.cancelButton);
        final Toast toastMessage1 = Toast.makeText(this, " Login button pressed "+email.getText().toString(), Toast.LENGTH_LONG );
        final Toast toastMessage2 = Toast.makeText(this, " Cancel button pressed "+email.getText(), Toast.LENGTH_LONG );

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
             String salonEmail = email.getText().toString();
             String salonPassword = password.getText().toString();
             toastMessage1.setText(salonEmail);
                // Match with the database;
                SALON obj = new SALON(salonEmail, salonPassword);

                Gson gson = new Gson();
//                gson.toJson(obj);
                final String jsonInString = gson.toJson(obj);



                if(1 == 1){

                    // Instantiate the RequestQueue.

                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                    StringRequest req = new StringRequest(Request.Method.POST, "http://127.0.0.1:8080/login",  new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.
                            toastMessage1.setText("Response is: "+ response.substring(0,500));
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            toastMessage1.setText("That didn't work!");
                        }
                    }) {
                        @Override
                        public byte[] getBody() throws AuthFailureError{
                            return jsonInString.getBytes();
                        }
                        @Override
                        public String getBodyContentType(){
                            return "application/json";
                        }
                    };

                                                   /*

                    // Request a string response from the provided URL.
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    // Display the first 500 characters of the response string.
                                    toastMessage1.setText("Response is: "+ response.substring(0,500));
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            toastMessage1.setText("That didn't work!");
                        }
                        */

                    // Add the request to the RequestQueue.
                    queue.add(req);

                    /*
                    Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(i);
                    //setContentView(R.layout.home_postlogin);
                    */
                }
                toastMessage1.show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                toastMessage2.show();

            }
        });
    }
}
