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
            "Animales Fantasticos",
            "Armageddon",
            "Batman",
            "Bhoemia Rapsody",
            "Buscando a Dory",
            "Buscando a Nemo",
            "Capitán América",
            "Cars",
            "Carrie",
            "Cementerio de animales",
            "Coraline",
            "Crepusculo",
            "Duro de matar",
            "American graffiti",
            "Armageddon",
            "Baby driver",
            "Bajos instintos",
            "Batman Inicia",
            "Batman Regresa",
            "Black Panter",
            "Cantando bajo la lluvia",
            "Carrera de la muerte",
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
            "Nieve negra",
            "Otra vez 17",
            "Perdida",
            "Viernes 13",
            "Walli-e",
            "Yo, robot",
            "The crow",
            "The Sandman",
            "Beetlejuice",
            "Air bud",
            "Garfield",
            "Peter pan",
            "Arrow",
            "Breaking bad",
            "BoJack Horseman",
            "Mr. Robot",
            "Narcos",
            "Ash Vs Evil dead",
            "Pokémon",
            "The titans",
            "Vikings",
            "Rick and Morty",
            "The wall",
            "Thor Un mundo oscuro",
            "Tomb raider",
            "Toy Story",
            "Truth or dare",
            "Vecinos invasores",
            "Pirañas asesinas",
            "Piratas del Caribe",
            "Pixel",
            "Pocahontas",
            "Predator",
            "Psicosis",
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
