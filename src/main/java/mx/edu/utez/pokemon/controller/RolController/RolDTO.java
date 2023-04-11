package mx.edu.utez.pokemon.controller.RolController;

import lombok.*;
import mx.edu.utez.pokemon.model.Rol.Rol;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolDTO {
    Long idRoles;
    String name;
 public Rol converToRol(){
     return new Rol(
             getIdRoles(),getName()
     );
 }
}
