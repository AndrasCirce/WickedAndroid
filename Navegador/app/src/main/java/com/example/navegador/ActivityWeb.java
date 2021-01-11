package com.example.navegador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityWeb extends AppCompatActivity {
    WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        wv1 = (WebView)findViewById(R.id.wv1);
        String url = getIntent().getStringExtra("sitioweb");
        wv1.setWebViewClient(new WebViewClient());
        //wv1.getSettings().setJavaScriptEnable(true):
        wv1.loadUrl("http://"+url);
    }

    public void Cerrar(View view) { finish();}
}