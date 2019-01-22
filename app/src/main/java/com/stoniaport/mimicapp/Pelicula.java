package com.stoniaport.mimicapp;


import java.util.ArrayList;
import java.util.Random;

class Pelicula{


    private ArrayList<String> ultimas15 = new ArrayList<>();
    private ArrayList<String> peliculaYaJugada = new ArrayList<>();
    private int cantidadDeVecesQuePediUnaPelicula=0;


    String[] pelicula = {
            "2001 Odisea en el espacio",
            "10 razones para odiarte",
            "Toy Story",
            "Amadeus",
            "Amelie",
            "American         History X",
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
            "Carrera de la    muerte",
            "Cincuenta Sombras de Grey",
            "Dead man",
            "DeadPool",
            "Deep blue sea",
            "Deja vu",
            "Doctor Strange",
            "Dentro del      laberinto",
            "Desafio total",
            "Duro de matar",
            "E.T",
            "El Código Da Vinci",
            "El coleccionista de huesos",
            "El color del        Dinero",
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
            "El precio del   mañana",
            "El padrino",
            "Extraño mundo de jack",
            "Fight club",
            "Feliz dia de tu  muerte",
            "GhostRider",
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
            "Medianoche en    París",
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
            "La lista de      schindler ",
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
            "Una rubia muy    legal",
            "Un jefe en pañales",
            "V de Vendetta",
            "Viernes 13",
            "Yo, robot",
            "Warcraft",
            "Zoolander",
            "Zootopia",
            //Peliculas agregadas por mica
            "house",
            "Brid box",
            "Merlí",
            "El potro",
            "La casa de papel",
            "El diario de la princesa",
            "Frisen",
            "Intensamente",
            "Bolt",
            "Jefe en pañales",
            "Sherlock Homes",
            "Friends",
            "Shrek",
            "Hill house",
            "Viernes de locos",
            "Gossip girl",
            "Skins",
            "Atypical",
            "Caroline",
            "Dark",
            "Amelie",
            "Hasta el hueso",
            "Hilo rojo",
            "Absurdah",
            "Locas por las compras",
            "Desde mi cielo",
            "Matilda",
            "El turista",
            "El marginal",
            "Lost",
            "Chicas buenas",
            "El perfume",



    };

    Pelicula() {
    }

    // --------------------- Getter Setter ----------------------------

    ArrayList<String> getUltimas15() {
        return ultimas15;
    }

    void setUltimas15(ArrayList<String> ultimas15) {

        this.ultimas15 = ultimas15;
    }

    ArrayList<String> getPeliculaYaJugada() {
        return peliculaYaJugada;
    }

    void setPeliculaYaJugada(ArrayList<String> peliculaYaJugada) {
        this.peliculaYaJugada = peliculaYaJugada;
    }

    int getCantidadDeVecesQuePediUnaPelicula() {
        return cantidadDeVecesQuePediUnaPelicula;
    }

    void setCantidadDeVecesQuePediUnaPelicula(int cantidadDeVecesQuePediUnaPelicula) {
        this.cantidadDeVecesQuePediUnaPelicula = cantidadDeVecesQuePediUnaPelicula;
    }

    //--------------------------------- Acerto ----------------------------------

    void peliculaYaJugada(String peliculaYaJugada){
        this.peliculaYaJugada.add(peliculaYaJugada);
        //System.out.println("Agregar a la lista de jugadas" + peliculaYaJugada);
    }


    //---------------------- Pelicula que ya se jugo ----------------------------

     boolean yaSalio(String peliculaSeleccionada) {
         //System.out.println("Lista de jugadas ");
        for (String check : peliculaYaJugada) {

            if (check.equals(peliculaSeleccionada)) {
                //System.out.println("lista "+check);
                //System.out.println("nueva= "+peliculaSeleccionada);
                return true;
            }
        }

        return false;
    }


    //--------------------- Logica de Busqueda de peliculas ---------------------

    String getPelicula() {
        //System.out.println(cantidadDeVecesQuePediUnaPelicula);
        String peliculaSeleccionada = peliculaSeleccionada();
        boolean cambio;

        do {
            cambio = false;
            for (String check : ultimas15) {
                //System.out.print(check);
                if (check.equals(peliculaSeleccionada)) {
                    //System.out.println("FILTRO " + peliculaSeleccionada);
                    peliculaSeleccionada = peliculaSeleccionada();
                    cambio = true;
                    break;
                }
            }
        } while (cambio);


        if (cantidadDeVecesQuePediUnaPelicula > 14) {

            ultimas15.remove(0);
            ultimas15.add(peliculaSeleccionada);
            //System.out.println("Pelicula proxima a eliminar " + ultimas15.get(0));
        } else {
            ultimas15.add(peliculaSeleccionada);
        }
        //System.out.println("Pelicula nueva" + peliculaSeleccionada);

        cantidadDeVecesQuePediUnaPelicula++;
        //System.out.println(cantidadDeVecesQuePediUnaPelicula);
    return peliculaSeleccionada;
    }



    private String peliculaSeleccionada(){
        Random number = new Random();
        int j = number.nextInt(pelicula.length + 1);
    return  pelicula[j];
    }


}
