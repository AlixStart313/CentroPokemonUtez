package mx.edu.utez.pokemon.model.CitaMedica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.model.Consultorio.Consultorio;
import mx.edu.utez.pokemon.model.Pokemon.Pokemon;
import org.apache.catalina.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("medicalConsultation")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CitaMedica {
    @Id
    Long idmedicalConsultation;
    Date date;
    String medicalConsultation;
    String suffering;
    Pokemon pokemon;
    User doctor;
    Consultorio clinic;




}
