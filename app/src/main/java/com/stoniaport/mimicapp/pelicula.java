package com.stoniaport.mimicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pelicula extends AppCompatActivity {

    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);

        volver=findViewById(R.id.Volver);

        volver.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent volver = new Intent(pelicula.this, MainActivity.class);
                startActivity(volver);
            }
        });
    }
}
