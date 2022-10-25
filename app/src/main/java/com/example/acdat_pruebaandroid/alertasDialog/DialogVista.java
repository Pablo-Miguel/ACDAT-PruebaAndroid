package com.example.acdat_pruebaandroid.alertasDialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.acdat_pruebaandroid.R;

public class DialogVista extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_vista);
        findViewById(R.id.btnMostrar).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnMostrar){

            AlertDialog.Builder dialogo = clrearDialogo();
            dialogo.show();

        }
    }

    public AlertDialog.Builder clrearDialogo(){
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Pedido");
        dialogo1.setMessage("¿Confirma la pizza?");
        dialogo1.setCancelable(false);

        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                aceptar();
            }
        });

        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cancelar();
            }
        });

        return  dialogo1;
    }

    public void aceptar(){
        Toast t = Toast.makeText(this, "La pizza llegará en breves. Vaya enfriando la cervecita", Toast.LENGTH_SHORT);
        t.show();
    }

    public void cancelar(){
        Toast t = Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT);
        t.show();
    }
}