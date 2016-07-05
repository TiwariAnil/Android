package com.methaneblue.speedmaths;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.CircleProgress;

public class Loop extends Activity {

    private ProgressBar progressBar;
    private CircleProgress circleProgress;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        circleProgress = (CircleProgress) findViewById(R.id.circle_progress);
        textView = (TextView) findViewById(R.id.textView1);
        progressBar.setScaleY(3f);
        // Start long running operation in a background thread

//        for(int i=0; i<5; i++)
            Progress(5);

    }

    public void Progress(final int numberOfRuns){
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            circleProgress.setProgress(progressStatus);
                            progressBar.setProgress(progressStatus);
                            textView.setText(progressStatus+"/"+progressBar.getMax());
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        //Just to display the progress slowly
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                progressStatus = 0;
                Progress(numberOfRuns - 1);
            }
        }).start();
    }
}
