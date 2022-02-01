package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class PokemonController (private val pokemonRepository: PokemonRepository){

    @GetMapping("prueba1")
    fun prueba1() {
        println("En la base de datos hay ${pokemonRepository.count()}")
        val pokemon = Pokemon("P1",1)
        pokemonRepository.save(pokemon)
        println("En la base de datos ahora hay ${pokemonRepository.count()}")
    }
    @GetMapping("mostrarPokemon")
    fun mostrarPokemon() : MutableList<Pokemon> {
        return pokemonRepository.findAll()
    }

    @GetMapping("actualizarPokemon")
    fun actualizarPokemon() {
        var p =Pokemon("Pokemon Reemplazado",99)
        p.id =1
        pokemonRepository.save(p)
    }
    @GetMapping("insertarPokemon/{nombre}/{nivel}")
    fun insertarPokemon(@PathVariable nombre:String, @PathVariable nivel:Int): Pokemon {
        val pokemon =Pokemon(nombre, nivel)
        pokemonRepository.save(pokemon)
        return pokemon
    }
}