package by.cherkas.diplom.company;

import by.cherkas.diplom.department.Department;
import by.cherkas.diplom.embassy.Embassy;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "company")
    @JsonManagedReference
    private List<Department> departments;

    @ManyToMany
    @JoinTable(
            name = "visa_support",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "embassy_id")
    )
    private List<Embassy> embassies;
}
