package com.methaneblue.speedmaths;

/**
 * Created by user on 25-Jun-16.
 */
public final class GameSettings {

    public static int TimeMax;
    public static int RESISTANCE;
    public static int QUE_TOTAL;

    public static int ADD_LOW;
    public static int ADD_HIGH;
    public static int MUL_LOW;
    public static int MUL_HIGH;

    public static int ADD_STRENGTH;
    public static int SUB_STRENGTH;
    public static int MUL_STRENGTH;
    public static int DIV_STRENGTH;

    public static int D_LOW;
    public static int D_HIGH;
    public static int POISON_FOOD;
    public static String MY_AD_UNIT_ID = "TBA";

    public static void init(int level){

        if( level == 0){ // testing way
            RESISTANCE = 1;
            ADD_LOW = 1;
            ADD_HIGH = 10;
            MUL_LOW = 1;
            MUL_HIGH = 10;
            QUE_TOTAL = 5;
            TimeMax = 11000;
        }else if (level == 1){
            RESISTANCE = 2;
            ADD_LOW = 10;
            ADD_HIGH = 100;
            MUL_LOW = 10;
            MUL_HIGH = 100;
            QUE_TOTAL = 20;
            TimeMax = 11000;
        }else if (level == 2){
            RESISTANCE = 3;
            ADD_LOW = 100;
            ADD_HIGH = 1000;
            MUL_LOW = 100;
            MUL_HIGH = 1000;
            QUE_TOTAL = 30;
            TimeMax = 11000;
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
