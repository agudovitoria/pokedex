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
}
