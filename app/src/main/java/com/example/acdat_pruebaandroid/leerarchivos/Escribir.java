package com.example.acdat_pruebaandroid.leerarchivos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.acdat_pruebaandroid.R;

public class Escribir extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escribir);

        findViewById(R.id.btnGuardar).setOnClickListener(this);
        preferencias = getSharedPreferences ("misDatos", Context.MODE_PRIVATE);




    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnGuardar){
            SharedPreferences.Editor editor = preferencias.edit();
            EditText txtEscribir = (EditText) findViewById(R.id.txtEscribir);
            editor.putString( "texto", txtEscribir.getText().toString() );
            editor.commit();
            Intent i = new Intent(this, LeerEscribir.class);
            startActivity(i);
        }
    }
}