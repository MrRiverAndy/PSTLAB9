package com.example.pst8lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class webViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

    }
    public void link(View v){
        EditText url=(EditText) findViewById(R.id.url);
        String link= url.getText().toString();
        WebView web=(WebView) findViewById(R.id.web1);
        WebSettings opciones=web.getSettings();
        opciones.setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://"+link);
    }
    public void regresar(View v){
        finish();
    }
}