package mx.edu.utez.pokemon.controller.TipoController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.model.User.TiposPokemon.TipoPokemon;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TipoDTO {
    String id;
    String name;

    public TipoPokemon convertToType(){
        return  new TipoPokemon(
                getId(),
                getName()
        );
    }
}
