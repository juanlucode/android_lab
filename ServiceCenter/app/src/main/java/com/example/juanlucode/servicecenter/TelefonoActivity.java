package com.example.juanlucode.servicecenter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelefonoActivity   extends
                                    AppCompatActivity
                                implements
                                    View.OnClickListener {

    private EditText telefonoEditText;
    private Button llamarButton;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefono);

        telefonoEditText = (EditText) findViewById(R.id.telefonoEditText);
        llamarButton = (Button) findViewById(R.id.llamarButton);
        llamarButton.setOnClickListener(this);

        bundle = getIntent().getExtras();
        telefonoEditText.setText(bundle.getString("phone"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.llamarButton:
                intent = new Intent();
                // ACTION_CALL requiere permisos -> declararla en el manifiesto
                // ACTION_DIAL no requiere permisos -> abre la app de teléfono (recomendado)
                intent.setAction(intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:".concat(telefonoEditText.getText().toString())));
                try{
                    startActivity(intent);
                } catch (Exception ex){
                    ex.printStackTrace();
                }

                break;
        }
    }
}
