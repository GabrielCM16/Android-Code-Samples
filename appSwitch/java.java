package com.example.aula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Switch switchSenha;
    private ToggleButton toggleButtonLigado;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchSenha = findViewById(R.id.switchSenha);
        toggleButtonLigado = findViewById(R.id.toggleButtonLigado);
        textResultado = findViewById(R.id.textResultado);

        carregarListenner();

    }

    //Listenner
    public void carregarListenner(){

        switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    textResultado.setText("Switch ligado");
                } else{
                    textResultado.setText("Switch desligado");
                }

            }
        });
    }

//    public void enviar(View view){

            //Switch
//        if (switchSenha.isChecked()){
//            textResultado.setText("Switch ligado");
//        } else{
//            textResultado.setText("Switch desligado");
//        }
            //ToggleButton
//        if (toggleButtonLigado.isChecked()){
//            textResultado.setText("Switch ligado");
//        } else{
//            textResultado.setText("Switch desligado");
//        }
//    }


}
