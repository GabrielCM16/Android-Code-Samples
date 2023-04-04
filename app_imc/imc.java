package com.example.topicoshelo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Resultado;
    private EditText editPeso;
    private EditText editAltura;
    private EditText editIdade;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resultado = findViewById(R.id.Resultado);

        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        editIdade = findViewById(R.id.editIdade);



    }

    public void processar (View view){


        String Peso = editPeso.getText().toString();
        String Altura = editAltura.getText().toString();
        String Idade = editIdade.getText().toString();

        int peso = Integer.parseInt(Peso);
        int altura = Integer.parseInt(Altura);
        int idade = Integer.parseInt(Idade);

        float aaltura = (float) altura/100;

        double IMC = peso / Math.pow(aaltura, 2);

        String faixaEtaria = "";
        String classificacao = "";

        if (idade > 65){
            faixaEtaria = "Idoso";
        } else {
            faixaEtaria = "Adulto";
        }

        if (faixaEtaria == "Adulto"){

            if (IMC < 18.5){
                classificacao = "Baixo peso";
            } else if(IMC > 18.5 && IMC <= 24.9){
                classificacao = "Peso normal";
            } else if (IMC >= 25 && IMC <= 29.9){
                classificacao = "Excesso de peso";
            } else if(IMC >= 30 && IMC <= 34.9){
                classificacao = "Obesidade de Classe 1";
            } else if(IMC >= 35 && IMC <= 39.9){
                classificacao = "Obesidade de Classe 2";
            } else if (IMC >= 40){
                classificacao = "Obesidade de Classe 3";
            }


        } else {




            if (IMC <= 22) {
                classificacao = "Baixo peso";
            }

            if (IMC > 22 && IMC < 27) {
                classificacao = "Adequado ou eutrófico";
            }

            if (IMC >= 27) {
                classificacao = "Sobrepeso";
            }




        }

        Resultado.setText("Resultado: " + faixaEtaria + " " + aaltura +  "m " + peso + "Kg \n" + "IMC: " + IMC  + "\n" + classificacao + "\n" );


    }

}
