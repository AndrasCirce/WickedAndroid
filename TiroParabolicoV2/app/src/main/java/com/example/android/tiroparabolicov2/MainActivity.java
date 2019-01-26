package com.example.android.tiroparabolicov2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button calcular, reiniciar;
    EditText caja1, caja2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcular = (Button) findViewById(R.id.btncalcular);

        caja1 = (EditText) findViewById(R.id.vitxt);
        caja2 = (EditText) findViewById(R.id.angulotxt);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraVista = new Intent(MainActivity.this, Resultado.class);
                String S = caja1.getText().toString();
                String Q = caja2.getText().toString();
                otraVista.putExtra("vi",S);
                otraVista.putExtra("angulo",Q);
                startActivity(otraVista);
            }
        });





        //ToolsTIro algo = new ToolsTIro();
    }


}
