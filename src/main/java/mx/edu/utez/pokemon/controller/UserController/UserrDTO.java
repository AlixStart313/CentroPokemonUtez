package mx.edu.utez.pokemon.controller.UserController;

import lombok.*;
import mx.edu.utez.pokemon.model.Rol.Rol;
import mx.edu.utez.pokemon.model.User.User;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserrDTO {
    String id;

    String username;
    String password;
    Rol rol;

    public User convertToUser(){
        return  new User(
                getId(),
                getUsername(),
                getPassword(),
                getRol()
        );
    }

}
