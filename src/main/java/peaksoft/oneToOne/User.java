package peaksoft.oneToOne;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String lastName;
    int age;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "car_id")
    Car car;
}
