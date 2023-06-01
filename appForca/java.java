package com.example.forca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;



public class MainActivity extends AppCompatActivity {

    public EditText entradaTexto;
    public TextView SaidaVida;
    public TextView SaidaPalavras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entradaTexto = findViewById(R.id.entrada);

        SaidaPalavras = findViewById(R.id.SaidaPalavra);

        SaidaVida = findViewById(R.id.SaidaVidas);
    }

    final static public String palavras[] = {"RATO", "SAPO", "MARRECO", "PANELA", "CAVALO", "MACHADO", "CEREJA", "LIMAO", "LARANJA", "LELIS"};

    static String palavraSoteada = palavras[sortea()];

    static int im = palavraSoteada.length();

    final static String letrasUsadas[] = new String[im];

    public static int vidas = 0;

    static int dificuldade = 10;

    static int aux = 0;

    public static String palavra_incompleta = "";

    public static String palavra_aux = "";



    public void reiniciarJogo(View view) {

        SaidaVida.setText(vidas);

        palavraSoteada = palavras[sortea()];

        vidas = 0;

        aux = 0;

        dificuldade = 10;

        palavra_incompleta = "";

        palavra_aux = "";

    }

    public void Jogar(View view){


        String n_vida = Integer.toString(10 - vidas);
        SaidaVida.setText("Chances restantes = "+ (n_vida));

        SaidaPalavras.setText(palavraSoteada);

        palavra_aux = "";

        StringBuilder sb = new StringBuilder(palavra_incompleta);


        String letra = entradaTexto.getText().toString();

        boolean repete = false;

        if (vidas >= dificuldade){
            String textoo = "Voce perdeu o jogo!";
            abrirToast(textoo);
        } else {
            if (letra.length() == 1){
                //é uma letra adiciona no vetor somente se nao estiver

                //verificando se a letra inserida ja foi adicionada
//                for(int i = 0; i <= letrasUsadas.length; i++){
//
//                    String letraa = letrasUsadas[i];
//
//                    if (letraa.equals(letra.toUpperCase())){
//                        //letra ja foi usada
//                        //precisa dar erro
//                        String textoo = "Letra ja inserida!";
//                        abrirToast(textoo);
//
//                        vidas += 1;
//
//                        repete = true;
//                        i = letrasUsadas.length;
//                    } else{
//                        continue;
//                    }
//                }
                if (!repete){ //se a letra nao repete



                    for(int i = 0; i < palavraSoteada.length(); i++){

                        char letraDaStr = palavraSoteada.charAt(i);

                        if(letra.equals(letraDaStr)){
                            sb.setCharAt(i, letraDaStr);
                        } else {
                            palavra_aux += '_';
                        }

                    }


                    //adicionar a letra no vetor de letras usadas
                    letrasUsadas[aux] = letra.toUpperCase();
                    aux += 1;
                }

            } else {
                //não é uma letra precisa dar erro
                String textoo = "Insira uma letra valida";
                abrirToast(textoo);
            }



        }


        //Verificando se ja ganhou

        if(palavraSoteada.equals(palavra_incompleta)){
            String textoo = "Voce Ganhouuu";
            abrirToast(textoo);
        }

        n_vida = Integer.toString(10 - vidas);
        SaidaVida.setText("Chances restantes = "+ (n_vida));
        SaidaPalavras.setText(palavra_incompleta);


    }



    public static int sortea(){
        Random gerador = new Random();

        int num1 = gerador.nextInt(palavras.length);
        return num1;

    }

    public void abrirToast(String texto){
        Toast.makeText(
                getApplicationContext(),
                texto,
                Toast.LENGTH_LONG
        ).show();
    }

}
