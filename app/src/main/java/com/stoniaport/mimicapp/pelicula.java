package com.stoniaport.mimicapp;

import android.content.Intent;
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
    boolean vueltaDeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);


        Bundle datos = getIntent().getExtras();

        equipo1 = datos.getString("equipo1");
        puntos1 = datos.getInt("equipo1");

        equipo2 = datos.getString("equipo2");
        puntos2 = datos.getInt("equipo2");

        equipoActual = datos.getString("equipoActual");


        TextView nombreDeEquipoActual =(TextView)findViewById(R.id.nombreDeEquipoActual);

        nombreDeEquipoActual.setText(equipoActual);

        vueltaDeActivity=true;

    }

    public void volver(View v) {
        Intent intent = new Intent(pelicula.this, MainActivity.class);

        intent.putExtra("equipo1", equipo1);
        intent.putExtra("equipo1", puntos1);
        intent.putExtra("equipo2", equipo2);
        intent.putExtra("equipo2", puntos2);
        intent.putExtra("equipoActual", equipoActual);
        intent.putExtra("vueltaDeActivity", vueltaDeActivity);

        startActivity(intent);
    }
}
