package com.example.android.scanner1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCaptura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCaptura = (Button) findViewById(R.id.btnCaptura);
        btnCaptura.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnCaptura:
            Intent intent = new Intent(this, SimpleScannerActivity.class);
            startActivity(intent);
            break;
        }
    }
}
