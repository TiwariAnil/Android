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
import android.view.KeyEvent;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class Mixed extends Activity {

    private int op1, tempNum, Divident;
    private int [] myArray = new int[4];

    private String Que;
    private String Ans, CorrectAns;
    private TextView QueView, AnsView, TimerField, ScoreView;
    private int result;
    private int score, total;
    private CountDownTimer Ctimer1;

    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mixed);

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        Toast.makeText(Mixed.this, "Game Level : " + SP.getString("mixedType", "1").toString(), Toast.LENGTH_SHORT).show();

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
                    Ctimer1.cancel();
                    genNextSet();
                }
            }
        });
//        Toast.makeText(Mixed.this, "Your score = "+Integer.toString(score), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        Ctimer1.cancel();
        Thread.currentThread().interrupt();
        super.onBackPressed();
        finish();
    }

    private void genNextSet() {

        AnsView.setText("");
        ScoreView.setText(Integer.toString(score) + "/" + Integer.toString(total));
        if(total == GameSettings.QUE_TOTAL){
            Intent myIntent = new Intent(Mixed.this, GAME_OVER.class);
            myIntent.putExtra("score",score);
            myIntent.putExtra("type",1);
//            Ctimer1.cancel();
            startActivity(myIntent);
            finish();
        }
        total = total+1;
        QueView = (TextView) findViewById(R.id.addQue);

        gen4variables();

        if (op1 == 1) {
            //  (a * b) - c + d
            Que = "("+Integer.toString(myArray[0]) + " x " + Integer.toString(myArray[1])+") - "+Integer.toString(myArray[2])+" + "+Integer.toString(myArray[3]);
            result = (myArray[0] * myArray[1]) - myArray[2] + myArray[3];

        } else if (op1 == 2) {
            // (a / b) + d - c
            Divident = myArray[0] * myArray[1];
            Que = "("+Integer.toString(Divident) + " / " + Integer.toString(myArray[1])+") + "+Integer.toString(myArray[3])+" - "+Integer.toString(myArray[2]);
            result = (myArray[0]) - myArray[2] + myArray[3];

        } else if (op1 == 3){
            // ((a / b) * c) - d + e
            Random r = new Random();
            tempNum = r.nextInt(GameSettings.MUL_HIGH - GameSettings.MUL_LOW + 1) + GameSettings.MUL_LOW;
            Divident = tempNum * myArray[1];
            Que = "(("+Integer.toString(Divident) + " / " + Integer.toString(tempNum)+") * "+Integer.toString(myArray[0])+") - "+Integer.toString(myArray[2])+" + "+Integer.toString(myArray[3]);
            result = (myArray[1] * myArray[0]) - myArray[2] + myArray[3];

        }else{
            // a + b - c
            Que = Integer.toString(myArray[3]) + " + " + Integer.toString(myArray[2])+" - "+Integer.toString(myArray[1]);
            result = (myArray[3] + myArray[2]) - myArray[1];
        }
        QueView.setText(Que);
        CorrectAns = Integer.toString(result);

        Ctimer1 = new CountDownTimer(GameSettings.TimeMax, 1000) {

            public void onTick(long millisUntilFinished) {
                TimerField.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                genNextSet();
            }
        }.start();
    }
    void gen4variables(){
        Random r = new Random();
        myArray[0] = r.nextInt(GameSettings.MUL_HIGH - GameSettings.MUL_LOW + 1) + GameSettings.MUL_LOW;
        myArray[1] = r.nextInt(GameSettings.MUL_HIGH - GameSettings.MUL_LOW + 1) + GameSettings.MUL_LOW;
        myArray[2] = r.nextInt(GameSettings.MUL_HIGH - GameSettings.MUL_LOW + 1) + GameSettings.MUL_LOW;
        myArray[3] = r.nextInt(GameSettings.MUL_HIGH - GameSettings.MUL_LOW + 1) + GameSettings.MUL_LOW;
        op1 = r.nextInt(4);
        Arrays.sort(myArray);
    }
}