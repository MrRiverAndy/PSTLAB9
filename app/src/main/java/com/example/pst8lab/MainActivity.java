package com.example.pst8lab;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
/*
import android.widget.Toast;
import android.app.ProgressDialog;
import android.os.AsyncTask;


import javax.mail.Authenticator;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
*/
public class MainActivity extends AppCompatActivity {

    EditText etnombres, etapellidos, etphone, etmail;
    Intent emailIntent = new Intent(Intent.ACTION_SEND);
    public static final String EXTRA_MESSAGE = "com.example.pst8lab.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnombres = (EditText) findViewById(R.id.nombres);
        etapellidos = (EditText) findViewById(R.id.apellidos);
        etphone = (EditText) findViewById(R.id.telefono);
        etmail = (EditText) findViewById(R.id.email);
    }

    public void enviar(View v) {

        String[] to = {"andribenavides@espol.edu.ec"};
        String texto = "Datos de Contacto \n" +
                "Nombres: " + etnombres.getText().toString() + "\n" +
                "Apellidos: " + etapellidos.getText().toString() + "\n" +
                "Teléfono: " + etphone.getText().toString() + "\n" +
                "Correo Electrónico: " + etmail.getText().toString() + "\n";

        //String[] cc = {"cvaccaro@fiec.espol.edu.ec"};
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        //emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Formulario de Registro PST");
        emailIntent.putExtra(Intent.EXTRA_TEXT,texto);
        /*
        final String recipientEmail = "pstlab8@gmail.com";
        final String recipientPassword = "pstlab8andy";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.startttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        //props.put("mail.smtp.socketFactory.port", "465");
        //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(recipientEmail, recipientPassword);
            }
        });
        try {
            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(recipientEmail));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to[0]));
            mimeMessage.setSubject("Formulario de Registro PST");
            mimeMessage.setText(texto);
            Transport.send(mimeMessage);
            Toast.makeText(getApplicationContext(), "Correo Enviado", Toast.LENGTH_LONG).show();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
*/
        Intent intent = new Intent(this, activity2.class);
        String message = texto;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}