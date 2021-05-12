package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    TextView textView;

    Button division, plus, equal, multi, sub;
    Button cancel;

    String number;

    int value;

    int DIVISION = 0;
    int PLUS = 1;
    int MULTI = 2;
    int SUB = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.calculatoranswer);
        edit = (EditText) findViewById(R.id.showcal);
        number = "";

        division = (Button)findViewById(R.id.avgButton);
        plus = (Button)findViewById(R.id.plusButton);
        equal = (Button)findViewById(R.id.enterButton);
        sub = (Button)findViewById(R.id.minusButton);
        multi = (Button)findViewById(R.id.multButton);

        division.setOnClickListener(mListener);
        plus.setOnClickListener(mListener);
        equal.setOnClickListener(mListener);
        sub.setOnClickListener(mListener);
        multi.setOnClickListener(mListener);

        cancel = (Button)findViewById(R.id.cancleButton); // C
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = "";
                edit.setText("");
            }
        });
    }

    Button.OnClickListener mListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.avgButton :
                    number = edit.getText().toString();
                    edit.setText("");
                    value = DIVISION;
                    break;
                case R.id.plusButton :
                    number = edit.getText().toString();
                    edit.setText("");
                    value = PLUS;
                    break;
                case R.id.minusButton :
                    number = edit.getText().toString();
                    edit.setText("");
                    value = SUB;
                    break;
                case R.id.multButton :
                    number = edit.getText().toString();
                    edit.setText("");
                    value = MULTI;
                    break;
                case R.id.enterButton :
                    if (value == MULTI) {
                        textView.setText("" + (Double.parseDouble(number) * Double.parseDouble(edit.getText().toString())));
                    } else if (value == SUB){
                        textView.setText("" + (Double.parseDouble(number) - Double.parseDouble(edit.getText().toString())));
                    } else if (value == PLUS){
                        textView.setText("" + (Double.parseDouble(number) + Double.parseDouble(edit.getText().toString())));
                    } else if (value == DIVISION){
                        textView.setText("" + (Double.parseDouble(number) / Double.parseDouble(edit.getText().toString())));
                    }
                    number = edit.getText().toString();
                    break;
            }
        }
    };

    public void onClick (View v)
    {
        switch(v.getId()){
            case R.id.Number0 : edit.setText(edit.getText().toString() + 0); break;
            case R.id.Number1 : edit.setText(edit.getText().toString() + 1); break;
            case R.id.Number2 : edit.setText(edit.getText().toString() + 2); break;
            case R.id.Number3 : edit.setText(edit.getText().toString() + 3); break;
            case R.id.Number4 : edit.setText(edit.getText().toString() + 4); break;
            case R.id.Number5 : edit.setText(edit.getText().toString() + 5); break;
            case R.id.Number6 : edit.setText(edit.getText().toString() + 6); break;
            case R.id.Number7 : edit.setText(edit.getText().toString() + 7); break;
            case R.id.Number8 : edit.setText(edit.getText().toString() + 8); break;
            case R.id.Number9 : edit.setText(edit.getText().toString() + 9); break;
        }
    }
}