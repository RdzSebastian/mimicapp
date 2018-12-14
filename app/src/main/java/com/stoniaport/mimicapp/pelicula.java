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


        Bundle estado = getIntent().getExtras();
        equipo1 = estado.getString("equipo1");
        puntos1 = estado.getInt("puntos1");

        equipo2 = estado.getString("equipo2");
        puntos2 = estado.getInt("puntos2");

        equipoActual = estado.getString("equipoActual");

        TextView nombreDeEquipoActual =findViewById(R.id.nombreDeEquipoActual);
        nombreDeEquipoActual.setText(equipoActual);


    }

    public void volver(View v) {
        Intent intent = new Intent(pelicula.this, MainActivity.class);

        intent.putExtra("equipo1",equipo1);
        intent.putExtra("puntos1",puntos1);
        intent.putExtra("equipo2",equipo2);
        intent.putExtra("puntos2",puntos2);

        intent.putExtra("equipoActual", equipoActual);


        startActivity(intent);
    }
}
