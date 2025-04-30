package by.cherkas.diplom.validators;

import by.cherkas.diplom.exceptions.ErrorMessages;
import by.cherkas.diplom.exceptions.types.UserNotValidException;
import by.cherkas.diplom.user.User;
import io.micrometer.common.util.StringUtils;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserValidator {
    public static void execute(User user){
        if(StringUtils.isEmpty(user.getUsername()))
            throw new UserNotValidException(ErrorMessages.USERNAME_REQUIRED.getMessage());
        if(StringUtils.isEmpty(user.getEmail()))
            throw new UserNotValidException(ErrorMessages.EMAIL_REQUIRED.getMessage());
        if(StringUtils.isEmpty(user.getPassword()))
            throw new UserNotValidException(ErrorMessages.PASSWORD_REQUIRED.getMessage());
        if(!user.getEmail().contains("@"))
            throw new UserNotValidException(ErrorMessages.INVALID_EMAIL.getMessage());
        if(user.getPassword().length() < 8)
            throw new UserNotValidException(ErrorMessages.INVALID_PASSWORD.getMessage());
    }
}
