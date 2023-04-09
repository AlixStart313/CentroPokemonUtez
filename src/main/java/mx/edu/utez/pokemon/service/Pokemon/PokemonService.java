package mx.edu.utez.pokemon.service.Pokemon;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.Pokemon.Pokemon;
import mx.edu.utez.pokemon.model.Pokemon.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    @Autowired
    private PokemonRepository repository;

    public CustomResponse<Pokemon> save(Pokemon pokemon) {
        if (this.repository.existsByName(pokemon.getName()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro ya existe"
            );

        return new CustomResponse<>(
                this.repository.save(pokemon),
                false,
                200,
                "Tipo de pokemon  registrado con exito"
        );
    }

    public CustomResponse<List<Pokemon>> findAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public CustomResponse<Pokemon> findOne(Pokemon pokemon) {
        return new CustomResponse<>(
                this.repository.findByName(pokemon.getName()),
                false,
                200,
                "OK"
        );
    }


    public CustomResponse<Pokemon> delete(Pokemon pokemon) {
        if (!this.repository.existsByName(pokemon.getName()))
            return new CustomResponse<>(
                    null, true, 400, "Ese registro no existe en la base de datos"
            );

        if (this.repository.existsByName(pokemon.getName()))
            this.repository.deleteById(pokemon.getIdPokemon());
        return new CustomResponse<>(
                null,
                false,
                200,
                "registro eliminado con exito");

    }
}
