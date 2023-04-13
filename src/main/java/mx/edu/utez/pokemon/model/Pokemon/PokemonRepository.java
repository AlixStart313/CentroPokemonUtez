package mx.edu.utez.pokemon.model.Pokemon;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends MongoRepository<Pokemon,Long> {
    Pokemon findByName(String name);
    Boolean existsByName(String name);

    Boolean existsById(String id);
    void deleteById(String id);

}
