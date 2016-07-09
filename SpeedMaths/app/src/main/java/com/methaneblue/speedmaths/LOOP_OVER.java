package com.methaneblue.speedmaths;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LOOP_OVER extends AppCompatActivity {

    Intent myIntent;

    private EditText inputText;
    private TextView msgV;
    private TextView correctV;
    private int answer, tmp;
    private Button checkB;
    private String userAns;
    private StrengthUpdater strengthUpdate;

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

        strengthUpdate = new StrengthUpdater(LOOP_OVER.this);


        GameSettings.CurrentTimeScore=0;
        checkB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAns = inputText.getText().toString();
                checkB.setVisibility(View.GONE);
                if( inputText.length() <= 0){
                    Toast.makeText(LOOP_OVER.this, "Please Enter your answer!", Toast.LENGTH_SHORT).show();
                }else if(answer == Integer.parseInt(inputText.getText().toString()) ){
                    msgV.setText("I can just say, You are Awesome!");

                }else {
                    msgV.setText("That's not what Ramanujan will answer!");
                    correctV.setText("Answer : "+Integer.toString(answer));
                    correctV.setVisibility(View.VISIBLE);
                }
                strengthUpdate.UpdateStrength();
                msgV.setVisibility(View.VISIBLE);

            }
        });
    }
}
