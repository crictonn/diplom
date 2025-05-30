package by.cherkas.diplom.user.services;

import by.cherkas.diplom.customer.UserCustomerDTO;
import by.cherkas.diplom.exceptions.types.user.UserNotFoundException;
import by.cherkas.diplom.exceptions.types.user.UserNotValidException;
import by.cherkas.diplom.user.LoginRequest;
import by.cherkas.diplom.user.User;
import by.cherkas.diplom.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserService {

    private final UserRepository userRepository;

    public LoginUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<UserCustomerDTO> loginUser(LoginRequest request){
        Optional<User> user;
        if(request==null)
            throw new UserNotValidException("Empty input exception");
        if(request.getIdentifier().contains("@"))
            user = userRepository.getUserByEmail(request.getIdentifier());
        else
            user = userRepository.getUserByUsername(request.getIdentifier());
        if(user.isEmpty())
            throw new UserNotFoundException();

        return ResponseEntity.ok(new UserCustomerDTO(user.get()));
    }
}
