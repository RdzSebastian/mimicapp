package com.stoniaport.mimicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AcertoONo extends AppCompatActivity {

    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerto_ono);
    }

    public void Si(View v) {
        Intent acerto = new Intent(AcertoONo.this, MainActivity.class);
        mainActivity.incrementaContador();
        startActivity(acerto);
    }

    public void No(View v) {
        Intent noAcerto = new Intent(AcertoONo.this, MainActivity.class);
        mainActivity.decrementaContador();
        startActivity(noAcerto);
    }
}
