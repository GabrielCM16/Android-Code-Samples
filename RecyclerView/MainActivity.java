package com.example.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.adapter.Adapter;
import com.example.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();


    public void criarFilmes(){
        Filme filme = new Filme("Homem Aranha", "aventura", "2018");
        this.listaFilmes.add(filme);
        filme = new Filme("Mulher Maravilha", "aventura", "2019");
        this.listaFilmes.add(filme);
        filme = new Filme("O Senhor dos Aneis", "ficção", "2001");
        this.listaFilmes.add(filme);
        filme = new Filme("Matrix", "ficção", "2002");
        this.listaFilmes.add(filme);
        filme = new Filme("Poderoso Chefão", "drama", "1972");
        this.listaFilmes.add(filme);
        filme = new Filme("Doze Homens e uma Sentença", "drama", "1957");
        this.listaFilmes.add(filme);
        filme = new Filme("Forrest Gump", "drama", "1994");
        this.listaFilmes.add(filme);
        filme = new Filme("Dois Papas", "drama", "2019");
        this.listaFilmes.add(filme);
        filme = new Filme("O Regresso", "drama", "2015");
        this.listaFilmes.add(filme);
        filme = new Filme("A Teoria de Tudo", "drama", "2014");
        this.listaFilmes.add(filme);
        filme = new Filme("Django Livre", "ação", "2012");
        this.listaFilmes.add(filme);
        filme = new Filme("Era uma vez em Hollywood", "comédia", "2019");
        this.listaFilmes.add(filme);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //listagem de filmes
        this.criarFilmes();

        // Configurar adapter;
        Adapter adapter = new Adapter(listaFilmes);


        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter); //criar adapter

        //evento recyclerView
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(),
                                "item selecionado" + filme.getTituloFilme(),
                                Toast.LENGTH_LONG
                        ).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Toast.makeText(getApplicationContext(),
                                "item com longo click" + position,
                                Toast.LENGTH_LONG
                        ).show();

                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
        ));


    }
}
