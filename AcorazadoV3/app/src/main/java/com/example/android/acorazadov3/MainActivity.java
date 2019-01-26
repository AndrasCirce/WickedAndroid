package com.example.android.acorazadov3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {
    GridView tabla;
    Button a0,a1,a2,a3,a4, b0,b1,b2,b3,b4, c0,c1,c2,c3,c4, d0,d1,d2,d3,d4
            ,e0,e1,e2,e3,e4, f0,f1,f2,f3,f4, g0,g1,g2,g3,g4, h0,h1,h2,h3,h4;
    Button [] botones = {a0,a1,a2,a3,a4, b0,b1,b2,b3,b4, c0,c1,c2,c3,c4, d0,d1,d2,d3,d4
            ,e0,e1,e2,e3,e4, f0,f1,f2,f3,f4, g0,g1,g2,g3,g4, h0,h1,h2,h3,h4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabla = (GridView) findViewById(R.id.tabla);


        GridAdapter adapter = new GridAdapter(MainActivity.this, botones);
        tabla.setAdapter(adapter);

        tabla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, botones[i], Toast.LENGTH_SHORT).show();
            }
        });


    }




}
