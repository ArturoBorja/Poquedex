package com.example.poquedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetallePokemon extends AppCompatActivity {
    ImageView img_detallepokemon_pokemon;
    TextView txt_detallepokemon_nombre;
    LinearLayout ll_detallepokemon_ataques;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pokemon);
        img_detallepokemon_pokemon=findViewById(R.id.img_detallepokemon_pokemon);
        txt_detallepokemon_nombre=findViewById(R.id.txt_detallepokemon_nombre);
        ll_detallepokemon_ataques=findViewById(R.id.ll_detallepokemon_ataques);
        Intent i = getIntent();
        CargarPokeDatos(i.getIntExtra("id",1));
    }
    void CargarPokeDatos(int codpokemon){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfazPokemon ip = retrofit.create(InterfazPokemon.class);
        Call<Pokemon> servicio = ip.obtenerPokemon(codpokemon);
        servicio.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon p = response.body();
                txt_detallepokemon_nombre.setText(p.id+" - "+p.name);

                Glide.with(DetallePokemon.this).load(p.sprites.front_default).into(img_detallepokemon_pokemon);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        });
    }

}
