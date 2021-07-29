package com.example.pst8lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InicioSesion extends AppCompatActivity {
    private String usuario;
    private String contraseña;
    EditText etusuario, etcontraseña;

    public static final String EXTRA_MESSAGE = "com.example.pst8lab.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        etcontraseña = (EditText) findViewById(R.id.contra);
        etusuario = (EditText) findViewById(R.id.usuarioId);
    }
    public void siguiente(View v){
        contraseña= etcontraseña.getText().toString();
        usuario= etusuario.getText().toString();
        Intent intent = new Intent(this, Saludo.class);
        intent.putExtra(EXTRA_MESSAGE, usuario);
        startActivity(intent);
    }
    public void regresar1(View v){
        finish();
    }

}