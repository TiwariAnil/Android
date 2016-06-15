package com.yourpanache.crmpanache.dView;

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
import com.yourpanache.crmpanache.HomeActivity;
import com.yourpanache.crmpanache.R;
import com.yourpanache.crmpanache.aModel.SALON;

public class LoginActivity extends AppCompatActivity {

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
        final Toast toastMessage1 = Toast.makeText(this, " Login button pressed ", Toast.LENGTH_LONG);
        final Toast toastMessage2 = Toast.makeText(this, " Cancel button pressed ", Toast.LENGTH_LONG);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String salonEmail = email.getText().toString();
                String salonPassword = password.getText().toString();
//                toastMessage1.setText(salonEmail);
                // Match with the database;

                SALON obj = new SALON(salonEmail, salonPassword);
                Gson gson = new Gson();
                final String jsonInString = gson.toJson(obj);
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
//                StringRequest req = new StringRequest(Request.Method.POST, "http://164.99.140.98:8080/login", new Response.Listener<String>() {
                StringRequest req = new StringRequest(Request.Method.POST, "http://192.168.1.6:8080/login", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if( response.contains("True") ){
                            toastMessage1.setText("Response is: " + response);
                            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(i);
                            //setContentView(R.layout.home_postlogin);
                        }
                        else {
                            toastMessage1.setText("Username/Password is invalid!");
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        toastMessage1.setText("That didn't work!");
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
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toastMessage2.show();

            }
        });
    }
}
