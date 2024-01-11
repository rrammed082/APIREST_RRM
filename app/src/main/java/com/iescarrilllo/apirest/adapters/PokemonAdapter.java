package com.iescarrilllo.apirest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.iescarrilllo.apirest.R;
import com.iescarrilllo.apirest.modelo.Pokemon;

import java.util.List;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

    // Constructor de la clase PokemonAdapter
    public PokemonAdapter(Context context, List<Pokemon> pokemonList) {
        super(context, 0, pokemonList);
    }

    // Método para obtener la vista de un elemento en la posición dada
    public View getView(int position, View converView, ViewGroup parent) {
        // Obtener el objeto Pokemon en la posición especificada
        Pokemon pokemon = getItem(position);

        // Verificar si la vista ya existe (reciclaje de vistas)
        if (converView == null) {
            // Si la vista no existe, inflarla desde el diseño especificado (item_pokemon_list)
            converView = LayoutInflater.from(getContext()).inflate(R.layout.item_pokemon_list, parent, false);
        }

        // Obtener la referencia al TextView en la vista
        TextView tvPokemonName = converView.findViewById(R.id.tvPokemonName);

        // Establecer el nombre del Pokémon en el TextView
        tvPokemonName.setText(pokemon.getName());

        // Devolver la vista actualizada
        return converView;
    }
}
