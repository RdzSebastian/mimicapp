package com.stoniaport.mimicapp;


import java.util.ArrayList;
import java.util.Random;

class Pelicula{


    private ArrayList<String> ultimas15 = new ArrayList<>();


    String[] pelicula = {
            "2001 Odisea en el espacio",
            "10 razones para odiarte",
            "Toy Story",
            "Amadeus",
            "Amelie",
            "American History X ",
            "Apocalypto",
            "Air bud",
            "Arrow",
            "Ant-Man",
            "Agente 007",
            "Assassin's creed",
            "Toy Story",
            "Babel",
            "Bangkok Dangerous",
            "Big fish",
            "Blade Runner",
            "Black hawk",
            "Boat trip",
            "Buffalo 66",
            "Breaking bad",
            "BoJack Horseman",
            "Beetlejuice",
            "Black miror",
            "Baby driver",
            "Bajos instintos",
            "Black Panter",
            "Capitán América",
            "Casino",
            "Charada",
            "Cube",
            "Cars",
            "Coco",
            "Carrie",
            "Cementerio de animales",
            "Coraline",
            "Cantando bajo la lluvia",
            "Carrera de la muerte",
            "Cincuenta Sobras de Grey",
            "Dead man",
            "DeadPool",
            "Deep blue sea",
            "Deja vu",
            "Doctor Strange",
            "Dentro del laberitno",
            "Desafio total",
            "Duro de matar",
            "E.T",
            "El Código Da Vinci",
            "El coleccionista de huesos",
            "El color del Dinero",
            "El cuervo",
            "El demonio vestio de azul",
            "El día de mañana",
            "El Exorcista",
            "El bueno, el malo y el feo",
            "El conjuro",
            "El efecto mariposa",
            "El Grinch",
            "El juego del miedo",
            "El maquinista",
            "El orfanato",
            "El resplandor",
            "El transportador",
            "El precio del mañana",
            "El padrino",
            "Extraño mundo de jack",
            "Fight club",
            "Feliz dia de tu muerte",
            "GhostRider",
            "Garganta profunda",
            "Hannibal",
            "Hill House",
            "Han Solo",
            "Hackers",
            "Halloween",
            "Hombre en llamas",
            "Huye",
            "Intensamente",
            "It",
            "Interestelar",
            "Juego de gemelas",
            "Kill Bill",
            "Krank",
            "Kun fu panda",
            "Kujo",
            "Mulan",
            "Matrix",
            "Mary Poppins",
            "Medianoche en París",
            "Mi nombre es Sam",
            "Milk",
            "Mision imposible",
            "Monster inc",
            "Match point",
            "Misery",
            "Megalodon",
            "Mad max",
            "La bruja",
            "La niebla",
            "La era de hielo",
            "La lista de schindler ",
            "La máscara",
            "La cenicienta",
            "La mujer maravilla",
            "La monja",
            "La purga",
            "La sirenita",
            "La vida es bella ",
            "Las chicas del calendario",
            "Las 13 rosas",
            "Las locuras del emperador",
            "La forma del agua",
            "La La Land",
            "Lego",
            "Liberen a willie",
            "Lilo y stich",
            "Los Goonies",
            "Los Simpson",
            "Logan",
            "Londres bajo fuego",
            "Otra vez 17",
            "Viernes 13",
            "Vikings",
            "Walli-e",
            "Pearl Harbour",
            "Philadelphia",
            "Poseidón",
            "Pulp Fiction",
            "Pirañas asesinas",
            "Pixel",
            "Psicosis",
            "Perdida",
            "Rick and Morty",
            "Ralph el demoledor",
            "Reservoir Dogs",
            "Resident evil",
            "Rocky",
            "Roge One",
            "Scary movie",
            "Scooby doo",
            "Scream",
            "Sinister",
            "Star wars",
            "Soy Leyenda",
            "Scarface",
            "Sabrina",
            "Star Trek",
            "Tambo",
            "Transformers",
            "Tiempos modernos",
            "Terminator",
            "The titans",
            "The wall",
            "Thor Un mundo oscuro",
            "Tomb raider",
            "Toy Story",
            "Truth or dare",
            "Truman Show",
            "Taxi Driver",
            "Una rubia muy legal",
            "Un jefe en pañales",
            "V de Vendetta",
            "Viernes 13",
            "Yo, robot",
            "Warcraft",
            "Zoolander",
            "Zootopia"


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
