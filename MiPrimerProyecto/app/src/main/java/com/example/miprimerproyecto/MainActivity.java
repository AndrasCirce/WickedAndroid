package com.example.miprimerproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int matematicas = 10;
        int quimica = 10;
        int fisica = 10;
        int promedio = 0;
        promedio = (matematicas+quimica+fisica)/3;
        if(promedio >= 6)
            Toast.makeText(this,"Aprobado",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Reprobado",Toast.LENGTH_SHORT).show();;
    }
}