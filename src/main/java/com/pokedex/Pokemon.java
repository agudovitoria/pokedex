package com.pokedex;

/**
 * Created by iagudo on 29/10/16.
 */
public class Pokemon {
    private long id;
    private String name;
    private String type;
    private String description;
    private Long evolution;
    private boolean favorite;

    public Pokemon() {
        this.name = null;
        this.type = null;
        this.description = null;
        this.evolution = null;
        this.favorite = false;
    }

    public Pokemon(String name) {
        this.name = name;
        this.type = null;
        this.description = null;
        this.evolution = null;
        this.favorite = false;
    }

    public Pokemon(Pokemon pokemon) {
        this.name = pokemon.getName();
        this.type = pokemon.getDescription();
        this.description = pokemon.getType();
        this.evolution = pokemon.getEvolution();
        this.favorite = pokemon.isFavorite();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEvolution() {
        return evolution;
    }

    public void setEvolution(Long evolution) {
        this.evolution = evolution;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        if (!name.equals(pokemon.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (evolution != null ? evolution.hashCode() : 0);
        result = 31 * result + (favorite ? 1 : 0);
        return result;
    }
}
