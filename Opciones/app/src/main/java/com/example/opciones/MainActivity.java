package com.example.opciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  EditText et1,et2;
    private RadioButton rb_sum,rb_res,rb_multi,rb_div;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.txt_valor1);
        et2 = (EditText) findViewById(R.id.txt_valor2);
        rb_sum = (RadioButton) findViewById(R.id.rb_suma);
        rb_res = (RadioButton) findViewById(R.id.rb_resta);
        rb_multi = (RadioButton) findViewById(R.id.rb_producto);
        rb_div = (RadioButton) findViewById(R.id.rb_division);
        tv1 = (TextView) findViewById(R.id.txt_resultado);
    }

    public void Calcular(View view) {
        String valor1_string = et1.getText().toString();
        String valor2_string = et2.getText().toString();

        int valor1_entero =Integer.parseInt(valor1_string);
        int valor2_entero =Integer.parseInt(valor2_string);
        if(rb_sum.isChecked() == true){
            int suma = valor1_entero + valor2_entero;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);
        }
        if(rb_res.isChecked() == true){
            int resta = valor1_entero - valor2_entero;
            String resultado = String.valueOf(resta);
            tv1.setText(resultado);
        }
        if(rb_multi.isChecked() == true){
            int multiplicacion = valor1_entero * valor2_entero;
            String resultado = String.valueOf(multiplicacion);
            tv1.setText(resultado);
        }
        if(rb_div.isChecked() == true){
            if(valor2_entero != 0){
                int division = valor1_entero / valor2_entero;
                String resultado = String.valueOf(division);
                tv1.setText(resultado);
            }
        }
    }
}