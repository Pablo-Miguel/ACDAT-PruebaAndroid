package com.example.acdat_pruebaandroid.recyclerViewReactivo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.acdat_pruebaandroid.R;
import com.example.acdat_pruebaandroid.databinding.ActivityMainRecyclerViewBinding;

import java.util.ArrayList;

public class MainActivityRecyclerView extends AppCompatActivity {

    private ActivityMainRecyclerViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainRecyclerViewBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();

        ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas.add(new Persona("Pablo"));
        listaPersonas.add(new Persona("Marta"));
        listaPersonas.add(new Persona("Manu"));
        listaPersonas.add(new Persona("Carlos"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(listaPersonas);

        binding.recycler.setAdapter(adapter);

        /*
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.removePersona(adapter.getPersona(binding.recycler.getChildAdapterPosition(view)));
            }
        });
        */

        binding.btnAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addPersona(new Persona(binding.editTxtPersona.getText().toString()));
            }
        });

    }
}