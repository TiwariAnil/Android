package com.methaneblue.speedmaths;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class AddActivity extends AppCompatActivity {

    private int num1, num2, op1, tempNum;
    private String Que;
    private String Ans, CorrectAns;
    private TextView QueView, AnsView, TimerField, ScoreView;
    private int result;
    private int score, total;
    private CountDownTimer Ctimer;

    private KeyboardView addV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        score = 0;
        total = 0;

//        addV = (KeyboardView) findViewById(R.id.addkeyview);
        AnsView = (EditText) findViewById(R.id.numberInput);
        TimerField = (TextView) findViewById(R.id.timerView);
        ScoreView = (TextView) findViewById(R.id.scoreView);

        genNextSet();

        AnsView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Ans = AnsView.getText().toString();
                if (Ans.equalsIgnoreCase(CorrectAns)) {
                    score++;
                    Ctimer.cancel();
                    genNextSet();
                }
            }
        });
//        Toast.makeText(AddActivity.this, "Your score = "+Integer.toString(score), Toast.LENGTH_LONG).show();
    }

    private void genNextSet() {
        AnsView.setText("");
        ScoreView.setText(Integer.toString(score) + "/" + Integer.toString(total));
        if(total == GameSettings.QUE_TOTAL){
            Intent myIntent = new Intent(AddActivity.this, GAME_OVER.class);
            myIntent.putExtra("score",score);
            myIntent.putExtra("type",1);
            startActivity(myIntent);
            finish();
        }
        total = total+1;


        Random r = new Random();
        num1 = r.nextInt(GameSettings.ADD_HIGH - GameSettings.ADD_LOW + 1) + GameSettings.ADD_LOW;
        num2 = r.nextInt(GameSettings.ADD_HIGH - GameSettings.ADD_LOW + 1) + GameSettings.ADD_LOW;
        op1 = r.nextInt(2);
        QueView = (TextView) findViewById(R.id.addQue);

        // num1 should be >>> num2
        tempNum = GameSettings.myMax(num1, num2);
        num2 = GameSettings.myMin(num1, num2);
        num1 = tempNum;

        if (op1 == 1) {
            // Do the Addition
            Que = Integer.toString(num1) + " + " + Integer.toString(num2);
            result = num1 + num2;

        } else {
            // Do the Subtraction
            Que = Integer.toString(num1) + " - " + Integer.toString(num2);
            result = num1 - num2;
        }
        QueView.setText(Que);
        CorrectAns = Integer.toString(result);

        Ctimer = new CountDownTimer(GameSettings.TimeMax, 1000) {

            public void onTick(long millisUntilFinished) {
                TimerField.setText("t = " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                genNextSet();
            }
        }.start();

    }
}