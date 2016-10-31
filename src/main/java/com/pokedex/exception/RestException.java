package com.pokedex.exceptions;

/**
 * Created by iagudo on 30/10/16.
 */
public class RestException extends Exception {
    // EJEMPLAR
    public static final String POKEMON_NO_EXISTE = "Pokemon no encontrado";
    public static final String MAX_FAVORITOS = "Máximos Pokemons favoritos alcanzado";

    public RestException() {
        super();
    }

    public RestException(String message) {
        super(message);
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
    }
}
