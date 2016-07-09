package com.methaneblue.speedmaths;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 25-Jun-16.
 */
public final class GameSettings extends Application {

    public static int TimeMax;
    public static int RESISTANCE;
    public static int QUE_TOTAL;
    public static int QUE_TOTAL_DUEL=10;
    public static int QUE_TOTAL_PRETEST=5;
    public static int TIME_PRETEST = 11000;

    public static int ADD_LOW;
    public static int ADD_HIGH;
    public static int MUL_LOW;
    public static int MUL_HIGH;

    public static int ADD_STRENGTH;
    public static int SUB_STRENGTH;
    public static int MUL_STRENGTH;
    public static int DIV_STRENGTH;


    public static int PreScore;
    public static int PreTime;

    public static void init(int level){
        // Testing LEVEL
        if( level == -1){
            RESISTANCE = 1;
            ADD_LOW = 1;
            ADD_HIGH = 10;
            MUL_LOW = 1;
            MUL_HIGH = 10;
            QUE_TOTAL = 3;
            TimeMax = 11000;
        }
        //LEVEL 1
        if( level == 1){
            RESISTANCE = 1;
            ADD_LOW = 1;
            ADD_HIGH = 10;
            MUL_LOW = 1;
            MUL_HIGH = 10;
            QUE_TOTAL = 10;
            TimeMax = 11000;
        }else if( level == 2) {
            RESISTANCE = 1;
            ADD_LOW = 1;
            ADD_HIGH = 10;
            MUL_LOW = 1;
            MUL_HIGH = 10;
            QUE_TOTAL = 20;
            TimeMax = 6000;
        }else if (level == 3){
            RESISTANCE = 2;
            ADD_LOW = 10;
            ADD_HIGH = 100;
            MUL_LOW = 10;
            MUL_HIGH = 100;
            QUE_TOTAL = 10;
            TimeMax = 11000;
        }else if (level == 4){
            RESISTANCE = 2;
            ADD_LOW = 10;
            ADD_HIGH = 100;
            MUL_LOW = 10;
            MUL_HIGH = 100;
            QUE_TOTAL = 20;
            TimeMax = 6000;
        }else if (level == 5){
            RESISTANCE = 3;
            ADD_LOW = 100;
            ADD_HIGH = 1000;
            MUL_LOW = 10;
            MUL_HIGH = 100;
            QUE_TOTAL = 10;
            TimeMax = 11000;
        }else if (level == 6){
            RESISTANCE = 3;
            ADD_LOW = 100;
            ADD_HIGH = 1000;
            MUL_LOW = 10;
            MUL_HIGH = 100;
            QUE_TOTAL = 20;
            TimeMax = 6000;
        }
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
