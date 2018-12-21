package com.stoniaport.mimicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AcertoONo extends AppCompatActivity {

    String equipo1;
    int puntos1;
    String equipo2;
    int puntos2;
    String equipoActual;
    String pelicula;

    boolean cambioDeEquipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerto_ono);

        Bundle estado = getIntent().getExtras();
        equipo1 = estado.getString("equipo1");
        puntos1 = estado.getInt("puntos1");

        equipo2 = estado.getString("equipo2");
        puntos2 = estado.getInt("puntos2");

        equipoActual = estado.getString("equipoActual");
        pelicula = estado.getString("pelicula");

        cambioDeEquipo = true;

    }

    public void Si(View v) {

        if(equipoActual.equals(equipo1)) {
            puntos1++;
        }
        else{
            puntos2++;
        }

        Intent acerto = new Intent(AcertoONo.this, MainActivity.class);

        acerto.putExtra("equipo1",equipo1);
        acerto.putExtra("puntos1",puntos1);
        acerto.putExtra("equipo2",equipo2);
        acerto.putExtra("puntos2",puntos2);

        acerto.putExtra("equipoActual", equipoActual);
        acerto.putExtra("pelicula",pelicula);

        acerto.putExtra("acerto",true);

        startActivity(acerto);
    }

    public void No(View v) {
        Intent noAcerto = new Intent(AcertoONo.this, MainActivity.class);
        noAcerto.putExtra("equipo1",equipo1);
        noAcerto.putExtra("puntos1",puntos1);
        noAcerto.putExtra("equipo2",equipo2);
        noAcerto.putExtra("puntos2",puntos2);

        noAcerto.putExtra("equipoActual", equipoActual);
        noAcerto.putExtra("pelicula",pelicula);

        noAcerto.putExtra("acerto",false);

        startActivity(noAcerto);
    }
}
