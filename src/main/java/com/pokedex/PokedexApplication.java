package com.pokedex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokedexApplication {

	private PokemonCollection collection;

	public static void main(String[] args) {
		SpringApplication.run(PokedexApplication.class, args);
	}
}
