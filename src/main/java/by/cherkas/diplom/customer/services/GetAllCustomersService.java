package by.cherkas.diplom.customer.services;

import by.cherkas.diplom.customer.Customer;
import by.cherkas.diplom.customer.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCustomersService {

    private final CustomerRepository customerRepository;

    public GetAllCustomersService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerRepository.findAll());
    }
}
