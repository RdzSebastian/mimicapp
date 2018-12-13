package com.stoniaport.mimicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button siguiente;
    int contador;
    int numero=1;

    Equipo equipo1 = new Equipo("Equipo 1",1,0);
    Equipo equipo2 = new Equipo("Equipo 2",2,0);
    Equipo equipoActual = equipo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador=0;
        mostrarResultado();

    }

    public void pelicula(View Vista) {
                Intent siguiente = new Intent(MainActivity.this, pelicula.class);
                startActivity(siguiente);
    }

    public void incrementaContador(View Vista){
        contador++;
        mostrarResultado();
    }

    public void decrementaContador(View Vista){
        contador--;
        mostrarResultado();
    }

    public void reseteaContador(View Vista){
        contador=0;
        mostrarResultado();
    }

    public void mostrarResultado(){


        TextView text = (TextView)findViewById(R.id.puntos);
        text.setText("" + contador);
    }



    public void cambioDeEquipo(View Vista){

        TextView text = (TextView)findViewById(R.id.nombre);
        numero++;
        if(numero==2 ){
            equipoActual = equipo2;
        }
        else {
            numero=1;
            equipoActual=equipo1;
        }
        text.setText(equipoActual.getNombre());
    }
}
