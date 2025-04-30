package by.cherkas.diplom.user.controllers;

import by.cherkas.diplom.customer.UserCustomerDTO;
import by.cherkas.diplom.user.User;
import by.cherkas.diplom.user.services.SaveUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SaveUserController {

    private final SaveUserService saveUserService;

    public SaveUserController(SaveUserService saveUserService) {
        this.saveUserService = saveUserService;
    }

    @PostMapping("/add")
    public ResponseEntity<UserCustomerDTO> saveUser(@RequestBody User user){
        return saveUserService.saveUser(user);
    }
}
