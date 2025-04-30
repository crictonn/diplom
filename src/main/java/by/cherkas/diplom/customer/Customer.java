package by.cherkas.diplom.customer;

import by.cherkas.diplom.address.Address;
import by.cherkas.diplom.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "customers")
@Getter
@Setter
@RequiredArgsConstructor
public class Customer {
    @Id
    private UUID id;

    @Column
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;


    public Customer(User user) {
        this.user = user;
    }
}
