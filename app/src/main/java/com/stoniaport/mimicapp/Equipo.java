package com.stoniaport.mimicapp;

public class Equipo {
    String nombre;
    int numeroEquipo;
    int puntos;

    public Equipo(String nombre, int numeroEquipo, int puntos) {
        this.nombre = nombre;
        this.numeroEquipo = numeroEquipo;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroEquipo() {
        return numeroEquipo;
    }

    public void setNumeroEquipo(int numeroEquipo) {
        this.numeroEquipo = numeroEquipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}
