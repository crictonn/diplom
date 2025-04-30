package by.cherkas.diplom.user.controllers;

import by.cherkas.diplom.user.User;
import by.cherkas.diplom.user.services.UpdateUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UpdateUserController {

    private final UpdateUserService updateUserService;

    public UpdateUserController(UpdateUserService updateUserService) {
        this.updateUserService = updateUserService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User user){
        return updateUserService.updateUser(id, user);
    }
}
