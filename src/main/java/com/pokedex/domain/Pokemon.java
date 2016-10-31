package com.pokedex;

import java.util.ArrayList;

/**
 * Created by iagudo on 29/10/16.
 * Pokemon domain class
 */
public class Pokemon {
    private long id;
    private String name;
    private ArrayList<String> types;
    private String description;
    private String evolution;
    private boolean favorite;

    /**
     * Default constructor
     */
    public Pokemon() {
        this.name = null;
        this.types = null;
        this.description = null;
        this.evolution = null;
        this.favorite = false;
    }

    /**
     * Overloaded constructor
     */
    public Pokemon(String name) {
        this.name = name;
        this.types = null;
        this.description = null;
        this.evolution = null;
        this.favorite = false;
    }

    /**
     * Copy constructor
     * @param pokemon Original object to copy
     */
    public Pokemon(Pokemon pokemon) {
        this.name = pokemon.getName();
        this.types = pokemon.getTypes();
        this.description = pokemon.getDescription();
        this.evolution = pokemon.getEvolution();
        this.favorite = pokemon.isFavorite();
    }

    /**
     * Get the id property
     * @return pokemon's id
     */
    public long getId() {
        return id;
    }

    /**
     * Set the id property
     * @param id pokemon's id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get the name property
     * @return pokemon's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name property
     * @param name pokemon's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the types property
     * @return pokemon's type
     */
    public ArrayList<String> getTypes() {
        return types;
    }

    /**
     * Set Pokemon's types property
     * @param types Pokemon's property to set
     */
    public void setTypes(ArrayList types) {
        this.types = types;
    }

    /**
     * Get the description property
     * @return pokemon's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description property
     * @param description Pokemon's decription to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the evolution pokemon if it's possible do
     * @return evolution pokemon's name
     */
    public String getEvolution() {
        return evolution;
    }

    /**
     * Set the evolution property
     * @param evolution Id of the Pokemon to evolution
     */
    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    /**
     * Get the favorite property
     * @return if pokemon's favorite
     */
    public boolean isFavorite() {
        return favorite;
    }

    /**
     * Set the favorite property
     * @param favorite If Pokemon is favorite
     */
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    /**
     * Pokemon class comparation method
     * @param o Pokemon with which to compare
     * @return If both Pokemon are equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        if (!name.equals(pokemon.name)) return false;

        return true;
    }
}
