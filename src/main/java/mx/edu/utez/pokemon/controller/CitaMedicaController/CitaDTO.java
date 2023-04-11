package mx.edu.utez.pokemon.controller.CitaMedicaController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.model.CitaMedica.CitaMedica;
import mx.edu.utez.pokemon.model.Consultorio.Consultorio;
import mx.edu.utez.pokemon.model.Pokemon.Pokemon;
import org.apache.catalina.User;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CitaDTO {
    Long idmedicalConsultation;
    LocalDate date;
    String medicalConsultation;
    String suffering;
    Pokemon pokemon;
    User doctor;
    Consultorio clinic;

    public CitaMedica convertTomedicalConsultation(){
        return  new CitaMedica(
                getIdmedicalConsultation(),
                LocalDate.now(),
                getMedicalConsultation(),
                getSuffering(),
                getPokemon(),
                getDoctor(),
                getClinic()
        );
    }
}
