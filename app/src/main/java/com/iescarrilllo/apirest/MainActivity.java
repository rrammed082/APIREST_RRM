package com.iescarrilllo.apirest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.iescarrilllo.apirest.adapters.PokemonAdapter;
import com.iescarrilllo.apirest.apiClients.PokemonApiClient;
import com.iescarrilllo.apirest.apiServices.PokemonApiService;
import com.iescarrilllo.apirest.modelo.NamedAPIResourceList;
import com.iescarrilllo.apirest.modelo.Pokemon;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Actividad principal que muestra la lista de Pokémon
public class MainActivity extends AppCompatActivity {
    private PokemonAdapter pokemonAdapter;
    // Lista de pokemons a rellenar
    private List<Pokemon> pokemonList;
    private ListView lvPokemonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creamos la instancia del APIService y la inicializo
        PokemonApiService apiService = PokemonApiClient.getClient().create(PokemonApiService.class);
        lvPokemonList = findViewById(R.id.lvPokemonList);
        pokemonList = new ArrayList<>();

        // Creamos la llamada al método que nos devuelve todos los pokémons
        Call callPokemons = apiService.getPokemons();


        /**
         * El método enqueue realiza una llamada asíncrona a la API y notifica mediante un
         * callback la respuesta obtenida
         */
        callPokemons.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) { // Verificamos si la respuesta es exitosa

                if (response.isSuccessful()) {
                    NamedAPIResourceList namedAPIResourceList = (NamedAPIResourceList) response.body();

                    // Verificamos si la lista de pokémons no es nula
                    if (namedAPIResourceList != null && namedAPIResourceList.getResults() != null) {
                        pokemonList.clear(); // Limpiamos la lista por si hubiera algún dato no deseado

                        // Obtenemos el listado de pokémons y la agregamos a la lista
                        for(Pokemon p : namedAPIResourceList.getResults()){
                            pokemonList.add(p);
                        }

                        // Creamos un adaptador para la lista de pokémons y lo establecemos en el ListView
                        pokemonAdapter = new PokemonAdapter(getApplicationContext(), pokemonList);
                        lvPokemonList.setAdapter(pokemonAdapter);

                    }
                } else {
                    // Manejar el caso en que la respuesta no sea exitosa
                    Log.e("Error", "Respuesta de conexión fallida. Codigo: " + response.code());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                // Manejar el caso en que la llamada falle
                Log.e("Error", "No se pudo realizar la petición", t);
            }
        });

        // Configuramos el evento de clic para los elementos del ListView
        lvPokemonList.setOnItemClickListener((parent, view, position, id) -> {

            // Obtenemos el Pokémon seleccionado
            Pokemon pokemonSelected = (Pokemon) parent.getItemAtPosition(position);

            // Creamos un intent para abrir la actividad de detalles y pasamos el Pokémon como extra
            Intent detailPokemonIntent = new Intent(getApplicationContext(), DetailPokemonActivity.class);
            detailPokemonIntent.putExtra("pokemon", pokemonSelected);
            startActivity(detailPokemonIntent);
        });
    }
}