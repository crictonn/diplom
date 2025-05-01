package by.cherkas.diplom.customer.services;

import by.cherkas.diplom.customer.Customer;
import by.cherkas.diplom.customer.CustomerRepository;
import by.cherkas.diplom.exceptions.types.user.UserNotFoundException;
import by.cherkas.diplom.user.User;
import by.cherkas.diplom.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SaveCustomerService {
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    public SaveCustomerService(
            CustomerRepository customerRepository,
            UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Customer> createCustomer(UUID userId){

        Optional<User> user = userRepository.findById(userId);

        if(user.isEmpty())
            throw new UserNotFoundException();

        return ResponseEntity.ok(customerRepository.save(new Customer(user.get())));
    }
}
