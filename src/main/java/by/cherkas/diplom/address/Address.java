package by.cherkas.diplom.address;

import by.cherkas.diplom.company.Company;
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

    private String streetName;
    private int houseNumber;
    private String postIndex;

    @OneToMany(mappedBy = "address")
    private List<Customer> customers;

    @OneToMany(mappedBy = "issued_address")
    private List<Passport> passports;

    @OneToMany(mappedBy = "address")
    private List<Company> companies;

    @OneToOne(mappedBy = "address")
    private Embassy embassy;
}
