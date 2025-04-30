package by.cherkas.diplom.customer;

import by.cherkas.diplom.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class UserCustomerDTO {
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;

    public UserCustomerDTO(User user, Customer customer) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
    }
}
