package com.example.juanlucode.myform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Pantalla3Activity
                                extends
                                    AppCompatActivity
                                implements View.OnClickListener {
    private Button showButton;
    private Button shareButton;
    private Bundle datosAnteriores;
    private String mensaje;

    private Intent shareIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        showButton = (Button) findViewById(R.id.showButton);
        showButton.setOnClickListener(this);

        shareButton = (Button) findViewById(R.id.shareButton);
        shareButton.setOnClickListener(this);

        datosAnteriores = this.getIntent().getExtras();


    }

    private String generarMensaje(){
        StringBuilder mensaje;
        String nombre;
        int edad;

        nombre = datosAnteriores.getString("nombre");
        edad = datosAnteriores.getInt("edad");

        if (datosAnteriores.getBoolean("saludo")){
            mensaje = new StringBuilder("Hola %s, ¿Cómo llevas esos %d años? #MyForm");
        } else {
            mensaje = new StringBuilder(
                    "Espero verte pronto %s, antes que cumplas %d.. #MyForm");
            edad++;
        }

        return String.format(mensaje.toString(), nombre, edad );
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.showButton:
                mensaje = generarMensaje();
                Toast.makeText(this, mensaje,Toast.LENGTH_LONG).show();
                showButton.setVisibility(Button.INVISIBLE);
                shareButton.setVisibility(Button.VISIBLE);
                break;

            case R.id.shareButton:
                shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent, "Compartir con ..."));
                break;
        }
    }
}
