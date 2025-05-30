package by.cherkas.diplom.user;

import by.cherkas.diplom.application.Application;
import by.cherkas.diplom.customer.Customer;
import by.cherkas.diplom.department.Department;
import by.cherkas.diplom.passport.Passport;
import by.cherkas.diplom.user.role.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Email
    @NotNull
    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated
    private Roles role;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Application> applications;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_identifier", referencedColumnName = "identifier")
    private Passport passport;

    @ManyToMany(mappedBy = "customers")
    private List<Department> departments;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User(UUID id){
        this.id = id;
    }
}
