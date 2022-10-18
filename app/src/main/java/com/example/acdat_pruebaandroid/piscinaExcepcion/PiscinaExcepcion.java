package com.example.acdat_pruebaandroid.piscinaExcepcion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.acdat_pruebaandroid.R;
import com.example.acdat_pruebaandroid.piscinaExcepcion.excepciones.CantidadFueraDeRangoException;
import com.example.acdat_pruebaandroid.piscinaExcepcion.modelo.Piscina;
import com.example.acdat_pruebaandroid.piscinaExcepcion.servicio.Servicio;

import java.util.ArrayList;

public class PiscinaExcepcion extends AppCompatActivity implements View.OnClickListener {
    private SeekBar sldNivel;
    private Piscina piscinaTemp;
    private TextView txtRespuesta, txtValorSldr;
    private Button btnLlenar, btnVaciar;
    private ListView listPiscina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piscina_excepcion);

        txtRespuesta = (TextView) findViewById(R.id.txtRespuesta);
        txtValorSldr = (TextView) findViewById(R.id.txtValorSldr);
        sldNivel = (SeekBar) findViewById(R.id.sldNivel);
        sldNivel.setEnabled(false);
        btnLlenar = (Button) findViewById(R.id.btnLlenar);
        btnLlenar.setOnClickListener(this);
        btnLlenar.setBackgroundColor(Color.parseColor("#A1FFA1"));
        btnVaciar = (Button) findViewById(R.id.btnVaciar);
        btnVaciar.setOnClickListener(this);
        btnVaciar.setBackgroundColor(Color.parseColor("#FF7E7E"));

        ArrayList<String> listTemp = new ArrayList<String>();

        for (Piscina p : Servicio.getInstance().getPiscinas()) {
            listTemp.add((Math.round(p.MAX_NIVEL / 10) / 100.0) + "");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listTemp);

        listPiscina = (ListView) findViewById(R.id.listPiscina);
        listPiscina.setAdapter(adapter);
        listPiscina.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                piscinaTemp = Servicio.getInstance().getPiscina(new Piscina((int) (Double.parseDouble(listPiscina.getItemAtPosition(position).toString()) * 1000)));

                sldNivel.setMax(piscinaTemp.MAX_NIVEL);
                btnLlenar.setEnabled(true);
                btnVaciar.setEnabled(true);

                if (piscinaTemp.getNivel() == 0) {
                    txtRespuesta.setText(txtRespuesta.getText() + "Piscina " + piscinaTemp.MAX_NIVEL + "L está vacía: 0L\n");
                    txtRespuesta.setText(txtRespuesta.getText() + "------------------------------------------------------------------------------------------------------------------\n");
                } else {
                    txtRespuesta.setText(txtRespuesta.getText() + "Piscina " + piscinaTemp.MAX_NIVEL + "L -> Nivel actual de piscina: " + piscinaTemp.getNivel() + "L\n");
                    txtRespuesta.setText(txtRespuesta.getText() + "------------------------------------------------------------------------------------------------------------------\n");
                }
            }
        });

        sldNivel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtValorSldr.setText(sldNivel.getProgress() + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnLlenar){

            try {
                sldNivel.setProgress(getRandom());
                piscinaTemp.llenar(sldNivel.getProgress());
                txtRespuesta.setText(txtRespuesta.getText() + "Piscina " + piscinaTemp.MAX_NIVEL + "L -> Llenando: " + sldNivel.getProgress() + "L \tNivel: " + piscinaTemp.getNivel() + "L\n");
                txtRespuesta.setText(txtRespuesta.getText() + "------------------------------------------------------------------------------------------------------------------\n");
            } catch (CantidadFueraDeRangoException ex) {
                txtRespuesta.setText(txtRespuesta.getText() + "Piscina " + piscinaTemp.MAX_NIVEL + "L -> Llenando: " + sldNivel.getProgress() + "L \t" + ex.getMessage() + "\n");
                txtRespuesta.setText(txtRespuesta.getText() + "\t\t\tSe queda con " + piscinaTemp.getNivel() + "L\n");
                txtRespuesta.setText(txtRespuesta.getText() + "------------------------------------------------------------------------------------------------------------------\n");
            }

        } else if(view.getId() == R.id.btnVaciar){

            try {
                sldNivel.setProgress(getRandom());
                piscinaTemp.vaciar(sldNivel.getProgress());
                txtRespuesta.setText(txtRespuesta.getText() + "Piscina " + piscinaTemp.MAX_NIVEL + "L -> Vaciando: " + sldNivel.getProgress() + "L \tNivel: " + piscinaTemp.getNivel() + "L\n");
                txtRespuesta.setText(txtRespuesta.getText() + "------------------------------------------------------------------------------------------------------------------\n");
            } catch (CantidadFueraDeRangoException ex) {
                txtRespuesta.setText(txtRespuesta.getText() + "Piscina " + piscinaTemp.MAX_NIVEL + "L -> Vaciando: " + sldNivel.getProgress() + "L \t" + ex.getMessage() + "\n");
                txtRespuesta.setText(txtRespuesta.getText() + "\t\t\tSe queda con " + piscinaTemp.getNivel() + "L\n");
                txtRespuesta.setText(txtRespuesta.getText() + "------------------------------------------------------------------------------------------------------------------\n");
            }
        }
    }

    private int getRandom() {
        return (int) (Math.random() * 1000 + 1);
    }

}