package mx.edu.utez.pokemon.service.Consultorio;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.Combinacion.Combinacion;
import mx.edu.utez.pokemon.model.Consultorio.Consultorio;
import mx.edu.utez.pokemon.model.Consultorio.IConsultorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultorioService {
    @Autowired
    private IConsultorioRepository repository;

    public CustomResponse<Consultorio> save(Consultorio consultorio) {
        if (this.repository.existsByName(consultorio.getName()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro ya existe"
            );

        return new CustomResponse<>(
                this.repository.save(consultorio),
                false,
                200,
                "Tipo de pokemon  registrado con exito"
        );
    }

    public CustomResponse<List<Consultorio>> findAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public CustomResponse<Consultorio> findOne(Consultorio consultorio) {
        return new CustomResponse<>(
                this.repository.findByName(consultorio.getName()),
                false,
                200,
                "OK"
        );
    }


    public CustomResponse<Consultorio> delete(Consultorio consultorio) {
        if (!this.repository.existsByName(consultorio.getName()))
            return new CustomResponse<>(
                    null, true, 400, "Ese registro no existe en la base de datos"
            );

        if (this.repository.existsByName(consultorio.getName()))
            this.repository.deleteById(consultorio.getIdclinic());
        return new CustomResponse<>(
                null,
                false,
                200,
                "registro eliminado con exito");

    }
}
