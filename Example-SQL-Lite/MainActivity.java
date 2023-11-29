package com.example.exerciciosqllite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private RecyclerView recyclerLista;
    private SQLiteDatabase db;
    private List<Pessoa> pessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregarComponents();
        carregardadosBD();
    }

    private void carregardadosBD() {
        db = openOrCreateDatabase("app", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade int(3), imc double, categoria VARCHAR)");
        Cursor cursor = db.rawQuery("SELECT nome, idade, imc, categoria FROM pessoas", null);

        pessoas = new ArrayList<Pessoa>();

        int indiceNome = cursor.getColumnIndex("nome");
        int indiceIdade = cursor.getColumnIndex("idade");
        int indiceImc = cursor.getColumnIndex("imc");
        int indiceCategoria = cursor.getColumnIndex("categoria");

        if (cursor.moveToFirst()) {
            do {
                String nome = cursor.getString(indiceNome);
                int idade = Integer.parseInt(cursor.getString(indiceIdade));
                String categoria = cursor.getString(indiceCategoria);
                double imc = Double.parseDouble(cursor.getString(indiceImc));
                Log.d("Resultado nome:", cursor.getString(indiceNome));
                Log.d("Resultado idade: ", cursor.getString(indiceIdade));
                Log.d("Resultado imc: ", cursor.getString(indiceImc));
                Log.d("Resultado categoria: ", cursor.getString(indiceCategoria));

                Pessoa pessoa = new Pessoa(nome, idade,imc,categoria);
                pessoas.add(pessoa);

            } while (cursor.moveToNext());
        }

        cursor.close();

        AdapterListPessoa adapterListPessoa = new AdapterListPessoa(pessoas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerLista.setLayoutManager(layoutManager);
        recyclerLista.setHasFixedSize(true);
        recyclerLista.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerLista.setAdapter(adapterListPessoa);

        recyclerLista.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerLista,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Pessoa pessoaClick = pessoas.get(position);
                        deletarDados(pessoaClick.getNome());
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }));
    }

    private void deletarDados(String nomeParaDeletar) {
        db = openOrCreateDatabase("app", MODE_PRIVATE, null);

        db.execSQL("DELETE FROM pessoas WHERE nome = ?", new String[]{nomeParaDeletar});

        carregardadosBD();
    }



    private void carregarComponents() {
        button = findViewById(R.id.button);
        recyclerLista = findViewById(R.id.recyclerLista);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CadastroIMC.class);
                startActivity(intent);
            }
        });
    }


}