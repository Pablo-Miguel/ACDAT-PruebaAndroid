package com.example.acdat_pruebaandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ListActivity {

    String tests[] = { "HolaMundo", "PiscinaExcepcion", "Calculadora", "LeerEscribir", "MainActivityRecyclerView"};
    String pakage[] = {"holamundo.", "piscinaExcepcion.", "calculadora.", "leerarchivos.", "recyclerViewReactivo."};
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tests));
    }


    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);

        String testName = tests[position];
        String pakageName = pakage[position];

        try {

            Class clazz = Class.forName("com.example.acdat_pruebaandroid." + pakageName + testName);
            Intent intent = new Intent(this, clazz);
            startActivity(intent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}