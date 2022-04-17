package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button btnDelete, btnPlusMinus, btnPlus, btnMinus, btnX, btnDev, btnEqual;
    TextView tvSan, tv_zapis;

    String birinshiSan, ekinshiSan, znak, zapisText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        numMethods();
        delPlusMinusMethod();
        functionMethod();

    }

    public void initViews(){
        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);

        tvSan = findViewById(R.id.tv_san);
        tv_zapis = findViewById(R.id.tv_zapis);


        btnDelete = findViewById(R.id.btnDelete);
        btnPlusMinus = findViewById(R.id.btnPlusMinus);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnX = findViewById(R.id.btnX);
        btnDev = findViewById(R.id.btnDev);
        btnEqual = findViewById(R.id.btnEqual);
    }
    public void numMethods(){
        View.OnClickListener buttonSandar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aldingiSan = tvSan.getText().toString();
                String basilganSan = "";
                String songiResult = "";

                switch (view.getId()){
                    case R.id.btn0:
                        basilganSan = "0";
                        break;

                    case R.id.btn1:
                        basilganSan = "1";
                        break;

                    case R.id.btn2:
                        basilganSan = "2";
                        break;

                    case R.id.btn3:
                        basilganSan = "3";
                        break;

                    case R.id.btn4:
                        basilganSan = "4";
                        break;

                    case R.id.btn5:
                        basilganSan = "5";
                        break;

                    case R.id.btn6:
                        basilganSan = "6";
                        break;

                    case R.id.btn7:
                        basilganSan = "7";
                        break;

                    case R.id.btn8:
                        basilganSan = "8";
                        break;

                    case R.id.btn9:
                        basilganSan = "9";
                        break;
                }
                if(!aldingiSan.equals("0")) songiResult = aldingiSan + basilganSan;
                else songiResult = basilganSan;
                tvSan.setText(songiResult);
            }
        };

        button0.setOnClickListener(buttonSandar);
        button1.setOnClickListener(buttonSandar);
        button2.setOnClickListener(buttonSandar);
        button3.setOnClickListener(buttonSandar);
        button4.setOnClickListener(buttonSandar);
        button5.setOnClickListener(buttonSandar);
        button6.setOnClickListener(buttonSandar);
        button7.setOnClickListener(buttonSandar);
        button8.setOnClickListener(buttonSandar);
        button9.setOnClickListener(buttonSandar);
    }
    public  void delPlusMinusMethod(){

        View.OnClickListener buttonDeletePlusMinus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnDelete:
                        tvSan.setText("0");
                        tv_zapis.setText("");
                        break;

                    case R.id.btnPlusMinus:
                        String sanText = tvSan.getText().toString();
                        int san = Integer.parseInt(sanText);

                        if(san > 0) tvSan.setText("-"+sanText);
                        else{
                            san = san * (-1);
                            tvSan.setText(""+san);
                        }

                }

            }
        };

        btnDelete.setOnClickListener(buttonDeletePlusMinus);
        btnPlusMinus.setOnClickListener(buttonDeletePlusMinus);
    }
    public void functionMethod(){
        View.OnClickListener btnFunctions = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                birinshiSan = tvSan.getText().toString();

                switch (view.getId()){
                    case R.id.btnPlus:
                        znak = "+";
                        break;

                    case R.id.btnMinus:
                        znak = "-";
                        break;

                    case R.id.btnX:
                        znak = "*";
                        break;

                    case R.id.btnDev:
                        znak = "/";
                        break;
                }

                zapisText = birinshiSan + znak;
                tv_zapis.setText(zapisText);
                tvSan.setText("0");

            }
        };

        btnPlus.setOnClickListener(btnFunctions);
        btnMinus.setOnClickListener(btnFunctions);
        btnX.setOnClickListener(btnFunctions);
        btnDev.setOnClickListener(btnFunctions);



        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ekinshiSan = tvSan.getText().toString();
                int san1 = Integer.parseInt(birinshiSan);
                int san2 = Integer.parseInt(ekinshiSan);
                int res = 0;

                if (znak.equals("+")){
                    res = san1 + san2;
                }else if(znak.equals("-")) {
                    res = san1 - san2;
                }else if(znak.equals("*")) {
                    if(san2 == 0){
                        res = 0;
                    }else{
                        res = san1 * san2;
                    }
                }else if(znak.equals("/")) {
                    if(san2 == 0){
                        tvSan.setText("Error");
                        return;
                    }else{
                        res = san1 / san2;
                    }

                }

                zapisText = birinshiSan + znak + ekinshiSan + "=" + res;

                tv_zapis.setText(zapisText);
                tvSan.setText(""+res);
            }
        });
    }
}