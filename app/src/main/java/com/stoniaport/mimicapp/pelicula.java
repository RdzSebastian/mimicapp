package com.stoniaport.mimicapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pelicula extends AppCompatActivity {

    Button volver;

    String equipo1;
    int puntos1;
    String equipo2;
    int puntos2;
    String equipoActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);

       SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);

     /*    equipo1 = datos.getString("equipo1","equipo1");
        puntos1 = datos.getInt("equipo1",0);

        equipo2 = datos.getString("equipo2","equipo1");
        puntos2 = datos.getInt("equipo2",0);
*/
        equipoActual = datos.getString("equipoActual","equipo1");


        TextView nombreDeEquipoActual =findViewById(R.id.nombreDeEquipoActual);

        nombreDeEquipoActual.setText(equipoActual);


    }

    public void volver(View v) {
        Intent intent = new Intent(pelicula.this, MainActivity.class);

      SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor miEditor = datos.edit();
/*
        miEditor.putString("equipo1",equipo1);
        miEditor.putInt("equipo1",puntos1);

        miEditor.putString("equipo2",equipo2);
        miEditor.putInt("equipo2",puntos2);
*/
        miEditor.putString("equipoActual",equipoActual);

        miEditor.apply();
        startActivity(intent);
    }
}
