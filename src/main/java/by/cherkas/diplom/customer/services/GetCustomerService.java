package by.cherkas.diplom.customer.services;

import by.cherkas.diplom.customer.Customer;
import by.cherkas.diplom.customer.CustomerRepository;
import by.cherkas.diplom.exceptions.types.customer.CustomerNotFoundException;
import by.cherkas.diplom.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetCustomerService {

    private final CustomerRepository customerRepository;

    public GetCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<Customer> getCustomerById(UUID id){
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent())
            return ResponseEntity.ok(customer.get());
        throw new CustomerNotFoundException();
    }

    public ResponseEntity<Customer> getCustomerByUser(User user){
        return getCustomerById(user.getId());
    }
}
