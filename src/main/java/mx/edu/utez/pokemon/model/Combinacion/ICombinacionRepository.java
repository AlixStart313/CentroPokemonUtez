package mx.edu.utez.pokemon.model.Combinacion;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICombinacionRepository extends MongoRepository<Combinacion,Long> {
    Combinacion findByCombination(String name);
    Boolean existsByCombination(String name);
}
