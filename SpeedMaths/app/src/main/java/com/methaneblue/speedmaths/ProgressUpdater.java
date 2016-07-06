package com.methaneblue.speedmaths;

import android.os.Handler;
import android.widget.ProgressBar;

/**
 * Created by user on 05-Jul-16.
 */
public class ProgressUpdater {

    private ProgressBar Bar;
    private int Strength, maxStrength, progressStatus;
    private Handler handler = new Handler();

    public  ProgressUpdater(ProgressBar Bar, int Strength, int maxStrength){
        this.Bar = Bar;
        this.Strength = Strength;
        this.maxStrength = maxStrength;
        progressStatus = 0;
    }

    public void UpdateProgress(){
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < Strength) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            Bar.setProgress(progressStatus);
//                            textView.setText(progressStatus+"/"+progressBar.getMax());
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        //Just to display the progress slowly
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


}
