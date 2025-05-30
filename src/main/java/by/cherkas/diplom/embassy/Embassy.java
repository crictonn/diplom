package by.cherkas.diplom.embassy;

import by.cherkas.diplom.address.Address;
import by.cherkas.diplom.application.Application;
import by.cherkas.diplom.company.Company;
import by.cherkas.diplom.embassy.countries.Countries;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Embassies")
@Getter
@Setter
@RequiredArgsConstructor
public class Embassy {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated
    private Countries country;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(mappedBy = "embassies")
    private List<Company> companies;

    @JsonIgnore
    @OneToMany(mappedBy = "embassy")
    private List<Application> applications;
}
