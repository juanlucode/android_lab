package com.example.juanlucode.myform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyFormMainActivity
                                extends
                                    AppCompatActivity
                                implements
                                    View.OnClickListener {

    private EditText nombreEditText;
    private Button avanzarButton;

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
                break;
        }
    }
}
