package com.example.acdat_pruebaandroid.piscinaExcepcion.servicio;

import com.example.acdat_pruebaandroid.piscinaExcepcion.DAOs.DAOPiscina;
import com.example.acdat_pruebaandroid.piscinaExcepcion.modelo.Piscina;

import java.util.ArrayList;

public class Servicio {
    private static Servicio servicio = null;
    private static ArrayList<Piscina> listaPiscinas = null;

    private Servicio() {
        listaPiscinas = DAOPiscina.getInstance().getPiscinas();
    }

    public static Servicio getInstance() {

        if (listaPiscinas == null) {
            listaPiscinas = new ArrayList<Piscina>();
        }

        if (servicio == null) {
            servicio = new Servicio();
        }

        return servicio;

    }

    public ArrayList<Piscina> getPiscinas() {

        return listaPiscinas;

    }

    public Piscina getPiscina(Piscina piscina) {
        if(listaPiscinas.contains(piscina)){
            for(int i = 0; i < listaPiscinas.size(); i++){
                if(listaPiscinas.get(i).equals(piscina)){
                    return listaPiscinas.get(i);
                }
            }
        }

        return null;
    }
}
