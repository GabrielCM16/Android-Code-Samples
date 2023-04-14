package com.example.jokenpo2;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jokenpo2.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView saida;
    private EditText editNome1;
    private EditText editNome2;

    private ImageView imagem1;
    private ImageView imagem2;


    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saida = findViewById(R.id.saida);
        editNome1 = findViewById(R.id.editNome1);
        editNome2 = findViewById(R.id.editNome2);
        imagem1 = findViewById(R.id.imagem1);
        imagem2 = findViewById(R.id.imagem2);

    }

    public void Começar(View view){
        String Nome1= editNome1.getText().toString();
        String Nome2 = editNome2.getText().toString();

        int jogada1 = sortea();
        int jogada2 = sortea();



        if (jogada1 == 0){
            imagem1.setVisibility(View.VISIBLE);
            imagem1.setImageResource(R.drawable.pedra);
        }
        if (jogada1 == 1){
            imagem1.setVisibility(View.VISIBLE);
            imagem1.setImageResource(R.drawable.papel);
        }
        if (jogada1 == 2){
            imagem1.setVisibility(View.VISIBLE);
            imagem1.setImageResource(R.drawable.tesoura);
        }


        if (jogada2 == 0){
            imagem2.setVisibility(View.VISIBLE);
            imagem2.setImageResource(R.drawable.pedra);
        }
        if (jogada2 == 1){
            imagem2.setVisibility(View.VISIBLE);
            imagem2.setImageResource(R.drawable.papel);
        }
        if (jogada2 == 2){
            imagem2.setVisibility(View.VISIBLE);
            imagem2.setImageResource(R.drawable.tesoura);
        }

        if (jogada1 == jogada2){
            saida.setText("Empate");
        }

        //) 0= pedra
        // 1 = papel
        // 2 = tesoura


        if (jogada1 == 0 && jogada2 == 1){
            saida.setText("Papel ganhou " + Nome2 + " é o ganhador");
        }
        if (jogada2 == 0 && jogada1 == 1){
            saida.setText("Papel ganhou " + Nome1 + " é o ganhador");
        }


        if (jogada1 == 2 && jogada2 == 1){
            saida.setText("Tesoura ganhou " + Nome1 + " é o ganhador");
        }
        if (jogada1 == 1 && jogada2 == 2){
            saida.setText("Tesoura ganhou " + Nome2 + " é o ganhador");
        }


        if (jogada1 == 0 && jogada2 == 2){
            saida.setText("Pedra ganhou " + Nome1 + " é o ganhador");
        }
        if (jogada1 == 2 && jogada2 == 0){
            saida.setText("Pedra ganhou " + Nome2 + " é o ganhador");
        }




    }

    public int sortea(){
        Random gerador = new Random();

        int num1 = gerador.nextInt(3);
        return num1;

    }


}
