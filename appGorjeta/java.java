package com.example.appgorjeta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private SeekBar SeekBarPessoas;
    private SeekBar SeekBarGorjeta;
    private int nPessoas;
    private int pGorejeta;
    public EditText entradaTexto;
    private TextView textoPessoas;
    private TextView textoGorjeta;
    private TextView saidaTexto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBarGorjeta = findViewById(R.id.seekBarGorjeta);
        SeekBarPessoas = findViewById(R.id.seekBarPessoas);
        textoPessoas = findViewById(R.id.textopessoas);
        textoGorjeta = findViewById(R.id.textoGorjeta);
        entradaTexto = findViewById(R.id.entradaTexto);
        saidaTexto = findViewById(R.id.saidaTexto);


        SeekBarPessoas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //quando tiver mexendo
                nPessoas = progress;
                textoPessoas.setText("N pessoas: " + nPessoas);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //quando clicar
                nPessoas = seekBar.getProgress();
                textoPessoas.setText("N pessoas: " + nPessoas);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //quando soltar
                nPessoas = seekBar.getProgress();
                textoPessoas.setText("N pessoas: " + nPessoas);
            }
        });


        SeekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pGorejeta = progress;
                textoGorjeta.setText("Porcentagem da gorjeta: " + pGorejeta + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                pGorejeta = seekBar.getProgress();
                textoGorjeta.setText("Porcentagem da gorjeta: " + pGorejeta + "%");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                pGorejeta = seekBar.getProgress();
                textoGorjeta.setText("Porcentagem da gorjeta: " + pGorejeta + "%");
            }
        });
    }

    public void abrirDialog(View view) {

        // Instanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        // Configurar título e mensagem
        dialog.setTitle("Gorjeta");
        dialog.setMessage("com ou sem gorjeta?");

        // Configurar cancelamento do AlertDialog
        dialog.setCancelable(false);
        dialog.setIcon(android.R.drawable.ic_btn_speak_now);


        // Configurar ações para SIM e NÃO

        dialog.setPositiveButton("Com Gorjeta", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {
                String entrada = entradaTexto.getText().toString();
                int number = Integer.parseInt(entrada);
                float a = pGorejeta;
                double valorGorjeta = number * (a / 100.00);
                double valores = (number / nPessoas) + valorGorjeta;

                saidaTexto.setText("Valores por pessoa: R$" + valores  );

            }
        });


        dialog.setNegativeButton("Sem Gorjeta", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String entrada = entradaTexto.getText().toString();
                int number = Integer.parseInt(entrada);
                double valores = (number / nPessoas);

                saidaTexto.setText("Valores por pessoa: R$" + valores  );
            }
        });

        // Criar e exibir AlertDialog

        dialog.create();
        dialog.show();


    }
}
