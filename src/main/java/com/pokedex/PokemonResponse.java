package com.pokedex;

import java.util.ArrayList;

/**
 * Created by iagudo on 30/10/16.
 */
public class PokemonResponse {
    private ArrayList data;
    private boolean error;
    private String message;

    public PokemonResponse() {
        this.data = new ArrayList();
        this.error = false;
        this.message = "";
    }

    public ArrayList getData() {
        return data;
    }

    public void setData(ArrayList data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
