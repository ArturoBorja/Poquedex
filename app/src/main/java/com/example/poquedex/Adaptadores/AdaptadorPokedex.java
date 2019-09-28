package com.example.poquedex.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poquedex.Pokemon;

import java.util.List;

public class AdaptadorPokedex extends RecyclerView.Adapter<PokedexHolder> {
    Context context;
    int layout;
    List<Pokemon> datos;
    LayoutInflater layoutInflater;

    public AdaptadorPokedex(Context context, int layout, List<Pokemon> datos) {
        this.context = context;
        this.layout = layout;
        this.datos = datos;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PokedexHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(layout,parent,false);
        return new PokedexHolder(v,context);
    }

    @Override
    public void onBindViewHolder(@NonNull PokedexHolder holder, int position) {
        holder.nombrepokemon.setText(datos.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}
