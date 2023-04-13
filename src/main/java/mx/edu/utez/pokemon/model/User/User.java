package mx.edu.utez.pokemon.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mx.edu.utez.pokemon.model.Rol.Rol;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    String id;
    String username;
    String password;
     Rol rol;


}
