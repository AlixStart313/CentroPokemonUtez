package mx.edu.utez.pokemon.controller.EspecieController;

import lombok.*;
import mx.edu.utez.pokemon.model.Especie.Especie;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EspecoeDTO {
    Long idSpecies;
    String species;
    public Especie convertToSpecies(){
        return  new Especie(
                getIdSpecies(),
                getSpecies()
        );
    }
}
