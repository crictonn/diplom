package by.cherkas.diplom.exceptions.types.embassy;

import by.cherkas.diplom.exceptions.ErrorMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmbassyNotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(EmbassyNotFoundException.class);

    public EmbassyNotFoundException(){
        super(ErrorMessages.EMBASSY_NOT_FOUND.getMessage());
        logger.error("Exception {} thrown", EmbassyNotFoundException.class);
    }
}
