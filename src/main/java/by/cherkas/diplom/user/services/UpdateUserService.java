package by.cherkas.diplom.user.services;

import by.cherkas.diplom.exceptions.types.user.UserNotFoundException;
import by.cherkas.diplom.user.User;
import by.cherkas.diplom.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateUserService {

    private final UserRepository userRepository;

    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> updateUser(UUID id, User user){
        Optional<User> optionalUser = userRepository.findById(id);


        //TODO check how user is updated
        if(optionalUser.isEmpty())
            throw new UserNotFoundException();
        user.setId(id);
        return ResponseEntity.ok(userRepository.save(user));
    }
}
