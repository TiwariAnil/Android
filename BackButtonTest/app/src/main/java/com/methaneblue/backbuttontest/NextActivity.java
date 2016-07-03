package com.methaneblue.backbuttontest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NextActivity extends AppCompatActivity {

    private Button myBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        myBtn = (Button) findViewById(R.id.button2);

        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NextActivity.this, ThirdActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}