package by.cherkas.diplom.exceptions.types.passport;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PassportNotValidException extends RuntimeException {
    public PassportNotValidException(String message) {
        super(message);
    }
}
