package by.cherkas.diplom.user.controllers;

import by.cherkas.diplom.user.User;
import by.cherkas.diplom.user.services.GetOneUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class GetOneUserController {

    private final GetOneUserService getUserService;

    public GetOneUserController(GetOneUserService getUserService) {
        this.getUserService = getUserService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id){
        return getUserService.getUserById(id);
    }
}
