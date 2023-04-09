package mx.edu.utez.pokemon.model.Origen;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrigenRepository  extends MongoRepository<Origen,Long> {
    Origen findByIdOrigin(String name);
    Boolean existsByOrigin(String name);
}
