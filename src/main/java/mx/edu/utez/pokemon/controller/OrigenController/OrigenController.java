package mx.edu.utez.pokemon.controller.OrigenController;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.controller.EspecieController.EspecoeDTO;
import mx.edu.utez.pokemon.model.Especie.Especie;
import mx.edu.utez.pokemon.model.Origen.Origen;
import mx.edu.utez.pokemon.service.Especie.EspecieService;
import mx.edu.utez.pokemon.service.Origen.OrigenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokeUtez/origin")
@CrossOrigin(origins = {"*"})
public class OrigenController {
    @Autowired
    private OrigenService service;

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Origen>> save(@RequestBody OrigenDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.convertToOrigin()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Origen>>> getAll(){
        return new ResponseEntity<>(
                this.service.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<CustomResponse<Origen>> getOne(@PathVariable("name") String name){
        return new ResponseEntity<>(
                this.service.findOne(name),
                HttpStatus.OK
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Origen>> update(@RequestBody OrigenDTO dto){

        return new ResponseEntity<>(
                this.service.update(dto.convertToOrigin()),
                HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<CustomResponse<Origen>> delete(@RequestBody OrigenDTO dto){
        return  new ResponseEntity<>(
                this.service.delete(dto.convertToOrigin()),
                HttpStatus.OK);
    };
}
