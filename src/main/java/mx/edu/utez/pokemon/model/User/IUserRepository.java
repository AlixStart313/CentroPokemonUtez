package mx.edu.utez.pokemon.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends MongoRepository<User, Long> {


    User findByUsername(String username);

    Boolean existsByUsername(String username);
    Boolean existsByIdUser(Long id);




}
