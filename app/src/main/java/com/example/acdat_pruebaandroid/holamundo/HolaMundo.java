package com.example.acdat_pruebaandroid.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.acdat_pruebaandroid.R;

public class HolaMundo extends AppCompatActivity implements View.OnClickListener{

    private static Integer cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holamundo);

        //Se empieza a programar a partir de aquí

        Button btnSaludar2 = findViewById(R.id.btnSaludar2);
        Button btnCont = findViewById(R.id.btnContPanel);

        btnSaludar2.setOnClickListener(this);
        btnCont.setOnClickListener(this);

        Log.i("info", "Funciona");

        /*
        TextView texto = new TextView(this);

        texto.setText("Hello, Android");

        setContentView(texto);
        */
    }

    public void onClick(View view) {
        if(view.getId() == R.id.btnSaludar){
            TextView txtSaludar = findViewById(R.id.txtSaludar);
            txtSaludar.setText("Hola mundo1");
            Button btnSaludar = (Button) view;
            btnSaludar.setText("Has saludado1");
            btnSaludar.setEnabled(false);
            //Toast.makeText(this, "Este mensaje se autodestruirá en 4 segundos", Toast.LENGTH_LONG).show();
            //Thread.sleep(4000);
        } else if(view.getId() == R.id.btnSaludar2){
            TextView txtSaludar = findViewById(R.id.txtSaludar);
            txtSaludar.setText("Hola mundo2");
            Button btnSaludar = (Button) view;
            btnSaludar.setText("Has saludado2");
            btnSaludar.setEnabled(false);
            //Toast.makeText(this, "Este mensaje se autodestruirá en 4 segundos", Toast.LENGTH_LONG).show();
            //Thread.sleep(4000);
        }
        else {

            String tamanyo = "Mi pizza mide 45 centimetracos";
            Intent i = new Intent(this, Pulsador.class);
            i.putExtra("tamanyoPizza", tamanyo);
            startActivity(i);

        }

    }

}