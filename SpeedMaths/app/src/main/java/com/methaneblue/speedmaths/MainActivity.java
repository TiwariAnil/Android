package com.methaneblue.speedmaths;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  {

    private Button addBtn;
    private Button mulBtn;
    private Button mixBtn;
    private Button loopBtn;
    private Button duelBtn;
    private Button settingBtn;

    private PrefManager prefManager;
    private SharedPreferences SP;
    private SharedPreferences settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefManager = new PrefManager(this);
        SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());


//        Toast.makeText(MainActivity.this, "PreScore: " + Integer.toString(GameSettings.PreScore), Toast.LENGTH_SHORT).show();
//        Toast.makeText(MainActivity.this, "PreTime: " + Integer.toString(GameSettings.PreTime), Toast.LENGTH_SHORT).show();


        settings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = settings.edit();

        if (prefManager.getLEVEL() == -2) {
            if (GameSettings.PreScore == 5) {
                if (GameSettings.PreTime < 25) {

                    Toast.makeText(MainActivity.this, "Setting up Levels for you!", Toast.LENGTH_SHORT).show();
                    editor.putString("addType","3");
                    editor.putString("mulType","2");
                    editor.commit();

                }
            } else if (GameSettings.PreScore == 4) {
                if (GameSettings.PreTime < 30) {
                    Toast.makeText(MainActivity.this, "Setting up Levels for you!", Toast.LENGTH_SHORT).show();

                    editor.putString("addType","2");
                    editor.commit();
                }
            } else {
                prefManager.setLEVEL(1);
            }
        } else {
            prefManager.setLEVEL(1);
        }

        addBtn = (Button) findViewById(R.id.addbutton);
        mulBtn = (Button) findViewById(R.id.mulbutton);
        mixBtn = (Button) findViewById(R.id.mixdbutton);
        loopBtn = (Button) findViewById(R.id.loopbutton);
        duelBtn = (Button) findViewById(R.id.duelbutton);
        settingBtn = (Button) findViewById(R.id.settingsbutton);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GameSettings.init(Integer.parseInt(SP.getString("addType", "1").toString()));
                Intent i = new Intent(MainActivity.this, Add.class);
                startActivity(i);
            }
        });

        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GameSettings.init(Integer.parseInt(SP.getString("mulType", "1").toString()));
                Intent i = new Intent(MainActivity.this, Multi.class);
                startActivity(i);
            }
        });

        mixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GameSettings.init(Integer.parseInt(SP.getString("mixedType", "1").toString()));
                Intent i = new Intent(MainActivity.this, Mixed.class);
                startActivity(i);
            }
        });

        loopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GameSettings.init(Integer.parseInt(SP.getString("loopType", "1").toString()));
                Intent i = new Intent(MainActivity.this, Loop.class);
                startActivity(i);
            }
        });

        duelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GameSettings.init(Integer.parseInt(SP.getString("duelType", "1").toString()));
                Intent i = new Intent(MainActivity.this, Duel.class);
                startActivity(i);
            }
        });

        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Settings.class);
                startActivity(i);
            }
        });
    }
}
