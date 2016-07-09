package com.methaneblue.speedmaths;

import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.CircleProgress;

public class Strengths extends AppCompatActivity {

    private ProgressBar percentBar, addBar, mulBar, mixedBar, loopBar;
    private CircleProgress CpercentBar, CaddBar, CmulBar, CmixedBar, CloopBar;
    private CircleProgress circleProgress;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();
    private SharedPreferences SP;

    private Button PercentileB, AddB, MulB, MixB, LoopB;

//    Handler handler = new Handler();
    private ProgressUpdater percentP, addP, mulP, mixedP, loopP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_strengths);
        setContentView(R.layout.activity_strengths1);

        PercentileB = (Button) findViewById(R.id.PercentileT);
        AddB = (Button) findViewById(R.id.AddT);
        MulB = (Button) findViewById(R.id.MulT);
        MixB = (Button) findViewById(R.id.MixedT);
        LoopB = (Button) findViewById(R.id.LoopT);
        final Toast[] toast = new Toast[1];

        SP = PreferenceManager.getDefaultSharedPreferences(Strengths.this);
        PercentileB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toast[0] = Toast.makeText(Strengths.this, "Coming Soon!", Toast.LENGTH_SHORT);
                toast[0].show();

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

                toast[0] = Toast.makeText(Strengths.this, "Strength : "+(float)SP.getFloat("addSTRENGTH", 1), Toast.LENGTH_SHORT);
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
                toast[0] = Toast.makeText(Strengths.this, "Strength : "+(float)SP.getFloat("mulSTRENGTH", 1), Toast.LENGTH_SHORT);
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
                toast[0] = Toast.makeText(Strengths.this, "Strength : "+(float)SP.getFloat("mixedSTRENGTH", 1), Toast.LENGTH_SHORT);
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
                toast[0] = Toast.makeText(Strengths.this, "Strength : "+(float)SP.getFloat("loopSTRENGTH", 1), Toast.LENGTH_SHORT);
                toast[0].show();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast[0].cancel();
                    }
                }, 1000);
            }
        });
        /*
        percentBar = (ProgressBar) findViewById(R.id.percentBar);
        addBar = (ProgressBar) findViewById(R.id.addBar);
        mulBar = (ProgressBar) findViewById(R.id.mulBar);
        mixedBar = (ProgressBar) findViewById(R.id.mixedBar);
        loopBar = (ProgressBar) findViewById(R.id.loopBar);

        percentBar.setScaleY(3f);
        addBar.setScaleY(3f);
        mixedBar.setScaleY(3f);
        mulBar.setScaleY(3f);
        loopBar.setScaleY(3f);

        percentP = new ProgressUpdater(percentBar, 90, 100);
        addP = new ProgressUpdater(addBar, 90, 100);
        mulP = new ProgressUpdater(mulBar, 90, 100);
        mixedP = new ProgressUpdater(mixedBar, 10, 100);
        loopP = new ProgressUpdater(loopBar, 10, 100);
*/

        CpercentBar = (CircleProgress) findViewById(R.id.percentBar);
        CaddBar = (CircleProgress) findViewById(R.id.addBar);
        CmulBar = (CircleProgress) findViewById(R.id.mulBar);
        CmixedBar = (CircleProgress) findViewById(R.id.mixedBar);
        CloopBar = (CircleProgress) findViewById(R.id.loopBar);

//        percentBar.setScaleY(3f);
//        addBar.setScaleY(3f);
//        mixedBar.setScaleY(3f);
//        mulBar.setScaleY(3f);
//        loopBar.setScaleY(3f);

        SP = PreferenceManager.getDefaultSharedPreferences(this);

        percentP = new ProgressUpdater(percentBar,CpercentBar, 90, 100);
        addP = new ProgressUpdater(addBar, CaddBar,SP.getFloat("addSTRENGTH", 1), 100);
        mulP = new ProgressUpdater(mulBar, CmulBar,SP.getFloat("mulSTRENGTH", 1), 100);
        mixedP = new ProgressUpdater(mixedBar, CmixedBar, SP.getFloat("mixedSTRENGTH", 1), 100);
        loopP = new ProgressUpdater(loopBar,CloopBar, SP.getFloat("loopSTRENGTH", 1), 100);


        percentP.UpdateProgressC();
        addP.UpdateProgressC();
        mulP.UpdateProgressC();
        mixedP.UpdateProgressC();
        loopP.UpdateProgressC();
    }
}
