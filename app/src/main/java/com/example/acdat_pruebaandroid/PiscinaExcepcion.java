package com.example.acdat_pruebaandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class PiscinaExcepcion extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piscina_excepcion);

        findViewById(R.id.btnProbar).setOnClickListener(this);
        findViewById(R.id.btnLlenar).setOnClickListener(this);
        findViewById(R.id.btnVaciar).setOnClickListener(this);

        RecyclerView recicler = findViewById(R.id.listPiscina);

        ArrayAdapter<String> listaPiscinas = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnProbar){


        } else if(view.getId() == R.id.btnLlenar){


        } else if(view.getId() == R.id.btnVaciar){


        }
    }
}