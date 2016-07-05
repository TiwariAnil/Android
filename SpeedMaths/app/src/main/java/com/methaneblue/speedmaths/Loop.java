package com.methaneblue.speedmaths;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.CircleProgress;

import java.util.Random;

public class Loop extends Activity {

    private ProgressBar progressBar;
    private CircleProgress circleProgress;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();

    private int num1, num2, op1, tempNum;
    private String Que;
    private String Ans, CorrectAns;
    private TextView QueView, AnsView, TimerField, ScoreView;
    private int result;
    private int score, total;
    private int finaAns;
    private int started = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        circleProgress = (CircleProgress) findViewById(R.id.circle_progress);
        textView = (TextView) findViewById(R.id.textView1);
        QueView = (TextView) findViewById(R.id.instruction);

        progressBar.setScaleY(3f);
        // Start long running operation in a background thread
//        Random r = new Random();
//
//        finaAns = r.nextInt(GameSettings.ADD_HIGH - GameSettings.ADD_LOW + 1) + GameSettings.ADD_LOW;
        QueView.setText("Get Ready!");
        Progress(5);

    }

    public void Progress(final int numberOfRuns){
//        QueView.setText(Que);
        if (numberOfRuns == 0){
            Intent myIntent = new Intent(Loop.this, LOOP_OVER.class);
            myIntent.putExtra("answer",finaAns);
            startActivity(myIntent);
            finish();
        }
        new Thread(new Runnable() {

            public void run() {
                genNextSet();
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            circleProgress.setProgress(progressStatus);
                            progressBar.setProgress(progressStatus);
                            textView.setText(progressStatus+"/"+progressBar.getMax());
//                            It works hee as well!!
//                            QueView.setText(Que);
                        }
                    });
                    try {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // TODO Auto-generated method stub

                                QueView.setText(Que);
                            }
                        });
                        // Sleep for 200 milliseconds.
                        //Just to display the progress slowly
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                progressStatus = 0;

                Progress(numberOfRuns - 1);
            }
        }).start();
    }

    private void genNextSet() {

        Random r = new Random();
        num1 = r.nextInt(GameSettings.ADD_HIGH - GameSettings.ADD_LOW + 1) + GameSettings.ADD_LOW;
//        num2 = r.nextInt(GameSettings.ADD_HIGH - GameSettings.ADD_LOW + 1) + GameSettings.ADD_LOW;
        op1 = r.nextInt(3);

        // num1 should be >>> num2
        tempNum = GameSettings.myMax(num1, num2);
        num2 = GameSettings.myMin(num1, num2);
        num1 = tempNum;
        if( started == 0){
            Que = "Start with "+Integer.toString(num1);
            finaAns = num1;
            started = 1;
        }else if (op1 == 1 ) {
            // Do the Addition
            Que = "Add "+Integer.toString(num1);
            finaAns = finaAns + num1;

        } else if (op1 == 2 && num1 < finaAns){
            // Do the Subtraction
            Que = "Subtract "+Integer.toString(num1);
            finaAns = finaAns - num1;
        } else{
            // Do the Multiplication
            Que = "Multiply by "+Integer.toString(num1);
            finaAns = finaAns * num1;
        }
    }
}

