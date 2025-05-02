package by.cherkas.diplom.exceptions.types.requisition;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequisitionNotValidException extends RuntimeException {
    public RequisitionNotValidException(String message) {
        super(message);
    }
}
