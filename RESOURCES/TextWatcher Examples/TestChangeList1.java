package com.methaneblue.speedmaths;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by user on 27-Jun-16.
 */
public class TestChangeList1 extends AppCompatActivity {

        private EditText Field1;
        private EditText Field2;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_change);


            Field1 = (EditText)findViewById(R.id.field1);
            Field2 = (EditText)findViewById(R.id.field2);
            Field1.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {}

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                    if(s.length() != 0)
                        Field2.setText("");
                }
            });

            Field2.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {}

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                    if(s.length() != 0)
                        Field1.setText("");
                }
            });


        }
    }
