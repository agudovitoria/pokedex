package com.pokedex;

/**
 * Created by iagudo on 29/10/16.
 * Pokemon domain class
 */
public class Pokemon {
    private long id;
    private String name;
    private String type;
    private String description;
    private Long evolution;
    private boolean favorite;

    /**
     * Default constructor
     */
    public Pokemon() {
        this.name = null;
        this.type = null;
        this.description = null;
        this.evolution = null;
        this.favorite = false;
    }

    /**
     * Overloaded constructor
     */
    public Pokemon(String name) {
        this.name = name;
        this.type = null;
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
        this.type = pokemon.getDescription();
        this.description = pokemon.getType();
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
     * Get the type property
     * @return pokemon's type
     */
    public String getType() {
        return type;
    }

    /**
     * Set Pokemon's type property
     * @param type Pokemon's property to set
     */
    public void setType(String type) {
        this.type = type;
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
     * @return evolution pokemon's id member
     */
    public Long getEvolution() {
        return evolution;
    }

    /**
     * Set the evolution property
     * @param evolution Id of the Pokemon to evolution
     */
    public void setEvolution(Long evolution) {
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

    /**
     * Unique code due to identify Pokemon
     * @return Unique Pokemon identificator
     */
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
