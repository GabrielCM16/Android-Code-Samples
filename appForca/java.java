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

    final static public String palavras[] = {"RATO", "SAPO", "MARRECO", "PANELA", "CAVALO", "MACHADO", "CEREJA", "LIMAO", "LARANJA", "LELIS"};

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

        String palavra_incompleta = "";

        String palavra_aux = "";
        
    }

    public void Jogar(View view){

        String palavra_aux = "";

        String letra = entrada.getText().toString();

        boolean repete = false;

        if (vidas == dificuldade){
            //perdeu o jogo
        } else {
            if (letra.length() == 1){
                //é uma letra adiciona no vetor somente se nao estiver

                //verificando se a letra inserida ja foi adicionada
                for(int i = 0; i <= letrasUsadas.length; i++){
                    
                    String letraa = letrasUsadas[i];

                    if (letraa.equals(letra.toUpperCase())){
                        //letra ja foi usada
                        //precisa dar erro
                        repete = true;
                        i = letrasUsadas.length;
                    } else{
                        continue;
                    }
                }
                if (!repete){ //se a letra nao repete

                    for(int i = 0; i < palavraSoteada.length(); i++){

                        String letraDaStr = palavraSoteada.substring(i,i+1);

                        if(letra.equals(letraDaStr)){
                            palavra_aux += letra;
                        } else {
                            palavra_aux += '_';
                        }

                    }

                    palavra_incompleta = palavra_aux;

                    letrasUsadas[aux] = letra.toUpperCase();
                    aux += 1;
                }

            } else {
                //não é uma letra precisa dar erro
            }

            

        }


        //Verificando se ja ganhou

        if(palavraSoteada.equals(palavra_incompleta)){
            //ganhouuuu
        }


    }



    public int sortea(){
        Random gerador = new Random();

        int num1 = gerador.nextInt(palavras.length);
        return num1;

    }


}
