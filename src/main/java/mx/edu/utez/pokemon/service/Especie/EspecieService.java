package mx.edu.utez.pokemon.service.Especie;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.Combinacion.Combinacion;
import mx.edu.utez.pokemon.model.Especie.Especie;
import mx.edu.utez.pokemon.model.Especie.IEspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecieService {
    @Autowired
    private IEspecieRepository repository;

    public CustomResponse<Especie> save(Especie especie) {
        if (this.repository.existsBySpecies(especie.getSpecies()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro ya existe"
            );

        return new CustomResponse<>(
                this.repository.save(especie),
                false,
                200,
                "Tipo de pokemon  registrado con exito"
        );
    }

    public CustomResponse<List<Especie>> findAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public CustomResponse<Especie> findOne(String especie) {
        return new CustomResponse<>(
                this.repository.findBySpecies(especie),
                false,
                200,
                "OK"
        );
    }


    public CustomResponse<Especie> delete(Especie especie) {
        if (!this.repository.existsBySpecies(especie.getSpecies()))
            return new CustomResponse<>(
                    null, true, 400, "Ese registro no existe en la base de datos"
            );

        if (this.repository.existsBySpecies(especie.getSpecies()))
            this.repository.deleteById(especie.getIdSpecies());
        return new CustomResponse<>(
                null,
                false,
                200,
                "registro eliminado con exito");

    }
}
