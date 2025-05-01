package by.cherkas.diplom.address;

import by.cherkas.diplom.department.Department;
import by.cherkas.diplom.customer.Customer;
import by.cherkas.diplom.embassy.Embassy;
import by.cherkas.diplom.passport.Passport;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@RequiredArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fullAddress;
    private String city;
    private String streetName;
    private String houseNumber;
    private String postIndex;

    //TODO add coordinates for map integration

    @OneToMany(mappedBy = "address")
    private List<Customer> customers;

    @OneToMany(mappedBy = "issued_address")
    private List<Passport> passports;

    @OneToMany(mappedBy = "address")
    private List<Department> departments;

    @OneToOne(mappedBy = "address")
    private Embassy embassy;
}
