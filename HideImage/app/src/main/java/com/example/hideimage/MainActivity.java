package com.example.hideimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_o, btn_m;
    ImageView img_p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_o = (Button)findViewById(R.id.btn_ocultar);
        btn_m = (Button)findViewById(R.id.btn_mostrar);
        img_p = (ImageView)findViewById(R.id.img_poster);
        findViewById(R.id.btn_ocultar).setOnClickListener(this);
        findViewById(R.id.btn_mostrar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_ocultar:
                img_p.setVisibility(View.GONE);
            break;
            case R.id.btn_mostrar:
                img_p.setVisibility(View.VISIBLE);
            break;
        }
    }
}