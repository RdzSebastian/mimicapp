package com.stoniaport.mimicapp;

public class Equipo {
    String nombre;
    int puntos;


    Equipo(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public Equipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    int getPuntos() {
        return puntos;
    }

    void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    void acerto(){
        puntos++;
    }
}
