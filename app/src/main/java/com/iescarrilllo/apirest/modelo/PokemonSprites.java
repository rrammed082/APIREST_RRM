package com.iescarrilllo.apirest.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

// Clase que representa las imágenes (sprites) de un Pokémon
public class PokemonSprites implements Serializable {

    // Atributo que representa la imagen frontal por defecto del Pokémon en batalla
    @SerializedName("front_default")
    @Expose
    private String frontDefault;

    // Atributo que representa la imagen trasera por defecto del Pokémon en batalla
    @SerializedName("back_default")
    @Expose
    private String backDefault;

    // Constructor vacío de la clase PokemonSprites
    public PokemonSprites() {
    }

    // Métodos getter y setter para acceder a los atributos
    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public String getBackDefault() {
        return backDefault;
    }

    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    // Método toString para obtener una representación de cadena del objeto PokemonSprites
    @Override
    public String toString() {
        return "PokemonSprites{" +
                "frontDefault='" + frontDefault + '\'' +
                ", backDefault='" + backDefault + '\'' +
                '}';
    }
}
