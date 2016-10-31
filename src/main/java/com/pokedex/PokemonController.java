package com.pokedex;

import com.pokedex.domain.Pokemon;
import com.pokedex.domain.PokemonCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * Created by iagudo on 29/10/16.
 */

@RestController
public class PokemonController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final PokemonCollection collection = new PokemonCollection();

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
    public PokemonResponse getAll() {
        PokemonResponse response = new PokemonResponse();
        response.setData(this.collection.getAll());
        return response;
    }

    @RequestMapping(value = "/getOneByName/{name}", method = RequestMethod.GET, produces = "application/json")
    public Pokemon getOneByName(@PathVariable String name) {
        return this.collection.getOneByName(name);
    }

    @RequestMapping(value = "/setFavorite", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public PokemonResponse setFavorite(@RequestBody final Map<String, String> parameters) {
        PokemonResponse response = new PokemonResponse();
        try {
            String name = parameters.get("name");
            log.info("PokemonController::setFavorite (" + name + ")");
            boolean result = this.collection.setFavorite(name);
            response.setError(!result);
        } catch (Exception e) {
            response.setError(true);
            response.setMessage(e.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/unsetFavorite", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public PokemonResponse unsetFavorite(@RequestBody final Map<String, String> parameters) {
        PokemonResponse response = new PokemonResponse();
        try {
            String name = parameters.get("name");
            log.info("PokemonController::unsetFavorite (" + name + ")");
            boolean result = this.collection.unsetFavorite(name);
            response.setError(!result);
        } catch (Exception e) {
            response.setError(true);
            response.setMessage(e.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public PokemonResponse add(@RequestBody Pokemon pokemon) {
        PokemonResponse response = new PokemonResponse();
        try {
            log.info("PokemonController::add (" + pokemon.getName() + ")");
            boolean result = this.collection.add(pokemon);
            response.setError(!result);
        } catch (Exception e) {
            response.setError(true);
            response.setMessage(e.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public PokemonResponse modify(@RequestBody Pokemon pokemon) {
        PokemonResponse response = new PokemonResponse();
        try {
            log.info("PokemonController::modify (" + pokemon.getName() + ")");
            boolean result = this.collection.modify(pokemon);
            response.setError(!result);
        } catch (Exception e) {
            response.setError(true);
            response.setMessage(e.getMessage());
        }

        return response;
    }

    @RequestMapping(value = "/delete/{name}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public PokemonResponse delete(@PathVariable String name) {
        PokemonResponse response = new PokemonResponse();
        try {
            log.info("PokemonController::delete (" + name + ")");
            boolean result = this.collection.delete(name);
            response.setError(!result);
        } catch (Exception e) {
            response.setError(true);
            response.setMessage(e.getMessage());
        }

        return response;
    }
}
