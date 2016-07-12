package com.methaneblue.speedmaths;

import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.CircleProgress;

/**
 * Created by user on 05-Jul-16.
 */
public class ProgressUpdater {

    private ProgressBar Bar;
    private TextView TextBar;
    private CircleProgress CBar;
    private float Strength, maxStrength, progressStatus;

    private Handler handler = new Handler();

//    public  ProgressUpdater(ProgressBar Bar, CircleProgress CBar, float Strength, float maxStrength){
    public  ProgressUpdater(TextView TextBar, float Strength, float maxStrength){
        this.TextBar = TextBar;
        this.Strength = Strength;
        this.maxStrength = maxStrength;
        progressStatus = 0;
    }


    public void UpdateProgressC(){
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < Strength) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            CBar.setProgress((int)progressStatus);
//                            textView.setText(progressStatus+"/"+progressBar.getMax());
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
            }
        }).start();
    }

    public void UpdateProgressB(){
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < Strength) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            Bar.setProgress((int)progressStatus);
//                            textView.setText(progressStatus+"/"+progressBar.getMax());
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
            }
        }).start();
    }
    public void UpdateProgressT() {
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < Strength) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            TextBar.setText(Integer.toString((int) progressStatus));
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
            }
        }).start();
    }
}
