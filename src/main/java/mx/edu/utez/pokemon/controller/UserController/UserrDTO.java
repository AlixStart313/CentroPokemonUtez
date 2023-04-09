package mx.edu.utez.pokemon.controller.UserController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.model.Rol.Rol;
import mx.edu.utez.pokemon.model.User.User;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserrDTO {
    Long idUser;

    String username;
    String password;
    Rol rol;

    public User convertToUser(){
        return  new User(
                getIdUser(),
                getUsername(),
                getPassword(),
                getRol()
        );
    }

}
