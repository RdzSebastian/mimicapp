package com.stoniaport.mimicapp;

public class Equipo {
    String nombre;
    int puntos;
    boolean turno;


    Equipo(String nombre, int puntos, boolean turno) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.turno = turno;
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

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    void acerto(){
        puntos++;
    }
}
