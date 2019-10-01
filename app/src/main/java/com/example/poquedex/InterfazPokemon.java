package com.example.poquedex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InterfazPokemon {
    @GET("pokemon/")
    Call<Pokedex> obtenerPokedex (@Query("limit") int cantidad);
    @GET("pokemon/{codigo}")
    Call<Pokemon> obtenerPokemon(@Path("codigo") int id);
    @GET("pokemon/{codigo}")
    Call<Pokemon> obtenerPokemon(@Path("codigo") String id);
}
