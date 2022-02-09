package com.example.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class Database {
    @Bean
    fun initDatabase(pokemonRepository: PokemonRepository):CommandLineRunner{
        return CommandLineRunner {
            println("Base de datos creandose")
            val listaPokemon = listOf(
                Pokemon("Charmander",1),
                Pokemon("Bulbasaur",1),
                Pokemon("Squirtel",1)
            )
            listaPokemon.forEach{
                println("El Pokemon ${it.nombre} tiene un id de ${it.id} ")
            }
            listaPokemon.forEach {
                pokemonRepository.save(it)
            }
            val p = Pokemon("Ratata",1)
            pokemonRepository.save(p)

            p.nivel = 2
            pokemonRepository.save(p)

            p.id = 10
            pokemonRepository.save(p)






            pokemonRepository.findAll().forEach{
                println(it)
            }
            println("La base de datos esta creada y llena de datos")
        }
    }
}