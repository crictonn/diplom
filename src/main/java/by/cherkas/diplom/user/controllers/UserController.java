package by.cherkas.diplom.user.controllers;

import by.cherkas.diplom.customer.UserCustomerDTO;
import by.cherkas.diplom.user.User;
import by.cherkas.diplom.user.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final SaveUserService saveUserService;
    private final GetOneUserService getOneUserService;
    private final GetAllUsersService getAllUsersService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;

    public UserController(
            SaveUserService saveUserService,
            GetOneUserService getOneUserService,
            GetAllUsersService getAllUsersService,
            UpdateUserService updateUserService,
            DeleteUserService deleteUserService) {

        this.saveUserService = saveUserService;
        this.getOneUserService = getOneUserService;
        this.getAllUsersService = getAllUsersService;
        this.updateUserService = updateUserService;
        this.deleteUserService = deleteUserService;
    }

    @PostMapping("/add")
    public ResponseEntity<UserCustomerDTO> saveUser(@RequestBody User user){
        return saveUserService.saveUser(user);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id){
        return getOneUserService.getUserById(id);
    }

    @GetMapping("/get")
    public ResponseEntity<User> getUserByUsername(@RequestParam String username){
        return getOneUserService.getUserByUsername(username);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return getAllUsersService.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User user){
        return updateUserService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id){
        return deleteUserService.deleteUserById(id);
    }
}
