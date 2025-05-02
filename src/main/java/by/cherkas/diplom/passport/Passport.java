package by.cherkas.diplom.passport;

import by.cherkas.diplom.address.Address;
import by.cherkas.diplom.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "passports")
@Getter
@Setter
@RequiredArgsConstructor
public class Passport {

    @Id
    @Column(nullable = false)
    private String identifier;

    private String firstName;
    private String lastName;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "date of issue")
    private Date issueDate;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "issued_address")
    private Address issuedAddress;

    @OneToOne(mappedBy = "passport")
    private User user;

}
