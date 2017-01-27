package com.example.juanlucode.myform;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyFormMainActivity
                                extends
                                    AppCompatActivity
                                implements
                                    View.OnClickListener {

    private EditText nombreEditText;
    private Button avanzarButton;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_form_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_form);

        nombreEditText = (EditText) findViewById(R.id.nombreEditText);
        avanzarButton = (Button) findViewById(R.id.avanzarButton);
        avanzarButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.avanzarButton:
                if (validar()){
                    intent = new Intent(this, Pantalla2Activity.class);
                    intent.putExtra("nombre", nombreEditText.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Debe introducir un nombre", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    private boolean validar(){
        boolean ok = true;

        if (nombreEditText.getText().toString().isEmpty()) ok = false;
        return ok;
    }
}
