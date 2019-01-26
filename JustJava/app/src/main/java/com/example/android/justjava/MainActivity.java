    package com.example.android.justjava;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
//2 botones, 4 radiobuttons, textview




public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    double a,b,c,d,e,x,y,p0,pi,n,t;
     TextView Resultado;
     Button blanco;
     Button rojo;
     RadioButton Biseccion,Newton,Secante,ReglaFalsa;
     EditText caja;
     String s;
     int Q=1;
     double datos[];
     String var[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {//definicion de objetos
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blanco=(Button) findViewById(R.id.BotonBlanco);
        rojo=(Button) findViewById(R.id.BotonRojo);
        Biseccion=(RadioButton) findViewById(R.id.biseccionador);
        Newton=(RadioButton) findViewById(R.id.newtonrhapson);
        Secante=(RadioButton) findViewById(R.id.secante);
        ReglaFalsa=(RadioButton)findViewById(R.id.reglafalsa);
        caja = (EditText) findViewById(R.id.Cajita);
        Resultado=(TextView)findViewById(R.id.Final);
        Biseccion.setOnClickListener(this);
        ReglaFalsa.setOnClickListener(this);
        Secante.setOnClickListener(this);
        Newton.setOnClickListener(this);
        blanco.setOnClickListener(this);
        rojo.setOnClickListener(this);

    }


    public double Biseccion(double a,double b,double c,
                            double d,double e,double p0, double pi,double n){
        double pn=p0,i=1,fa=0,fb,fp;
        for(i=1; i<=n; i++){
            pn=p0+(pi-p0)/2;
            fa=(a*Math.pow(p0, 4)+ b*Math.pow(p0, 3)+ c*Math.pow(p0, 2)+d*p0+e);
            fb=(a*Math.pow(pi, 4)+ b*Math.pow(pi, 3)+ c*Math.pow(pi, 2)+d*pi+e);
            fp=(a*Math.pow(pn, 4)+ b*Math.pow(pn, 3)+ c*Math.pow(pn, 2)+d*pn+e);
            if(fa*fp<0)
                pi=pn;
            if(fp*fb<0)
                p0=pn;
        }
        return pn;
    }

    public double Secante(double a, double b, double c,
                          double d, double e, double p0, double pi, double n) {
        double r1, r2, r3;
        double rf = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                rf = p0;
                System.out.println("El resultado en p0 es :" + rf);
            }
            if (i == 1) {
                rf = pi;
                System.out.println("El resultado en p1 es :" + rf);

            } else {
                r1 = a * Math.pow(p0, 4) + b * Math.pow(p0, 3) + c * Math.pow(p0, 2) + (d * (p0)) + e;//Funcion evaluada en pn-1

                r2 = (pi) - (p0);                                                         //resta entre puntos

                r3 = a * Math.pow(pi, 4) + b * Math.pow(pi, 3) + c * Math.pow(pi, 2) + (d * (pi)) + e;//Funcion evaluada en pn-2

                rf = (pi) - (r3 * r2) / (r3 - r1);//Formula del metodo secante

                System.out.println("El resultado en p" + (i) + " " + rf);
                p0=pi;
                r3=r1;
                pi=rf;

            }

        }

        return rf;
    }

    public double Newton(double a,double b,double c,
                         double d,double e, double p0, double n,double t){
        double er=0,pn=p0,i=1;
        for( i=1; i<=n; i++){
            pn=p0-(a*Math.pow(p0, 4)+ b*Math.pow(p0, 3)+ c*Math.pow(p0, 2)+d*p0+e)/ //formula del metodo newton
                    (4*a*Math.pow(p0, 3)+3*b*Math.pow(p0, 2)+2*c*p0+d);

            er=Math.abs(pn-p0);//error relativo
            if(er<=t){
                System.out.println(i+" resultado final "+pn+" con error "+er+" tolerancia"+t);//resultado
                i=n;
            }else{//para comprobar se omite
                System.out.println(i+" "+pn+" con error "+er);//para comprobar se omite
            }//para comprobar se omite
            p0=pn;
        }
        return pn;
    }

    public double ReglaFalsa(double a,double b,double c,
                             double d,double e, double x, double y){
        double r1,r2,r3,r4,rf;
        r1= x*((a*Math.pow(y, 4))+(b*Math.pow(y, 3))+(c*Math.pow(y, 2))+d*y+e);
        r2= y*((a*Math.pow(x, 4))+(b*Math.pow(x, 3))+(c*Math.pow(x, 2))+d*x+e);
        r3=  ((a*Math.pow(y, 4))+(b*Math.pow(y, 3))+(c*Math.pow(y, 2))+d*y+e);
        r4=  ((a*Math.pow(x, 4))+(b*Math.pow(x, 3))+(c*Math.pow(x, 2))+d*x+e);

        rf= (r1-r2)/(r3-r4);
        return rf;
    }



    @Override
    public void onClick(View view) {//Definicion del longitud de arreglo de datos segun el radiobutton
     int id=view.getId();
            if( id==R.id.BotonBlanco)
            {
                Captura();}
            else if (id==R.id.BotonRojo){
                Reiniciar();
            }

        else SeleccionarF();

    }

    public void SeleccionarF(){
        if(Biseccion.isChecked()) {
            var = new String[]{"A","B","C","D","E","P0","PI","N"};
            //caja.setVisibility(View.VISIBLE);

        }
        else  if(ReglaFalsa.isChecked()) {
            var = new String[]{"A","B","C","D","E","Lim A","Lim B"};
            //caja.setVisibility(View.VISIBLE);

        }

        else if(Secante.isChecked()) {
            var = new String[]{"A","B","C","D","E","P0","PI","N"};
            //caja.setVisibility(View.VISIBLE);

        }
        else if(Newton.isChecked()) {
            var = new String[]{"A","B","C","D","E","P0","N","T"};
            //caja.setVisibility(View.VISIBLE);

        }
        datos= new double[var.length];
        Preparar();
    }

    public void Captura(){
       String s=caja.getText().toString();
        if(s.isEmpty()){
            Toast.makeText(this,"Esta vacio",Toast.LENGTH_SHORT).show();
        } else {
                datos[Q-1]=Double.parseDouble(s);
                caja.setText("");
               if(Q < datos.length)
                    caja.setHint("Ingrese " + var[Q]);
                else{
                    Toast.makeText(this,"Calculo completo",Toast.LENGTH_SHORT).show();
            Resolver();}
            Q++;
        }
        }

    public void Resolver(){
        double res = 0;
        if (Biseccion.isChecked()) {
            res = Biseccion(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7]);
        } else if (Newton.isChecked()) {
            res =Newton(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7]);
        } else if (ReglaFalsa.isChecked()) {
            res = ReglaFalsa(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]);
        } else if (Secante.isChecked()) {
            res = Secante(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7]);
        }
        Resultado.setVisibility(View.VISIBLE);
        Resultado.setText(String.valueOf(res));
        Reiniciar();
    };

    public void Reiniciar(){
        Q=1;
        caja.setVisibility(View.INVISIBLE);
        Biseccion.setChecked(false);
        Secante.setChecked(false);
        ReglaFalsa.setChecked(false);
        Newton.setChecked(false);
    }

    public void Preparar(){
            Q=1;
            caja.setVisibility(View.VISIBLE);
            caja.setHint("Ingresa "+var[Q-1]);
    }


}
