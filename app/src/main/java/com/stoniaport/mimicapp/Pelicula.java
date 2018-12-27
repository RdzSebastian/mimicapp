package com.stoniaport.mimicapp;


import java.util.ArrayList;
import java.util.Random;

class Pelicula{


    private ArrayList<String> ultimas15 = new ArrayList<>();


    String[] pelicula = {
            "300",
            "101 dalmatas",
            "Actividad paranormal",
            "Avengers",
            "American Psycho",
            "Anabel",
            "Anaconda",
            "Aquaman",
            "Air bud",
            "Animales Fantasticos",
            "Armageddon",
            "American graffiti",
            "Armageddon",
            "Arrow",
            "Ash Vs Evil dead",
            "Breaking bad",
            "BoJack Horseman",
            "Batman",
            "Beetlejuice",
            "Bhoemia Rapsody",
            "Buscando a Dory",
            "Buscando a Nemo",
            "Baby driver",
            "Bajos instintos",
            "Batman Inicia",
            "Batman Regresa",
            "Black Panter",
            "Capitán América",
            "Cars",
            "Carrie",
            "Cementerio de animales",
            "Coraline",
            "Crepusculo",
            "Cantando bajo la lluvia",
            "Carrera de la muerte",
            "Duro de matar",
            "El caballero de la noche",
            "El bueno, el malo y el feo",
            "El cadaver de la novia",
            "El conjuro",
            "El doctor Dolitle",
            "El efecto mariposa",
            "El expreso polar",
            "El Grinch",
            "El hombre araña",
            "El juego del miedo",
            "El maquinista",
            "El orfanato",
            "El pianista",
            "El resplandor",
            "El Rey León",
            "El transportador",
            "El precio del mañana",
            "Especies",
            "Extraño mundo de jack",
            "Fight club",
            "Forrest Gump",
            "Frankiewinnie",
            "GhostRider",
            "Garfield",
            "Hackers",
            "Halloween",
            "Harry Potter",
            "Hombre en llamas",
            "Hostel",
            "Hotel Rwanda",
            "Hotel transilvania",
            "Intensamente",
            "Iron Man",
            "It",
            "Juego de gemelas",
            "Jurasik World",
            "Jurasik park",
            "Kill Bill vol 2",
            "King Kong",
            "Krank",
            "Kujo",
            "Mulan",
            "Madagascar",
            "Mars attacks",
            "Matrix",
            "Medianoche en París",
            "Mi nombre es Sam",
            "Mi pobre angelito",
            "Mi villano favorito",
            "Milk",
            "Mision imposible",
            "Monster inc",
            "Mr. Robot",
            "Narcos",
            "Nieve negra",
            "La bruja",
            "La era de hielo",
            "La Masacre de texas",
            "La máscara",
            "La mujer maravilla",
            "La monja",
            "La purga",
            "La sirenita",
            "La ventana indiscreta",
            "Las locuras del emperador",
            "Liberen a willie",
            "Lilo y stich",
            "Logan",
            "Londres bajo fuego",
            "Otra vez 17",
            "Vecinos invasores",
            "Viernes 13",
            "Vikings",
            "Walli-e",
            "Pirañas asesinas",
            "Piratas del Caribe",
            "Pixel",
            "Pocahontas",
            "Predator",
            "Psicosis",
            "Peter pan",
            "Perdida",
            "Pokémon",
            "Rick and Morty",
            "Ralph el demoledor",
            "Rápido y furioso",
            "Resident evil",
            "Scary movie",
            "Scooby doo",
            "Scream",
            "Sharknado",
            "Sinister",
            "Star wars",
            "Star wars",
            "Superman",
            "Taken",
            "Taking Woodstock",
            "Tambo",
            "Terminator",
            "The crow",
            "The Sandman",
            "The titans",
            "The wall",
            "Thor Un mundo oscuro",
            "Tomb raider",
            "Toy Story",
            "Truth or dare",
            "Yo, robot",

    };

    Pelicula() {
    }

    String getPelicula(int cantidadDeVecesQuePediUnaPelicula) {

        Random number = new Random();
        int j = number.nextInt(pelicula.length + 1);
        String peliculaSeleccionada = pelicula[j];

        boolean cambio;

        do {
            cambio = false;
            for (String check : ultimas15) {
                if (check.equals(peliculaSeleccionada)) {

                    j = number.nextInt(pelicula.length + 1);
                    peliculaSeleccionada = pelicula[j];
                    cambio = true;
                    break;
                }
            }
        } while (cambio);


        if (cantidadDeVecesQuePediUnaPelicula>16) {
            ultimas15.remove(0);
            for (int i = 1;i<15;i++){

                String p = ultimas15.get(i);
                ultimas15.add(i-1, p);

            }
            ultimas15.add(15,peliculaSeleccionada);
        }
        else {
            ultimas15.add(peliculaSeleccionada);
        }

    return peliculaSeleccionada;
    }


}
