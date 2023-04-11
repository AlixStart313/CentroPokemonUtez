package mx.edu.utez.pokemon.controller.ConsultorioController;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.controller.TipoController.TipoDTO;
import mx.edu.utez.pokemon.model.Consultorio.Consultorio;
import mx.edu.utez.pokemon.service.Consultorio.ConsultorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokeUtez/clinic")
@CrossOrigin(origins = {"*"})
public class ConsultorioContoller {
    @Autowired
    private ConsultorioService service;

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Consultorio>> save(@RequestBody ConsulroioDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.convertToClinic()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Consultorio>>> getAll(){
        return new ResponseEntity<>(
                this.service.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<CustomResponse<Consultorio>> getOne(@PathVariable("name") String name){
        return new ResponseEntity<>(
                this.service.findOne(name),
                HttpStatus.OK
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Consultorio>> update(@RequestBody ConsulroioDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.convertToClinic()),
                HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<CustomResponse<Consultorio>> delete(@RequestBody ConsulroioDTO dto){
        return  new ResponseEntity<>(
                this.service.delete(dto.convertToClinic()),
                HttpStatus.OK);
    };
}
