package by.cherkas.diplom.customer.controllers;

import by.cherkas.diplom.customer.Customer;
import by.cherkas.diplom.customer.services.GetCustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("customer")
public class GetCustomerController {

    private final GetCustomerService getCustomerService;

    public GetCustomerController(GetCustomerService getCustomerService) {
        this.getCustomerService = getCustomerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable UUID id){
        return getCustomerService.getCustomerById(id);
    }
}
