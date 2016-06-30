package com.methaneblue.speedmaths;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button addBtn;
    private Button mulBtn;
    private Button testBtn;
    private Button loopBtn;
    private Button duelBtn;
    private Button settingBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameSettings.init(0);

        addBtn = (Button) findViewById(R.id.addbutton);
        mulBtn = (Button) findViewById(R.id.mulbutton);
        testBtn = (Button) findViewById(R.id.testbutton);
        loopBtn = (Button) findViewById(R.id.loopbutton);
        duelBtn = (Button) findViewById(R.id.duelbutton);
        settingBtn = (Button) findViewById(R.id.settingsbutton);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivity(i);
            }
        });

        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MulActivity.class);
                startActivity(i);
            }
        });

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Mixedctivity.class);
                startActivity(i);
            }
        });

        loopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TrialRoomActivity.class);
//                Intent i = new Intent(MainActivity.this, LoopActivity.class);
                startActivity(i);
            }
        });

        duelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TrialRoomActivity.class);
                startActivity(i);
            }
        });

        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(i);
            }
        });
    }
}
