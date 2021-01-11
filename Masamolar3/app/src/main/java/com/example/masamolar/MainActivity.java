package com.example.masamolar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button boton1;
    //coleccion de botones

    EditText resutado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //boton1 = (Button)findViewById(R.id.button1a);

        resutado = (EditText) findViewById(R.id.resultado);
    }

    public void Pantallatexto(View view) {
        String texto=resutado.getText().toString();
        resutado.setText(texto + boton1.getText());
    }
}