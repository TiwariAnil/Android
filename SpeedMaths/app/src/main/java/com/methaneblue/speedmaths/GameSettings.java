package com.methaneblue.speedmaths;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by user on 25-Jun-16.
 */
public final class GameSettings extends Application {

    public static int TimeMax;
    public static int RESISTANCE;
    public static int QUE_TOTAL;
    public static int QUE_TOTAL_DUEL = 10;
    public static int QUE_TOTAL_PRETEST = 5;
    public static int TIME_PRETEST = 11000;

    public static int ADD_LOW;
    public static int ADD_HIGH;
    public static int MUL_LOW;
    public static int MUL_HIGH;


    public static String SERVER = "http://164.99.140.98:8080/GetPer";
//    public static String SERVER = "http://192.168.1.9:8080/GetPer";

    public static int winQuotes = 26;
    public static int loosQuotes = 25;
    public static int tipQuotes = 11;

    public static int PreScore;
    public static int PreTime;

    public static int CurrentScore;
    public static int CurrentTimeLimit;
    public static int CurrentTimeScore;
    public static int CurrentLevel;
    public static int CurrentFinalScore;
    public static int CurrentTotalScore;
    public static int CurrentType;

    public static void ComputeScore() {

        int total = QUE_TOTAL * CurrentLevel;

        // Consider TIME, For each QUE, if you solve under Half time, you will get 1 Extra point.
        total = total + (QUE_TOTAL);
        CurrentTotalScore = total;

        CurrentFinalScore = CurrentScore * CurrentLevel;
        CurrentFinalScore = CurrentFinalScore + CurrentTimeScore;

    }

    public static int getRandom(int Low, int High) {
        Random r = new Random();
        int num1 = r.nextInt(High - Low + 1) + Low;

        return num1;

    }

    public static void init(int level) {

        // Testing LEVEL
        if (level == -1) {
            RESISTANCE = 1;
            ADD_LOW = 1;
            ADD_HIGH = 10;
            MUL_LOW = 1;
            MUL_HIGH = 10;
            QUE_TOTAL = 3;
            TimeMax = 6000;

            //Loop;
            CurrentTotalScore = 10;

        }
        //LEVEL 1
        if (level == 1) {
            RESISTANCE = 1;
            ADD_LOW = 1;
            ADD_HIGH = 10;
            MUL_LOW = 1;
            MUL_HIGH = 10;
            QUE_TOTAL = 5;
            TimeMax = 6000;
            CurrentTotalScore = 10;

        } else if (level == 2) {
            RESISTANCE = 1;
            ADD_LOW = 1;
            ADD_HIGH = 10;
            MUL_LOW = 1;
            MUL_HIGH = 10;
            QUE_TOTAL = 20;
            TimeMax = 6000;
            CurrentTotalScore = 20;

        } else if (level == 3) {
            RESISTANCE = 2;
            ADD_LOW = 10;
            ADD_HIGH = 100;
            MUL_LOW = 1;
            MUL_HIGH = 10;
            QUE_TOTAL = 10;
            TimeMax = 11000;
            CurrentTotalScore = 30;
        } else if (level == 4) {
            RESISTANCE = 2;
            ADD_LOW = 10;
            ADD_HIGH = 100;
            MUL_LOW = 10;
            MUL_HIGH = 100;
            QUE_TOTAL = 20;
            TimeMax = 6000;
            CurrentTotalScore = 40;
        } else if (level == 5) {
            RESISTANCE = 3;
            ADD_LOW = 100;
            ADD_HIGH = 1000;
            MUL_LOW = 1;
            MUL_HIGH = 10;
            QUE_TOTAL = 10;
            TimeMax = 11000;
            CurrentTotalScore = 50;
        } else if (level == 6) {
            RESISTANCE = 3;
            ADD_LOW = 100;
            ADD_HIGH = 1000;
            MUL_LOW = 10;
            MUL_HIGH = 100;
            QUE_TOTAL = 20;
            TimeMax = 6000;
            CurrentTotalScore = 60;
        }

        CurrentLevel = level;
        CurrentTimeLimit = TimeMax / 2000;
    }

    public static int myMax(int x, int y) {
        if (x > y)
            return x;
        return y;
    }

    public static int myMin(int x, int y) {
        if (x > y)
            return y;
        return x;
    }
}
