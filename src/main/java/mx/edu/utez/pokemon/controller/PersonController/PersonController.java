package mx.edu.utez.pokemon.controller.PersonController;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.Pokemon.Person.Person;
import mx.edu.utez.pokemon.service.Person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokeUtez/person")
@CrossOrigin(origins = {"*"})
public class PersonController {
    @Autowired
    private PersonService service;

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Person>> save(@RequestBody PersonDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.convertToPerson()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Person>>> getAll(){
        return new ResponseEntity<>(
                this.service.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<CustomResponse<Person>> getOne(@PathVariable("name") String name){
        return new ResponseEntity<>(
                this.service.findOne(name),
                HttpStatus.OK
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Person>> update(@RequestBody PersonDTO dto){
        return new ResponseEntity<>(
                this.service.update(dto.convertToPerson()),
                HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<CustomResponse<Person>> delete(@RequestBody PersonDTO dto){
        return  new ResponseEntity<>(
                this.service.delete(dto.convertToPerson()),
                HttpStatus.OK);
    };
}
