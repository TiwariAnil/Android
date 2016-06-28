package com.methaneblue.speedmaths;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GAME_OVER extends AppCompatActivity {

    Intent myIntent;

    private TextView msgV;
    private TextView scoreV;
    private float score;
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__over);

        // Use "type" to update strengths
        myIntent = getIntent(); // gets the previously created intent
        float score = myIntent.getIntExtra("score",0); // will return "FirstKeyValue"
        int type = myIntent.getIntExtra("type", 0);

        msgV = (TextView) findViewById(R.id.msgView);
        scoreV = (TextView) findViewById(R.id.scoreView);

        float total = GameSettings.QUE_TOTAL;

        float percent = score/total;
        percent = percent * 100;
        scoreV.setText(Integer.toString((int)score)+"/"+Integer.toString((int)total));;
        if( percent > 90.0 ){
            msgV.setText("I can just say, You are Awesome!");

        }else if( percent > 60.0 ){
            msgV.setText("Good going, keep crushing it!");
        }else {
            msgV.setText("Don't worry, I am there!");
        }
    }
}
