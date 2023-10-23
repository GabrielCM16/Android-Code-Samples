package com.example.qrcodecontador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView saidaTempo;
    private long finalContador = 30000; //milisegundos (30 segundos)
    private long intervaloContador = 1000; //milisegundos (1 segundo)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saidaTempo = findViewById(R.id.saidaTempo);
    }

    private void contador(long finalCont, long intervaloCont){
        new CountDownTimer(finalCont, intervaloCont) {

            public void onTick(long millisUntilFinished) {
                long segundos = millisUntilFinished / 1000;
                saidaTempo.setText("segundos restantes: " + segundos);
            }

            public void onFinish() {
                saidaTempo.setText("Fim!");
            }
        }.start();
    }

    public void iniciarTempo(View view){
        contador(finalContador, intervaloContador);
    }
}
