package mx.edu.utez.pokemon.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomResponse<T> {
    T data;
    boolean error;
    int statusCode;
    String message;

    public CustomResponse(boolean error, int statusCode, String message) {
        this.error = error;
        this.statusCode = statusCode;
        this.message = message;
    }
}
