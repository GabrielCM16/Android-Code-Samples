
package com.example.appaula;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais;
    private String[] itens = {
            "Filosofia",
            "Biologia",
            "Sociologia",
            "Quimica",
            "História",
            "Fisica",
            "Geografia",
            "TCC",
            "Programação para Internet",
            "Programação Orientada a Objetos",
            "Ingles",
            "Topicos Especiais de Informatica",
            "Portugues",
            "Matematica",
            "Redes"
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

        //adiciona o click na lista
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String materiaSelecionada = listLocais.getItemAtPosition(position).toString();
                dialog(view, materiaSelecionada);
            }
        });
    }

    public void dialog(View view, String materia){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        //configurar titulo e mensagem
        dialog.setTitle("Realizar Matricula em " + materia);
        dialog.setMessage("deseja realizar a matricula em " + materia + "?");

        //configurar cancelamento do alert dialog
        dialog.setCancelable(false);

        //configurar icone
        //dialog.setIcon(android.R.drawable.ic_btn_speak_now);

        //configurar açoes para sim e nâo
        dialog.setPositiveButton("Realizar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "foi feita a matrícula em " + materia, Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("Não Realizar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Matrícula não realizada", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.create();
        dialog.show();
    }
}
