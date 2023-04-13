package mx.edu.utez.pokemon.controller.PersonController;

import lombok.*;
import mx.edu.utez.pokemon.model.Pokemon.Person.Person;
import mx.edu.utez.pokemon.model.User.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDTO {
    String id;
    String name;
    String lastName;
    String surName;
    String email;
    User user;
    public Person convertToPerson(){
        return   new Person(
                getId(),
                getName(),
                getLastName(),
                getSurName(),
                getEmail(),
                getUser()
        );
    }
}
