package com.example.acdat_pruebaandroid.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.acdat_pruebaandroid.R;

public class Pulsador extends AppCompatActivity implements View.OnClickListener {
    private static Integer cont = 0;
    private TextView txtPulsacion;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulsador);

        Button btnPulsar = (Button) findViewById(R.id.btnCont);
        btnPulsar.setOnClickListener(this);

        txtPulsacion = (TextView) findViewById(R.id.txtPulsacion);
        txtPulsacion.setText(cont + "");

        bundle = getIntent().getExtras();

        System.out.println(bundle.getString( "tamanyoPizza" ));
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnCont){
            cont++;
            txtPulsacion.setText(cont + "");
        }
    }
}