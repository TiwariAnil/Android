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
//    SharedPreferences.Editor edit;
//    SharedPreferences.OnSharedPreferenceChangeListener mListener;
//    private Context mContext;

//    private MyPreference myPref;

    private SharedPreferences settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mContext = new Settings();

        prefManager = new PrefManager(this);
        SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());


        Toast.makeText(MainActivity.this, "PreScore: " + Integer.toString(GameSettings.PreScore), Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, "PreTime: " + Integer.toString(GameSettings.PreTime), Toast.LENGTH_SHORT).show();


        settings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("addType","6");
        editor.putString("mulType","6");
        editor.putString("mixedType","6");
        editor.commit();

        if (prefManager.getLEVEL() == -2) {
            if (GameSettings.PreScore == 5) {
                if (GameSettings.PreTime < 25) {

                    Toast.makeText(MainActivity.this, "Making addType 3 ", Toast.LENGTH_SHORT).show();
                    prefManager.editor.putString("addType", "3");
                    prefManager.editor.putString("mulType", "2");
                    prefManager.editor.commit();
//                    SP. ("addType", "1");
                    prefManager.setLEVEL(3);
                    prefManager.setAddSTRENGTH(3);
                    prefManager.setMulSTRENGTH(2);
                }
            } else if (GameSettings.PreScore == 4) {
                if (GameSettings.PreTime < 30) {
                    Toast.makeText(MainActivity.this, "Making addType 2 ", Toast.LENGTH_SHORT).show();
                    prefManager.editor.putString("addType", "2");
//                    edit.putInt("mulType", 2);
                    prefManager.editor.commit();
                    prefManager.setLEVEL(2);
                    prefManager.setAddSTRENGTH(2);
                }
            } else {
                prefManager.setLEVEL(1);
            }
        } else {


        }


//        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());


//        String strUserName = SP.getString("username", "NA");
//        boolean bAppUpdates = SP.getBoolean("applicationUpdates", false);
//        String downloadType = SP.getString("downloadType", "1");
//        String addL = SP.getString("addType", "Level 1");



//        prefManager.setMulSTRENGTH(Integer.parseInt(SP.getString("mulType", "1").toString()));
//        prefManager.setDuelSTRENGTH(Integer.parseInt(SP.getString("duelType", "1").toString()));
//        prefManager.setMixedSTRENGTH(Integer.parseInt(SP.getString("mixedType", "1").toString()));
//        prefManager.setLoopSTRENGTH(Integer.parseInt(SP.getString("loopType", "1").toString()));

//        prefManager.setMulSTRENGTH(GameSettings.Mymap.get(SP.getString("mulType", "Level 1")));
//        prefManager.setDuelSTRENGTH(GameSettings.Mymap.get(SP.getString("duelType", "Level 1")));
//        prefManager.setMixedSTRENGTH(GameSettings.Mymap.get(SP.getString("mixedType", "Level 1")));
//        prefManager.setLoopSTRENGTH(GameSettings.Mymap.get(SP.getString("loopType", "Level 1")));


//        int x = prefManager.getAddSTRENGTH();
//        Toast.makeText(MainActivity.this, "Your LEVEL = " + Integer.toString(x), Toast.LENGTH_SHORT).show();
//        Toast.makeText(MainActivity.this, " addLEVEL set is = " + addL, Toast.LENGTH_SHORT).show();
//        Toast.makeText(MainActivity.this, "username = "+strUserName, Toast.LENGTH_SHORT).show();

//        String addSTRENGTH =
//        String mulSTRENGTH =
//        String mixedSTRENGTH =
//        String loopSTRENGTH =
//        String duelSTRENGTH = SP.getString("duelType","Level 1");
//        String duelSTRENGTH = SP.getString("","Level 1");

//        GameSettings.init(prefManager.getLEVEL());

//        Toast.makeText(MainActivity.this, "Pre Test Score = "+Integer.toString(PreScore), Toast.LENGTH_LONG).show();
//        Toast.makeText(MainActivity.this, "Pre Test Time = "+Integer.toString(PreTime), Toast.LENGTH_LONG).show();

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
