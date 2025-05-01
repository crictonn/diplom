package by.cherkas.diplom.exceptions.types.address;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AddressNotValidException extends RuntimeException {
    public AddressNotValidException(String message) {
        super(message);
    }
}
