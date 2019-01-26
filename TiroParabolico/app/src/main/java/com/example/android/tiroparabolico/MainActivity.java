package com.example.android.tiroparabolico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    double angulo, vi, vix, viy, t, d, Rango;
    double vf = 0;
    EditText txtcaja1, txtcaja2;
    Button btncalcular, btnreiniciar;
    TextView txtresultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtcaja1 = (EditText)findViewById(R.id.vitxt);
        txtcaja2 = (EditText)findViewById(R.id.angulotxt);
        btncalcular = (Button)findViewById(R.id.btncalcular);
        btnreiniciar = (Button)findViewById(R.id.btnreiniciar);
        txtresultado = (TextView)findViewById(R.id.txtfinal);
        btncalcular.setOnClickListener(this);
        btnreiniciar.setOnClickListener(this);
    }

    public void Captura(){
        String s = txtcaja1.getText().toString();
        String q = txtcaja2.getText().toString();
        if(s.isEmpty() && q.isEmpty()){
            Toast.makeText(this,"Esta vacio",Toast.LENGTH_SHORT).show();

        } else {
            VelocidadInicialX();

        }
    }



    @Override
    public void onClick(View v) {

    }

    public double VelocidadInicialX(){//double a, double b
        //a es igual a velocidad inicial y b es el angulo proporcionado

        vix = vi*(Math.cos(Math.toRadians(angulo)));
        return vix;
    }

    public double VelocidadInicialY(){//double a, double b
        //a sera velocidad inicial y b sera el angulo inicial
        viy = vi*Math.sin(Math.toRadians(angulo));
        return viy;
    }

    public double tiempo (){//double a, double
        //a sera velocidad final y b sera velocidad inicial
        t = (vf-VelocidadInicialY())/-9.8;
        return t;
    }

    public double distancia (){//double a, double b
        //a sera la velocidad inicial y b sera el tiempo
        d = (Math.pow(vi, 2)*Math.pow(Math.sin(Math.toRadians(angulo)), 2))/(2*(9.8));

        return d;
    }

    public double rango (){//double a, double b
        //a sera la velocidad inicial en X y b sera el tiempo
        Rango = VelocidadInicialX() * (2*tiempo());
        return Rango;
    }
}
