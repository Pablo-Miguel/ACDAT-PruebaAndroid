package com.example.acdat_pruebaandroid.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.acdat_pruebaandroid.R;
import com.example.acdat_pruebaandroid.calculadora.EventoBotones;

public class Calculadora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        findViewById(R.id.btnSumar).setBackgroundColor(Color.parseColor("#A1FFA1"));
        findViewById(R.id.btnRestar).setBackgroundColor(Color.parseColor("#FF7E7E"));

        EventoBotones btn = new EventoBotones(this);

    }

    public void sumar(){
        EditText etNum1 = (EditText) findViewById(R.id.editTextNum1);
        EditText etNum2 = (EditText) findViewById(R.id.editTextNum2);
        TextView txtRespuesta = (TextView) findViewById(R.id.lblCalcResultado);

        if(!etNum1.getText().toString().equals("") && !etNum2.getText().toString().equals("")){
            txtRespuesta.setText( "" + (Double.parseDouble(etNum1.getText().toString()) + Double.parseDouble(etNum2.getText().toString())));
        }
        else {
            txtRespuesta.setText("ERROR: Introduzca los numeros");
        }


    }

    public void restar(){
        EditText etNum1 = (EditText) findViewById(R.id.editTextNum1);
        EditText etNum2 = (EditText) findViewById(R.id.editTextNum2);
        TextView txtRespuesta = (TextView) findViewById(R.id.lblCalcResultado);

        if(!etNum1.getText().toString().equals("") && !etNum2.getText().toString().equals("")){
            txtRespuesta.setText( "" + (Double.parseDouble(etNum1.getText().toString()) - Double.parseDouble(etNum2.getText().toString())));
        }
        else {
            txtRespuesta.setText("ERROR: Introduzca los numeros");
        }

    }
}