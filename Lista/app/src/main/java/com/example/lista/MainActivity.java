package com.example.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private ListView ltv1;
    private String nombres [] = {"Circe","Qaro","Ryu"};
    private String edades [] = {"18","16","17"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.txt_mensaje);
        ltv1 = (ListView) findViewById(R.id.ltv_opciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.list_item_andres,nombres);
        ltv1.setAdapter(adapter);

        ltv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv1.setText("La edad de "+ ltv1.getItemAtPosition(position) + " es "+ edades[position]);
            }
        });

    }
}