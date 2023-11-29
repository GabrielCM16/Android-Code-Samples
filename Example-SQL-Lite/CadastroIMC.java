package com.example.exerciciosqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroIMC extends AppCompatActivity {
    private Button cadastrar;
    private Button cancelar;
    private EditText nome;
    private EditText altura;
    private EditText peso;
    private EditText idade;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_imc);

        carregarComponents();
    }

    private void cadastrarIMC() {
        String Snome = nome.getText().toString();
        String Sidade = idade.getText().toString();
        String Saltura = altura.getText().toString();
        String Speso = peso.getText().toString();

        double p = Double.parseDouble(Speso);
        double a = Double.parseDouble(Saltura);

        double imc = calcularIMC(p,a);
        String categoria = obterCategoriaIMC(imc);

        db.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade int(3), imc double, categoria VARCHAR)");

        db.execSQL("INSERT INTO pessoas (nome, idade, imc, categoria) VALUES (?, ?, ?, ?)",
                new Object[]{Snome, Integer.parseInt(Sidade), imc, categoria});

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public static double calcularIMC(double peso, double altura) {
        double a = altura / 100.0;
        return peso / (a * a);
    }
    public static String obterCategoriaIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do Peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "Normal";
        } else if (imc >= 25 && imc <= 29.9) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc <= 34.9) {
            return "Obesidade grau I";
        } else if (imc >= 35 && imc <= 39.9) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }

    private void carregarComponents() {
        db = openOrCreateDatabase("app", MODE_PRIVATE, null);

        cadastrar = findViewById(R.id.cadastrar);
        cancelar = findViewById(R.id.cancelar);
        nome = findViewById(R.id.entradaNome);
        altura = findViewById(R.id.entradaAltura);
        peso = findViewById(R.id.entradaPeso);
        idade = findViewById(R.id.entradaIdade);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarIMC();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}