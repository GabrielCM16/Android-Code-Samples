package com.example.appaula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais;
    private String[] itens = {
            "Angra dos Reis",
            "Caldas Novas",
            "Campos do Jordão",
            "Cascavel",
            "São Paulo",
            "Curitiba",
            "Rio de Janeiro",
            "Londrina",
            "Florianopolis",
            "Gramado",
            "Foz do Iguaçu",
            "Porto Alegre",
            "Salvador",
            "Dourados",
            "Maceio",
            "Rolandia"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.listLocais);

        //cria o adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1, // layout
                android.R.id.text1, //id do layout
                itens // lista a ser passada
        );
        listLocais.setAdapter(adapter);
    }
}
