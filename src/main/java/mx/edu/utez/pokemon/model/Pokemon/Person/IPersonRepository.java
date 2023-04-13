package mx.edu.utez.pokemon.model.Pokemon.Person;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository  extends MongoRepository<Person,Long> {
    Person findByEmail(String email);
    Boolean existsByEmail(String email);

    Boolean existsById(String unique);
    void deleteById(String id);
}
