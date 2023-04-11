package mx.edu.utez.pokemon.controller.PersonController;

import lombok.*;
import mx.edu.utez.pokemon.model.Person.Person;
import mx.edu.utez.pokemon.model.User.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDTO {
    Long idPeople;
    String name;
    String lastName;
    String surName;
    String email;
    User user;
    public Person convertToPerson(){
        return   new Person(
                getIdPeople(),
                getName(),
                getLastName(),
                getSurName(),
                getEmail(),
                getUser()
        );
    }
}
