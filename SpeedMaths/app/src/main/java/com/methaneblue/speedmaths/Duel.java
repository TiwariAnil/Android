package com.methaneblue.speedmaths;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class Duel extends Activity {

    private int op1, tempNum, Divident;
    private int [] myArray = new int[4];

    private int result;

    //    private String [] Ans = new String[2];
    private String Ans;

    private String [] CorrectAns = new String[2];
    //    private String [] Que= new String[2];
    private String Que;
    private int [] score = new int[2];

    private TextView [] opQue = new TextView[2];

    private Button[][] opBtn = new Button[2][4];

    PrefManager prefManager;
    private SharedPreferences SP;

    private int MagicCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_duel);
        SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        MagicCounter = 0;
//        prefManager = new PrefManager(this);

//        GameSettings.init(prefManager.getDuelSTRENGTH());

//        if (Build.VERSION.SDK_INT >= 21) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        }

        score[0] = 0;
        score[1] = 0;

        opBtn[0][0] = (Button) findViewById(R.id.opt1Btn1);
        opBtn[0][1] = (Button) findViewById(R.id.opt1Btn2);
        opBtn[0][2] = (Button) findViewById(R.id.opt1Btn3);
        opBtn[0][3] = (Button) findViewById(R.id.opt1Btn4);

        opBtn[1][0] = (Button) findViewById(R.id.opt2Btn1);
        opBtn[1][1] = (Button) findViewById(R.id.opt2Btn2);
        opBtn[1][2] = (Button) findViewById(R.id.opt2Btn3);
        opBtn[1][3] = (Button) findViewById(R.id.opt2Btn4);

        opQue[0] = (TextView) findViewById(R.id.opt1Que);
        opQue[1] = (TextView) findViewById(R.id.opt2Que);

        genNextSet(0);
        genNextSet(1);

        opBtn[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ans = opBtn[0][0].getText().toString();
                if (Ans.equalsIgnoreCase(CorrectAns[0])) {
                    score[0]++;
//                    opBtn[0][0].setBackgroundColor(0x00FF00);

                }else{
                    score[0]--;
//                    opBtn[0][0].setBackgroundColor(0xFF3300);
                }
                genNextSet(0);
            }
        });
        opBtn[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ans = opBtn[0][1].getText().toString();
                if (Ans.equalsIgnoreCase(CorrectAns[0])) {
                    score[0]++;
//                    opBtn[0][1].setBackgroundColor(0x00FF00);

                }else{
                    score[0]--;
//                    opBtn[0][1].setBackgroundColor(0xFF3300);
                }
                genNextSet(0);
            }
        });
        opBtn[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ans = opBtn[0][2].getText().toString();
                if (Ans.equalsIgnoreCase(CorrectAns[0])) {
                    score[0]++;
//                    opBtn[0][2].setBackgroundColor(0x00FF00);
                }else{
                    score[0]--;
//                    opBtn[0][2].setBackgroundColor(0xFF3300);
                }
                genNextSet(0);
            }
        });
        opBtn[0][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ans = opBtn[0][3].getText().toString();
                if (Ans.equalsIgnoreCase(CorrectAns[0])) {
                    score[0]++;
//                    opBtn[0][2].setBackgroundColor(0x00FF00);
                }else{
                    score[0]--;
//                    opBtn[0][2].setBackgroundColor(0xFF3300);
                }
                genNextSet(0);
            }
        });
        opBtn[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ans = opBtn[1][0].getText().toString();
                if (Ans.equalsIgnoreCase(CorrectAns[1])) {
                    score[1]++;
//                    opBtn[1][0].setBackgroundColor(0x00FF00);
                }else{
                    score[1]--;
//                    opBtn[1][0].setBackgroundColor(0xFF3300);
                }
                genNextSet(1);
            }
        });
        opBtn[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ans = opBtn[1][1].getText().toString();
                if (Ans.equalsIgnoreCase(CorrectAns[1])) {
                    score[1]++;
//                    opBtn[1][1].setBackgroundColor(0x00FF00);
                }else{
                    score[1]--;
//                    opBtn[1][1].setBackgroundColor(0xFF3300);
                }
                genNextSet(1);
            }
        });
        opBtn[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ans = opBtn[1][2].getText().toString();
                if (Ans.equalsIgnoreCase(CorrectAns[1])) {
                    score[1]++;
//                    opBtn[1][2].setBackgroundColor(0x00FF00);
                }else{
                    score[1]--;
//                    opBtn[1][2].setBackgroundColor(0xFF3300);
                }
                genNextSet(1);
            }
        });
        opBtn[1][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ans = opBtn[1][3].getText().toString();
                if (Ans.equalsIgnoreCase(CorrectAns[1])) {
                    score[1]++;
//                    opBtn[1][3].setBackgroundColor(0x00FF00);
                }else{
                    score[1]--;
//                    opBtn[1][3].setBackgroundColor(0xFF3300);
                }
                genNextSet(1);
            }
        });

//        Toast.makeText(Mixed.this, "Your score = "+Integer.toString(score), Toast.LENGTH_LONG).show();
    }

    private void genNextSet(int OP) {

        if(score[OP] == GameSettings.QUE_TOTAL_DUEL){
            Intent myIntent = new Intent(Duel.this, GAME_OVER_DUEL.class);
            myIntent.putExtra("score0",score[0]);
            myIntent.putExtra("score1",score[1]);
            startActivity(myIntent);
            finish();
        }

        gen4variables();

        if (op1 == 1) {
            //  (a * b) - c + d
            Que = "("+Integer.toString(myArray[0]) + " x " + Integer.toString(myArray[1])+") - "+Integer.toString(myArray[2])+" + "+Integer.toString(myArray[3]);
            result = (myArray[0] * myArray[1]) - myArray[2] + myArray[3];

        } else if (op1 == 2) {
            // (a / b) + d - c
            Divident = myArray[0] * myArray[1];
            Que = "("+Integer.toString(Divident) + " / " + Integer.toString(myArray[1])+") + "+Integer.toString(myArray[3])+" - "+Integer.toString(myArray[2]);
            result = (myArray[0]) - myArray[2] + myArray[3];

        } else if (op1 == 3){
            // ((a / b) * c) - d + e
            Random r = new Random();
            tempNum = r.nextInt(GameSettings.MUL_HIGH - GameSettings.MUL_LOW + 1) + GameSettings.MUL_LOW;
            Divident = tempNum * myArray[1];
            Que = "(("+Integer.toString(Divident) + " / " + Integer.toString(tempNum)+") * "+Integer.toString(myArray[0])+") - "+Integer.toString(myArray[2])+" + "+Integer.toString(myArray[3]);
            result = (myArray[1] * myArray[0]) - myArray[2] + myArray[3];

        }else{
            // a + b - c
            Que = Integer.toString(myArray[3]) + " + " + Integer.toString(myArray[2])+" - "+Integer.toString(myArray[1]);
            result = (myArray[3] + myArray[2]) - myArray[1];
        }
        opQue[OP].setText(Que);

        CorrectAns[OP] = Integer.toString(result);
        setOptions(OP);

    }
    void gen4variables(){
        Random r = new Random();
        myArray[0] = r.nextInt(GameSettings.MUL_HIGH - GameSettings.MUL_LOW + 1) + GameSettings.MUL_LOW;
        myArray[1] = r.nextInt(GameSettings.MUL_HIGH - GameSettings.MUL_LOW + 1) + GameSettings.MUL_LOW;
        myArray[2] = r.nextInt(GameSettings.MUL_HIGH - GameSettings.MUL_LOW + 1) + GameSettings.MUL_LOW;
        myArray[3] = r.nextInt(GameSettings.MUL_HIGH - GameSettings.MUL_LOW + 1) + GameSettings.MUL_LOW;
        op1 = r.nextInt(4);
        Arrays.sort(myArray);
    }

    void setOptions(int OP){

        Random r = new Random();
        op1 = r.nextInt(4);

        if(Integer.parseInt(SP.getString("Magic", "0").toString())==1 && OP==0){
            //Cheat

            if (MagicCounter == 0) {
                opBtn[OP][3].setText(CorrectAns[OP]);
                opBtn[OP][2].setText(Integer.toString(result - 2));
                opBtn[OP][1].setText(Integer.toString(result + 3));
                opBtn[OP][0].setText(Integer.toString(result + 4));

            } else if (MagicCounter == 1) {
                opBtn[OP][0].setText(CorrectAns[OP]);
                opBtn[OP][1].setText(Integer.toString(result - 2));
                opBtn[OP][2].setText(Integer.toString(result + 3));
                opBtn[OP][3].setText(Integer.toString(result + 4));

            } else if (MagicCounter == 2) {
                opBtn[OP][2].setText(CorrectAns[OP]);
                opBtn[OP][0].setText(Integer.toString(result - 2));
                opBtn[OP][3].setText(Integer.toString(result + 3));
                opBtn[OP][1].setText(Integer.toString(result + 4));

            } else {
                opBtn[OP][1].setText(CorrectAns[OP]);
                opBtn[OP][3].setText(Integer.toString(result - 2));
                opBtn[OP][0].setText(Integer.toString(result + 3));
                opBtn[OP][2].setText(Integer.toString(result + 4));
            }
            MagicCounter++;
            MagicCounter = MagicCounter%4;


        }else {
            if (op1 == 0) {
                opBtn[OP][3].setText(CorrectAns[OP]);
                opBtn[OP][2].setText(Integer.toString(result - 2));
                opBtn[OP][1].setText(Integer.toString(result + 3));
                opBtn[OP][0].setText(Integer.toString(result + 4));

            } else if (op1 == 1) {
                opBtn[OP][0].setText(CorrectAns[OP]);
                opBtn[OP][1].setText(Integer.toString(result - 2));
                opBtn[OP][2].setText(Integer.toString(result + 3));
                opBtn[OP][3].setText(Integer.toString(result + 4));

            } else if (op1 == 2) {
                opBtn[OP][2].setText(CorrectAns[OP]);
                opBtn[OP][0].setText(Integer.toString(result - 2));
                opBtn[OP][3].setText(Integer.toString(result + 3));
                opBtn[OP][1].setText(Integer.toString(result + 4));

            } else {
                opBtn[OP][1].setText(CorrectAns[OP]);
                opBtn[OP][3].setText(Integer.toString(result - 2));
                opBtn[OP][0].setText(Integer.toString(result + 3));
                opBtn[OP][2].setText(Integer.toString(result + 4));
            }
        }

    }
}