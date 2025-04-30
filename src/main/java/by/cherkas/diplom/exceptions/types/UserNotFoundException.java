package by.cherkas.diplom.exceptions.types;

import by.cherkas.diplom.exceptions.ErrorMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    private static final Logger logger = LoggerFactory.getLogger(UserNotFoundException.class);

    public UserNotFoundException(){
        super(ErrorMessages.USER_NOT_FOUND.getMessage());
        logger.error("Exception " + getClass() + " thrown");
    }
}
