package by.cherkas.diplom.requisiton;

import by.cherkas.diplom.department.Department;
import by.cherkas.diplom.embassy.Embassy;
import by.cherkas.diplom.embassy.countries.Countries;
import by.cherkas.diplom.requisiton.status.Statuses;
import by.cherkas.diplom.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
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
    private Embassy embassy;

    @ManyToOne
    private Department department;
}
