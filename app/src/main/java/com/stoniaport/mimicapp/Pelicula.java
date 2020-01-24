package com.stoniaport.mimicapp;


import java.util.ArrayList;
import java.util.Random;

class Pelicula{

    private String pelicula;
    private ArrayList<String> ultimas15 = new ArrayList<>();
    private ArrayList<String> peliculaYaJugada = new ArrayList<>();
    private int cantidadDeVecesQuePediUnaPelicula=0;


    private String[] peliculaArray = {
            "¿Qué pasó con Lunes?",
            "10 cosas que odio de ti",
            "13 reasons why",
            "2001 Odisea en el espacio",
            "Abzurdah",
            "Agente 007",
            "Alicia en el pais de las maravillas",
            "Amadeus",
            "Amelie",
            "American         History X",
            "American horror story",
            "Amigos con derechos",
            "Annabelle",
            "Ant-Man",
            "Apocalypto",
            "Arenas movedizas",
            "Arrow",
            "Así nos ven",
            "Assassin's creed",
            "Atypical",
            "Bajos instintos",
            "Bandersnatch",
            "Bastardos sin gloria",
            "Batman",
            "Beetlejuice",
            "Big hero 6",
            "Bird box",
            "Black miror",
            "Black Panter",
            "Blade Runner",
            "Blindpost",
            "BoJack Horseman",
            "Bolt",
            "Breaking bad",
            "Capitán América",
            "Capitana Marvel",
            "Carrera de la    muerte",
            "Carrie",
            "Cars",
            "Casino",
            "Cementerio de animales",
            "Chernobyl",
            "Chicas buenas",
            "Cincuenta Sombras de Grey",
            "Civil war",
            "Coco",
            "Contratiempo",
            "Coraline",
            "Cube",
            "Dark",
            "Dead man",
            "DeadPool",
            "Déjà vu",
            "Dentro del      laberinto",
            "Desde mi cielo",
            "Detective Pikachu",
            "Doctor Foster",
            "Doctor Strange",
            "Duro de matar",
            "E.T",
            "El efecto mariposa",
            "El barco",
            "El bueno, el malo y el feo",
            "El Código Da Vinci",
            "El color del        Dinero",
            "El conjuro",
            "El cuervo",
            "El demonio vestido de azul",
            "El día después de mañana",
            "El diario de la princesa",
            "El Exorcista",
            "El extraño mundo de jack",
            "El Grinch",
            "El juego del miedo",
            "El maquinista",
            "El marginal",
            "El orfanato",
            "El padrino",
            "El perfume",
            "El potro",
            "El precio del   mañana",
            "El resplandor",
            "El transportador",
            "El turista",
            "Élite",
            "Feliz día de tu  muerte",
            "Fight club",
            "Friends",
            "Frozen",
            "Games of thrones",
            "GhostRider",
            "Gossip girl",
            "Grey's anatomy",
            "Hackers",
            "Halloween",
            "Han Solo",
            "Hannibal",
            "Hasta el hueso",
            "Hill House",
            "El hilo rojo",
            "Hombre en llamas",
            "House of cards",
            "House",
            "How to sell drugs online (fast)",
            "Huye",
            "Intensamente",
            "Interestelar",
            "Iron man",
            "It",
            "Juego de gemelas",
            "Kill Bill",
            "Krank",
            "Kun fu panda",
            "La casa de papel",
            "La cenicienta",
            "La era de hielo",
            "La La Land",
            "La lista de      Schindler ",
            "La máscara",
            "La monja",
            "La mujer maravilla",
            "La purga",
            "La sirenita",
            "La vida es bella ",
            "Las locuras del emperador",
            "Lego",
            "Liberen a Willy",
            "Lilo y stich",
            "Locas por las compras",
            "Logan",
            "Los increibles",
            "Los Simpson",
            "Lost",
            "Love Death + Robots",
            "Lucifer",
            "Lucy",
            "Mad max",
            "Maniac",
            "Mary Poppins",
            "Match point",
            "Matilda",
            "Matrix",
            "Medianoche en    París",
            "Megalodón",
            "Merlí",
            "Mi nombre es Sam",
            "Milk",
            "Misery",
            "Misión imposible",
            "Monster inc",
            "Mulan",
            "Once upon a time",
            "Orange is the new black",
            "17 otra vez",
            "Peaky blinders",
            "Perdida",
            "Pinocho",
            "Pirañas asesinas",
            "Pixel",
            "Poseidón",
            "Psicosis",
            "Pulp Fiction",
            "Ralph el demoledor",
            "Ratatouille",
            "Red social",
            "Reservoir Dogs",
            "Resident evil",
            "Rick and Morty",
            "Rocky",
            "Roge One",
            "Sabrina",
            "Scarface",
            "Scary movie",
            "Scooby doo",
            "Scream",
            "Sex education",
            "Sherlock Homes",
            "Shrek",
            "Sinister",
            "Skins",
            "Soy Leyenda",
            "Star Trek",
            "Star wars",
            "Stranger things",
            "Taxi Driver",
            "Terminator",
            "The alienist",
            "The society",
            "The tourist",
            "The umbrella academy",
            "The walking dead",
            "The wall",
            "Thor",
            "Tiempos modernos",
            "Tiempos violentos",
            "Tierra de zombies",
            "Tomb raider",
            "Toy Story",
            "Transformers",
            "The Truman Show",
            "Truth or dare",
            "Un jefe en pañales",
            "UP",
            "V de Venganza",
            "Viernes 13",
            "Viernes de locos",
            "Vikings",
            "VIS a VIS",
            "Wall-E",
            "Warcraft",
            "Yo, robot",
            "YOU",
            "Zootopia",
    };

    Pelicula() {
    }

    // --------------------- Getter Setter ----------------------------


    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    String getPeliculaString(){
        return pelicula;
    }


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

    void peliculaYaJugada(){
        this.peliculaYaJugada.add(pelicula);
        //System.out.println("Agregar a la lista de jugadas" + peliculaYaJugada);
    }


    //---------------------- Pelicula que ya se jugo ----------------------------

     boolean yaSalio() {
         //System.out.println("Lista de jugadas ");
        for (String check : peliculaYaJugada) {
            //System.out.println(check);
            if (check.equals(pelicula)) {
                //System.out.println("lista "+check);
                //System.out.println("nueva= "+peliculaSeleccionada);
                return true;
            }
        }

        return false;
    }


    //--------------------- Logica de Busqueda de peliculas ---------------------

    void getPelicula() {
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
        setPelicula(peliculaSeleccionada);
        //System.out.println("Pelicula nueva " + peliculaSeleccionada);

        cantidadDeVecesQuePediUnaPelicula++;
        //System.out.println(cantidadDeVecesQuePediUnaPelicula);
    }



    private String peliculaSeleccionada(){
        Random number = new Random();
        int j = number.nextInt(peliculaArray.length + 1);
    return  peliculaArray[j];
    }


}
