package com.example.acdat_pruebaandroid.calculadora;

import android.view.View;
import android.widget.Button;

import com.example.acdat_pruebaandroid.Calculadora;
import com.example.acdat_pruebaandroid.R;

public class EventoBotones implements View.OnClickListener {
    Calculadora calculadora;
    public EventoBotones(Calculadora calculadora) {
        Button btnSumar = (Button) calculadora.findViewById(R.id.btnSumar);
        btnSumar.setOnClickListener(this::onClick);
        Button btnRestar = (Button) calculadora.findViewById(R.id.btnRestar);
        btnRestar.setOnClickListener(this::onClick);
        this.calculadora = calculadora;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnSumar){
            calculadora.sumar();
        }
        else if (view.getId() == R.id.btnRestar) {
            calculadora.restar();
        }
    }
}
