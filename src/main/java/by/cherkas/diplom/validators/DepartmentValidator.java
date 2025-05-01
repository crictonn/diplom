package by.cherkas.diplom.validators;

import by.cherkas.diplom.department.Department;
import by.cherkas.diplom.exceptions.types.department.DepartmentNotValidException;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DepartmentValidator {
    public static void execute(Department department){
        if(department.getCompany() == null)
            throw new DepartmentNotValidException("Department must be assigned to a company");
    }
}
