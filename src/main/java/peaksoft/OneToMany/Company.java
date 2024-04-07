package peaksoft.OneToMany;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String location;
    String ownerNameCompany;

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE},mappedBy = "company")
    List <Employee> employee;

}
