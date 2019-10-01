package com.example.poquedex;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;


import com.example.poquedex.Adaptadores.AdaptadorPokedex;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_pokedex;
    SearchView sv_main_buscapokemon;
    List<Pokemon> pokemonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_pokedex = findViewById(R.id.rv_main_pokedex);
        Toolbar mytoolbar = (Toolbar) findViewById(R.id.toolbar_main_busqueda);
        setSupportActionBar(mytoolbar);
        sv_main_buscapokemon =findViewById(R.id.sv_main_buscapokemon);


        CargarPokedex();

        sv_main_buscapokemon.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e("SearchV", query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.e("SearchV", newText);
                List<Pokemon> poketemp = new ArrayList<>();
                for (Pokemon poke : pokemonList){
                    if(poke.name.contains(newText)){
                        poketemp.add(poke);
                    }
                }
                AdaptadorPokedex adaptadorPokedex=
                        new AdaptadorPokedex(MainActivity.this,R.layout.item_pokedex,poketemp);
                rv_pokedex.setAdapter(adaptadorPokedex);
                return false;
            }
        });


    }

    void CargarPokedex(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfazPokemon ip = retrofit.create(InterfazPokemon.class);
        Call<Pokedex> servicio = ip.obtenerPokedex(151);
        servicio.enqueue(new Callback<Pokedex>() {
            @Override
            public void onResponse(Call<Pokedex> call, Response<Pokedex> response) {
                switch (response.code()){
                    case 200:
                        Pokedex pokedex = response.body();
                        pokemonList = pokedex.results;
                        AdaptadorPokedex adaptadorPokedex=
                                new AdaptadorPokedex(MainActivity.this,R.layout.item_pokedex,pokedex.results);
                        rv_pokedex.setAdapter(adaptadorPokedex);
                        rv_pokedex.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                }

                for (Pokemon p : response.body().results){
                    Log.e("pokemon",p.name);
                }
            }
            @Override
            public void onFailure(Call<Pokedex> call, Throwable t) {
                Log.e("pokemon", t.toString());
            }
        });
    }
}
