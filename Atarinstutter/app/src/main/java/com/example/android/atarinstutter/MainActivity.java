package com.example.android.atarinstutter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void Registrarse(View view) {
        Intent i = new Intent(this, Registroclass.class);
        startActivity(i);
    }

    public void  IniciarSesion(View view){
        Intent i = new Intent(this, InicioSesion.class);
        startActivity(i);
    }
}
