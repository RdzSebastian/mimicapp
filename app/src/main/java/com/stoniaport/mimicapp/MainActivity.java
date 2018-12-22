package com.stoniaport.mimicapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    int puntos;
    String nombre;
    String pelicula;
    int cantidadDeVecesQuePediUnaPelicula;
    ArrayList<String> peliculaYaJugada = new ArrayList<>();

    Equipo equipo1 = new Equipo("Equipo 1", 0);
    Equipo equipo2 = new Equipo("Equipo 2", 0);
    Equipo equipoActual = equipo1;

    Pelicula peliculaC = new Pelicula();

    boolean cambio;

    private TextView countDownText;

    private long timeLeftInMiliseconds = 60000; // 1min

    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countDownText = findViewById(R.id.tiempo);

        puntos = 0;
        mostrarResultado();

        cantidadDeVecesQuePediUnaPelicula = 0;

        pelicula="";

    }


    //-------------- OnResume (cuando vienen de otra activity -----------------
    @Override
    public void onResume() {
        super.onResume();
        Bundle datos = getIntent().getExtras();

        if (datos != null) {


            String equipo1String = datos.getString("equipo1");
            equipo1.setNombre(equipo1String);

            int puntos1 = datos.getInt("puntos1");
            equipo1.setPuntos(puntos1);

            String equipo2String = datos.getString("equipo2");
            equipo2.setNombre(equipo2String);

            int puntos2 = datos.getInt("puntos2");
            equipo2.setPuntos(puntos2);

            pelicula = datos.getString("pelicula");


            boolean acerto = datos.getBoolean("acerto");

            if (acerto) {
                peliculaYaJugada.add(pelicula);
            }


            String equipoActualString = datos.getString("equipoActual");

            if (equipoActualString != null) {
                if (equipoActualString.equals(equipo1String)) {
                    equipoActual = equipo1;
                    cambioDeEquipo();
                } else {
                    equipoActual = equipo2;
                    cambioDeEquipo();
                }
            }
            mostrarResultado();
        }
    }


    //-----------  On pause ----------------------------------
    @Override
    public void onPause() {
        super.onPause();

    }


    //------------ Va a buscar la peli al metodo de la class ----------------


    public void buscarPelicula(View Vista) {
        pelicula = peliculaC.getPelicula(cantidadDeVecesQuePediUnaPelicula);
        cantidadDeVecesQuePediUnaPelicula++;

        while (yaSalio()) {
            buscarPelicula();
        }

        mostrarResultado();

    }


    public void buscarPelicula() {

        pelicula = peliculaC.getPelicula(cantidadDeVecesQuePediUnaPelicula);
        cantidadDeVecesQuePediUnaPelicula++;

    }

    public boolean yaSalio() {
        for (String check : peliculaYaJugada) {
            if (check.equals(pelicula)) {
                return true;
            }
        }

        peliculaYaJugada.add(pelicula);
        return false;
    }

    //---------------- Mostrar puntaje y equipo en la pantalla --------------------


    public void mostrarResultado() {
        TextView textEquipo1 = findViewById(R.id.Equipo1);
        String nombreEquipo1 = equipo1.getNombre();
        textEquipo1.setText(nombreEquipo1);

        TextView textPuntos1 = findViewById(R.id.puntos1);
        int nombrePuntos1 = equipo1.getPuntos();
        String nombreEquipo1String = Integer.toString(nombrePuntos1);
        textPuntos1.setText(nombreEquipo1String);


        TextView textEquipo2 = findViewById(R.id.Equipo2);
        String nombreEquipo2 = equipo2.getNombre();
        textEquipo2.setText(nombreEquipo2);

        TextView textPuntos2 = findViewById(R.id.puntos2);
        int nombrePuntos2 = equipo2.getPuntos();
        String nombreEquipo2String = Integer.toString(nombrePuntos2);
        textPuntos2.setText(nombreEquipo2String);

        TextView textNombre = findViewById(R.id.nombre);
        nombre = equipoActual.getNombre();
        textNombre.setText(nombre);


        TextView PeliculaV = findViewById(R.id.PeliculaSelect);
        PeliculaV.setText(pelicula);

    }


    //--------------------Cambio de equipo------------------------------------


    public void cambioDeEquipo() {
        if (equipo1.getNombre().equals(equipoActual.getNombre())) {
            equipoActual = equipo2;
        } else {
            equipoActual = equipo1;
        }
        mostrarResultado();
    }


    //------------------------ Restart juego ---------------------------------------------


    public void reseteaContador(View Vista) {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("¿ Quiere reiniciar el juego?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                aceptar();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
            }
        });
        dialogo1.show();

    }

    public void aceptar() {
        equipoActual.setPuntos(0);
        cambioDeEquipo();
        equipoActual.setPuntos(0);
        equipoActual = equipo1;
        pelicula = "";

        if (countDownTimer != null) {
            restartTimmer();
        }

        mostrarResultado();
    }





    //--------------------------Apreto Empezar sin pelicula----------------------------------

    public void noElegioPelicula() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("No elegiste una pelicula");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
            }
        });

        dialogo1.show();

    }



    //--------------------------------Timer----------------------------------------------


    public void startTimer(View view) {
        if(pelicula.equals("")){
            noElegioPelicula();
        }else {
            countDownTimer = new CountDownTimer(timeLeftInMiliseconds, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    timeLeftInMiliseconds = millisUntilFinished;
                    updateTimer();
                }

                @Override
                public void onFinish() {
                    timeLeftInMiliseconds = 60000;
                    Acierto();
                }

            }.start();
        }
    }



    public void updateTimer(){
        int minutes = (int) timeLeftInMiliseconds / 60000;
        int seconds = (int) timeLeftInMiliseconds % 60000/1000;

        String timeLeftText;

        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if(seconds<10) timeLeftText +="0";
        timeLeftText += seconds;

        countDownText.setText(timeLeftText);
    }


    public void restartTimmer(){
        countDownTimer.cancel();
        countDownTimer = null;
        timeLeftInMiliseconds = 60000;
        updateTimer();

    }


    //-------Almacena datos si doy vuelta la pantalla o si la pongo en segundo plano---------------

    public void onSaveInstanceState(Bundle estado){

        estado.putString("equipo1",equipo1.getNombre());
        estado.putInt("equipo1",equipo1.getPuntos());

        estado.putString("equipo2",equipo2.getNombre());
        estado.putInt("equipo2",equipo2.getPuntos());

       estado.putString("equipoActual",equipoActual.getNombre());

        super.onSaveInstanceState(estado);
    }


    public void onRestoreInstanceState(Bundle estado){

        super.onRestoreInstanceState(estado);

        equipo1.setNombre(estado.getString("equipo1"));
        equipo1.setPuntos(estado.getInt("equipo1"));

        equipo2.setNombre(estado.getString("equipo2"));
        equipo2.setPuntos(estado.getInt("equipo2"));


        if(equipo1.getNombre().equals(estado.getString("equipoActual"))) {
            equipoActual = equipo1;
        }
        else {

            equipoActual = equipo2;
        }

        mostrarResultado();

    }



    public void Acierto() {

        if(countDownTimer != null) {
            restartTimmer();
        }

        Intent AcertoONo = new Intent(MainActivity.this, AcertoONo.class);

        AcertoONo.putExtra("equipo1",equipo1.getNombre());
        AcertoONo.putExtra("puntos1",equipo1.getPuntos());

        AcertoONo.putExtra("equipo2",equipo2.getNombre());
        AcertoONo.putExtra("puntos2",equipo2.getPuntos());

        AcertoONo.putExtra("equipoActual", equipoActual.getNombre());
        AcertoONo.putExtra("pelicula", pelicula);


        startActivity(AcertoONo);

    }

    public void Acierto(View view) {

        if(pelicula.equals("")){
            noElegioPelicula();
        }else {


            if (countDownTimer != null) {
                restartTimmer();
            }

            Intent AcertoONo = new Intent(MainActivity.this, AcertoONo.class);

            AcertoONo.putExtra("equipo1", equipo1.getNombre());
            AcertoONo.putExtra("puntos1", equipo1.getPuntos());

            AcertoONo.putExtra("equipo2", equipo2.getNombre());
            AcertoONo.putExtra("puntos2", equipo2.getPuntos());

            AcertoONo.putExtra("equipoActual", equipoActual.getNombre());
            AcertoONo.putExtra("pelicula", pelicula);
            startActivity(AcertoONo);
        }
    }
}

