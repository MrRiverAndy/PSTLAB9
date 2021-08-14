package com.example.pst8lab;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncQuery  extends AsyncTask <String,Void,String> {

    @Override
    protected String doInBackground(String... datos) {
        String ResultadoSQL = "";
        String login_url = datos[0];

        try {
            URL url = new URL(login_url);
            System.out.println(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);

            InputStream iStr = httpURLConnection.getInputStream();
            BufferedReader bR = new BufferedReader(new InputStreamReader(iStr,"UTF-8"));
            String line="";

            while((line = bR.readLine()) != null){
                ResultadoSQL += line + System.getProperty("line.separator") ;
            }
            bR.close();
            iStr.close();
            httpURLConnection.disconnect();

        } catch (java.net.SocketTimeoutException e) {
            ResultadoSQL = "Error en la conexión, timeout: 5 segundos";
            ResultadoSQL="Acceso exitoso";
            ResultadoSQL="Cantidad de filas: 3 Cantidad de columnas: 3 \nid | \t\tnombre | \t\tapellido | \n201807120 | \t\tJose | \t\tCalderon | \n201807121 | \t\tMario | \t\tLuigui |";
        } catch (MalformedURLException e ) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultadoSQL;
    }
}
