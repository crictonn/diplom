package by.cherkas.diplom.user.controllers;

import by.cherkas.diplom.customer.UserCustomerDTO;
import by.cherkas.diplom.security.jwt.JwtUtils;
import by.cherkas.diplom.user.LoginRequest;
import by.cherkas.diplom.user.User;
import by.cherkas.diplom.user.UserRepository;
import by.cherkas.diplom.user.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    private final SaveUserService saveUserService;
    private final GetOneUserService getOneUserService;
    private final GetAllUsersService getAllUsersService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;
    private final LoginUserService loginUserService;

    public UserController(
            SaveUserService saveUserService,
            GetOneUserService getOneUserService,
            GetAllUsersService getAllUsersService,
            UpdateUserService updateUserService,
            DeleteUserService deleteUserService,
            LoginUserService loginUserService) {

        this.saveUserService = saveUserService;
        this.getOneUserService = getOneUserService;
        this.getAllUsersService = getAllUsersService;
        this.updateUserService = updateUserService;
        this.deleteUserService = deleteUserService;
        this.loginUserService = loginUserService;
    }

    @PostMapping("/add")
    public ResponseEntity<UserCustomerDTO> saveUser(@RequestBody User user){
        return saveUserService.saveUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<UserCustomerDTO> loginUser(@RequestBody LoginRequest request){
        return loginUserService.loginUser(request);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id){
        return getOneUserService.getUserById(id);
    }

    @GetMapping("/get")
    public ResponseEntity<User> getUserByUsernameOrEmail(@RequestParam String input){
        return getOneUserService.getUserByUsernameOrEmail(input);
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
