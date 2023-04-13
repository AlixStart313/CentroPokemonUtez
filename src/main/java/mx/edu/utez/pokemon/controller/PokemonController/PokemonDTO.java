package mx.edu.utez.pokemon.controller.PokemonController;

import lombok.*;
import mx.edu.utez.pokemon.model.Combinacion.Combinacion;
import mx.edu.utez.pokemon.model.Especie.Especie;
import mx.edu.utez.pokemon.model.Origen.Origen;
import mx.edu.utez.pokemon.model.Pokemon.Pokemon;
import mx.edu.utez.pokemon.model.User.TiposPokemon.TipoPokemon;
import mx.edu.utez.pokemon.model.User.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PokemonDTO {
    String id;
    String name;
    int age;
    String description;
    User trainer;
    Especie species;
    Origen origin;
    TipoPokemon type;
    Combinacion combination;

    public Pokemon convertToPokemon(){
        return  new Pokemon(
                getId(),
                getName(),
                getAge(),
                getDescription(),
                getTrainer(),
                getSpecies(),
                getOrigin(),
                getType(),
                getCombination()
        );
    }
}
