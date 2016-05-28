package com.ashatechsoln.thecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText operand1;
    private EditText operand2;
    private Button btnAddition;
    private Button btnSubtraction;
    private Button btnMultiplication;
    private Button btnDivision;
    private Button btnClear;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operand1 = (EditText) findViewById(R.id.editOperand1);
        operand2 = (EditText) findViewById(R.id.editOperand2);
        btnAddition = (Button) findViewById(R.id.btnAddition);
        btnSubtraction = (Button) findViewById(R.id.btnSubtraction);
        btnMultiplication = (Button) findViewById(R.id.btnMultiplication);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnClear = (Button) findViewById(R.id.btnClear);
        txtResult = (TextView) findViewById(R.id.txtResult);

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double oper1 = Double.parseDouble(operand1.getText().toString());
                double oper2 = Double.parseDouble(operand2.getText().toString());

                double theResult = oper1 + oper2;
                txtResult.setText(Double.toString(theResult));
            }
        });
        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double oper1 = Double.parseDouble(operand1.getText().toString());
                double oper2 = Double.parseDouble(operand2.getText().toString());

                double theResult = oper1 - oper2;
                txtResult.setText(Double.toString(theResult));
            }
        });
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double oper1 = Double.parseDouble(operand1.getText().toString());
                double oper2 = Double.parseDouble(operand2.getText().toString());

                double theResult = oper1 * oper2;
                txtResult.setText(Double.toString(theResult));
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double oper1 = Double.parseDouble(operand1.getText().toString());
                double oper2 = Double.parseDouble(operand2.getText().toString());

                double theResult = oper1 / oper2;
                txtResult.setText(Double.toString(theResult));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                operand1.setText("");
                operand2.setText("");
                txtResult.setText("0.0");
                operand1.requestFocus();
            }
        });

    }
}
