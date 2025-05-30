package by.cherkas.diplom.application;

import by.cherkas.diplom.department.Department;
import by.cherkas.diplom.embassy.Embassy;
import by.cherkas.diplom.application.status.Statuses;
import by.cherkas.diplom.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "applications")
@Getter
@Setter
@RequiredArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated
    private Statuses status;

    private Date submittedAt;

    private String country;

    private String visaType;

    @OneToMany
    @JoinColumn(name = "application_id")
    private List<Document> documents;

//    @JsonIgnore
    @ManyToOne
    private User customer;

//    @JsonIgnore
    @ManyToOne
    private Embassy embassy;

//    @JsonIgnore
    @ManyToOne
    private Department department;
}
