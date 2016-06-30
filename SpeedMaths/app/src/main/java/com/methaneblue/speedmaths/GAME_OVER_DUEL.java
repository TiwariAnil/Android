package com.methaneblue.speedmaths;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GAME_OVER_DUEL extends Activity {

    private RelativeLayout [] opLayout = new RelativeLayout[2];
    private int [] score = new int[2];
    private TextView [] scoreV = new TextView[2];
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__over__duel);

        opLayout[0] = (RelativeLayout) findViewById(R.id.opponentOVER0);
        opLayout[1] = (RelativeLayout) findViewById(R.id.opponentOVER1);

        myIntent = getIntent();
        score[0] = myIntent.getIntExtra("score0",0); // will return "FirstKeyValue"
        score[1] = myIntent.getIntExtra("score1",0); // will return "FirstKeyValue"

        int winner;
        if( score[0] > score[1])
            winner = 0;
        else
            winner = 1;

        opLayout[winner].setBackgroundColor(0x00FF00);

        scoreV[0] = (TextView) findViewById(R.id.op0Score0);
        scoreV[1] = (TextView) findViewById(R.id.op1Score1);

        scoreV[0].setText(Integer.toString(score[0]));
        scoreV[1].setText(Integer.toString(score[1]));

    }
}
