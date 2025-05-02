package by.cherkas.diplom.exceptions.types.address;

import by.cherkas.diplom.exceptions.ErrorMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AddressNotFoundException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(AddressNotFoundException.class);

    public AddressNotFoundException() {
        super(ErrorMessages.ADDRESS_NOT_FOUND.getMessage());
        logger.error("Exception {} thrown", AddressNotFoundException.class);
    }
}
