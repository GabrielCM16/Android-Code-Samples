package com.example.agenda;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.adapter.AdapterAgenda;
import com.example.agenda.compromissos.Event;
import com.example.agenda.RercyclerViewClick.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText EntradaTitulo;
    private EditText EntradaLocal;
    private EditText EntradaData;
    private EditText EntradaHorario;
    private Button botao;
    private RecyclerView recyclerView;
    private List<Event> events = new ArrayList<>();
    // Configurar adapter;
    private final AdapterAgenda adapter = new AdapterAgenda(events);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();
        carregarAlgunsEventos();
        adicionarEvento();
        listarEventos();
    }

    private void adicionarEvento(){
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = EntradaData.getText().toString();
                String hora = EntradaData.getText().toString();
                String titulo = EntradaTitulo.getText().toString();
                String local = EntradaLocal.getText().toString();
                if (!data.isEmpty() && !hora.isEmpty() && !titulo.isEmpty() && !local.isEmpty()){
                    Event evento = new Event(titulo,data,local,hora);
                    events.add(evento);
                    Toast.makeText(getApplicationContext(),
                            "Evento adicionado",
                            Toast.LENGTH_LONG).show();
                    // Notifique o adaptador sobre a mudança de dados
                    adapter.notifyDataSetChanged();
                } else{
                    Toast.makeText(getApplicationContext(),
                            "Preencha todos os campos",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void listarEventos(){
        // Notifique o adaptador sobre a mudança de dados
        adapter.notifyDataSetChanged();

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
                        Toast.makeText(getApplicationContext(),
                                "local: " + events.get(position).getLocal(),
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }));
    }

    private void inicializarComponentes(){
        EntradaData = findViewById(R.id.EntradaData);
        EntradaHorario = findViewById(R.id.EntradaHora);
        EntradaTitulo  = findViewById(R.id.entradaTitulo);
        EntradaLocal = findViewById(R.id.EntradaLocal);
        botao = findViewById(R.id.BotaoSalvar);
        recyclerView = findViewById(R.id.RecyclerView);
    }

    private void carregarAlgunsEventos(){
        Event event = new Event("Prova Topicos", "17/08/2023","IFPR-Campus Cascavel", "08:00");
        this.events.add(event);
        event = new Event("Prova POO", "20/08/2023", "IFPR-Campus Cascavel", "10:00");
        this.events.add(event);
    }
}