package by.cherkas.diplom.validators;

import by.cherkas.diplom.exceptions.ErrorMessages;
import by.cherkas.diplom.exceptions.types.passport.PassportNotValidException;
import by.cherkas.diplom.passport.Passport;
import io.micrometer.common.util.StringUtils;

public class PassportValidator {
    public static void execute(Passport passport){
        if(StringUtils.isEmpty(passport.getIdentifier()))
            throw new PassportNotValidException(ErrorMessages.ID_REQUIRED.getMessage());
        if(StringUtils.isEmpty(passport.getFirstName()))
            throw new PassportNotValidException(ErrorMessages.FIRST_NAME_REQUIRED.getMessage());
        if(StringUtils.isEmpty(passport.getLastName()))
            throw new PassportNotValidException(ErrorMessages.LAST_NAME_REQUIRED.getMessage());
        if(passport.getDateOfBirth() == null)
            throw new PassportNotValidException(ErrorMessages.DOB_REQUIRED.getMessage());
        if(passport.getExpirationDate() == null)
            throw new PassportNotValidException(ErrorMessages.EXP_DATE_REQUIRED.getMessage());
        if(passport.getIssuedAddress() == null)
            throw new PassportNotValidException(ErrorMessages.ISSUED_ADDRESS_REQUIRED.getMessage());

    }
}
