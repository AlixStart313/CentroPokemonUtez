package mx.edu.utez.pokemon.model.Rol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.model.User.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.annotation.processing.Generated;

@Document("Roles")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Rol {
    @Id
    Long idRoles;
    String name;
}
