package com.example.acdat_pruebaandroid.piscinaExcepcion.DAOs;

import com.example.acdat_pruebaandroid.piscinaExcepcion.modelo.Piscina;

import java.util.ArrayList;

public class DAOPiscina {

    private static DAOPiscina daoPiscina = null;
    private static ArrayList<Piscina> listaPiscinas = null;

    private DAOPiscina() {
        //Constructor
    }

    public static DAOPiscina getInstance() {

        if (daoPiscina == null) {
            daoPiscina = new DAOPiscina();
        }

        if (listaPiscinas == null) {
            listaPiscinas = new ArrayList<Piscina>();
        }

        return daoPiscina;

    }

    public ArrayList<Piscina> getPiscinas() {

        if (listaPiscinas.isEmpty()) {

            listaPiscinas.add(new Piscina(1000));
            listaPiscinas.add(new Piscina(1100));
            listaPiscinas.add(new Piscina(1200));
            listaPiscinas.add(new Piscina(1300));
            listaPiscinas.add(new Piscina(1400));
            listaPiscinas.add(new Piscina(1500));
            listaPiscinas.add(new Piscina(1600));
            listaPiscinas.add(new Piscina(1700));
            listaPiscinas.add(new Piscina(1800));
            listaPiscinas.add(new Piscina(1900));
            listaPiscinas.add(new Piscina(2000));

            return listaPiscinas;
        } else {
            return listaPiscinas;
        }
    }
}
