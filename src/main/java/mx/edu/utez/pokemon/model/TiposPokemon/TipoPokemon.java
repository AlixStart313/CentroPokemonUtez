package mx.edu.utez.pokemon.model.TiposPokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Type")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TipoPokemon {
    @Id
    Long idType;

    String name;
}
