package mx.edu.utez.pokemon.service.CitaMedica;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.CitaMedica.CitaMedica;
import mx.edu.utez.pokemon.model.CitaMedica.ICitaMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {
    @Autowired
    private ICitaMedicaRepository repository;

    public CustomResponse<CitaMedica> save(CitaMedica cita) {
        if (this.repository.existsById(cita.getId()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro ya existe"
            );

        return new CustomResponse<>(
                this.repository.save(cita),
                false,
                200,
                "Cita registrada  con exito"
        );
    }

    public CustomResponse<CitaMedica> update(CitaMedica cita) {
        if (!this.repository.existsById(cita.getId()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro No existe"
            );

        return new CustomResponse<>(
                this.repository.save(cita),
                false,
                200,
                "Cita modificada con exito"
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

    public CustomResponse<CitaMedica> findOne(String cita) {
        return new CustomResponse<>(
                this.repository.findByMedicalConsultation(cita),
                false,
                200,
                "OK"
        );
    }


    public CustomResponse<CitaMedica> delete(CitaMedica cita) {
        if (!this.repository.existsById(cita.getId()))
            return new CustomResponse<>(
                    null, true, 400, "Ese registro no existe en la base de datos"
            );


        this.repository.deleteById(cita.getId());
        return new CustomResponse<>(
                null,
                false,
                200,
                "registro eliminado con exito");

    }
}
