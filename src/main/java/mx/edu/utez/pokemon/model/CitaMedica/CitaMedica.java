package mx.edu.utez.pokemon.model.CitaMedica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.model.Consultorio.Consultorio;
import mx.edu.utez.pokemon.model.Pokemon.Person.Person;
import mx.edu.utez.pokemon.model.Pokemon.Pokemon;
import org.apache.catalina.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document("medicalConsultation")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CitaMedica {
    @Id
    String id;
    String medicalConsultation;
    String suffering;
    Pokemon pokemon;
    Person doctor;
    Consultorio clinic;




}
