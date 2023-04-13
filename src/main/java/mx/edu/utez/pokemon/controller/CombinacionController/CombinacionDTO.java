package mx.edu.utez.pokemon.controller.CombinacionController;


import lombok.*;
import mx.edu.utez.pokemon.model.Combinacion.Combinacion;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CombinacionDTO {
    String id;

    String combination;

    public Combinacion convertoToCombination(){
        return  new Combinacion(
                getId(),
                getCombination()
        );
    }
}
