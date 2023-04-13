package mx.edu.utez.pokemon.model.Especie;

import mx.edu.utez.pokemon.model.User.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface IEspecieRepository extends MongoRepository<Especie,Long> {

    Especie findBySpecies(String name);

    Boolean existsBySpecies(String name);

    Boolean existsById(String id);
    void deleteById(String id);

}
