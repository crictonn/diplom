package by.cherkas.diplom.exceptions.types.department;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DepartmentNotValidException extends RuntimeException {
    public DepartmentNotValidException(String message) {
        super(message);
    }
}
