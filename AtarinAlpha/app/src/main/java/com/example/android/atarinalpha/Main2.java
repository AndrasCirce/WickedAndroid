package com.example.android.atarinalpha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class Main2 extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtpassword = (EditText)findViewById(R.id.txtPass);


    }
}
