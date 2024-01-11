package com.iescarrilllo.apirest.apiServices;

import com.iescarrilllo.apirest.modelo.NamedAPIResourceList;
import com.iescarrilllo.apirest.modelo.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

// Interfaz para definir los métodos de la API de Pokémon
public interface PokemonApiService {

    // Método para obtener la lista de los primeros 30 Pokémon
    @GET("pokemon/?limit=30")
    Call<NamedAPIResourceList> getPokemons();

    // Método para obtener información de un Pokémon por su ID
    @GET("pokemon/{pokemonId}")
    Call<Pokemon> getPokemonById(@Path("pokemonId") int pokemonId);

    // Método para obtener información de un Pokémon por su nombre
    @GET("pokemon/{pokemonName}")
    Call<Pokemon> getPokemonByName(@Path("pokemonName") String pokemonName);
}