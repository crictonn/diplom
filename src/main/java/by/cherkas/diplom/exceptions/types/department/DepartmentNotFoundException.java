package by.cherkas.diplom.exceptions.types.department;

import by.cherkas.diplom.exceptions.ErrorMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentNotFoundException.class);

    public DepartmentNotFoundException() {
        super(ErrorMessages.DEPARTMENT_NOT_FOUND.getMessage());
        logger.error("Exception " + DepartmentNotFoundException.class + " thrown");
    }
}
