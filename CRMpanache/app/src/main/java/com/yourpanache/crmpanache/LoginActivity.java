package com.yourpanache.crmpanache;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        final Toast toastMessage1 = Toast.makeText(this, " Login button pressed "+email.getText().toString(), Toast.LENGTH_LONG );
        final Toast toastMessage2 = Toast.makeText(this, " Cancel button pressed "+email.getText(), Toast.LENGTH_LONG );

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
             String salonEmail = email.getText().toString();
             String salonPassword = password.getText().toString();
             toastMessage1.setText(salonEmail);
                // Match with the database;
                if(1 == 1){
                    Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(i);
                    //setContentView(R.layout.home_postlogin);
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
