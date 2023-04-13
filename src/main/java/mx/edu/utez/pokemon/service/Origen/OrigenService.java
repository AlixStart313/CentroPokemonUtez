package mx.edu.utez.pokemon.service.Origen;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.Combinacion.Combinacion;
import mx.edu.utez.pokemon.model.Origen.IOrigenRepository;
import mx.edu.utez.pokemon.model.Origen.Origen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrigenService {
    @Autowired
    private IOrigenRepository repository;

    public CustomResponse<Origen> save(Origen origen) {
        if (this.repository.existsByOrigin(origen.getOrigin()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro ya existe"
            );

        return new CustomResponse<>(
                this.repository.save(origen),
                false,
                200,
                "Registro existoso"
        );
    }

    public CustomResponse<Origen> update(Origen origen) {
        if (!this.repository.existsById(origen.getId()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro no existe"
            );

        return new CustomResponse<>(
                this.repository.save(origen),
                false,
                200,
                "Registro modificado"
        );
    }

    public CustomResponse<List<Origen>> findAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public CustomResponse<Origen> findOne(String origen) {
        return new CustomResponse<>(
                this.repository.findById(origen),
                false,
                200,
                "OK"
        );
    }


    public CustomResponse<Origen> delete(Origen origen) {
        if (!this.repository.existsByOrigin(origen.getOrigin()))
            return new CustomResponse<>(
                    null, true, 400, "Ese registro no existe en la base de datos"
            );

        this.repository.deleteById(origen.getId());
        return new CustomResponse<>(
                null,
                false,
                200,
                "registro eliminado con exito");

    }
}
