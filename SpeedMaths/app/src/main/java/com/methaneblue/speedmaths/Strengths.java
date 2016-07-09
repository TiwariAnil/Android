package com.methaneblue.speedmaths;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.CircleProgress;

public class Strengths extends AppCompatActivity {

    private ProgressBar percentBar, addBar, mulBar, mixedBar, loopBar;
    private CircleProgress CpercentBar, CaddBar, CmulBar, CmixedBar, CloopBar;
    private CircleProgress circleProgress;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();



    private ProgressUpdater percentP, addP, mulP, mixedP, loopP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_strengths);
        setContentView(R.layout.activity_strengths1);

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

        percentP = new ProgressUpdater(percentBar,CpercentBar, 90, 100);
        addP = new ProgressUpdater(addBar, CaddBar,90, 100);
        mulP = new ProgressUpdater(mulBar, CmulBar,30, 100);
        mixedP = new ProgressUpdater(mixedBar, CmixedBar, 60, 100);
        loopP = new ProgressUpdater(loopBar,CloopBar, 45, 100);


        percentP.UpdateProgressC();
        addP.UpdateProgressC();
        mulP.UpdateProgressC();
        mixedP.UpdateProgressC();
        loopP.UpdateProgressC();
    }
}
