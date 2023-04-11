package mx.edu.utez.pokemon.controller.EspecieController;


import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.Especie.Especie;
import mx.edu.utez.pokemon.service.Especie.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokeUtez/species")
@CrossOrigin(origins = {"*"})
public class EspecieController {
    @Autowired
    private EspecieService service;

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Especie>> save(@RequestBody EspecoeDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.convertToSpecies()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Especie>>> getAll(){
        return new ResponseEntity<>(
                this.service.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<CustomResponse<Especie>> getOne(@PathVariable("name") String name){
        return new ResponseEntity<>(
                this.service.findOne(name),
                HttpStatus.OK
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Especie>> update(@RequestBody EspecoeDTO dto){

        return new ResponseEntity<>(
                this.service.save(dto.convertToSpecies()),
                HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<CustomResponse<Especie>> delete(@RequestBody EspecoeDTO dto){
        return  new ResponseEntity<>(
                this.service.delete(dto.convertToSpecies()),
                HttpStatus.OK);
    };
}
