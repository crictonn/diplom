package by.cherkas.diplom.application;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@RequiredArgsConstructor
@Getter
@Setter
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String link;
    private String type;
    private String size;
    private Date uploadedAt;

    @JsonBackReference
    @ManyToOne
    private Application application;
}
