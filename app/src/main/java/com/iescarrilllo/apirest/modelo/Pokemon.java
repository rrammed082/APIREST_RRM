package com.iescarrilllo.apirest.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

// Clase que representa un Pokémon
public class Pokemon implements Serializable {

    // Atributo que representa el nombre del Pokémon
    @SerializedName("name")
    @Expose
    private String name;

    // Atributo que representa la URL del Pokémon
    @SerializedName("url")
    @Expose
    private String url;

    // Atributo que representa el ID del Pokémon
    @SerializedName("id")
    @Expose
    private Integer id;

    // Atributo que representa las imágenes del Pokémon
    @SerializedName("sprites")
    @Expose
    private PokemonSprites sprites;

    // Atributo que representa el peso del Pokémon
    @SerializedName("weight")
    @Expose
    private int weight;

    // Atributo que representa la altura del Pokémon
    @SerializedName("height")
    @Expose
    private int height;

    // Constructor vacío de la clase Pokemon
    public Pokemon() {
    }

    // Métodos getter y setter para acceder a los atributos
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PokemonSprites getSprites() {
        return sprites;
    }

    public void setSprites(PokemonSprites sprites) {
        this.sprites = sprites;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // Método toString para obtener una representación de cadena del objeto Pokemon
    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", id=" + id +
                ", sprites=" + sprites +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}