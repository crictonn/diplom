package by.cherkas.diplom.user.services;

import by.cherkas.diplom.exceptions.types.UserNotFoundException;
import by.cherkas.diplom.user.User;
import by.cherkas.diplom.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetOneUserService {
    private final UserRepository userRepository;

    public GetOneUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> getUserById(UUID id){

        Optional<User> user = userRepository.findById(id);

        if(user.isPresent())
            return ResponseEntity.ok(user.get());

        throw new UserNotFoundException();
    }
}
