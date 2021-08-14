package com.example.pst8lab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Correo extends AppCompatActivity {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correo);
        WebView web=(WebView) findViewById(R.id.web2);
        b=(Button) findViewById(R.id.button4);
        WebSettings opciones=web.getSettings();
        opciones.setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://www.gmail.com");
    }
    public void volver(View v){
       finish();
    }
}