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
import java.util.logging.Handler;

public class Add extends Activity {

    private int num1, num2, op1, tempNum;
    private String Que;
    private String Ans, CorrectAns;
    private TextView QueView, AnsView, TimerField, ScoreView;
    private int result;
    private int score, total;
    private CountDownTimer Ctimer;
    private int CurrTime, totalTime;
    private android.os.Handler handler = new android.os.Handler();

    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add);

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        prefManager = new PrefManager(this);

        final Toast toast = Toast.makeText(Add.this, "Level: "+SP.getString("addType", "1").toString(), Toast.LENGTH_SHORT);
        toast.show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 500);

        totalTime = 0;
        CurrTime = 0;
        score = 0;
        total = 0;

        GameSettings.CurrentTimeScore=0;
        GameSettings.CurrentType = 1;

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
                    if(CurrTime <= GameSettings.CurrentTimeLimit){
                        GameSettings.CurrentTimeScore++;
                    }
                    Ctimer.cancel();
                    genNextSet();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Ctimer.cancel();
        Thread.currentThread().interrupt();
        super.onBackPressed();
        finish();
    }

    private void genNextSet() {
        AnsView.setText("");
        ScoreView.setText(Integer.toString(score) + "/" + Integer.toString(total));
        if(total == GameSettings.QUE_TOTAL){
            Intent myIntent = new Intent(Add.this, GAME_OVER.class);
            GameSettings.CurrentScore = score;
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
                TimerField.setText("" + millisUntilFinished / 1000);
                CurrTime = (GameSettings.TimeMax/1000) - (int) (millisUntilFinished / 1000);
            }

            public void onFinish() {
                CurrTime = 0;
                genNextSet();
            }
        }.start();
    }
}