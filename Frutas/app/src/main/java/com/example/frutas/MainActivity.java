package com.example.frutas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton banana, cereza, frambuesa, fresa, kiwi, manzana, mango, melon, naranja, pera, pina, sandia, uva, zarazamora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banana = (ImageButton)findViewById(R.id.btn_bananas);
        cereza = (ImageButton) findViewById(R.id.btn_cerezas);
        frambuesa = (ImageButton) findViewById(R.id.btn_frambuesas);
        fresa = (ImageButton) findViewById(R.id.btn_fresas);
        kiwi = (ImageButton) findViewById(R.id.btn_kiwis);
        manzana = (ImageButton) findViewById(R.id.btn_manzanas);
        mango = (ImageButton) findViewById(R.id.btn_mangos);
        melon = (ImageButton) findViewById(R.id.btn_melon);
        naranja = (ImageButton) findViewById(R.id.btn_naranjas);
        pera = (ImageButton) findViewById(R.id.btn_pera);
        pina = (ImageButton) findViewById(R.id.btn_pina);
        sandia = (ImageButton) findViewById(R.id.btn_sandia);
        uva = (ImageButton) findViewById(R.id.btn_uvas);
        zarazamora = (ImageButton) findViewById(R.id.btn_zarzamora);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_bananas:
                Toast.makeText(this, "Quieres Bananas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cerezas:
                Toast.makeText(this, "Quieres Cerazas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_frambuesas:
                Toast.makeText(this, "Quieres Frambuesas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_fresas:
                Toast.makeText(this, "Quieres Fresas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_kiwis:
                Toast.makeText(this, "Quieres Kiwis", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_manzanas:
                Toast.makeText(this, "Quieres Manzanas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_mangos:
                Toast.makeText(this, "Quieres Mangos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_melon:
                Toast.makeText(this, "Quieres Melones", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_naranjas:
                Toast.makeText(this, "Quieres naranjas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_pera:
                Toast.makeText(this, "Quieres Peras", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_pina:
                Toast.makeText(this, "Quieres Piñas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sandia:
                Toast.makeText(this, "Quieres Sandias", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_uvas:
                Toast.makeText(this, "Quieres Uvas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_zarzamora:
                Toast.makeText(this, "Quieres Zarzamoras", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}