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

public class FragmentLojas extends Fragment {
    private RecyclerView recyclerLoja;
    List<String> lojas = new ArrayList<>();

    public FragmentLojas() {
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
        View view = inflater.inflate(R.layout.fragment_lojas, container, false);

        recyclerLoja = view.findViewById(R.id.recyclerLojas);
        lojas.add("Loja Cascavel");
        lojas.add("Loja Rio de Janeiro");
        lojas.add("Loja São Paulo");
        lojas.add("Loja Belo Horizonte");
        lojas.add("Loja Brasília");
        lojas.add("Loja Recife");
        lojas.add("Loja Salvador");
        lojas.add("Loja Curitiba");
        lojas.add("Loja Fortaleza");
        lojas.add("Loja Manaus");

        StringAdapter stringAdapter = new StringAdapter(lojas);
        recyclerLoja.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerLoja.setAdapter(stringAdapter);

        return view;
    }
}