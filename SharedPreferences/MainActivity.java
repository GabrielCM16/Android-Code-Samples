package com.example.exerciciosharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView MeuIMC;
    private CRUDSharedPreferences crudSharedPreferences;
    private EditText entradaAltura;
    private EditText entradaPeso;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crudSharedPreferences = new CRUDSharedPreferences(getApplicationContext());
        carregarComponentes();
        carregarIMC();
    }

    private void carregarComponentes() {
        MeuIMC = findViewById(R.id.MeuIMC);
        entradaAltura = findViewById(R.id.entradaAltura);
        entradaPeso = findViewById(R.id.entradaPeso);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarNovosDados();
            }
        });
    }

    private void salvarNovosDados() {
        String peso = entradaPeso.getText().toString();
        String altura = entradaAltura.getText().toString();

        if (!peso.equals("") && !altura.equals("")){
            double alturaMetros = Integer.parseInt(altura) / 100.0;

            double imc = Integer.parseInt(peso) / (alturaMetros * alturaMetros);

            crudSharedPreferences.salvarChave("peso", peso);
            crudSharedPreferences.salvarChave("altura", altura);
            crudSharedPreferences.salvarChave("imc", String.valueOf(new DecimalFormat("#,##0.00").format(imc)));

            entradaPeso.setText("");
            entradaAltura.setText("");

            carregarIMC();
        } else {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
        }
    }

    private void carregarIMC() {
        String imc = crudSharedPreferences.recuperarChave("imc");
        String peso = crudSharedPreferences.recuperarChave("peso");
        String altura = crudSharedPreferences.recuperarChave("altura");

        if (!imc.equals("ERRO")){
            MeuIMC.setText("Meu Imc Atual é: " + imc);
        } else {
            MeuIMC.setText("Meu Imc Atual é: Indefinido ");
        }

        if (!peso.equals("ERRO")){
            entradaPeso.setHint("Seu Peso Atual: (Kg) " + peso);
        } else {
            entradaPeso.setHint("Seu Peso Atual: (Kg) ");
        }

        if (!altura.equals("ERRO")){
            entradaAltura.setHint("Sua Altura Atual: (cm) " + altura);
        } else {
            entradaAltura.setHint("Sua Altura Atual: (cm) ");
        }

    }
}