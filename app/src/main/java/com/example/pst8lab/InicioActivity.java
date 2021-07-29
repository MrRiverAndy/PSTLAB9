package com.example.pst8lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }
    public void iniciar(View v){
        Intent intent = new Intent(this, InicioSesion.class);;
        startActivity(intent);
    }
    public void buscarWeb(View v){
        Intent intent = new Intent(this, webViewActivity.class);;
        startActivity(intent);
    }
    public void buscarCorreo(View v){
        Intent intent = new Intent(this, Correo.class);;
        startActivity(intent);
    }
    public void acercaDe(View v){
        Intent intent = new Intent(this, AcercaDe.class);;
        startActivity(intent);
    }
}