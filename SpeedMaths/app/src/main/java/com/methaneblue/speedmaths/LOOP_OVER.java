package com.methaneblue.speedmaths;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LOOP_OVER extends AppCompatActivity {

    Intent myIntent;

    private EditText inputText;
    private TextView msgV;
    private TextView correctV;
    private int answer, tmp;
    private Button checkB;
    String userAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_over);

        // Use "type" to update strengths
        myIntent = getIntent(); // gets the previously created intent
        answer = myIntent.getIntExtra("answer",0); // will return "FirstKeyValue"

        inputText = (EditText) findViewById(R.id.userAnswer);
        checkB = (Button) findViewById(R.id.check);
        msgV = (TextView) findViewById(R.id.msgView);
        correctV = (TextView) findViewById(R.id.correctView);


        inputText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText("");
            }
        });

        checkB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAns = inputText.getText().toString();
                checkB.setVisibility(View.GONE);
                if( answer == Integer.parseInt(inputText.getText().toString()) ){
                    msgV.setText("I can just say, You are Awesome!");

                }else {
                    msgV.setText("That's not what Ramanujan will answer!");
                }
                correctV.setText("Answer : "+Integer.toString(answer));
                msgV.setVisibility(View.VISIBLE);
                correctV.setVisibility(View.VISIBLE);
            }
        });
    }
}
