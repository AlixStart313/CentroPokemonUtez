package mx.edu.utez.pokemon.model.Consultorio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("clinic")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Consultorio {
    @Id
    String id;
    String name;
}
