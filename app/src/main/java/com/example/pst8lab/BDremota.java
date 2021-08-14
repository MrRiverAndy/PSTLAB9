package com.example.pst8lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class BDremota extends AppCompatActivity {
     private TextView queryText;
     private EditText query,cond;
     private String servidor="192.168.56.1";
     private int puerto=8080;
     private String ruta="/android";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdremota);
        queryText=(TextView) findViewById(R.id.datos1);
        query=(EditText)findViewById(R.id.tabla);
        cond=(EditText)findViewById(R.id.condicion);
    }
    public void conectar(View v){
        String resultado=null;
        try {
            String url="http://"+servidor+":"+puerto+ruta;
            AsyncQuery query =new AsyncQuery();
            resultado=query.execute(url).get();
            if (resultado!= null){
                queryText.setText(resultado);
            }
            else{
                queryText.setText("Error al leer la página, esta vacía");
            }
        }catch(ExecutionException e){
                e.printStackTrace();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public void consulta(View v){
        String resultado = null;
        String datos=null;
        conectar(v);
        String condicion=cond.getText().toString();
        try {
            if (!condicion.isEmpty()) {
                datos = "http://" + servidor + ":" + puerto + "/android/Select%20*%20FROM%20" + query.getText().toString() + "%20WHERE%20" + condicion;
            }else{
                datos = "http://" + servidor + ":" + puerto + "/android/Select%20*%20FROM%20" + query.getText().toString();
            }AsyncQuery async = new AsyncQuery();
            resultado = async.execute(datos).get();
            queryText.setText(resultado);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    public void Salir(View v){finish();}
}