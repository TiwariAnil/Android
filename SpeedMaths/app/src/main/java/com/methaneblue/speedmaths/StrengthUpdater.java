package com.methaneblue.speedmaths;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;
import android.provider.Settings.Secure;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Created by user on 09-Jul-16.
 */
public class StrengthUpdater {


    class USER {
        private String userid;
        private int score;

        // constructor
        public USER(String userid, int score) {
            this.userid = userid;
            this.score = score;
        }};

    private PrefManager prefManager;
    private SharedPreferences SP;
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;
    private int type, score;
    private Context myContext;
    private String android_id;
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
        editor = settings.edit();

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

        CalculatePercentile();
    }

    void CalculatePercentile(){

        android_id = Secure.getString(myContext.getContentResolver(),Secure.ANDROID_ID);
        Toast.makeText(myContext, "Your Device ID: "+android_id, Toast.LENGTH_SHORT).show();

        final Toast toastMessage1 = Toast.makeText(myContext, "I am the toast!", Toast.LENGTH_LONG );
        final int[] Percent = new int[1];

        float Currentadd = (float) SP.getFloat("addSTRENGTH", 1);
        float Currentmul = (float) SP.getFloat("mulSTRENGTH", 1);
        float Currentmixed = (float) SP.getFloat("mixedSTRENGTH", 1);
        float Currentloop = (float) SP.getFloat("loopSTRENGTH", 1);

        int TotalScore = (int) (Currentadd + Currentmul + Currentmixed + Currentloop);

        // userid = android_id ; score = TotalScore;

        USER obj = new USER(android_id, TotalScore);

        Gson gson = new Gson();
        final String jsonInString = gson.toJson(obj);


        RequestQueue queue = Volley.newRequestQueue(myContext);
        StringRequest req = new StringRequest(Request.Method.POST, GameSettings.SERVER,  new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                toastMessage1.setText("Response is: "+ response);
                Percent[0] = Integer.parseInt(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                toastMessage1.setText("That didn't work!");
            }
        }) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                return jsonInString.getBytes();
            }
            @Override
            public String getBodyContentType(){
                return "application/json";
            }
        };

        // Add the request to the RequestQueue.
        queue.add(req);
        toastMessage1.show();

//        Insert / Update in Table USER , android_id and TotalScore.
//        Get the Rank.
//        Find total number of Users,
//
//        float Percentile = Rank/TotalNumber of users;
//
        editor.putFloat("percentSTRENGTH", Percent[0]);
        editor.commit();
    }

}
