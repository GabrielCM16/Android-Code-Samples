package com.example.jogoforca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

import javax.xml.transform.sax.SAXResult;

public class MainActivity extends AppCompatActivity {

    public TextInputEditText entrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entrada = findViewById(R.id.);
    }


    public String palavras[] = {"a", "b"};

    String palavraSoteada = palavras[sortea()];



    public void Jogar(View view){

        String letra = entrada.getText().toString();

        if (letra.)

    }



    public int sortea(){
        Random gerador = new Random();

        int num1 = gerador.nextInt(palavras.length);
        return num1;

    }


}
