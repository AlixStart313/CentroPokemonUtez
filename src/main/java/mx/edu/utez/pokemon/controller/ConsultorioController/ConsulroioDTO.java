package mx.edu.utez.pokemon.controller.ConsultorioController;

import lombok.*;
import mx.edu.utez.pokemon.model.Consultorio.Consultorio;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsulroioDTO {
    String id;
    String name;
    public Consultorio convertToClinic(){
        return  new Consultorio(
                getId(),
                getName()
        );
    }
}
