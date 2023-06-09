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

    //Works correctly
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

    //Works correctly
    public CustomResponse<User> update(User user) {
        if (!this.repository.existsById(user.getId()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro no se encuentra en nuestra base de datos "
            );

        return new CustomResponse<>(
                this.repository.save(user),
                false,
                200,
                "Usuario actualizado  con exito"
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

    //Works correctly
    public CustomResponse<User> findOne(String username) {
        return new CustomResponse<>(
                this.repository.findByUsername(username),
                false,
                200,
                "OK"
        );
    }

    //Works correctly
    public CustomResponse<User> deleteByUserName(User user) {
        if (!this.repository.existsByUsername(user.getUsername()))
            return new CustomResponse<>(
                    null, true, 400, "este usuario no existe"
            );


         this.repository.deleteById(user.getId());
             return new CustomResponse<>(
                null,
                false,
                200,
                "Usuario eliminado con exito");

    }


}
