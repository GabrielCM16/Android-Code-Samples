package com.example.appgorjeta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void abrirDialog(View view) {

        // Instanciar AlertDialog

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        // Configurar título e mensagem

        dialog.setTitle("Gorjeta");

        dialog.setMessage("valor individual, com ou sem gorjeta?");

        // Configurar cancelamento do AlertDialog

        dialog.setCancelable(false);

        dialog.setIcon(android.R.drawable.ic_btn_speak_now);


        // Configurar ações para SIM e NÃO

        dialog.setPositiveButton("Com Gorjeta", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(

                        getApplicationContext(),

                        "Executar ação ao clicar no botão SIM",

                        Toast.LENGTH_LONG

                ).show();

            }

        });


        dialog.setNegativeButton("Sem Gorjeta", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(

                        getApplicationContext(),

                        "Executar ação ao clicar no botão NÃO",

                        Toast.LENGTH_LONG

                ).show();

            }

        });


        // Criar e exibir AlertDialog

        dialog.create();

        dialog.show();


    }
}
