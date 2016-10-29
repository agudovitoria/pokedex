package com.pokedex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by iagudo on 29/10/16.
 */
public class PokemonCollection {
    private ArrayList<Pokemon> collection;

    public PokemonCollection() {
        this.collection = new ArrayList<Pokemon>();
        this.initMock();
    }

    public void addOne(Pokemon pokemon) {
        this.collection.add(pokemon);
    }

    public ArrayList getAll() {
        return this.collection;
    }

    public ArrayList getAllFavorites() {
        ArrayList favorites = new ArrayList<Pokemon>();
        for (Pokemon p: this.collection) {
            if (p.isFavorite()) {
                favorites.add(p);
            }
        }

        return favorites;
    }

    public Pokemon getOneByName(String name) {
        for (Pokemon p: this.collection) {
            if (p.getName().equals(name)) {
                return p;
            }
        }

        return null;
    }

    public boolean setFavorite(String name) {
        for (Pokemon p: this.collection) {
            if (p.getName().equals(name)) {
                p.setFavorite(true);
                return true;
            }
        }

        return false;
    }

    private void initMock() {
        String[] names = {
                "Ivysaur",
                "Kingler",
                "Gloom",
                "Electabuzz",
                "Shellder",
                "Magnemite",
                "Staryu",
                "Dratini",
                "Pidgey",
                "Chansey",
                "Rhydon",
                "Aerodactyl",
                "Gloom",
                "Weedle",
                "Nidorina",
                "Vileplume",
                "Bellsprout",
                "Poliwhirl"
        };

        String[] types = {
                "Normal",
                "Fighting",
                "Flying",
                "Poison",
                "Ground",
                "Rock",
                "Bug",
                "Ghost",
                "Steel",
                "Fire",
                "Grass",
                "Water",
                "Electric",
                "Psychic",
                "Ice",
                "Dragon",
                "Dark",
                "Fairy"
        };

        Pokemon pokemon;
        Random rnd = new Random();
        int type;
        Long evolution;
        boolean isFavorite;
        boolean hasEvolution;

        for (int i = 0; i < names.length; i++) {
            type = (int) (rnd.nextDouble() * names.length);
            isFavorite = (type > (names.length / 2));
            hasEvolution = ((int) (rnd.nextDouble() * names.length) > (names.length / 3));
            evolution = hasEvolution ? new Long((int) (rnd.nextDouble() * names.length)) : null;

            pokemon = new Pokemon();
            pokemon.setId(i);
            pokemon.setName(names[i]);
            pokemon.setType(types[type]);
            pokemon.setDescription("Pokemon called " + names[i]);
            pokemon.setFavorite(isFavorite);
            pokemon.setFavorite(isFavorite);
            pokemon.setEvolution(evolution);
            this.collection.add(pokemon);
        }
    }
}
