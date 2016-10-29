package com.pokedex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by iagudo on 29/10/16.
 */

@RestController
public class PokemonController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
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
    public boolean setFavorite(@RequestBody @Valid final Map<String, String> parameters, HttpServletResponse response) {
        String name = parameters.get("name");
        log.info("PokemonController::setFavorite (" + name + ")");
        boolean result = this.collection.setFavorite(name);
        if (result) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        return result;
    }

    @RequestMapping(value = "/unsetFavorite", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public boolean unsetFavorite(@RequestBody @Valid final Map<String, String> parameters, HttpServletResponse response) {
        String name = parameters.get("name");
        log.info("PokemonController::unsetFavorite (" + name + ")");
        boolean result = this.collection.unsetFavorite(name);
        if (result) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public boolean add(@RequestBody @Valid Pokemon pokemon, HttpServletResponse response) {
        log.info("PokemonController::add (" + pokemon + ")");
        boolean result = this.collection.add(pokemon);
        if (result) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        return result;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public boolean modify(@RequestBody @Valid Pokemon pokemon, HttpServletResponse response) {
        log.info("PokemonController::modify (" + pokemon + ")");
        boolean result = this.collection.modify(pokemon);
        if (result) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@RequestBody @Valid  Map<String, String> parameters, HttpServletResponse response) {
        String name = parameters.get("name");
        log.info("PokemonController::delete (" + name + ")");
        boolean result = this.collection.delete(name);
        if (result) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        return result;
    }
}
