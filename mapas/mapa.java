package com.example.mapas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    private TextView Area;
    private TextView estado;
    private TextView Pop;
    private TextView Densi;
    private TextView id;
    private TextView num_m;

    private PhotoView imagemEstado;

    private ImageView imagemBandeira;

    private TextInputEditText entradaEstados;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entradaEstados = findViewById(R.id.entradaEstado);

        imagemEstado = (PhotoView) findViewById(R.id.imagemEstado);
        imagemBandeira = findViewById(R.id.imagenBandeira);

        estado = findViewById(R.id.saidaEstado);
        Area = findViewById(R.id.saidaArea);
        Pop = findViewById(R.id.saidaPopulacao);
        Densi = findViewById(R.id.saidaDensidade);
        id = findViewById(R.id.saidaIdh);
        num_m = findViewById(R.id.saidaMunicipios);

        imagemEstado.setImageResource(R.drawable.tresestados);
    }


    public void processar (View view) {


        String estados = entradaEstados.getText().toString();

        if (estados.equals("Parana")  || estados.equals("PR") ) {
            estado.setText("Parana");
            Area.setText("199.298,981");
            Pop.setText("11.597.484");
            Densi.setText("52,40");
            id.setText("0,749");
            num_m.setText("284");
            imagemEstado.setImageResource(R.drawable.pr);
            imagemBandeira.setVisibility(View.VISIBLE);
            imagemBandeira.setImageResource(R.drawable.bpr);

        } else if (estados.equals("Santa Catarina")  || estados.equals("SC") ) {
            estado.setText("Santa Catarina");
            Area.setText("95.730,690");
            Pop.setText("7.338.473");
            Densi.setText("65,29");
            id.setText("0,774");
            num_m.setText("295");
            imagemEstado.setImageResource(R.drawable.sc);
            imagemBandeira.setVisibility(View.VISIBLE);
            imagemBandeira.setImageResource(R.drawable.bsc);

        } else if (estados.equals("Rio Grande do Sul")  || estados.equals("RS") ) {
            estado.setText("Rio Grande do Sul");
            Area.setText("281.707,151");
            Pop.setText("11.466.630");
            Densi.setText("39,79");
            id.setText("0,746");
            num_m.setText("497");
            imagemEstado.setImageResource(R.drawable.rs);
            imagemBandeira.setVisibility(View.VISIBLE);
            imagemBandeira.setImageResource(R.drawable.brs);

        } else {
            entradaEstados.setError("Estados = PR, SC ou RS");
        }


    }


}
