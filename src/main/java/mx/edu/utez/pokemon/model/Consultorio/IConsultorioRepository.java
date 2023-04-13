package mx.edu.utez.pokemon.model.Consultorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IConsultorioRepository extends MongoRepository<Consultorio,Long> {
    Consultorio findByName(String name);
    Boolean existsByName(String name);

    Boolean existsById(String id);
    void deleteById(String id);
}
