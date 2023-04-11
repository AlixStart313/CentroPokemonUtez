package mx.edu.utez.pokemon.service.Tipos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.TiposPokemon.ITipoPokemonRepository;
import mx.edu.utez.pokemon.model.TiposPokemon.TipoPokemon;
import mx.edu.utez.pokemon.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TiposService {
    @Autowired
    private ITipoPokemonRepository repository;

    public CustomResponse<TipoPokemon> save(TipoPokemon tipo) {
        if (this.repository.existsByName(tipo.getName()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro ya existe"
            );

        return new CustomResponse<>(
                this.repository.save(tipo),
                false,
                200,
                "Tipo de pokemon  registrado con exito"
        );
    }

    public CustomResponse<List<TipoPokemon>> findAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public CustomResponse<TipoPokemon> findOne(String name) {
        return new CustomResponse<>(
                this.repository.findByName(name),
                false,
                200,
                "OK"
        );
    }


    public CustomResponse<TipoPokemon> delete(TipoPokemon tipoPokemon) {
        if (!this.repository.existsByName(tipoPokemon.getName()))
            return new CustomResponse<>(
                    null, true, 400, "Ese registro no existe en la base de datos"
            );

        if (this.repository.existsByName(tipoPokemon.getName()))
            this.repository.deleteById(tipoPokemon.getIdType());
        return new CustomResponse<>(
                null,
                false,
                200,
                "registro eliminado con exito");

    }
}
