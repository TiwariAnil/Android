package com.methaneblue.speedmaths;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

/**
 * Created by user on 09-Jul-16.
 */
public class StrengthUpdater {

    private PrefManager prefManager;
    private SharedPreferences SP;
    private SharedPreferences settings;
    private int type, score;
    private Context myContext;

    /*
        ADD : 1
        MUL : 2
        EQU : 3
        MEMO: 4
     */
    //Constructor
    public StrengthUpdater(Context myContext){//int type, int score, Context myContext){
//        this.type = type;
//        this.score = score;
        this.myContext = myContext;
    }

    // Updater Method
    void UpdateStrength(){

        prefManager = new PrefManager(myContext);
        SP = PreferenceManager.getDefaultSharedPreferences(myContext);

        settings = PreferenceManager.getDefaultSharedPreferences(myContext);
        SharedPreferences.Editor editor = settings.edit();

        GameSettings.ComputeScore();

        if( GameSettings.CurrentFinalScore == GameSettings.CurrentTotalScore){
//            Toast.makeText(MainActivity.this, "Setting up Levels for you!", Toast.LENGTH_SHORT).show();
        }

        float levelFactor = (float)GameSettings.CurrentLevel/100;
        float CurrentStrength, NewStrength;

        if(GameSettings.CurrentType == 1){  // Addition

            CurrentStrength = (float)SP.getFloat("addSTRENGTH", 1);
            if (
                (CurrentStrength > 25 && GameSettings.CurrentLevel == 1) ||
                (CurrentStrength > 40 && GameSettings.CurrentLevel == 2) ||
                (CurrentStrength > 50 && GameSettings.CurrentLevel == 3) ||
                (CurrentStrength > 65 && GameSettings.CurrentLevel == 4) ||
                (CurrentStrength > 70 && GameSettings.CurrentLevel == 5)
                ){
                Toast.makeText(myContext, "Great Going, Try increasing the Level", Toast.LENGTH_SHORT).show();
            } else {
                NewStrength = CurrentStrength / 100 + levelFactor * (float) ((float) GameSettings.CurrentFinalScore / (float) GameSettings.CurrentTotalScore);
                NewStrength = NewStrength / (1 + levelFactor);
                NewStrength = NewStrength * 100;
                editor.putFloat("addSTRENGTH", NewStrength);
                editor.commit();
            }
        }else if(GameSettings.CurrentType == 2){ // Multiply
            CurrentStrength = (float) SP.getFloat("mulSTRENGTH", 1);
            if (
                    (CurrentStrength > 25 && GameSettings.CurrentLevel == 1) ||
                    (CurrentStrength > 40 && GameSettings.CurrentLevel == 2) ||
                    (CurrentStrength > 50 && GameSettings.CurrentLevel == 3) ||
                    (CurrentStrength > 65 && GameSettings.CurrentLevel == 4) ||
                    (CurrentStrength > 70 && GameSettings.CurrentLevel == 5)
                    ){
                Toast.makeText(myContext, "Great Going, Try increasing the Level", Toast.LENGTH_SHORT).show();
            } else {

                NewStrength = CurrentStrength / 100 + levelFactor * (float) ((float) GameSettings.CurrentFinalScore / (float) GameSettings.CurrentTotalScore);
                NewStrength = NewStrength / (1 + levelFactor);
                NewStrength = NewStrength * 100;
                editor.putFloat("mulSTRENGTH", NewStrength);
                editor.commit();
            }
        }else if(GameSettings.CurrentType == 3){ // Equation
            CurrentStrength = (float) SP.getFloat("mixedSTRENGTH", 1);
            if (
                    (CurrentStrength > 25 && GameSettings.CurrentLevel == 1) ||
                    (CurrentStrength > 40 && GameSettings.CurrentLevel == 2) ||
                    (CurrentStrength > 50 && GameSettings.CurrentLevel == 3) ||
                    (CurrentStrength > 65 && GameSettings.CurrentLevel == 4) ||
                    (CurrentStrength > 70 && GameSettings.CurrentLevel == 5)
                    ){
                Toast.makeText(myContext, "Great Going, Try increasing the Level", Toast.LENGTH_SHORT).show();
            } else {

                NewStrength = CurrentStrength / 100 + levelFactor * (float) ((float) GameSettings.CurrentFinalScore / (float) GameSettings.CurrentTotalScore);
                NewStrength = NewStrength / (1 + levelFactor);
                NewStrength = NewStrength * 100;
                editor.putFloat("mixedSTRENGTH", NewStrength);
                editor.commit();
            }
        }else if(GameSettings.CurrentType == 4){ // Memory
            CurrentStrength = (float) SP.getFloat("loopSTRENGTH", 1);
            if (
                    (CurrentStrength > 25 && GameSettings.CurrentLevel == 1) ||
                    (CurrentStrength > 40 && GameSettings.CurrentLevel == 2) ||
                    (CurrentStrength > 50 && GameSettings.CurrentLevel == 3) ||
                    (CurrentStrength > 65 && GameSettings.CurrentLevel == 4) ||
                    (CurrentStrength > 70 && GameSettings.CurrentLevel == 5)
                    ){
                Toast.makeText(myContext, "Great Going, Try increasing the Level", Toast.LENGTH_SHORT).show();
            } else {

                NewStrength = CurrentStrength / 100 + levelFactor / 5;
                NewStrength = NewStrength / (1 + levelFactor);
                NewStrength = NewStrength * 100;
                editor.putFloat("loopSTRENGTH", NewStrength);
                editor.commit();
            }
        }
    }
}
