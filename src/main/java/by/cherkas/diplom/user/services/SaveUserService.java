package by.cherkas.diplom.user.services;

import by.cherkas.diplom.customer.Customer;
import by.cherkas.diplom.customer.CustomerRepository;
import by.cherkas.diplom.customer.UserCustomerDTO;
import by.cherkas.diplom.customer.services.SaveCustomerService;
import by.cherkas.diplom.user.User;
import by.cherkas.diplom.user.UserRepository;
import by.cherkas.diplom.user.role.Roles;
import by.cherkas.diplom.validators.UserValidator;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SaveUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;

    public SaveUserService(UserRepository userRepository, PasswordEncoder passwordEncoder, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public ResponseEntity<UserCustomerDTO> saveUser(User user){
        UserValidator.execute(user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Roles.USER);

        user = userRepository.save(user);

        //TODO decide how to save BOTH customer and user simultaneously (either by creating a new object with all the fields or
        //by sending two objects from frontend)

        Customer customer = new Customer(user);
        customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserCustomerDTO(user));
    }
}
