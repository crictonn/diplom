package by.cherkas.diplom.user;

import by.cherkas.diplom.company.Company;
import by.cherkas.diplom.passport.Passport;
import by.cherkas.diplom.requisiton.Requisition;
import by.cherkas.diplom.user.role.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated
    private Roles role;

    @OneToMany(mappedBy = "customer")
    private List<Requisition> requisitions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_identifier", referencedColumnName = "identifier")
    private Passport passport;

    @ManyToMany(mappedBy = "customers")
    private List<Company> companies;

}
