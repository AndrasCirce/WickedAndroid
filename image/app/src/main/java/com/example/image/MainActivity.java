package com.example.image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void Mensaje_shop(View view){
        Toast.makeText(this, "Para compras", Toast.LENGTH_SHORT).show();
    }

    public void Mensaje_show(View view){
        Toast.makeText(this, "Para proyectar", Toast.LENGTH_SHORT).show();
    }
}