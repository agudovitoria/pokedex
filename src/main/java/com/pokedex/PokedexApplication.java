package com.pokedex;

import com.pokedex.domain.PokemonCollection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokedexApplication {

	private PokemonCollection collection;

	public static void main(String[] args) {
		SpringApplication.run(PokedexApplication.class, args);
	}
}