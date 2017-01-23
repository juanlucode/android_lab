package com.example.juanlucode.servicecenter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity   extends
                                AppCompatActivity
                            implements
                                View.OnClickListener {

    private Button btnNavegador;
    private Button btnTelefono;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNavegador = (Button) this.findViewById(R.id.btnNavegador);
        btnNavegador.setOnClickListener(this);

        btnTelefono = (Button) findViewById(R.id.btnTelefono);
        btnTelefono.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNavegador:
                intent = new Intent(this, NavegadorActivity.class);
                intent.putExtra("site", "www.google.es");
                this.startActivity(intent);
                break;

            case R.id.btnTelefono:
                intent = new Intent(this, TelefonoActivity.class);
                intent.putExtra("phone", "924003262");
                this.startActivity(intent);
                break;
        }
    }
}
