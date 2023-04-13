package mx.edu.utez.pokemon.controller.OrigenController;

import lombok.*;
import mx.edu.utez.pokemon.model.Origen.Origen;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrigenDTO {
    String id;
    String origin;
    public Origen convertToOrigin(){
        return  new Origen(
                getId(),
                getOrigin()
        );
    }
}
