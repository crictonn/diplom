package by.cherkas.diplom.customer;

import by.cherkas.diplom.customer.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final SaveCustomerService saveCustomerService;
    private final GetCustomerService getCustomerService;
    private final GetAllCustomersService getAllCustomersService;
    private final UpdateCustomerService updateCustomerService;
    private final DeleteCustomerService deleteCustomerService;

    public CustomerController(
            GetCustomerService getCustomerService,
            SaveCustomerService saveCustomerService,
            GetAllCustomersService getAllCustomersService,
            UpdateCustomerService updateCustomerService,
            DeleteCustomerService deleteCustomerService) {

        this.getCustomerService = getCustomerService;
        this.saveCustomerService = saveCustomerService;
        this.getAllCustomersService = getAllCustomersService;
        this.updateCustomerService = updateCustomerService;
        this.deleteCustomerService = deleteCustomerService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Customer> saveCustomerWithUserID(@PathVariable UUID id){
        return saveCustomerService.createCustomer(id);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable UUID id){
        return getCustomerService.getCustomerById(id);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return getAllCustomersService.getAllCustomers();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable UUID id, @RequestBody Customer customer){
        return updateCustomerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID id){
        return deleteCustomerService.deleteCustomerById(id);
    }
}
