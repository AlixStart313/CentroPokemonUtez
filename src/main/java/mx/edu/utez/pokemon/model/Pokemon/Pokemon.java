package mx.edu.utez.pokemon.model.Pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.model.Combinacion.Combinacion;
import mx.edu.utez.pokemon.model.Especie.Especie;
import mx.edu.utez.pokemon.model.Origen.Origen;
import mx.edu.utez.pokemon.model.User.TiposPokemon.TipoPokemon;
import mx.edu.utez.pokemon.model.User.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Pokemon")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pokemon {
    @Id
    String id;
    String name;
    int age;
    String description;
    User trainer;
    Especie species;
    Origen origin;
    TipoPokemon type;
    Combinacion combination;

}
