package com.stoniaport.mimicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        EditText equipo1et = (EditText) findViewById(R.id.equipo1);
        EditText equipo2et = (EditText) findViewById(R.id.equipo2);

    }

    public void listo(View view) {
        Intent logIn = new Intent(LogIn.this, MainActivity.class);

        //String equipo1 = equipo1et.getText().toString();
        //String equipo2 = equipo2et.getText().toString();

        //logIn.putExtra("equipo1","hola");
        //logIn.putExtra("equipo2","do");

        startActivity(logIn);

    }

}
