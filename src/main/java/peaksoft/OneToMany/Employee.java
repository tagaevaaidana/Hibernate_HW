package peaksoft.OneToMany;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    Long id;
    String nameEmployee;
    String lastNameEmployee;
    LocalDate age;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "company")
    Company company;
}
