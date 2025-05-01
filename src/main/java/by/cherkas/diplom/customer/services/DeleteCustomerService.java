package by.cherkas.diplom.customer.services;

import by.cherkas.diplom.customer.CustomerRepository;
import by.cherkas.diplom.exceptions.types.customer.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCustomerService {

    private final CustomerRepository customerRepository;

    public DeleteCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<Void> deleteCustomerById(UUID id){

        if(customerRepository.findById(id).isEmpty())
            throw new CustomerNotFoundException();

        customerRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
