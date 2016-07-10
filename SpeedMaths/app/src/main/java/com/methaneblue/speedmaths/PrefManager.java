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
    private static final String addSTRENGTH = "addSTRENGTH"; //ADD
    private static final String mulSTRENGTH = "mulSTRENGTH"; //MULTIPLY
    private static final String mixedSTRENGTH = "mixedSTRENGTH"; //EQUATIONs
    private static final String loopSTRENGTH = "loopSTRENGTH";  // MEMORY
    private static final String duelSTRENGTH = "duelSTRENGTH"; // ANYTHING
    private static final String speedSTRENGTH = "speedSTRENGTH"; //
    private static final String accuracySTRENGTH = "accuracySTRENGTH";
    private static final String percentSTRENGTH = "percentSTRENGTH";

    private static final String LEVEL = "LEVEL";

    // Constructor
    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public Float getAddSTRENGTH() {
        return pref.getFloat(addSTRENGTH, 1);
    }

    public Float getMulSTRENGTH() {
        return pref.getFloat(mulSTRENGTH, 1);
    }

    public Float getMixedSTRENGTH() {
        return pref.getFloat(mixedSTRENGTH, 1);
    }

    public Float getLoopSTRENGTH() {return pref.getFloat(loopSTRENGTH, 1); }

    public Float getDuelSTRENGTH() {return pref.getFloat(duelSTRENGTH, 1); }

    public Float getSpeedSTRENGTH() {
        return pref.getFloat(speedSTRENGTH, 1);
    }

    public Float getAccuracySTRENGTH() {
        return pref.getFloat(accuracySTRENGTH, 1);
    }
    public Float getPercentSTRENGTH() {
        return pref.getFloat(percentSTRENGTH, 1);
    }

    public void setAddSTRENGTH(Float level) {
        editor.putFloat(addSTRENGTH, level);
        editor.commit();
    }

    public void setMulSTRENGTH(Float level) {
        editor.putFloat(mulSTRENGTH, level);
        editor.commit();
    }

    public void setMixedSTRENGTH(Float level) {
        editor.putFloat(mixedSTRENGTH, level);
        editor.commit();
    }

    public void setLoopSTRENGTH(Float level){
        editor.putFloat(loopSTRENGTH, level);
        editor.commit();
    }

    public void setDuelSTRENGTH(Float level){
        editor.putFloat(duelSTRENGTH, level);
        editor.commit();
    }

    public void setSpeedSTRENGTH(Float x) {
        editor.putFloat(speedSTRENGTH, x);
        editor.commit();
    }

    public void setAccuracySTRENGTH(Float level) {
        editor.putFloat(accuracySTRENGTH, level);
        editor.commit();
    }

    public void setPercentSTRENGTH(Float level) {
        editor.putFloat(percentSTRENGTH, level);
        editor.commit();
    }

    public int getLEVEL() {
        return pref.getInt(LEVEL, -2);
    }

    public void setLEVEL(int level){
        editor.putInt(LEVEL, level);
        editor.commit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}
