package com.yourpanache.crmpanache.dView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yourpanache.crmpanache.R;
import com.yourpanache.crmpanache.cController.LoginController;


Use this for login page: http://sourcey.com/beautiful-android-login-and-signup-screens-with-material-design/


public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button submit;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
