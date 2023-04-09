package mx.edu.utez.pokemon.service.CitaMedica;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.CitaMedica.CitaMedica;
import mx.edu.utez.pokemon.model.CitaMedica.ICitaMedicaRepository;
import mx.edu.utez.pokemon.model.TiposPokemon.ITipoPokemonRepository;
import mx.edu.utez.pokemon.model.TiposPokemon.TipoPokemon;
import mx.edu.utez.pokemon.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {
    @Autowired
    private ICitaMedicaRepository repository;

    public CustomResponse<CitaMedica> save(CitaMedica cita) {
        if (this.repository.existsByIdmedicalConsultation(cita.getIdmedicalConsultation()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro ya existe"
            );

        return new CustomResponse<>(
                this.repository.save(cita),
                false,
                200,
                "Tipo de pokemon  registrado con exito"
        );
    }

    public CustomResponse<List<CitaMedica>> findAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public CustomResponse<CitaMedica> findOne(CitaMedica cita) {
        return new CustomResponse<>(
                this.repository.findByMedicalConsultation(cita.getMedicalConsultation()),
                false,
                200,
                "OK"
        );
    }


    public CustomResponse<CitaMedica> delete(CitaMedica cita) {
        if (!this.repository.existsByIdmedicalConsultation(cita.getIdmedicalConsultation()))
            return new CustomResponse<>(
                    null, true, 400, "Ese registro no existe en la base de datos"
            );


            this.repository.deleteById(cita.getIdmedicalConsultation());
        return new CustomResponse<>(
                null,
                false,
                200,
                "registro eliminado con exito");

    }
}
