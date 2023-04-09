package mx.edu.utez.pokemon.service.User;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.User.IUserRepository;
import mx.edu.utez.pokemon.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsaerService {
    @Autowired
    private IUserRepository repository;

    public CustomResponse<User> save(User user) {
        if (this.repository.existsByUsername(user.getUsername()))
            return new CustomResponse<>(
                    null, true, 400, "este usuario ya esta registrado"
            );

        return new CustomResponse<>(
                this.repository.save(user),
                false,
                200,
                "Usuario registrado con exito"
        );
    }

    public CustomResponse<List<User>> findAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public CustomResponse<User> findOne(String username) {
        return new CustomResponse<>(
                this.repository.findByUsername(username),
                false,
                200,
                "OK"
        );
    }


    public CustomResponse<User> deleteByUserName(User user) {
        if (!this.repository.existsByUsername(user.getUsername()))
            return new CustomResponse<>(
                    null, true, 400, "este usuario ya esta registrado"
            );

        if (this.repository.existsByUsername(user.getUsername()))
            this.repository.deleteById(user.getIdUser());
             return new CustomResponse<>(
                null,
                false,
                200,
                "Usuario eliminado con exito");

    }


}
