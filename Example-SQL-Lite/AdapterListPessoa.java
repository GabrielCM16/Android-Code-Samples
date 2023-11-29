package com.example.exerciciosqllite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterListPessoa extends RecyclerView.Adapter<AdapterListPessoa.MyViewHolder> {

    private List<Pessoa> eventos;

    public AdapterListPessoa(List<Pessoa> lista){
        this.eventos = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itenLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pessoa, parent, false) ;

        return new MyViewHolder(itenLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder AdapterListPessoa, int position) {

        Pessoa pessoa = eventos.get(position);

        String imc = new DecimalFormat("#,##0.00").format(pessoa.getImc());
        String aux = imc + " - " + pessoa.getCategoria();

        AdapterListPessoa.saidaNome.setText(pessoa.getNome());
        AdapterListPessoa.saidaIMC.setText("IMC: " + aux);
        AdapterListPessoa.saidaIdade.setText(String.valueOf(pessoa.getIdade()) + " anos");
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView saidaNome;
        TextView saidaIdade;
        TextView saidaIMC;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            saidaIdade = itemView.findViewById(R.id.saidaIdade);
            saidaIMC = itemView.findViewById(R.id.saidaIMC);
            saidaNome = itemView.findViewById(R.id.saidaNome);
        }
    }

}