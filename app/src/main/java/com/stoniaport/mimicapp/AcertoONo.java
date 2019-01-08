package com.stoniaport.mimicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class AcertoONo extends AppCompatActivity {

    String equipo1;
    int puntos1;
    String equipo2;
    int puntos2;
    String equipoActual;
    String pelicula;
    Pelicula peliculaC = new Pelicula();

    boolean cambioDeEquipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerto_ono);

        Bundle estado = getIntent().getExtras();
        if (estado != null) {
            equipo1 = estado.getString("equipo1");

            puntos1 = estado.getInt("puntos1");

            equipo2 = estado.getString("equipo2");
            puntos2 = estado.getInt("puntos2");

            equipoActual = estado.getString("equipoActual");
            pelicula = estado.getString("pelicula");

            peliculaC.setUltimas15(estado.getStringArrayList("ultimas15"));
            peliculaC.setPeliculaYaJugada(estado.getStringArrayList("peliculaYaJugada"));
            peliculaC.setCantidadDeVecesQuePediUnaPelicula(estado.getInt("cantidadDeVecesQuePediUnaPelicula"));

        }
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
        intent(acerto);

        acerto.putExtra("acerto",true);

        startActivity(acerto);
    }

    public void No(View v) {
        Intent noAcerto = new Intent(AcertoONo.this, MainActivity.class);
        intent(noAcerto);

        noAcerto.putExtra("acerto",false);

        startActivity(noAcerto);
    }

    public void intent(Intent intent){
        intent.putExtra("equipo1",equipo1);
        intent.putExtra("puntos1",puntos1);
        intent.putExtra("equipo2",equipo2);
        intent.putExtra("puntos2",puntos2);

        intent.putExtra("equipoActual", equipoActual);
        intent.putExtra("pelicula",pelicula);

        intent.putExtra("ultimas15",peliculaC.getUltimas15());
        intent.putExtra("peliculaYaJugada",peliculaC.getPeliculaYaJugada());
        intent.putExtra("cantidadDeVecesQuePediUnaPelicula",peliculaC.getCantidadDeVecesQuePediUnaPelicula());

    }
}
