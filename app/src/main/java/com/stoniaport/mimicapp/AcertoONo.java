package com.stoniaport.mimicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class AcertoONo extends AppCompatActivity {


    Equipo equipo1 = new Equipo();
    Equipo equipo2 = new Equipo();
    String equipoActual;

    Pelicula pelicula = new Pelicula();

    boolean cambioDeEquipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerto_ono);

        Bundle estado = getIntent().getExtras();
        if (estado != null) {
            equipo1.setNombre(estado.getString("equipo1"));
            equipo1.setPuntos(estado.getInt("puntos1"));

            equipo2.setNombre(estado.getString("equipo2"));
            equipo2.setPuntos(estado.getInt("puntos2"));

            equipoActual = estado.getString("equipoActual");

            pelicula.setPelicula(estado.getString("pelicula"));
            pelicula.setUltimas15(estado.getStringArrayList("ultimas15"));
            pelicula.setPeliculaYaJugada(estado.getStringArrayList("peliculaYaJugada"));
            pelicula.setCantidadDeVecesQuePediUnaPelicula(estado.getInt("cantidadDeVecesQuePediUnaPelicula"));

        }
        cambioDeEquipo = true;

    }

    public void Si(View v) {

        if(equipoActual.equals(equipo1.getNombre())) {
            equipo1.acerto();
        }
        else{
            equipo2.acerto();
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
        intent.putExtra("equipo1",equipo1.getNombre());
        intent.putExtra("puntos1",equipo1.getPuntos());
        intent.putExtra("equipo2",equipo2.getNombre());
        intent.putExtra("puntos2",equipo2.getPuntos());

        intent.putExtra("equipoActual", equipoActual);
        intent.putExtra("pelicula",pelicula.getPeliculaString());

        intent.putExtra("ultimas15",pelicula.getUltimas15());
        intent.putExtra("peliculaYaJugada",pelicula.getPeliculaYaJugada());
        intent.putExtra("cantidadDeVecesQuePediUnaPelicula",pelicula.getCantidadDeVecesQuePediUnaPelicula());

    }
}
