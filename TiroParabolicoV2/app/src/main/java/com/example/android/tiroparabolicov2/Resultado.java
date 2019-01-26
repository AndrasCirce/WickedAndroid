package com.example.android.tiroparabolicov2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Resultado extends AppCompatActivity {
    EditText txtresultado, txtr2;
    ToolsTIro hera = new ToolsTIro();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        txtresultado = (EditText) findViewById(R.id.txtfinal);
        txtr2 = (EditText) findViewById(R.id.txtfinal2);

        Intent algomas = getIntent();
        Bundle bundle = algomas.getExtras();

        if(bundle != null) {
            String A = (String) bundle.get("vi");
            String B = (String) bundle.get("angulo");
            //txtresultado.setText(A);
            //txtr2.setText(B);
            double x = (double) bundle.get("vi");
            double y = (double) bundle.get("angulo");
        hera.VelocidadInicialX(x,y);
        txtr2.setText((int) hera.vix);
        }
    }
}
