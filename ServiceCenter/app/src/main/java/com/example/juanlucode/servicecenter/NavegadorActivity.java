package com.example.juanlucode.servicecenter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NavegadorActivity  extends
                                    AppCompatActivity
                                implements
                                    View.OnClickListener {

    private Button irButton;
    private EditText urlEditText;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador);

        irButton = (Button) this.findViewById(R.id.irButton);
        irButton.setOnClickListener(this);

        urlEditText = (EditText) findViewById(R.id.urlEditText);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.irButton:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlEditText.getText().toString()));
                startActivity(intent);
                break;
        }
    }
}
