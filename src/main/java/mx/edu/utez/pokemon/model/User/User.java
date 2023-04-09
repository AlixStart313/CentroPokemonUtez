package mx.edu.utez.pokemon.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mx.edu.utez.pokemon.model.Rol.Rol;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    Long idUser;
    String username;
    String password;
     Rol rol;


}
