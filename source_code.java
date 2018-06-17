package bob.god.lord.myapp;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import bob.god.lord.myapp.R;

import java.text.DecimalFormat;

public class MainActivity extends Activity implements View.OnClickListener{
    private enum OPERATOR{
        PLUS,SUB,MUL,DIV ,EQUAL,PER,SQUARE,POWER

    }
     TextView txtcal;
     TextView txtresult;
  // Instance Variable
    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRright;
    private OPERATOR currentOperator;
    private double calculationResult;
    int x=0;int r=0;
    int r1=0;
    int d=0;
    int t1=0;
    private String calculaionsString;
    DecimalFormat calcu =new DecimalFormat("#.#####");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        currentNumber="";
        calculationResult =0;
        calculaionsString="";
        txtcal=findViewById(R.id.txtcal);
        txtresult=findViewById(R.id.txtresult);
        findViewById(R.id.btnequal).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btndiv).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnplus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnsub).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnmul).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnclr).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnper).setOnClickListener(MainActivity.this);
        findViewById(R.id.btndec).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnsq).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnpower).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnneg).setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnequal:
                operatorIsTapped(OPERATOR.EQUAL);
                t1=1;
                break;
            case R.id.btn7:
                numberIsTapped(7);
                break;
            case R.id.btn8:
                numberIsTapped(8);
                break;
            case R.id.btn9:
                numberIsTapped(9);
                break;
            case R.id.btn4:
                numberIsTapped(4);
                break;
            case R.id.btn5:
                numberIsTapped(5);
                break;
            case R.id.btn6:
                numberIsTapped(6);
                break;
            case R.id.btn3:
                numberIsTapped(3);
                break;
            case R.id.btn2:
                numberIsTapped(2);
                break;
            case R.id.btn1:
                numberIsTapped(1);
                break;
            case R.id.btnneg:
                numberIsTapped(15);
                break;
            case R.id.btnplus:
                if(r1>0 && (currentNumber!="" || t1==1)) {
                   int x1= operatorIsTapped(OPERATOR.PLUS);
                   if(x1!=0) calculaionsString += " + ";
                }
                break;
            case R.id.btnmul:
                if(r1>0 && (currentNumber!="" || t1==1)){
                    int x2= operatorIsTapped(OPERATOR.MUL);
                    if(x2!=0) calculaionsString += " * ";
                }
                break;
            case R.id.btnsub:
                if(r1>0 && (currentNumber!="" || t1==1)) {
                    int x3=operatorIsTapped(OPERATOR.SUB);
                     if(x3!=0)   calculaionsString += " - ";
                }
                break;
            case R.id.btndiv:
                if(r1>0 && (currentNumber!="" || t1==1)) {
                   int x4=operatorIsTapped(OPERATOR.DIV);
                     if(x4!=0) calculaionsString += " / ";
                }
                break;
            case R.id.btn0:
                numberIsTapped(0);
                break;
            case R.id.btnclr:
                clearTapped();
                break;
            case R.id.btnper:
                if(r1>0) {
                    int x5= operatorIsTapped(OPERATOR.PER);
                   if(x5!=0) calculaionsString += " % ";
                }
                break;
            case R.id.btndec:
                numberIsTapped(10);
                break;
            case R.id.btnsq:
                if(r1>0) {
                   int x6=operatorIsTapped(OPERATOR.SQUARE);
                   if(x6!=0)  calculaionsString += " sq ";
                }
                break;
            case R.id.btnpower:
                if(r1>0 && (currentNumber!="" || t1==1)) {
                   int x7=  operatorIsTapped(OPERATOR.POWER);
                 if(x7!=0)   calculaionsString += " ^ ";
                }
                break;


        }
        txtcal.setText(calculaionsString);

    }
    private void numberIsTapped(int tappedNumber) {
        if (tappedNumber != 10 && tappedNumber != 15) {
            currentNumber = currentNumber+String.valueOf(tappedNumber) ;
            txtresult.setText(currentNumber);
            calculaionsString+=String.valueOf(tappedNumber);
            txtcal.setText(calculaionsString);
            r1++;
            d++;
        }
        if (tappedNumber == 10)
        {
            currentNumber = currentNumber + ".";
        txtresult.setText(currentNumber);
        calculaionsString+= ".";
        txtcal.setText(calculaionsString);
    }
        if(tappedNumber==15 && d==0)
        {
            currentNumber+="-";
            txtresult.setText(currentNumber);
            calculaionsString+="-";
            txtcal.setText(calculaionsString);
        }

    }
    private int operatorIsTapped(OPERATOR tappedOperator) {
        d=0;
        if (currentOperator != null && currentNumber != "") {
            stringNumberAtRright = currentNumber;
            currentNumber = "";
            switch (currentOperator) {

                case PLUS:
                    calculationResult = Double.parseDouble(stringNumberAtLeft) + Double.parseDouble(stringNumberAtRright);

                    break;
                case SUB:
                    calculationResult = Double.parseDouble(stringNumberAtLeft) - Double.parseDouble(stringNumberAtRright);
                    break;
                case MUL:
                    calculationResult = Double.parseDouble(stringNumberAtLeft) * Double.parseDouble(stringNumberAtRright);
                    break;
                case DIV:
                    calculationResult = Double.parseDouble(stringNumberAtLeft) / Double.parseDouble(stringNumberAtRright);
                    break;
                case PER:
                    calculationResult = (Double.parseDouble(stringNumberAtLeft) * Double.parseDouble(stringNumberAtRright)) / 100;
                    break;

                case POWER:
                    calculationResult = Math.pow(Double.parseDouble(stringNumberAtLeft), Double.parseDouble(stringNumberAtRright));
                    break;

            }

            String s3=calcu.format(calculationResult);
            int c=0;
            for( int i=0;i<s3.length();i++)
            {
                char c1=s3.charAt(i);
                if(c1=='.') break;
                c++;

            }
            if(c>10)
            {

                txtresult.setText("Too Big Number To Display");
                calculaionsString = stringNumberAtLeft;
            }
            else {
                stringNumberAtLeft = calcu.format(calculationResult);
                txtresult.setText(calcu.format(calculationResult));
                calculaionsString = stringNumberAtLeft;
            }

        } else {
            if (currentNumber == "" && currentOperator != null) {
                switch (currentOperator) {
                    case PER:

                            calculationResult = Double.parseDouble(stringNumberAtLeft) / 100;
                            stringNumberAtLeft = calcu.format(calculationResult);
                            txtresult.setText(calcu.format(calculationResult));
                            calculaionsString = stringNumberAtLeft;
                        break;
                    case SQUARE:

                            calculationResult = Math.sqrt(Double.parseDouble(stringNumberAtLeft));
                            stringNumberAtLeft = calcu.format(calculationResult);
                            txtresult.setText(calcu.format(calculationResult));
                            calculaionsString = stringNumberAtLeft;

                        break;
                    case PLUS: return 0;
                    case SUB: return 0;
                    case  MUL: return 0;
                    case  DIV: return 0;
                    case POWER:return 0;

                }


            } else {

                stringNumberAtLeft = currentNumber;
            }
        }
        currentNumber="";
        currentOperator = tappedOperator;
        return 1;
    }
    private void clearTapped(){
        stringNumberAtLeft= "";
        stringNumberAtRright= "";
        currentNumber = "";
        calculationResult=0;
        currentOperator= null;
        txtresult.setText("0");
        calculaionsString = "";
        r1=0;r=0;
        d=0;
        //txtcal.setText("0");
    }
}
