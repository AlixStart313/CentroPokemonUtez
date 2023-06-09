package mx.edu.utez.pokemon.service.Person;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.Pokemon.Person.IPersonRepository;
import mx.edu.utez.pokemon.model.Pokemon.Person.Person;
import mx.edu.utez.pokemon.model.User.IUserRepository;
import mx.edu.utez.pokemon.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private IPersonRepository  repository;

    @Autowired
    private IUserRepository userRepository;

    public CustomResponse<Person> save(Person person) {
        if (this.repository.existsByEmail(person.getEmail()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro ya existe"
            );
        if (this.userRepository.existsByUsername(person.getUser().getUsername()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro ya existe"
            );

        this.userRepository.save(person.getUser());
        return new CustomResponse<>(
                this.repository.save(person),
                false,
                200,
                "Persona registrado con exito"
        );
    }

    public CustomResponse<Person> update(Person person) {
        if (!this.repository.existsById(person.getId()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro no existe"
            );

        this.userRepository.save(person.getUser());
        return new CustomResponse<>(
                this.repository.save(person),
                false,
                200,
                "Persona modificada con exito"
        );
    }

    public CustomResponse<List<Person>> findAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public CustomResponse<Person> findOne(String person) {
        return new CustomResponse<>(
                this.repository.findByEmail(person),
                false,
                200,
                "OK"
        );
    }


    public CustomResponse<Person> delete(Person person) {
        if (!this.repository.existsByEmail(person.getEmail()))
            return new CustomResponse<>(
                    null, true, 400, "Ese registro no existe en la base de datos"
            );

        if (this.repository.existsByEmail(person.getEmail())){
            User userdelete= userRepository.findByUsername(person.getUser().getUsername());
            this.userRepository.deleteById(userdelete.getId());
             this.repository.deleteById(person.getId());
       }
        return new CustomResponse<>(
                null,
                false,
                200,
                "registro eliminado con exito");

    }
}
