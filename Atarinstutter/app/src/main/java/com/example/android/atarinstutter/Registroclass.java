package com.example.android.atarinstutter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;

public class Registroclass extends AppCompatActivity {
    private EditText tnombre;
    private EditText tpassword;
    private EditText tcorreo;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        tnombre=(EditText)findViewById(R.id.txtnombre);
        tcorreo=(EditText)findViewById(R.id.txtcorreo);
        tpassword=(EditText)findViewById(R.id.txtpass);
    }

    public void registrar(View view){

    String nombre = tnombre.getText().toString();
    String correo = tcorreo.getText().toString();
    String password = tpassword.getText().toString();



    }
}
