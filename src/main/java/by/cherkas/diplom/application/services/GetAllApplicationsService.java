package by.cherkas.diplom.application.services;

import by.cherkas.diplom.application.Application;
import by.cherkas.diplom.application.ApplicationRepository;
import by.cherkas.diplom.security.jwt.JwtUtils;
import by.cherkas.diplom.user.User;
import by.cherkas.diplom.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetAllApplicationsService {
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    public GetAllApplicationsService(ApplicationRepository applicationRepository, UserRepository userRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<Application>> getAllRequisitions(){
        return ResponseEntity.ok(applicationRepository.findAll());
    }

    public ResponseEntity<List<Application>> getAllByUserID(String auth){
        String username = JwtUtils.getClaims(auth.substring(7)).getSubject();
        Optional<User> user = userRepository.getUserByUsername(username);
        List<Application> result = applicationRepository.getAllByCustomerId(user.get().getId());
        return ResponseEntity.ok(result);
    }
}
