package com.example.acdat_pruebaandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se empieza a programar a partir de aquí

        Button btnSaludar = findViewById(R.id.btnSaludar);

        Log.i("info", "Funciona");

    }

    public void saludar(View view) {
        findViewById(R.id.textView);
    }
}