package com.pokedex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by iagudo on 29/10/16.
 */

@RestController
public class PokemonController {
    private final PokemonCollection collection = new PokemonCollection();

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
    public ArrayList getAll() {
        return this.collection.getAll();
    }

    @RequestMapping(value = "/getAllFavorites", method = RequestMethod.GET, produces = "application/json")
    public ArrayList getAllFavorites() {
        return this.collection.getAllFavorites();
    }

    @RequestMapping(value = "/getOneByName/{name}", method = RequestMethod.GET, produces = "application/json")
    public Pokemon getOneByName(@PathVariable String name) {
        return this.collection.getOneByName(name);
    }

    @RequestMapping(value = "/setFavorite", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public boolean setFavorite(@RequestParam(value = "name") String name, HttpServletResponse response) {
        boolean result = this.collection.setFavorite(name);
        if (result) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        return result;
    }
}
