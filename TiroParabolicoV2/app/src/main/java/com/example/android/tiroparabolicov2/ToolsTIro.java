package com.example.android.tiroparabolicov2;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ToolsTIro extends AppCompatActivity  {
    //    TiroTools algo = new  TiroTools();
    double angulo, vi, vix, viy, t, d, Rango;
    double vf = 0;

    EditText caja1, caja2;
    public double VelocidadInicialX(double a, double b) {//double a, double b
        //a es igual a velocidad inicial y b es el angulo proporcionado
        vix = a * (Math.cos(Math.toRadians(b)));
        return vix;
    }

    public double VelocidadInicialY() {//double a, double b
        //a sera velocidad inicial y b sera el angulo inicial
        viy = vi * Math.sin(Math.toRadians(angulo));
        return viy;
    }

    public double tiempo() {//double a, double
        //a sera velocidad final y b sera velocidad inicial
        t = (vf - VelocidadInicialY()) / -9.8;
        return t;
    }

    public double distancia() {//double a, double b
        //a sera la velocidad inicial y b sera el tiempo
        d = vi*(t * 2 )+(-9.8* Math.pow(t,2)/2);

        return d;
    }

    public double rango() {//double a, double b
        //a sera la velocidad inicial en X y b sera el tiempo
      //  Rango = VelocidadInicialX() * (2 * tiempo());
        return Rango;
    }

    /*
    public void Resolver(){
        VelocidadInicialX();
        VelocidadInicialY();
        tiempo();
        distancia();
        rango();
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btncalcular)
            Capturar();
        if(id == R.id.btnreiniciar)
            Reset();
    }

    public void Capturar() {
        String S = caja1.getText().toString();
        if (S.isEmpty()) {
            Toast.makeText(this, "Esta vacio", Toast.LENGTH_SHORT).show();
        } else {
            vi = Double.parseDouble(S);
        }
        String Q = caja2.getText().toString();
        if (Q.isEmpty()) {
            Toast.makeText(this, "Esta vacio", Toast.LENGTH_SHORT).show();
        } else {
            angulo = Double.parseDouble(S);
        }
        if (S != null && Q != null)
            Resolver();
    }
*/

    public void Reset (){
        caja1.setText("");
        caja2.setText("");

    }



}
