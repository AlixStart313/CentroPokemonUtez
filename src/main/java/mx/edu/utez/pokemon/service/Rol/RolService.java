package mx.edu.utez.pokemon.service.Rol;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.Rol.IRolRepository;
import mx.edu.utez.pokemon.model.Rol.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;

@Service

public class RolService {
    @Autowired
    private IRolRepository repository;

    public CustomResponse<Rol> save(Rol role) {
        if (this.repository.existsByName(role.getName()))
            return new CustomResponse<>(
                    null, true, 400, "Este registro ya existe"
            );

        return new CustomResponse<>(
                this.repository.save(role),
                false,200,"Registyro guardado con exito"
        );
    }

    public CustomResponse<List<Rol>> findAll() {
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public CustomResponse<Rol> findOne(String name) {
        return new CustomResponse<>(
                this.repository.findByName(name),
                false,
                200,
                "OK"
        );
    }


    public CustomResponse<Rol> delete(Rol rol) {
        if (!this.repository.existsByName(rol.getName()))
            return new CustomResponse<>(
                    null, true, 400, "Ese registro no existe en la base de datos"
            );

        if (this.repository.existsByName(rol.getName()))
            this.repository.deleteById(rol.getIdRoles());
        return new CustomResponse<>(
                null,
                false,
                200,
                "registro eliminado con exito");

    }
}
