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

    final static public String palavras[] = {"a", "b"};

    final static String palavraSoteada = palavras[sortea()];

    final static String letrasUsadas[] = new String[palavraSoteada.length()];

    final static int vidas = 0;

    final static int dificuldade = 10;

    final static int aux = 0;

    
    public void reiniciarJogo(View view, int di) {

        palavraSoteada = palavras[sortea()];

        String letrasUsadas[] = new String[palavraSoteada.length()];
        
        vidas = 0;

        aux = 0;

        dificuldade = di;
        
    }

    public void Jogar(View view){

        String letra = entrada.getText().toString();

        if (vidas == dificuldade){
            //perdeu o jogo
        } else {
            if (letra.length() == 1){
                //é uma letra adiciona no vetor somente se nao estiver

                //verificando se a letra inserida ja foi adicionada
                for(int i = 0; i <= letrasUsadas.length; i++){
                    
                    String letraa = letrasUsadas[i];

                    if (letraa == letra.toUpperCase()){
                        //letra ja foi usada
                        //precisa dar erro
                        i = letrasUsadas.length;
                    } else{
                        continue;
                    }
                    
                }

                letrasUsadas[aux] = letra.toUpperCase();
            } else {
                //não é uma letra precisa dar erro
            }

            

        }

    }



    public int sortea(){
        Random gerador = new Random();

        int num1 = gerador.nextInt(palavras.length);
        return num1;

    }


}
