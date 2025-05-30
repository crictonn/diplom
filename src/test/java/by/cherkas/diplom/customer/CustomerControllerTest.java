package by.cherkas.diplom.customer;

import by.cherkas.diplom.customer.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private GetCustomerService getCustomerService;

    @Mock
    private SaveCustomerService saveCustomerService;

    @Mock
    private GetAllCustomersService getAllCustomersService;

    @Mock
    private UpdateCustomerService updateCustomerService;

    @Mock
    private DeleteCustomerService deleteCustomerService;

    @InjectMocks
    private CustomerController customerController;

    private UUID testId;
    private Customer testCustomer;

    @BeforeEach
    void setUp() {
        testId = UUID.randomUUID();
        testCustomer = new Customer();
        testCustomer.setId(testId);
        testCustomer.setFirstName("Test Customer");
    }

    @Test
    void saveCustomerWithUserID_ShouldReturnCustomer() {
        when(saveCustomerService.createCustomer(testId))
                .thenReturn(ResponseEntity.ok(testCustomer));

        ResponseEntity<Customer> response = customerController.saveCustomerWithUserID(testId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testCustomer, response.getBody());
        verify(saveCustomerService, times(1)).createCustomer(testId);
    }

    @Test
    void getCustomerById_ShouldReturnCustomer() {
        when(getCustomerService.getCustomerById(testId))
                .thenReturn(ResponseEntity.ok(testCustomer));

        ResponseEntity<Customer> response = customerController.getCustomerById(testId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testCustomer, response.getBody());
        verify(getCustomerService, times(1)).getCustomerById(testId);
    }

    @Test
    void getAllCustomers_ShouldReturnAllCustomers() {
        List<Customer> customers = Arrays.asList(testCustomer, new Customer());
        when(getAllCustomersService.getAllCustomers())
                .thenReturn(ResponseEntity.ok(customers));

        ResponseEntity<List<Customer>> response = customerController.getAllCustomers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(getAllCustomersService, times(1)).getAllCustomers();
    }

    @Test
    void updateCustomer_ShouldReturnUpdatedCustomer() {
        when(updateCustomerService.updateCustomer(testId, testCustomer))
                .thenReturn(ResponseEntity.ok(testCustomer));

        ResponseEntity<Customer> response = customerController.updateCustomer(testId, testCustomer);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testCustomer, response.getBody());
        verify(updateCustomerService, times(1)).updateCustomer(testId, testCustomer);
    }

    @Test
    void deleteCustomer_ShouldReturnNoContent() {
        when(deleteCustomerService.deleteCustomerById(testId))
                .thenReturn(ResponseEntity.noContent().build());

        ResponseEntity<Void> response = customerController.deleteCustomer(testId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(deleteCustomerService, times(1)).deleteCustomerById(testId);
    }
}