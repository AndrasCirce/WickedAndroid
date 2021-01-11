package com.example.parametros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class segundaActividad extends AppCompatActivity {
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);
        tv1 = (TextView)findViewById(R.id.txt_dato);
        String dato = getIntent().getStringExtra("dato");
        tv1.setText("Hola "+dato);
    }

    public void Regresar(View view) {
        Intent regresar = new Intent(this,MainActivity.class);
        startActivity(regresar);
    }
}