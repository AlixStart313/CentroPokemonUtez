package mx.edu.utez.pokemon.model.Combinacion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Combination")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Combinacion {
    @Id
    Long idCombination;

    String combination;
}
