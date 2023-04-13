package mx.edu.utez.pokemon.model.User.TiposPokemon;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoPokemonRepository extends MongoRepository<TipoPokemon,Long> {
    TipoPokemon findByName(String name);
    Boolean existsByName(String name);

    Boolean existsById(String id);
    void deleteById(String id);
}
