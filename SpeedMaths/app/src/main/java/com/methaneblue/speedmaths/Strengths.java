package com.methaneblue.speedmaths;

import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.*;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.lzyzsd.circleprogress.CircleProgress;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//import org.json.parser;

public class Strengths extends AppCompatActivity {

    private ProgressBar percentBar, addBar, mulBar, mixedBar, loopBar;
    private CircleProgress CpercentBar, CaddBar, CmulBar, CmixedBar, CloopBar;
    private CircleProgress circleProgress;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();
    private SharedPreferences SP;
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;
    private static int Percent;
    private PrefManager prefManager;
    private Button PercentileB, AddB, MulB, MixB, LoopB;

//    Handler handler = new Handler();
    private ProgressUpdater percentP, addP, mulP, mixedP, loopP;
    private String android_id;
    class USER {
        private String userid;
        private String score;

        // constructor
        public USER(String userid, String score) {
            this.userid = userid;
            this.score = score;
        }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_strengths);
        setContentView(R.layout.activity_strengths1);


        prefManager = new PrefManager(Strengths.this);

        PercentileB = (Button) findViewById(R.id.PercentileT);
        AddB = (Button) findViewById(R.id.AddT);
        MulB = (Button) findViewById(R.id.MulT);
        MixB = (Button) findViewById(R.id.MixedT);
        LoopB = (Button) findViewById(R.id.LoopT);
        final Toast[] toast = new Toast[1];

        SP = PreferenceManager.getDefaultSharedPreferences(Strengths.this);
        settings = PreferenceManager.getDefaultSharedPreferences(Strengths.this);
        editor = settings.edit();
        CalculatePercentile();



        PercentileB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toast[0] = Toast.makeText(Strengths.this, "Percentile : "+prefManager.getPerSTRENGTH(), Toast.LENGTH_SHORT);
                toast[0].show();
                percentP.UpdateProgressC();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast[0].cancel();
                    }
                }, 1000);
            }
        });
        AddB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toast[0] = Toast.makeText(Strengths.this, "Strength : "+prefManager.getAddSTRENGTH(), Toast.LENGTH_SHORT);
                toast[0].show();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast[0].cancel();
                    }
                }, 1000);
            }
        });
        MulB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast[0] = Toast.makeText(Strengths.this, "Strength : "+prefManager.getMulSTRENGTH(), Toast.LENGTH_SHORT);
                toast[0].show();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast[0].cancel();
                    }
                }, 1000);
            }
        });
        MixB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast[0] = Toast.makeText(Strengths.this, "Strength : "+prefManager.getMixedSTRENGTH(), Toast.LENGTH_SHORT);
                toast[0].show();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast[0].cancel();
                    }
                }, 1000);
            }
        });
        LoopB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast[0] = Toast.makeText(Strengths.this, "Strength : "+prefManager.getLoopSTRENGTH(), Toast.LENGTH_SHORT);
                toast[0].show();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast[0].cancel();
                    }
                }, 1000);
            }
        });

        CpercentBar = (CircleProgress) findViewById(R.id.percentBar);
        CaddBar = (CircleProgress) findViewById(R.id.addBar);
        CmulBar = (CircleProgress) findViewById(R.id.mulBar);
        CmixedBar = (CircleProgress) findViewById(R.id.mixedBar);
        CloopBar = (CircleProgress) findViewById(R.id.loopBar);

        addP = new ProgressUpdater(addBar, CaddBar,prefManager.getAddSTRENGTH(), 100);
        mulP = new ProgressUpdater(mulBar, CmulBar,prefManager.getMulSTRENGTH(), 100);
        mixedP = new ProgressUpdater(mixedBar, CmixedBar,prefManager.getMixedSTRENGTH(), 100);
        loopP = new ProgressUpdater(loopBar,CloopBar,prefManager.getLoopSTRENGTH(), 100);
        percentP = new ProgressUpdater(percentBar,CpercentBar, prefManager.getPerSTRENGTH(), 100);

        addP.UpdateProgressC();
        mulP.UpdateProgressC();
        mixedP.UpdateProgressC();
        loopP.UpdateProgressC();
        percentP.UpdateProgressC();
    }

    void DisplayRank(){

    }
    void CalculatePercentile(){

        android_id = Settings.Secure.getString(Strengths.this.getContentResolver(), Settings.Secure.ANDROID_ID);
//        Toast.makeText(myContext, "Your Device ID: "+android_id, Toast.LENGTH_SHORT).show();

        final Toast toastMessage1 = Toast.makeText(Strengths.this, "I am the toast!", Toast.LENGTH_LONG );
        Percent=0;

        float Currentadd = prefManager.getAddSTRENGTH();
        float Currentmul = prefManager.getMulSTRENGTH();
        float Currentmixed = prefManager.getMixedSTRENGTH() ;
        float Currentloop = prefManager.getLoopSTRENGTH();

        int TotalScore = (int) (Currentadd + Currentmul + Currentmixed + Currentloop);

        USER obj = new USER(android_id, Integer.toString(TotalScore));

        Gson gson = new Gson();
        final String jsonInString = gson.toJson(obj);


        RequestQueue queue = Volley.newRequestQueue(Strengths.this);
        StringRequest req = new StringRequest(Request.Method.POST, GameSettings.SERVER,  new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                String percentS="0";
                try {
                    JSONObject obj = new JSONObject(response);
                    percentS = obj.getString("ResponsStr");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                String set = "Your rank is 1 out of 1!";
                Percent = Integer.parseInt(percentS);

                prefManager.setPerSTRENGTH((float)Percent);
                Toast.makeText(Strengths.this, "Percent is: : "+Integer.toString(Percent), Toast.LENGTH_SHORT).show();
                Toast.makeText(Strengths.this, "Percentile is: : "+prefManager.getPerSTRENGTH(), Toast.LENGTH_SHORT).show();

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

    }
}
