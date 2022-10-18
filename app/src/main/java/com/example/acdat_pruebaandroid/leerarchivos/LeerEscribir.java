package com.example.acdat_pruebaandroid.leerarchivos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.acdat_pruebaandroid.R;
import com.example.acdat_pruebaandroid.leerarchivos.Escribir;

public class LeerEscribir extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer_escribir);

        findViewById(R.id.btnEditarTexto).setOnClickListener(this);
        TextView txtLeer = (TextView) findViewById(R.id.txtLeer);
        preferencias = getSharedPreferences ("misDatos", Context.MODE_PRIVATE);

        txtLeer.setText(preferencias.getString("texto", ""));

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnEditarTexto){
            Intent intent = new Intent(this, Escribir.class);
            startActivity(intent);
        }
    }
}