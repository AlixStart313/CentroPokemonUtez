package mx.edu.utez.pokemon.controller.CitaMedicaController;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.CitaMedica.CitaMedica;
import mx.edu.utez.pokemon.service.CitaMedica.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokeUtez/consultation")
@CrossOrigin(origins = {"*"})
public class CitaMedicaController {
    @Autowired
    private CitaService service;

    @PostMapping("/")
    public ResponseEntity<CustomResponse<CitaMedica>> save(@RequestBody CitaDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.convertTomedicalConsultation()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<CitaMedica>>> getAll(){
        return new ResponseEntity<>(
                this.service.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{name}")
    public ResponseEntity<CustomResponse<CitaMedica>> getOne(@PathVariable("name") String name){
        return new ResponseEntity<>(
                this.service.findOne(name),
                HttpStatus.OK
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<CitaMedica>> update(@RequestBody CitaDTO dto){
        return new ResponseEntity<>(
                this.service.update(dto.convertTomedicalConsultation()),
                HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<CustomResponse<CitaMedica>> delete(@RequestBody CitaDTO dto){
        return  new ResponseEntity<>(
                this.service.delete(dto.convertTomedicalConsultation()),
                HttpStatus.OK);
    };
}
