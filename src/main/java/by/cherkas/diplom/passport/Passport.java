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

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "date of issue")
    private Date issueDate;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "issued_address")
    private Address issued_address;

    @OneToOne(mappedBy = "passport")
    private User user;

}
