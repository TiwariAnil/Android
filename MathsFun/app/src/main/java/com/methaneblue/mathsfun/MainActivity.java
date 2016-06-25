package com.methaneblue.mathsfun;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
//import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    //ui items
    private Button playBtn, helpBtn, highBtn;
    //level names
    String[] levelNames = {"Easy", "Medium", "Hard"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //retrieve references
        playBtn = (Button)findViewById(R.id.play_btn);
        helpBtn = (Button)findViewById(R.id.help_btn);
        highBtn = (Button)findViewById(R.id.high_btn);

        //listen for clicks

        playBtn.setOnClickListener(MainActivity.this);
        helpBtn.setOnClickListener(MainActivity.this);
        highBtn.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.play_btn){
            //play button
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Choose a level")
                    .setSingleChoiceItems(levelNames, 0, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            //start gameplay
                            startPlay(which);
                        }
                    });
            AlertDialog ad = builder.create();
            ad.show();
        }
        else if(view.getId()==R.id.help_btn){
            //how to play button
            Intent helpIntent = new Intent(this, HowToPlay.class);
            this.startActivity(helpIntent);
        }
        else if(view.getId()==R.id.high_btn){
            //high scores button
            Intent highIntent = new Intent(this, HighScores.class);
            this.startActivity(highIntent);
        }
    }

    private void startPlay(int chosenLevel){
        //start gameplay
        Intent playIntent = new Intent(this, PlayGame.class);
        playIntent.putExtra("level", chosenLevel);
        this.startActivity(playIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
