package com.example.exerciciofragment.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.exerciciofragment.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentProdutos extends Fragment {
    private RecyclerView recyclerProdutos;
    private List<String> produtos = new ArrayList<>();
    public FragmentProdutos() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produtos, container, false);

        recyclerProdutos = view.findViewById(R.id.recyclerProdutos);

        produtos.add("Camisetas esportivas");
        produtos.add("Shorts de corrida");
        produtos.add("Jaquetas esportivas");
        produtos.add("Meias esportivas");
        produtos.add("Leggings de ginástica");
        produtos.add("Bolas de futebol");
        produtos.add("Raquetes de tênis");
        produtos.add("Luvas de beisebol");
        produtos.add("Tacos de golfe");


        StringAdapter stringAdapter = new StringAdapter(produtos);
        recyclerProdutos.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerProdutos.setAdapter(stringAdapter);

        return view;
    }
}