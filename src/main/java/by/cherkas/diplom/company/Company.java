package by.cherkas.diplom.company;

import by.cherkas.diplom.address.Address;
import by.cherkas.diplom.requisiton.Requisition;
import by.cherkas.diplom.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "companies")
@Getter
@Setter
@RequiredArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany
    @JoinColumn(name = "employee_id")
    private List<User> employees;

    @OneToMany
    @JoinColumn(name = "company_id")
    private List<Requisition> requisitions;

    @ManyToMany
    private List<User> customers;
}
