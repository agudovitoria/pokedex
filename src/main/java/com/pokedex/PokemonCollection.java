package com.pokedex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by iagudo on 29/10/16.
 */
public class PokemonCollection {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
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
        for (Pokemon p : this.collection) {
            if (p.isFavorite()) {
                favorites.add(p);
            }
        }

        return favorites;
    }

    public Pokemon getOneByName(String name) {
        Pokemon p = new Pokemon(name);
        int pos = this.collection.indexOf(p);

        if (pos != -1) {
            return this.collection.get(pos);
        }

        return null;
    }

    public boolean setFavorite(String name) {
        log.info("PokemonCollection::setFavorite (" + name + ")");
        boolean result = false;
        try {
            Pokemon p = new Pokemon(name);
            int pos = this.collection.indexOf(p);

            if (pos != -1) {
                this.collection.get(pos).setFavorite(true);
                result = true;
            }

            result = false;

        } catch (Exception e) {
            log.error("PokemonCollection::add exception " + e.getMessage());
        } finally {
            return result;
        }
    }

    public boolean unsetFavorite(String name) {
        log.info("PokemonCollection::unsetFavorite (" + name + ")");
        boolean result = false;
        try {
            Pokemon p = new Pokemon(name);
            int pos = this.collection.indexOf(p);

            if (pos != -1) {
                this.collection.get(pos).setFavorite(false);
                result = true;
            }
        } catch (Exception e) {
            log.error("PokemonCollection::unsetFavorite exception " + e.getMessage());
        } finally {
            return result;
        }
    }

    public boolean add(Pokemon pokemon) {
        log.info("PokemonCollection::add (" + pokemon + ")");
        boolean result = false;
        try {
            int pos = this.collection.indexOf(pokemon);

            if (pos == -1) {
                pokemon.setId(((Integer) this.collection.size()).longValue());
                this.collection.add(pokemon);
                result = true;
            }
        } catch (Exception e) {
            log.error("PokemonCollection::add exception " + e.getMessage());
        } finally {
            return result;
        }
    }

    public boolean modify(Pokemon pokemon) {
        log.info("PokemonCollection::modify (" + pokemon + ")");
        boolean result = false;
        try {
            int pos = this.collection.indexOf(pokemon);

            if (pos != -1) {
                pokemon.setId(this.collection.get(pos).getId());
                this.collection.set(pos, pokemon);
                result = true;
            }
        } catch (Exception e) {
            log.error("PokemonCollection::modify exception " + e.getMessage());
        } finally {
            return result;
        }
    }

    public boolean delete(String name) {
        log.info("PokemonCollection::delete (" + name + ")");
        boolean result = false;
        try {
            Pokemon p = new Pokemon(name);
            int pos = this.collection.indexOf(p);

            if (pos != -1) {
                this.collection.remove(p);
                result = true;
            }
        } catch (Exception e) {
            log.error("PokemonCollection::delete exception " + e.getMessage());
        } finally {
            return result;
        }
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
