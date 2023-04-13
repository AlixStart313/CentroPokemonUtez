package mx.edu.utez.pokemon.model.Origen;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Origins")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Origen {
    @Id
    String id;
    String origin;
}
