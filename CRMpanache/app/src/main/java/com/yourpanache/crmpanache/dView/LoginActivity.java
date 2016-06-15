package com.yourpanache.crmpanache.dView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.yourpanache.crmpanache.cController.LoginController;

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
        final Toast toastMessage2 = Toast.makeText(this, " Cancel button pressed ", Toast.LENGTH_LONG);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String salonEmail = email.getText().toString();
                String salonPassword = password.getText().toString();

                LoginController loginControl = new LoginController(LoginActivity.this);
                loginControl.LoginControl(salonEmail, salonPassword);

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
