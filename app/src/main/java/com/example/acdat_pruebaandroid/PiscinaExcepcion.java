package com.example.acdat_pruebaandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;

import com.example.acdat_pruebaandroid.piscinaExcepcion.modelo.Piscina;
import com.example.acdat_pruebaandroid.piscinaExcepcion.servicio.Servicio;

import java.util.ArrayList;

public class PiscinaExcepcion extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piscina_excepcion);

        SeekBar sldNivel = (SeekBar) findViewById(R.id.sldNivel);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            sldNivel.setMin(0);
        }
        sldNivel.setMax(1300);
        sldNivel.setProgress(0);
        sldNivel.setEnabled(false);

        findViewById(R.id.btnLlenar).setOnClickListener(this);
        findViewById(R.id.btnVaciar).setOnClickListener(this);

        ArrayList<String> listTemp = new ArrayList<String>();

        for (Piscina p : Servicio.getInstance().getPiscinas()) {
            listTemp.add(p.MAX_NIVEL.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listTemp);

        ListView reciclerLista = (ListView) findViewById(R.id.listPiscina);
        reciclerLista.setAdapter(adapter);

        reciclerLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*

                if(listPiscina.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(this, "Porfavor, seleccione un valor de la lista");
                }
                else {
                    piscinaTemp = Servicio.getInstance().getPiscina(new Piscina((int) (Double.parseDouble(listPiscina.getSelectedValue()) * 1000)));

                    sdrCantidad.setMaximum(piscinaTemp.MAX_NIVEL);
                    btnLlenar.setEnabled(true);
                    btnVaciar.setEnabled(true);

                    if(piscinaTemp.getNivel() == 0){
                        taDatos.setText(taDatos.getText() + "Piscina " + piscinaTemp.MAX_NIVEL + "L está vacía: 0L\n");
                        taDatos.setText(taDatos.getText() + "------------------------------------------------------------------------------------------------------------------\n");
                    }
                    else {
                        taDatos.setText(taDatos.getText() + "Piscina " + piscinaTemp.MAX_NIVEL + "L -> Nivel actual de piscina: " + piscinaTemp.getNivel() + "L\n");
                        taDatos.setText(taDatos.getText() + "------------------------------------------------------------------------------------------------------------------\n");
                    }
                }

                 */
            }
        });

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLlenar){
            /*
            try {
                sdrCantidad.setValue(getRandom());
                piscinaTemp.llenar(sdrCantidad.getValue());
                taDatos.setText(taDatos.getText() + "Piscina " + piscinaTemp.MAX_NIVEL + "L -> Llenando: " + sdrCantidad.getValue() + "L \tNivel: " + piscinaTemp.getNivel() + "L\n");
                taDatos.setText(taDatos.getText() + "------------------------------------------------------------------------------------------------------------------\n");
            } catch (CantidadFueraDeRangoException ex) {
                taDatos.setText(taDatos.getText() + "Piscina " + piscinaTemp.MAX_NIVEL + "L -> Llenando: " + sdrCantidad.getValue() + "L \t" + ex.getMessage() + "\n");
                taDatos.setText(taDatos.getText() + "\t\t\tSe queda con " + piscinaTemp.getNivel() + "L\n");
                taDatos.setText(taDatos.getText() + "------------------------------------------------------------------------------------------------------------------\n");
            }

            */

        } else if(view.getId() == R.id.btnVaciar){
            /*
                try {
                    sdrCantidad.setValue(getRandom());
                    piscinaTemp.vaciar(sdrCantidad.getValue());
                    taDatos.setText(taDatos.getText() + "Piscina " + piscinaTemp.MAX_NIVEL + "L -> Vaciando: " + sdrCantidad.getValue() + "L \tNivel: " + piscinaTemp.getNivel() + "L\n");
                    taDatos.setText(taDatos.getText() + "------------------------------------------------------------------------------------------------------------------\n");
                } catch (CantidadFueraDeRangoException ex) {
                    taDatos.setText(taDatos.getText() + "Piscina " + piscinaTemp.MAX_NIVEL + "L -> Vaciando: " + sdrCantidad.getValue() + "L \t" + ex.getMessage() + "\n");
                    taDatos.setText(taDatos.getText() + "\t\t\tSe queda con " + piscinaTemp.getNivel() + "L\n");
                    taDatos.setText(taDatos.getText() + "------------------------------------------------------------------------------------------------------------------\n");
                }
            */

        }
    }
}