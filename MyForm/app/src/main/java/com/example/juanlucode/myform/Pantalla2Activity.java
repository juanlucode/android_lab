package com.example.juanlucode.myform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class Pantalla2Activity
                                extends
                                    AppCompatActivity
                                implements
                                    View.OnClickListener,
                                    SeekBar.OnSeekBarChangeListener{

    private RadioGroup  opcionRadioGroup;
    private RadioButton saludoRadioButton;
    private RadioButton despedidaRadioButton;
    private SeekBar     edadSeekBar;
    private EditText    edadEditText;
    private Button      avanzarButton;

    private Bundle      datosAnteriores;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // recuperamos controles del xml
        opcionRadioGroup = (RadioGroup) findViewById(R.id.opcionRadioGroup);
        saludoRadioButton = (RadioButton) findViewById(R.id.saludoRadioButton);
        despedidaRadioButton = (RadioButton) findViewById(R.id.despedidaRadioButton);
        edadSeekBar = (SeekBar) findViewById(R.id.edadSeekBar);
        edadSeekBar.setOnSeekBarChangeListener(this);
        edadEditText = (EditText) findViewById(R.id.edadEditText);
        avanzarButton = (Button) findViewById(R.id.avanzarButton);
        avanzarButton.setOnClickListener(this);

        // datos anteriores
        datosAnteriores = this.getIntent().getExtras();

        // establecemos radioButton por defecto
        opcionRadioGroup.check(saludoRadioButton.getId());

        // capturamos la edad inicial en el seekBar
        edadEditText.setText(String.valueOf(edadSeekBar.getProgress()));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.avanzarButton:
                if (validar()){
                    intent = new Intent(this, Pantalla3Activity.class);
                    if ( opcionRadioGroup.getCheckedRadioButtonId() == saludoRadioButton.getId() ) {
                        datosAnteriores.putBoolean("saludo", true);
                    } else {
                        datosAnteriores.putBoolean("saludo", false);
                    }

                    datosAnteriores.putInt(
                            "edad", Integer.valueOf(edadEditText.getText().toString()));

                    intent.putExtras(datosAnteriores);
                    startActivity(intent);
                } else {
                    Toast.makeText( this,
                                    "La edad debe estar comprendida entre 16 y 60.",
                                    Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    public boolean validar(){
        boolean ok = true;
        int edad = Integer.valueOf(edadEditText.getText().toString());
        if (edad < 16 || edad > 60) ok = false;
        return ok;

    }

    // métodos para SeekBar
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.edadSeekBar:
                edadEditText.setText(String.valueOf(edadSeekBar.getProgress()));
                break;

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        ;
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        ;
    }
}
