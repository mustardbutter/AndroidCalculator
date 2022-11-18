package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private boolean isNew = true;
    private boolean isOp = true;
    private boolean isDot = false;
    private String str;
    private  Double result = 0.0;
    private String prevNum;
    private String lastNum;
    private String operator;
    private EditText expression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expression = findViewById(R.id.expression);

    }
        public void selectNumber(View view) {
        if (isNew) {expression.setText("");}
        String number = "";
        isNew = false;
        isOp = false;
        str = expression.getText().toString();


            switch (view.getId()) {
                case R.id.ButtonAc1: number = "1"; break;
                case R.id.ButtonAc2: number = "2"; break;
                case R.id.ButtonAc3: number = "3"; break;
                case R.id.ButtonAc4: number = "4"; break;
                case R.id.ButtonAc5: number = "5"; break;
                case R.id.ButtonAc6: number = "6"; break;
                case R.id.ButtonAc7: number = "7"; break;
                case R.id.ButtonAc8: number = "8"; break;
                case R.id.ButtonAc9: number = "9"; break;
                case R.id.ButtonAc10: number = "10"; break;
                case R.id.ButtonAc11: number = "11"; break;
                case R.id.ButtonAc12: number = "12"; break;
                case R.id.ButtonAc13: number = "13"; break;
                case R.id.ButtonAc14: number = "14"; break;
                case R.id.ButtonAc15: number = "15"; break;
                case R.id.ButtonAc16: number = "16"; break;
                case R.id.ButtonAc17: number = "17"; break;
                case R.id.ButtonAc19: if (!isDot && !str.equals("") && !isOp) {
                    number = "."; isDot = true; isOp = true;
                }
                    break;
            }
            if (number.equals("-")) { str = "-" + str;}
            else {str += number;}
            if (operator == null ){prevNum = str;}
            else {lastNum = str;}
            expression.setText(str);
    }
        public void operation (View view){
        isNew = true;
        if (!isOp) {
            str = expression.getText().toString();
            isOp = true;
            isDot = false;
            switch (view.getId()){
                case R.id.ButtonAc12: operator = "+"; break;
                case R.id.ButtonAc16: operator = "-"; break;
                case R.id.ButtonAc3: operator = "*"; break;
                case R.id.ButtonAc4: operator = "/"; break;
                case R.id.ButtonAc8: operator = "%"; break;
            }
            str += operator;
            expression.setText(str);
        }
    }

    public void delete (View view) {
        expression.setText("0");
        prevNum = null;
        lastNum = null;
        operator = null;
        isDot = false;
        isNew = true;
    }

    public void equals(View view) {
        isNew = true;

        switch (operator){
            case "+":
                result = Double.parseDouble(prevNum) + Double.parseDouble(lastNum);
                break;
            case "-":
                result = Double.parseDouble(prevNum) - Double.parseDouble(lastNum);
                break;
            case "*":
                result = Double.parseDouble(prevNum) * Double.parseDouble(lastNum);
                break;
            case "/":
                result = Double.parseDouble(prevNum) / Double.parseDouble(lastNum);
                break;
            case "%":
                result = Double.parseDouble(prevNum) % Double.parseDouble(lastNum);
                break;
        }
        expression.setText(result.toString());
    }

}