package com.stoniaport.mimicapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    Equipo equipo1 = new Equipo("Equipo 1", 0);
    Equipo equipo2 = new Equipo("Equipo 2", 0);
    Equipo equipoActual = equipo1;

    Pelicula peliculaC = new Pelicula();
    String pelicula;

    private TextView countDownText;

    private long timeLeftInMiliseconds = 60000; // 1min

    CountDownTimer countDownTimer;

    Button customButton;
    MediaPlayer mp;
    ImageView selectorDeEquipo1;
    ImageView selectorDeEquipo2;

    boolean jugando;


    //------------------------- OnCreate --------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countDownText = findViewById(R.id.tiempo);

        pelicula="Presiona para obtener pelicula";

        mp = MediaPlayer.create(this,R.raw.silbato);

        customButton = findViewById(R.id.buttonEmpezar);
        customButton.setSelected(false);
        jugando=false;

        selectorDeEquipo1 = findViewById(R.id.avocadoEquipo1);
        selectorDeEquipo1.setVisibility(View.VISIBLE);

        selectorDeEquipo2 = findViewById(R.id.avocadoEquipo2);
        selectorDeEquipo2.setVisibility(View.INVISIBLE);

        mostrarResultado();
    }


    //-------------- OnResume (cuando vienen de otra activity -----------------

    @Override
    public void onResume() {
        super.onResume();
        Bundle datos = getIntent().getExtras();

        if (datos != null) {


            equipo1.setNombre(datos.getString("equipo1"));
            equipo1.setPuntos(datos.getInt("puntos1"));

            equipo2.setNombre(datos.getString("equipo2"));
            equipo2.setPuntos(datos.getInt("puntos2"));

            pelicula = datos.getString("pelicula");

            peliculaC.setUltimas15(datos.getStringArrayList("ultimas15"));
            peliculaC.setPeliculaYaJugada(datos.getStringArrayList("peliculaYaJugada"));
            peliculaC.setCantidadDeVecesQuePediUnaPelicula(datos.getInt("cantidadDeVecesQuePediUnaPelicula"));

            boolean acerto = datos.getBoolean("acerto");

            if (acerto) {
                peliculaC.peliculaYaJugada(pelicula);
            }


            String equipoActualString = datos.getString("equipoActual");

            if (equipoActualString != null) {
                if (equipoActualString.equals(datos.getString("equipo1"))) {
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


    //------------ Va a buscar la peli al metodo de la class ----------------

    public void buscarPelicula(View Vista){
        try {
            buscarPelicula();
            }catch (Exception e){
                System.out.println("Error buscando pelicula");
        }

        while (peliculaC.yaSalio(pelicula)) {
            buscarPelicula();
        }

        mostrarResultado();
    }


    public void buscarPelicula() {

        pelicula = peliculaC.getPelicula();
    }

    //---- Dependiendo la cantidad de caracteres, cambia el marginTop en la parte visual ------

    void marginPeliculaSelect(String pelicula){
        if(pelicula.length()>20){
            TextView peliculaSelect = findViewById(R.id.PeliculaSelect);
            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) peliculaSelect.getLayoutParams();
            mlp.setMargins(0, 0, 0, 0);
        }else{
            TextView peliculaSelect = findViewById(R.id.PeliculaSelect);
            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) peliculaSelect.getLayoutParams();
            mlp.setMargins(0, 35, 0, 0);
        }
    }



    //---------------- Mostrar puntaje y equipo en la pantalla --------------------


    public void mostrarResultado() {
        marginPeliculaSelect(pelicula);

        TextView textEquipo1 = findViewById(R.id.Equipo1);
        textEquipo1.setText(equipo1.getNombre());

        TextView textPuntos1 = findViewById(R.id.puntos1);
        int nombrePuntos1 = equipo1.getPuntos();
        String nombreEquipo1String = Integer.toString(nombrePuntos1);
        textPuntos1.setText(nombreEquipo1String);


        TextView textEquipo2 = findViewById(R.id.Equipo2);
        textEquipo2.setText(equipo2.getNombre());

        TextView textPuntos2 = findViewById(R.id.puntos2);
        int nombrePuntos2 = equipo2.getPuntos();
        String nombreEquipo2String = Integer.toString(nombrePuntos2);
        textPuntos2.setText(nombreEquipo2String);


        TextView PeliculaV = findViewById(R.id.PeliculaSelect);
        PeliculaV.setText(pelicula);

        if(equipoActual.getNombre().equals(equipo1.getNombre())){
            textEquipo1.setTypeface(null,Typeface.BOLD);
            textEquipo2.setTypeface(Typeface.SANS_SERIF);

            selectorDeEquipo1 = findViewById(R.id.avocadoEquipo1);
            selectorDeEquipo1.setVisibility(View.VISIBLE);

            selectorDeEquipo2 = findViewById(R.id.avocadoEquipo2);
            selectorDeEquipo2.setVisibility(View.INVISIBLE);


        }else{
            textEquipo1.setTypeface(Typeface.SANS_SERIF);
            textEquipo2.setTypeface(null,Typeface.BOLD);

            selectorDeEquipo1 = findViewById(R.id.avocadoEquipo1);
            selectorDeEquipo1.setVisibility(View.INVISIBLE);

            selectorDeEquipo2 = findViewById(R.id.avocadoEquipo2);
            selectorDeEquipo2.setVisibility(View.VISIBLE);


            }

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
        if(pelicula.equals("Presiona para obtener pelicula")){
            noElegioPelicula();
        }else {
            if(jugando) {
                Acierto();
                jugando=false;
            }
            else {
                customButton.setSelected(true);
                jugando=true;

                countDownTimer = new CountDownTimer(timeLeftInMiliseconds, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        timeLeftInMiliseconds = millisUntilFinished;
                        updateTimer();
                    }

                    @Override
                    public void onFinish() {
                        timeLeftInMiliseconds = 60000;
                        mp.start();
                        Acierto();
                    }


                }.start();
            }
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

        estado.putString("pelicula", pelicula);

        super.onSaveInstanceState(estado);
    }


    public void onRestoreInstanceState(Bundle estado){

        super.onRestoreInstanceState(estado);

        equipo1.setNombre(estado.getString("equipo1"));
        equipo1.setPuntos(estado.getInt("equipo1"));

        equipo2.setNombre(estado.getString("equipo2"));
        equipo2.setPuntos(estado.getInt("equipo2"));

        pelicula = estado.getString("pelicula");


        if(equipo1.getNombre().equals(estado.getString("equipoActual"))) {
            equipoActual = equipo1;
        }
        else {

            equipoActual = equipo2;
        }

        mostrarResultado();

    }



    //----------------------- Boton Stop o Termino el tiempo --------------------------------------

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

        AcertoONo.putExtra("ultimas15",peliculaC.getUltimas15());
        AcertoONo.putExtra("peliculaYaJugada",peliculaC.getPeliculaYaJugada());
        AcertoONo.putExtra("cantidadDeVecesQuePediUnaPelicula",peliculaC.getCantidadDeVecesQuePediUnaPelicula());


        startActivity(AcertoONo);

    }
    //----------------------- No se puede usar boton atras ----------------------

    @Override
    public void onBackPressed(){
    }


}

