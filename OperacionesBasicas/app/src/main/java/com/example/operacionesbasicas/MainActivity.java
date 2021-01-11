package com.example.operacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2;
    private Button b_sum,b_res,b_multi,b_div;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.txt_num1);
        et2 = (EditText) findViewById(R.id.txt_num2);
        b_sum = (Button) findViewById(R.id.btn_suma);
        b_res = (Button) findViewById(R.id.btn_resta);
        b_multi = (Button) findViewById(R.id.btn_Multiplicacion);
        b_div = (Button) findViewById(R.id.btn_division);
        tv1 = (TextView) findViewById(R.id.tv_resultado);
    }

    public void sumar(View view){
        String valor1_string = et1.getText().toString();
        String valor2_string = et2.getText().toString();

        int valor1_entero =Integer.parseInt(valor1_string);
        int valor2_entero =Integer.parseInt(valor2_string);
        int suma = valor1_entero + valor2_entero;
        String resultado = String.valueOf(suma);
        tv1.setText(resultado);
    }

    public void restar(View view){
        String valor1_string = et1.getText().toString();
        String valor2_string = et2.getText().toString();

        int valor1_entero =Integer.parseInt(valor1_string);
        int valor2_entero =Integer.parseInt(valor2_string);
        int suma = valor1_entero - valor2_entero;
        String resultado = String.valueOf(suma);
        tv1.setText(resultado);
    }

    public void multiplicar(View view){
        String valor1_string = et1.getText().toString();
        String valor2_string = et2.getText().toString();

        int valor1_entero =Integer.parseInt(valor1_string);
        int valor2_entero =Integer.parseInt(valor2_string);
        int suma = valor1_entero * valor2_entero;
        String resultado = String.valueOf(suma);
        tv1.setText(resultado);
    }

    public void dividir(View view){
        String valor1_string = et1.getText().toString();
        String valor2_string = et2.getText().toString();
        int valor1_entero =Integer.parseInt(valor1_string);
        int valor2_entero =Integer.parseInt(valor2_string);
        if(valor2_entero != 0){
            int division = valor1_entero / valor2_entero;
            String resultado = String.valueOf(division);
            tv1.setText(resultado);
        }
    }

}