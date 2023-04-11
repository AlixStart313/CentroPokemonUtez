package mx.edu.utez.pokemon.service.Combinacion;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.Combinacion.Combinacion;
import mx.edu.utez.pokemon.model.Combinacion.ICombinacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombinacionService {
    @Autowired
    private ICombinacionRepository repository;

    public CustomResponse<Combinacion> save(Combinacion combinacion) {
        if (this.repository.existsByCombination(combinacion.getCombination()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro ya existe"
            );

        return new CustomResponse<>(
                this.repository.save(combinacion),
                false,
                200,
                "Tipo de pokemon  registrado con exito"
        );
    }

    public CustomResponse<List<Combinacion>> findAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public CustomResponse<Combinacion> findOne(String combination) {
        return new CustomResponse<>(
                this.repository.findByCombination(combination),
                false,
                200,
                "OK"
        );
    }


    public CustomResponse<Combinacion> delete(Combinacion combinacion) {
        if (!this.repository.existsByCombination(combinacion.getCombination()))
            return new CustomResponse<>(
                    null, true, 400, "Ese registro no existe en la base de datos"
            );

        if (this.repository.existsByCombination(combinacion.getCombination()))
            this.repository.deleteById(combinacion.getIdCombination());
        return new CustomResponse<>(
                null,
                false,
                200,
                "registro eliminado con exito");

    }
}
