package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner sp1;
    private EditText et1,et2;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.txt_valor1);
        et2 = (EditText) findViewById(R.id.txt_valor2);
        tv1 = (TextView) findViewById(R.id.txt_resultado);
        sp1 = (Spinner) findViewById(R.id.spi_menu);
        String [] opciones = {"Sumar","Restar","Multiplicar","Dividir"};
        //ArrayAdapter <String> adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        ArrayAdapter <String> adapter =  new ArrayAdapter<String>(this, R.layout.spinner_item_andres, opciones);
        sp1.setAdapter(adapter);
    }
    public void Calcular(View view){
        String valor1_string = et1.getText().toString();
        String valor2_string = et2.getText().toString();
        int valor1_entero = Integer.parseInt(valor1_string);
        int valor2_entero = Integer.parseInt(valor2_string);
        String seleccion = sp1.getSelectedItem().toString();
        if(seleccion.equals("Sumar")){
          int suma = valor1_entero + valor2_entero;
          String resultado  = String.valueOf(suma);
          tv1.setText(resultado);
        }
        else if(seleccion.equals("Restar")){
            int resta = valor1_entero - valor2_entero;
            String resultado  = String.valueOf(resta);
            tv1.setText(resultado);
        }
        else if(seleccion.equals("Multiplicar")){
            int multiplicaion = valor1_entero * valor2_entero;
            String resultado  = String.valueOf(multiplicaion);
            tv1.setText(resultado);
        }
        else if(seleccion.equals("Dividir")){
            if(valor2_entero != 0){
            int division = valor1_entero / valor2_entero;
            String resultado  = String.valueOf(division);
            tv1.setText(resultado);
            }else
                Toast.makeText(this,"No se puede dividir entre cero",Toast.LENGTH_SHORT).show();
        }

    }
}