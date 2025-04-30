package by.cherkas.diplom.user.services;

import by.cherkas.diplom.customer.Customer;
import by.cherkas.diplom.customer.CustomerRepository;
import by.cherkas.diplom.exceptions.types.CustomerNotFoundException;
import by.cherkas.diplom.exceptions.types.UserNotFoundException;
import by.cherkas.diplom.user.User;
import by.cherkas.diplom.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeleteUserService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    public DeleteUserService(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public ResponseEntity<Void> deleteUserById(UUID id){

        Optional<User> user = userRepository.findById(id);
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isEmpty())
            throw new CustomerNotFoundException();
        customerRepository.delete(customer.get());

        if(user.isEmpty())
            throw new UserNotFoundException();
        userRepository.delete(user.get());
        return ResponseEntity.ok().build();
    }
}
