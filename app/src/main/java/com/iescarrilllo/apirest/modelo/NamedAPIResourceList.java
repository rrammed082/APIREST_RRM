package com.iescarrilllo.apirest.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

// Clase que representa la lista de recursos con nombres de la API
public class NamedAPIResourceList {

    @SerializedName("count") // Permite transformar de JSON a objeto Java (Serializar)
    @Expose // Permite transfomrar de un objeto Java a JSON (Deserializar)
    private Integer count; // Atributo que representa el número total de elementos en la lista
    @SerializedName("next") // Permite transformar de JSON a objeto Java (Serializar)
    @Expose // Permite transfomrar de un objeto Java a JSON (Deserializar)
    private String next; // Atributo que representa la URL de la siguiente página de resultados
    @SerializedName("previous") // Permite transformar de JSON a objeto Java (Serializar)
    @Expose // Permite transfomrar de un objeto Java a JSON (Deserializar)
    private String previous; // Atributo que representa la URL de la página de resultados anterior


    @SerializedName("results") // Permite transformar de JSON a objeto Java (Serializar)
    @Expose // Permite transfomrar de un objeto Java a JSON (Deserializar)
    private List<Pokemon> results; // Lista de Pokémon en la lista de recursos con nombres


    // Constructor vacío de la clase NamedAPIResourceList
    public NamedAPIResourceList() {
    }

    // Métodos getter y setter para acceder a los atributos
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
