package by.cherkas.diplom.user.controllers;

import by.cherkas.diplom.user.User;
import by.cherkas.diplom.user.services.GetAllUsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class GetAllUsersController {

    private final GetAllUsersService getAllUsersService;

    public GetAllUsersController(GetAllUsersService getAllUsersService) {
        this.getAllUsersService = getAllUsersService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return getAllUsersService.getAllUsers();
    }
}
