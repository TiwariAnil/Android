package com.methaneblue.speedmaths;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class GAME_OVER extends Activity {

    Intent myIntent;

    private TextView msgV;
    private TextView scoreV;
    private float score, total, percent;
    private int type;
    private String[] testArray;
    private StrengthUpdater strengthUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__over);

        msgV = (TextView) findViewById(R.id.msgView);
        scoreV = (TextView) findViewById(R.id.scoreView);

        total = GameSettings.QUE_TOTAL;
        score = GameSettings.CurrentScore;

        percent = score/total;
        percent = percent * 100;

        strengthUpdate = new StrengthUpdater(GAME_OVER.this);
        strengthUpdate.UpdateStrength();

        scoreV.setText(Integer.toString(GameSettings.CurrentFinalScore)+"/"+Integer.toString(GameSettings.CurrentTotalScore));
        if( percent >= 90 ){
            testArray = getResources().getStringArray(R.array.win);
            msgV.setText(testArray[GameSettings.getRandom(1,GameSettings.winQuotes)-1]);

        }else {

            testArray = getResources().getStringArray(R.array.loss);
            msgV.setText(testArray[GameSettings.getRandom(1,GameSettings.loosQuotes)-1]);
        }
    }

    @Override
    public void onBackPressed() {

        Thread.currentThread().interrupt();
        super.onBackPressed();
        finish();
    }
}

