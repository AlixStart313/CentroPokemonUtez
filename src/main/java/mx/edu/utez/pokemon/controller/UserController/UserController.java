package mx.edu.utez.pokemon.controller.UserController;

import mx.edu.utez.pokemon.Utils.CustomResponse;
import mx.edu.utez.pokemon.model.User.User;
import mx.edu.utez.pokemon.service.User.UsaerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokeUtez/user")
@CrossOrigin(origins = {"*"})
public class UserController {
    @Autowired
    private UsaerService service;

    @PostMapping("/")
    public ResponseEntity<CustomResponse<User>> save(@RequestBody UserrDTO dto){
        return new ResponseEntity<>(
                this.service.save(dto.convertToUser()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<User>>> getAll(){
        return new ResponseEntity<>(
                this.service.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{username}")
    public ResponseEntity<CustomResponse<User>> getOne(@PathVariable("username") String username){
        return new ResponseEntity<>(
                this.service.findOne(username),
                HttpStatus.OK
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<User>> updateUser(@RequestBody UserrDTO dto){
        return new ResponseEntity<>(
                this.service.update(dto.convertToUser()),
                HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<CustomResponse<User>> deleteUser(@RequestBody UserrDTO dto){
        return  new ResponseEntity<>(
                this.service.deleteByUserName(dto.convertToUser()),
                HttpStatus.OK);
    };
}
