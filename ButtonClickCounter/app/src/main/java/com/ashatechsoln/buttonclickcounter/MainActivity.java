package com.ashatechsoln.buttonclickcounter;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button myButoon;
    private TextView myMessage;
    private int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButoon = (Button) findViewById(R.id.button);
        myMessage = (TextView) findViewById(R.id.textView);

        View.OnClickListener ourOnClickListner = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clickCount = clickCount + 1;
                if(clickCount == 1){
                    myMessage.setText("The total count is "+clickCount+".");
                }else{
                    myMessage.setText("The total counts are "+clickCount+".");
                }
            }
        };

        myButoon.setOnClickListener(ourOnClickListner);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final Toast toastMessage1 = Toast.makeText(this, " FloatingButton pressed"+myMessage.getText(), Toast.LENGTH_LONG );
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                toastMessage1.show();


                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast toastMessage = Toast.makeText(this, "Menu Button Pressed"+myMessage.getText(), Toast.LENGTH_LONG );
            toastMessage.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
