package mx.edu.utez.pokemon.model.Especie;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("species")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Especie {
    @Id
    Long idSpecies;
    String species;

}
