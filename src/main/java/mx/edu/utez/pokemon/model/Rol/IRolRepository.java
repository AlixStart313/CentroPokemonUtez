package mx.edu.utez.pokemon.model.Rol;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends MongoRepository<Rol, Long> {
    Rol findByName(String name);

    Boolean existsByName(String name);

}
