package by.cherkas.diplom.exceptions.types.requisition;

import by.cherkas.diplom.exceptions.ErrorMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequisitionNotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(RequisitionNotFoundException.class);

    public RequisitionNotFoundException() {
        super(ErrorMessages.REQUISITION_NOT_FOUND.getMessage());
        logger.error("Exception {} thrown", RequisitionNotFoundException.class);
    }
}
