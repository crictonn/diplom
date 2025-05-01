package by.cherkas.diplom.customer.services;

import by.cherkas.diplom.customer.Customer;
import by.cherkas.diplom.customer.CustomerRepository;
import by.cherkas.diplom.exceptions.types.UserNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCustomerService {

    private final CustomerRepository customerRepository;

    public UpdateCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<Customer> updateCustomer(UUID id, Customer customer){

        if(!id.equals(customer.getUser().getId()))
            throw new UserNotValidException("Customer id and user do not match");

        return ResponseEntity.ok(customerRepository.save(customer));
    }
}
