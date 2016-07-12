package com.methaneblue.speedmaths;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class PreTest extends Activity {

    private int op1, tempNum, Divident;
    private int[] myArray = new int[4];
    private int result;
    private CountDownTimer Ctimer;
    private String Ans;
    private String CorrectAns;
    private String Que;
    private int score, total;
    private int CurrentTime, totalTime;
    private TextView opQue;
    private TextView TimerView;
    private Button[] opBtn = new Button[4];
    private boolean isRunning = false;
    private Button startB;
    private TextView skipB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_before_test);
        startB = (Button) findViewById(R.id.StartBtn);
        skipB = (TextView) findViewById(R.id.SkipBtn);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        startB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTest();
            }
        });

        skipB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(PreTest.this, Welcome.class);
                GameSettings.PreTime = 0;
                GameSettings.PreScore = 0;

                if(isRunning)
                    Ctimer.cancel();
                startActivity(myIntent);
                finish();
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

    void startTest(){
        setContentView(R.layout.activity_pre_test);

        score = 0;
        totalTime = 0;
        total = 0;

        opBtn[0] = (Button) findViewById(R.id.optBtn1);
        opBtn[1] = (Button) findViewById(R.id.optBtn2);
        opBtn[2] = (Button) findViewById(R.id.optBtn3);
        opBtn[3] = (Button) findViewById(R.id.optBtn4);

        opQue = (TextView) findViewById(R.id.optQue);
        TimerView = (TextView) findViewById(R.id.PretimerView);

        genNextSet();

        opBtn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ans = opBtn[0].getText().toString();
                if (Ans.equalsIgnoreCase(CorrectAns)) {
                    score++;
                    totalTime = totalTime + CurrentTime;
                }
                genNextSet();
            }
        });
        opBtn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ans = opBtn[1].getText().toString();
                if (Ans.equalsIgnoreCase(CorrectAns)) {
                    score++;
                    totalTime = totalTime + CurrentTime;
                }
                genNextSet();
            }
        });
        opBtn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ans = opBtn[2].getText().toString();
                if (Ans.equalsIgnoreCase(CorrectAns)) {
                    score++;
                    totalTime = totalTime + CurrentTime;
                }
                genNextSet();
            }
        });
        opBtn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ans = opBtn[3].getText().toString();
                if (Ans.equalsIgnoreCase(CorrectAns)) {
                    score++;
                    totalTime = totalTime + CurrentTime;
                }
                genNextSet();
            }
        });
//        Toast.makeText(Mixed.this, "Your score = "+Integer.toString(score), Toast.LENGTH_LONG).show();
    }

    private void genNextSet() {

        if (total == GameSettings.QUE_TOTAL_PRETEST) {
            Intent myIntent = new Intent(PreTest.this, Welcome.class);

            GameSettings.PreTime = totalTime;
            GameSettings.PreScore = score;

            if(isRunning)
                Ctimer.cancel();
//            Toast.makeText(PreTest.this, "Intent from PreTest for Welcome", Toast.LENGTH_SHORT).show();
//            Toast.makeText(PreTest.this, "Score: "+Integer.toString(score), Toast.LENGTH_SHORT).show();
//            Toast.makeText(PreTest.this, "Time: "+Integer.toString(totalTime), Toast.LENGTH_SHORT).show();
            startActivity(myIntent);
            finish();
        }
        if( isRunning )
            Ctimer.cancel();
        total++;
        gen4variables();

        if (op1 == 1) {
            //  (a * b) - c + d
            Que = "(" + Integer.toString(myArray[0]) + " x " + Integer.toString(myArray[1]) + ") - " + Integer.toString(myArray[2]) + " + " + Integer.toString(myArray[3]);
            result = (myArray[0] * myArray[1]) - myArray[2] + myArray[3];

        } else if (op1 == 2) {
            // (a / b) + d - c
            Divident = myArray[0] * myArray[1];
            Que = "(" + Integer.toString(Divident) + " / " + Integer.toString(myArray[1]) + ") + " + Integer.toString(myArray[3]) + " - " + Integer.toString(myArray[2]);
            result = (myArray[0]) - myArray[2] + myArray[3];

        } else if (op1 == 3) {
            // ((a / b) * c) - d + e
            Random r = new Random();
            tempNum = r.nextInt(10) + 1;
            Divident = tempNum * myArray[1];
            Que = "((" + Integer.toString(Divident) + " / " + Integer.toString(tempNum) + ") * " + Integer.toString(myArray[0]) + ") - " + Integer.toString(myArray[2]) + " + " + Integer.toString(myArray[3]);
            result = (myArray[1] * myArray[0]) - myArray[2] + myArray[3];

        } else {
            // a + b - c
            Que = Integer.toString(myArray[3]) + " + " + Integer.toString(myArray[2]) + " - " + Integer.toString(myArray[1]);
            result = (myArray[3] + myArray[2]) - myArray[1];
        }
        opQue.setText(Que);
        CorrectAns = Integer.toString(result);
        setOptions();

        Ctimer = new CountDownTimer(GameSettings.TIME_PRETEST, 1000) {

            public void onTick(long millisUntilFinished) {
                TimerView.setText("" + millisUntilFinished / 1000);
                CurrentTime = (GameSettings.TIME_PRETEST/1000)- (int)(millisUntilFinished / 1000);
                isRunning = true;
            }

            public void onFinish() {
                CurrentTime = 0;
                isRunning = false;
                genNextSet();
            }
        }.start();
    }

    void gen4variables() {
        Random r = new Random();
        myArray[0] = r.nextInt(10) + 1;
        myArray[1] = r.nextInt(10) + 1;
        myArray[2] = r.nextInt(10) + 1;
        myArray[3] = r.nextInt(10) + 1;
        op1 = r.nextInt(4);
        Arrays.sort(myArray);
    }

    void setOptions() {

        Random r = new Random();
        op1 = r.nextInt(4);

        if (op1 == 0) {
            opBtn[3].setText(CorrectAns);
            opBtn[2].setText(Integer.toString(result - 1));
            opBtn[1].setText(Integer.toString(result - 3));
            opBtn[0].setText(Integer.toString(result + 4));

        } else if (op1 == 1) {
            opBtn[0].setText(CorrectAns);
            opBtn[1].setText(Integer.toString(result - 2));
            opBtn[2].setText(Integer.toString(result + 1));
            opBtn[3].setText(Integer.toString(result + 4));

        } else if (op1 == 2) {
            opBtn[2].setText(CorrectAns);
            opBtn[0].setText(Integer.toString(result - 2));
            opBtn[3].setText(Integer.toString(result + 3));
            opBtn[1].setText(Integer.toString(result - 3));

        } else {
            opBtn[1].setText(CorrectAns);
            opBtn[3].setText(Integer.toString(result - 2));
            opBtn[0].setText(Integer.toString(result + 3));
            opBtn[2].setText(Integer.toString(result - 1));
        }
    }
}