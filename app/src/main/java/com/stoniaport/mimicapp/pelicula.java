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
    String peliculaSeleccionada;

    private String[] pelicula = {
            "300",
            "101 dalmatas",
            "Actividad paranormal",
            "Avengers",
            "Alien",
            "el octavo pasajero",
            "American Psycho",
            "Anabel",
            "Anaconda",
            "Aquaman",
            "Animales Fantasticos",
            "Armageddon",
            "Batman",
            "Bhoemia Rapsody",
            "Blancanieves y los siete enanitos",
            "Buscando a Dory",
            "Buscando a Nemo",
            "Capitán América",
            "Cars",
            "Carrie",
            "cementerio de animales",
            "Coraline",
            "Crepusculo",
            "Duro de matar",
            "El conjuro"
    };

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


        int i = (int) (Math.random() * 25) + 1;
        peliculaSeleccionada = pelicula[i];

        TextView Pelicula = findViewById(R.id.PELICULA);
        Pelicula.setText(peliculaSeleccionada);

    }

    public void volver(View v) {
        Intent intent = new Intent(pelicula.this, MainActivity.class);

        intent.putExtra("equipo1",equipo1);
        intent.putExtra("puntos1",puntos1);
        intent.putExtra("equipo2",equipo2);
        intent.putExtra("puntos2",puntos2);

        intent.putExtra("equipoActual", equipoActual);

        intent.putExtra("pelicula", peliculaSeleccionada);


        startActivity(intent);
    }




}

/*
        American graffiti
        los crimenes de Grindelwald
        Armageddon
        Baby driver
        Bajos instintos
         el caballero de la noche
        Batman Inicia
        Batman regresa
        Black Panter
        Cantando bajo la lluvia

        Carrera de la muerte
        Death race

        El bueno, el malo y el feo
        El cadaver de la novia

        El día que la tierra se detuvo
        El doctor Dolitle
        El efecto mariposa
        El expreso polar
        El Grinch
        El hombre araña
        El juego del miedo
        El maquinista
        el orfanato
        El perfume: historia de un asesino
        El pianista
        El resplandor
        El Rey León
        El transportador
        Especies
        Eterno resplandor de una mente sin recuerdos
        Extraño mundo de jack
        Fight club
        Forrest Gump
        Frankie winnie
        GhostRider
        Hackers
        Halloween
        Harry Potter
        hombre en llamas
        Hostel
        Hotel Rwanda
        Hotel transilvania
        Intensamente
        Iron Man
        it
        Juego de gemelas
        Jurasick World
        Jurásik parck
        Kill Bill vol 2
        King Kong
        Krank
        Kujo
        Mulan
        Ni idea
        Nieve negra
        otra vez 17
        Perdida
        Viernes 13
        Walli-e
        Y donde está el fantasma
        Yo, robot
        The crow
        The Sandman
        El joven manos de tijeras
        Beetlejuice
        Air bud
        Garfield
        La mujer maravilla
        Inteligencia Artificial
        Peter pan
        El precio del mañana
        Arrow
        Breaking bad
        BoJack Horseman
        Mr. Robot
        Narcos
        Ash Vs Evil dead
        Pokémon
        The titans
        Vikings
        Rick and Morty
        The wall
        Thor .Un mundo oscuro
        Tom raider
        Toy Story
        Truth or dare
        vecinos invasores
        Pesadilla en la calle Elm
        pirañas asesinas
        Piratas del Caribe
        pixel
        Pocahontas
        pocajontas
        Predator
        Psicosis
        ralph el demoledor
        Rápido y furioso
        Resident evil
        Scary movie
        Scooby doo
        Scott Pilgrim Vs the world
        Scream
        Sharknado
        sinister
        star wars el despertar de la fuerza
        star wars el retorno del jedi
        Superman
        Taken
        Taking Woodstock
        Tambo
        Terminator
        la bruja
        la era de hielo
        La leyenda del jinete sin cabeza
        LA Masacre de texas
        La máscara
        la monja
        La purga
        La sirenita
        La ventana indiscreta
        Las locuras del emperador
        liberen a willie
        Lilo y stich
        Logan
        londres bajo fuego
        madagascar
        Mars attacks
        Matrix
        Medianoche en París
        Mi nombre es Sam
        Mi pobre angelito
        Mi villano favorito
        Milk
        Mission impossible
        Moster inc
        Pesadilla en la calle elm

*/