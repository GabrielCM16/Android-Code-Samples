package com.example.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agenda.R;
import com.example.agenda.compromissos.Event;

import java.util.List;

public class AdapterAgenda extends RecyclerView.Adapter<com.example.recyclerview.adapter.AdapterAgenda.MyViewHolder> {

    private List<Event> eventos;

    public AdapterAgenda(List<Event> lista){
        this.eventos = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itenLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_eventos, parent, false) ;

        return new MyViewHolder(itenLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Event evento = eventos.get(position);

        holder.titulo.setText(evento.getTitle());
        holder.data.setText(evento.getDate());
        holder.hora.setText(evento.getTime());
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        TextView data;
        TextView hora;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            data = itemView.findViewById(R.id.data);
            hora = itemView.findViewById(R.id.hora);
        }
    }

}