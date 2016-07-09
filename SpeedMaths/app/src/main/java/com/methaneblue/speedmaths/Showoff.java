package com.methaneblue.speedmaths;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class Showoff extends AppCompatActivity {

    private int op1, tempNum, Divident;
    private int [] myArray = new int[4];

    private int result;

    //    private String [] Ans = new String[2];
    private String Ans;

    private String [] CorrectAns = new String[2];
    //    private String [] Que= new String[2];
    private String Que;
    private int [] score = new int[2];

    private TextView[] opQue = new TextView[2];

    private Button[][] opBtn = new Button[2][4];

    PrefManager prefManager;
    private Button startB, skipB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_showoff);

        setContentView(R.layout.activity_showoff);
        startB = (Button) findViewById(R.id.StartBtn);

        startB.setOnClickListener(new View.OnClickListener() {

            private SharedPreferences settings;
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Showoff.this, Welcome.class);
                GameSettings.PreTime = 0;
                GameSettings.PreScore = 0;

                settings = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor editor = settings.edit();
                SharedPreferences SP;
                SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());


                if(Integer.parseInt(SP.getString("Magic", "0").toString())==0){
                    editor.putString("Magic", "1");
                    editor.commit();
                    startB.setText("Magic is On!");
                    startB.setBackground(getResources().getDrawable(R.color.Green));
                }else {
                    editor.putString("Magic", "0");
                    editor.commit();
                    startB.setText("Magic is Off!");
                    startB.setBackground(getResources().getDrawable(R.color.Pink));
                }

            }
        });
    }
}