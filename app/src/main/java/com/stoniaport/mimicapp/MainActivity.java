package com.stoniaport.mimicapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int puntos;
    int numero = 1;
    String nombre;
    boolean vueltaDeActivity=false;

    Equipo equipo1 = new Equipo("Equipo 1", 1, 0);
    Equipo equipo2 = new Equipo("Equipo 2", 2, 0);
    Equipo equipoActual = equipo1;

    private CountDownTimer countDownTimer;
    private TextView countDownText;
    private Button countDownButton;
    private long timeLeftInMiliseconds = 60000; // 1min


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countDownText = findViewById(R.id.tiempo);
        countDownButton = findViewById(R.id.buttonTime);

        puntos = 0;
        mostrarResultado();

        countDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

    }

    //-------------- OnResume (cuando vienen de otra activity -----------------
    @Override
    public void onResume() {
        super.onResume();

        Bundle datos = getIntent().getExtras();
        if (datos != null) {
            vueltaDeActivity = datos.getBoolean("vueltaDeActivity");
        }


        if (vueltaDeActivity) {

            String equipoA = datos.getString("equipo1");
            int puntosA = datos.getInt("equipo1");

            String equipoB = datos.getString("equipo2");
            int puntosB = datos.getInt("equipo2");

            String equipoActualString = datos.getString("equipoActual");


            equipo1.setNombre(equipoA);
            equipo1.setPuntos(puntosA);

            equipo2.setNombre(equipoB);
            equipo2.setPuntos(puntosB);
/*
            if (equipoA.equals(equipoActualString)) {
                equipoActual = equipo1;
            } else {

                equipoActual = equipo2;
            }
*/
        }

        vueltaDeActivity = false;
        mostrarResultado();

    }





    //------------ Va a buscar pelicula a la Activity Pelicula ----------------

    public void pelicula(View Vista) {
        Intent pelicula = new Intent(MainActivity.this, pelicula.class);
        EnviarValoresEntreActivities(pelicula);
        startActivity(pelicula);
    }


    //-------------- Enviar valores entre activities ------------------------

    public void EnviarValoresEntreActivities(Intent intent) {
        intent.putExtra("equipo1", equipo1.getNombre());
        intent.putExtra("equipo1", equipo1.getPuntos());
        intent.putExtra("equipo2", equipo2.getNombre());
        intent.putExtra("equipo2", equipo2.getPuntos());
        intent.putExtra("equipoActual", equipoActual.getNombre());

    }
    /*

    //-------------- Recibir valores entre Activities -----------------------
    public void recibirDatosEntreActivities(Bundle bundle){

        equipo1.setNombre(bundle.getString("equipo1"));
        equipo1.setPuntos(bundle.getInt("equipo1"));

        equipo2.setNombre(bundle.getString("equipo2"));
        equipo2.setPuntos(bundle.getInt("equipo2"));


        if(equipo1.getNombre().equals(bundle.getString("equipoActual"))) {
            equipoActual = equipo1;
        }
        else {

            equipoActual=equipo2;
        }

    }
*/
    //-------------------------- Puntaje -------------------------------------

    public void incrementaContador(View Vista) {
        equipoActual.incrementa();
        mostrarResultado();
    }

    public void incrementaContador() {
        equipoActual.incrementa();
        mostrarResultado();
    }

    public void decrementaContador(View Vista) {
        equipoActual.decrementa();
        mostrarResultado();
    }

    public void decrementaContador() {
        equipoActual.decrementa();
        mostrarResultado();
    }


    //---------------- Mostrar puntaje y equipo en la pantalla --------------------



    public void mostrarResultado() {
        TextView textNombre = findViewById(R.id.nombre);
        nombre = equipoActual.getNombre();

        TextView textPuntos = findViewById(R.id.puntos);
        puntos = equipoActual.getPuntos();

        String puntosString = Integer.toString(puntos);
        textNombre.setText(nombre);
        textPuntos.setText(puntosString);
    }




    //--------------------Cambio de equipo------------------------------------


    public void cambioDeEquipo(View Vista) {

        TextView textNombre = findViewById(R.id.nombre);


        if(equipo1.getNombre().equals(equipoActual.getNombre())) {
            equipoActual = equipo2;
        }
        else {

            equipoActual=equipo1;
        }

        textNombre.setText(equipoActual.getNombre());
        mostrarResultado();
    }

    public void cambioDeEquipo() {

        TextView textNombre = findViewById(R.id.nombre);

        if(equipo1.getNombre().equals(equipoActual.getNombre())) {
            equipoActual = equipo2;
        }
        else {

            equipoActual=equipo1;
        }

        textNombre.setText(equipoActual.getNombre());
        mostrarResultado();
    }




    //------------------------ Restart juego ---------------------------------------------


    public void reseteaContador(View Vista) {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("¿ Quiere reiniciar el juego? ?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                aceptar();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                cancelar();
            }
        });
        dialogo1.show();

    }

    public void aceptar() {
        equipoActual.setPuntos(0);
        cambioDeEquipo();
        equipoActual.setPuntos(0);
        equipoActual = equipo1;

        mostrarResultado();
    }

    public void cancelar() {
        finish();
    }




    //--------------------------------Timer----------------------------------------------


    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMiliseconds, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMiliseconds = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                countDownText.setText("1:00");
                timeLeftInMiliseconds= 60000;
                Intent AcertoONo = new Intent(MainActivity.this, AcertoONo.class);
                startActivity(AcertoONo);
                cambioDeEquipo();
            }
        }.start();
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

    //-----------------------------Bundle-----------------------------------------------

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

            equipoActual=equipo2;
        }

        mostrarResultado();

    }


    //-----------  On pause ----------------------------------
    @Override
    public void onPause() {
        super.onPause();

    }


}

