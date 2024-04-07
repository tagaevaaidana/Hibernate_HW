package peaksoft.ManyToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    Long id;
    String nameEmployee;
    String lastNameEmployee;
    LocalDate age;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "pass")
   Pass pass;
}
