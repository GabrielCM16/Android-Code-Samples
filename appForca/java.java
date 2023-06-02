package com.example.forca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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

    static String letrasUsadas = "";

    public static int vidas = 0;

    static int dificuldade = 10;

    static int aux = 0;

    public static String palavra_incompleta = "";

    public static String palavra_aux = "";

    public void reiniciarJogo(View view) {

        String n_vida = Integer.toString(10 - vidas);
        SaidaVida.setText("Chances restantes = "+ (n_vida) + "\n" + "Palavra com: " + im + " Letras");

        palavraSoteada = palavras[sortea()];

        vidas = 0;

        im = palavraSoteada.length();

        dificuldade = 10;

        palavra_incompleta = "";

        letrasUsadas = "";

        for (int i = 0; i < palavraSoteada.length(); i++){
            palavra_incompleta += '_';
        }

        StringBuilder sb = new StringBuilder(palavra_incompleta);

    }

    public void Jogar(View view){

        StringBuilder sb = new StringBuilder(palavra_incompleta);


        String n_vida = Integer.toString(10 - vidas);
        SaidaVida.setText("Chances restantes = "+ (n_vida) + "\n" + "Palavra com: " + im + " Letras");

        SaidaPalavras.setText(palavraSoteada);

        palavra_aux = "";

        String emm = entradaTexto.getText().toString();


        if (vidas >= dificuldade){
            String textoo = "Voce perdeu o jogo!";
            abrirToast(textoo);
        } else {
            if (emm.length() == 1){

                if (palavraSoteada.contains(emm)){ //se a letra esta na palavra

                    char letra = emm.charAt(0);

                    for(int i = 0; i < palavraSoteada.length(); i++){

                        char letraDaStr = palavraSoteada.charAt(i);

                        if(letra == letraDaStr){
                            sb.setCharAt(i, letraDaStr);
                        }
                    }
                    //adicionar a letra no vetor de letras usadas
                    letrasUsadas += emm.toUpperCase();
                    aux += 1;
                } else {
                    vidas += 1;
                }

            } else {
                //não é uma letra precisa dar erro
                String textoo = "Insira uma letra valida";
                abrirToast(textoo);
            }

        }

        //Verificando se ja ganhou

        palavra_incompleta = sb.toString();

        if(palavraSoteada.equals(palavra_incompleta)){
            String textoo = "Voce Ganhouuu";
            abrirToast(textoo);
        }


        n_vida = Integer.toString(10 - vidas);
        SaidaVida.setText("Chances restantes = "+ (n_vida) + "\n" + "Palavra com: " + im + " Letras");
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
