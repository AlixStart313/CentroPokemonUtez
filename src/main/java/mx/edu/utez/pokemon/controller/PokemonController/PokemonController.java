package mx.edu.utez.pokemon.controller.PokemonController;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.controller.TipoController.TipoDTO;
import mx.edu.utez.pokemon.model.Pokemon.Pokemon;
import mx.edu.utez.pokemon.model.TiposPokemon.TipoPokemon;
import mx.edu.utez.pokemon.service.Pokemon.PokemonService;
import mx.edu.utez.pokemon.service.Tipos.TiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api-pokeUtez/pokemon")
@CrossOrigin(origins = {"*"})
public class PokemonController {
    @Autowired
    private PokemonService service;

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Pokemon>> save(@RequestBody PokemonDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.convertToPokemon()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Pokemon>>> getAll(){
        return new ResponseEntity<>(
                this.service.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<CustomResponse<Pokemon>> getOne(@PathVariable("name") String name){
        return new ResponseEntity<>(
                this.service.findOne(name),
                HttpStatus.OK
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Pokemon>> update(@RequestBody PokemonDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.convertToPokemon()),
                HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<CustomResponse<Pokemon>> delete(@RequestBody PokemonDTO dto){
        return  new ResponseEntity<>(
                this.service.delete(dto.convertToPokemon()),
                HttpStatus.OK);
    };
}
