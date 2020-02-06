package com.anurag.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView calculations , result;
    private enum  Operator{
        PLUS , MULTIPLY , DIVIDE ,EQUAL ,SUBTRACT
    }
    //Instance Variables
    private String currentnumber , leftnumber ,rightnumber , calculationString;
    private Operator currentOperator;
    private double calculation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Calculator");

        calculations = findViewById(R.id.calculations);
        result = findViewById(R.id.result);
        currentnumber = "0";
        calculation = 0;
        calculationString = "0";
        findViewById(R.id.one).setOnClickListener(MainActivity.this);
        findViewById(R.id.two).setOnClickListener(MainActivity.this);
        findViewById(R.id.three).setOnClickListener(MainActivity.this);
        findViewById(R.id.five).setOnClickListener(MainActivity.this);
        findViewById(R.id.four).setOnClickListener(MainActivity.this);
        findViewById(R.id.six).setOnClickListener(MainActivity.this);
        findViewById(R.id.seven).setOnClickListener(MainActivity.this);
        findViewById(R.id.eight).setOnClickListener(MainActivity.this);
        findViewById(R.id.nine).setOnClickListener(MainActivity.this);
        findViewById(R.id.equal).setOnClickListener(MainActivity.this);
        findViewById(R.id.plus).setOnClickListener(MainActivity.this);
        findViewById(R.id.divide).setOnClickListener(MainActivity.this);
        findViewById(R.id.zero).setOnClickListener(MainActivity.this);
        findViewById(R.id.minus).setOnClickListener(MainActivity.this);
        findViewById(R.id.multiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.clear).setOnClickListener(MainActivity.this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.one:
                numberisTapped(1);
                break;
            case R.id.two:
                numberisTapped(2);
                break;
            case R.id.three:
                numberisTapped(3);
                break;
            case R.id.four:
                numberisTapped(4);
                break;
            case R.id.five:
                numberisTapped(5);
                break;
            case R.id.six:
                numberisTapped(6);
                break;
            case R.id.seven:
                numberisTapped(7);
                break;
            case R.id.eight:
                numberisTapped(8);
                break;
            case R.id.nine:
                numberisTapped(9);
                break;
            case R.id.zero:
                numberisTapped(0);
                break;
            case R.id.plus:
                operatorisTapped(Operator.PLUS);
                calculationString +=" + ";
                break;
            case R.id.minus:
                operatorisTapped(Operator.SUBTRACT);
                calculationString +=" - ";
                break;
            case R.id.multiply:
                operatorisTapped(Operator.MULTIPLY);
                calculationString +=" * ";
                break;
            case R.id.divide:
                operatorisTapped(Operator.DIVIDE);
                calculationString +=" / ";
                break;
            case R.id.equal:
                operatorisTapped(Operator.EQUAL);

                break;
            case R.id.clear:
                clearIsTapped();
                break;
        }
        calculations.setText(calculationString);

    }
    private void numberisTapped(int tappedNumber){
        currentnumber = currentnumber + String.valueOf(tappedNumber);
        result.setText(currentnumber);

        calculationString = currentnumber;
        calculations.setText(calculationString);
    }
    private void operatorisTapped(Operator tappedOperator){
        if (currentOperator != null) {

            if (currentnumber.equals(" ")) {
                rightnumber = currentnumber;
                currentnumber = " ";
                switch (currentOperator) {
                    case PLUS:
                        calculation = Double.parseDouble(leftnumber) + Double.parseDouble(rightnumber);

                        break;
                    case DIVIDE:
                        calculation = Double.parseDouble(leftnumber) / Double.parseDouble(rightnumber);

                        break;
                    case MULTIPLY:
                        calculation = Double.parseDouble(leftnumber) * Double.parseDouble(rightnumber);

                        break;
                    case SUBTRACT:
                        if (Double.parseDouble(leftnumber)>=Double.parseDouble(rightnumber)) {
                            calculation = Double.parseDouble(leftnumber) - Double.parseDouble(rightnumber);
                        }else{
                            calculation = -(Double.parseDouble(leftnumber) - Double.parseDouble(rightnumber));
                        }


                        break;
                }
                leftnumber = String.valueOf(calculation);
                result.setText(leftnumber);
                calculationString = leftnumber;
            }
        }

        else {
            leftnumber=currentnumber;
            currentnumber=" ";

        }
        currentOperator=tappedOperator;
    }
    private void clearIsTapped(){
        leftnumber="";
        rightnumber="";
        calculation=0;
        currentnumber="";
        currentOperator=null;
        result.setText("0");
        calculationString="";
    }

}
