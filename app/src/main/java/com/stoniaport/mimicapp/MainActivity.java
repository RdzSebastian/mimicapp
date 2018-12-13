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

    public void pelicula(View Vista) {
        Intent siguiente = new Intent(MainActivity.this, pelicula.class);
        startActivity(siguiente);
    }

    public void incrementaContador(View Vista) {
        equipoActual.incrementa();
        mostrarResultado();
    }

    public void decrementaContador(View Vista) {
        equipoActual.decrementa();
        mostrarResultado();
    }

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



    public void mostrarResultado() {
        TextView text = findViewById(R.id.puntos);
        puntos = equipoActual.getPuntos();
        String puntosString = Integer.toString(puntos);
        text.setText(puntosString);
    }


    public void cambioDeEquipo(View Vista) {

        TextView text = findViewById(R.id.nombre);
        numero++;
        if (numero == 2) {
            equipoActual = equipo2;
        } else {
            numero = 1;
            equipoActual = equipo1;
        }
        text.setText(equipoActual.getNombre());
        mostrarResultado();
    }

    public void cambioDeEquipo() {

        TextView text = findViewById(R.id.nombre);
        numero++;
        if (numero == 2) {
            equipoActual = equipo2;
        } else {
            numero = 1;
            equipoActual = equipo1;
        }
        text.setText(equipoActual.getNombre());
        mostrarResultado();
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
                //Intent AcertoONo = new Intent(MainActivity.this, AcertoONo.class);
                //startActivity(AcertoONo);
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

    //--------------------------------------------------------------------------------------

}

