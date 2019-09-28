package com.example.poquedex.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poquedex.DetallePokemon;
import com.example.poquedex.Pokemon;
import com.example.poquedex.R;

public class PokedexHolder extends RecyclerView.ViewHolder {
    TextView nombrepokemon;
    CardView cv;
    Context context;
    int id;

    public PokedexHolder(@NonNull final View itemView, Context c){
        super (itemView);
        this.context=c;
        nombrepokemon=itemView.findViewById(R.id.txt_itempokedex_pokemon);
        cv= itemView.findViewById(R.id.cv_itempokedex_01);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetallePokemon.class);
                intent.putExtra("id",id);

                context.startActivity(intent);
            }
        });
    }
}
