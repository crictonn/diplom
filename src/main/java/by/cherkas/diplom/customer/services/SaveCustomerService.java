package by.cherkas.diplom.customer.services;

import by.cherkas.diplom.customer.Customer;
import by.cherkas.diplom.customer.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SaveCustomerService {
    private final CustomerRepository repository;

    public SaveCustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

//    public ResponseEntity<Customer> saveCustomer(Customer customer){
//        return ResponseEntity.ok(repository.save(new Customer(customer.getId())));
//    }

    public void saveCustomerNoReturn(Customer customer){
        return;
    }

//    public ResponseEntity<Customer> saveCustomer(UUID id){
//        Customer customer = new Customer(id);
//        return ResponseEntity.ok(repository.save(customer));
//    }
}
