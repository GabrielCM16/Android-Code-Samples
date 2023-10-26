package com.example.exerciciofragment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.exerciciofragment.R;
import com.example.exerciciofragment.fragments.FragmentLojas;
import com.example.exerciciofragment.fragments.FragmentProdutos;

public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    private Button buttonLojas;
    private Button buttonProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregarComponenetes();
        fragmetProdutos();
    }

    private void carregarComponenetes(){
        frameLayout = findViewById(R.id.frameLayout);
        buttonLojas = findViewById(R.id.buttonLojas);
        buttonProdutos = findViewById(R.id.buttonProdutos);


        buttonLojas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmetLojas();
            }
        });

        buttonProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmetProdutos();
            }
        });
    }

    private void fragmetLojas(){
        FragmentLojas fragmentLojas = new FragmentLojas();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout, fragmentLojas);
        transaction.commit();
    }
    private void fragmetProdutos(){
        FragmentProdutos fragmentProdutos = new FragmentProdutos();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayout, fragmentProdutos);
        transaction.commit();
    }
}