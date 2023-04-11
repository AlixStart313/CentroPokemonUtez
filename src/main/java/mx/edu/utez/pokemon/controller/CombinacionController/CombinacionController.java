package mx.edu.utez.pokemon.controller.CombinacionController;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.Combinacion.Combinacion;
import mx.edu.utez.pokemon.service.Combinacion.CombinacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokeUtez/combination")
@CrossOrigin(origins = {"*"})
public class CombinacionController {
    @Autowired
    private CombinacionService service;

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Combinacion>> save(@RequestBody CombinacionDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.convertoToCombination()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Combinacion>>> getAll(){
        return new ResponseEntity<>(
                this.service.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<CustomResponse<Combinacion>> getOne(@PathVariable("name") String name){
        return new ResponseEntity<>(
                this.service.findOne(name),
                HttpStatus.OK
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Combinacion>> update(@RequestBody CombinacionDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.convertoToCombination()),
                HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<CustomResponse<Combinacion>> delete(@RequestBody CombinacionDTO dto){
        return  new ResponseEntity<>(
                this.service.delete(dto.convertoToCombination()),
                HttpStatus.OK);
    };
}
