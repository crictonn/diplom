package by.cherkas.diplom.requisiton;

import by.cherkas.diplom.company.Company;
import by.cherkas.diplom.requisiton.status.Statuses;
import by.cherkas.diplom.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "requisitions")
@Getter
@Setter
@RequiredArgsConstructor
public class Requisition {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated
    private Statuses status;

    @Column(name = "acceptance_time")
    private Date acceptanceDate;

    @ManyToOne
    private User customer;

    @ManyToOne
    private Company company;
}
