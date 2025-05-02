package by.cherkas.diplom.validators;

import by.cherkas.diplom.company.Company;
import by.cherkas.diplom.exceptions.types.company.CompanyNotValidException;
import io.micrometer.common.util.StringUtils;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CompanyValidator {
    public static void execute(Company company){
        if(StringUtils.isEmpty(company.getName()))
            throw new CompanyNotValidException("Company must have a name");
    }
}
