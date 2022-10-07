package com.example.acdat_pruebaandroid.piscinaExcepcion.modelo;

import com.example.acdat_pruebaandroid.piscinaExcepcion.excepciones.CantidadFueraDeRangoException;

import java.util.Objects;

public class Piscina {
    private Integer nivel;
    public final Integer MAX_NIVEL;

    public Piscina(Integer max){
        if(max < 0){
            max = 0;
        }

        MAX_NIVEL=max;

        nivel = 0;

    }

    public Integer getNivel(){
        return nivel;
    }

    public void vaciar(Integer cantidad) throws CantidadFueraDeRangoException {
        int nivelTemp = nivel - cantidad;
        if(nivelTemp < 0 || nivelTemp > MAX_NIVEL){
            throw new CantidadFueraDeRangoException("No queda agua suficiente");
        }
        nivel = nivel - cantidad;
    }

    public void llenar(Integer cantidad) throws CantidadFueraDeRangoException{
        int nivelTemp = nivel + cantidad;
        if(nivelTemp < 0 || nivelTemp > MAX_NIVEL){
            throw new CantidadFueraDeRangoException("Se desborda con tanta agua");
        }
        nivel = nivel + cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piscina)) return false;
        Piscina piscina = (Piscina) o;
        return MAX_NIVEL.equals(piscina.MAX_NIVEL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MAX_NIVEL);
    }
}
