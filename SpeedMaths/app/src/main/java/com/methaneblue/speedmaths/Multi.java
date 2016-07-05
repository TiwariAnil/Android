package com.methaneblue.speedmaths;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Multi extends Activity {


    private int num1, num2, op1, tempNum;
    private String Que;
    private String Ans, CorrectAns;
    private TextView QueView, AnsView, TimerField, ScoreView;
    private int result;
    private int score, total;
    private CountDownTimer Ctimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mul);

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        Toast.makeText(Multi.this, "Game Level : " + SP.getString("mulType", "1").toString(), Toast.LENGTH_SHORT).show();

        score = 0;
        total = 0;

        AnsView = (EditText) findViewById(R.id.numberInput);
        TimerField = (TextView) findViewById(R.id.timerView);
        ScoreView = (TextView) findViewById(R.id.scoreView);

        genNextSet();

        AnsView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

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
//        Toast.makeText(Add.this, "Your score = "+Integer.toString(score), Toast.LENGTH_LONG).show();
    }

    private void genNextSet() {
        AnsView.setText("");
        ScoreView.setText(Integer.toString(score) + "/" + Integer.toString(total));
        if(total == GameSettings.QUE_TOTAL){
            Intent myIntent = new Intent(Multi.this, GAME_OVER.class);
            myIntent.putExtra("score",score);
            myIntent.putExtra("type",1);
            startActivity(myIntent);
            finish();
        }
        total = total+1;

        Random r = new Random();
        num1 = r.nextInt(GameSettings.MUL_HIGH - GameSettings.MUL_LOW + 1) + GameSettings.MUL_LOW;
        num2 = r.nextInt(GameSettings.MUL_HIGH - GameSettings.MUL_LOW + 1) + GameSettings.MUL_LOW;
        op1 = r.nextInt(2);
        QueView = (TextView) findViewById(R.id.addQue);

        // num1 should be >>> num2
        tempNum = GameSettings.myMax(num1, num2);
        num2 = GameSettings.myMin(num1, num2);
        num1 = tempNum;

        if (op1 == 1) {
            // Do the Multiplication
            Que = Integer.toString(num1) + " x " + Integer.toString(num2);
            result = num1 * num2;

        } else {
            // Do the Division
            int Divident = num1 * num2;
            Que = Integer.toString(Divident) + " / " + Integer.toString(num1);
            result = num2;
        }
        QueView.setText(Que);
        CorrectAns = Integer.toString(result);

        Ctimer = new CountDownTimer(GameSettings.TimeMax, 1000) {

            public void onTick(long millisUntilFinished) {
                TimerField.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                genNextSet();
            }
        }.start();
    }
}