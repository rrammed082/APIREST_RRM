package com.iescarrilllo.apirest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.iescarrilllo.apirest.apiClients.PokemonApiClient;
import com.iescarrilllo.apirest.apiServices.PokemonApiService;
import com.iescarrilllo.apirest.modelo.Pokemon;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Actividad que muestra los detalles de un Pokémon
public class DetailPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pokemon);

        // Obtener el objeto Pokemon de la actividad anterior
        Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra("pokemon");

        // Referencias a las vistas en el layout
        TextView tvID = findViewById(R.id.tvID);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvWeight = findViewById(R.id.tvWeight);
        TextView tvHeight = findViewById(R.id.tvHeight);
        ImageView imgFront = findViewById(R.id.imgFront);
        ImageView imgBack = findViewById(R.id.imgBack);
        Button btnBack = findViewById(R.id.btnBack);

        // Creamos la instancia del APIService y la inicializo
        PokemonApiService apiService = PokemonApiClient.getClient().create(PokemonApiService.class);

        // Creamos la llamada al método que nos devuelve un Pokemon por Nombre
        Call callPokemons = apiService.getPokemonByName(pokemon.getName());

        callPokemons.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) { // Manejar la respuesta exitosa
                Pokemon pokemonAux = (Pokemon) response.body();
                if (pokemonAux != null) {

                    // Actualizar las vistas con la información del Pokémon
                    tvID.setText("Numero en la Pokedex: " + String.valueOf(pokemonAux.getId()));
                    tvName.setText("Nombre: " + pokemonAux.getName());
                    tvWeight.setText("Peso: " + String.valueOf(pokemonAux.getWeight()));
                    tvHeight.setText("Altura: " + String.valueOf(pokemonAux.getHeight()));

                    // Cargar las imágenes del Pokémon utilizando Picasso
                    Picasso.get().load(pokemonAux.getSprites().getFrontDefault()).into(imgFront);
                    Picasso.get().load(pokemonAux.getSprites().getBackDefault()).into(imgBack);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                // Manejar el caso en que la llamada falle
                Log.e("Error", "No se pudo realizar la petición", t);
            }
        });

        btnBack.setOnClickListener(v -> finish());
    }
}