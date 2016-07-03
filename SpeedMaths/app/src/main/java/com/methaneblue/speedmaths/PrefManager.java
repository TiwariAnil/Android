package com.methaneblue.speedmaths;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by user on 01-Jul-16.
 * This is our Preference Manger that holds shared preferences
 */
public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "speedmaths-welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    private static final String addSTRENGTH = "addSTRENGTH";
    private static final String mulSTRENGTH = "mulSTRENGTH";
    private static final String mixedSTRENGTH = "mixedSTRENGTH";
    private static final String loopSTRENGTH = "loopSTRENGTH";
    private static final String duelSTRENGTH = "duelSTRENGTH";
    private static final String speedSTRENGTH = "speedSTRENGTH";
    private static final String accuracySTRENGTH = "accuracySTRENGTH";

    private static final String LEVEL = "LEVEL";

    public int getAddSTRENGTH() {
        return pref.getInt(addSTRENGTH, 1);
    }

    public int getMulSTRENGTH() {
        return pref.getInt(mulSTRENGTH, 1);
    }

    public int getMixedSTRENGTH() {
        return pref.getInt(mixedSTRENGTH, 1);
    }

    public int getLoopSTRENGTH() {return pref.getInt(loopSTRENGTH, 1); }

    public int getDuelSTRENGTH() {return pref.getInt(duelSTRENGTH, 1); }

    public int getSpeedSTRENGTH() {
        return pref.getInt(speedSTRENGTH, 1);
    }

    public int getAccuracySTRENGTH() {
        return pref.getInt(accuracySTRENGTH, 1);
    }



    public int getLEVEL() {
        return pref.getInt(LEVEL, -2);
    }


    public void setAddSTRENGTH(int level) {
        editor.putInt(addSTRENGTH, level);
        editor.commit();
    }

    public void setMulSTRENGTH(int level) {
        editor.putInt(mulSTRENGTH, level);
        editor.commit();
    }

    public void setMixedSTRENGTH(int level) {
        editor.putInt(mixedSTRENGTH, level);
        editor.commit();
    }

    public void setLoopSTRENGTH(int level){
        editor.putInt(loopSTRENGTH, level);
        editor.commit();
    }

    public void setDuelSTRENGTH(int level){
        editor.putInt(duelSTRENGTH, level);
        editor.commit();
    }


    public void setSpeedSTRENGTH(int x) {
        editor.putInt(speedSTRENGTH, x);
        editor.commit();
    }

    public void setAccuracySTRENGTH(int level) {
        editor.putInt(accuracySTRENGTH, level);
        editor.commit();
    }

    public void setLEVEL(int level){
        editor.putInt(LEVEL, level);
        editor.commit();
    }


    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }



    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}
