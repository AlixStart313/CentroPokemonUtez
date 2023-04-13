package mx.edu.utez.pokemon.model.Pokemon.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.pokemon.model.User.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("People")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person {
    @Id
    String id;
    String name;
    String lastName;
    String surName;
    String email;
    User user;
}
