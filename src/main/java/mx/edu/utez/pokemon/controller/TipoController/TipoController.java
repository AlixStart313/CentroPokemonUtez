package mx.edu.utez.pokemon.controller.TipoController;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.User.TiposPokemon.TipoPokemon;
import mx.edu.utez.pokemon.service.Tipos.TiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokeUtez/types")
@CrossOrigin(origins = {"*"})
public class TipoController {
    @Autowired
    private TiposService service;

    @PostMapping("/")
    public ResponseEntity<CustomResponse<TipoPokemon>> save(@RequestBody TipoDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.convertToType()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<TipoPokemon>>> getAll(){
        return new ResponseEntity<>(
                this.service.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<CustomResponse<TipoPokemon>> getOne(@PathVariable("name") String name){
        return new ResponseEntity<>(
                this.service.findOne(name),
                HttpStatus.OK
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<TipoPokemon>> update(@RequestBody TipoDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.convertToType()),
                HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<CustomResponse<TipoPokemon>> delete(@RequestBody TipoDTO dto){
        return  new ResponseEntity<>(
                this.service.delete(dto.convertToType()),
                HttpStatus.OK);
    };
}
