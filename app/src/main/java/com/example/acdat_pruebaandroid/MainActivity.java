package com.example.acdat_pruebaandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se empieza a programar a partir de aquí

        Button btnSaludar = findViewById(R.id.btnSaludar);

        Log.i("info", "Funciona");

    }

    public void onClick(View view) throws InterruptedException {
        TextView txtSaludar = findViewById(R.id.txtSaludar);
        txtSaludar.setText("Hola mundo");
        Toast.makeText(this, "Este mensaje se autodestruirá en 4 segundos", Toast.LENGTH_LONG).show();
        Thread.sleep(4000);
    }
}