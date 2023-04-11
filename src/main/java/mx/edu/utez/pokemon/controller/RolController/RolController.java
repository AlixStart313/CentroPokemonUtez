package mx.edu.utez.pokemon.controller.RolController;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.controller.TipoController.TipoDTO;
import mx.edu.utez.pokemon.model.Rol.Rol;
import mx.edu.utez.pokemon.model.TiposPokemon.TipoPokemon;
import mx.edu.utez.pokemon.service.Rol.RolService;
import mx.edu.utez.pokemon.service.Tipos.TiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api-pokeUtez/roles")
@CrossOrigin(origins = {"*"})
public class RolController {
    @Autowired
    private RolService service;

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Rol>> save(@RequestBody RolDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.converToRol()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Rol>>> getAll(){
        return new ResponseEntity<>(
                this.service.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<CustomResponse<Rol>> getOne(@PathVariable("name") String name){
        return new ResponseEntity<>(
                this.service.findOne(name),
                HttpStatus.OK
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Rol>> update(@RequestBody RolDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.converToRol()),
                HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<CustomResponse<Rol>> delete(@RequestBody RolDTO dto){
        return  new ResponseEntity<>(
                this.service.delete(dto.converToRol()),
                HttpStatus.OK);
    };
}
