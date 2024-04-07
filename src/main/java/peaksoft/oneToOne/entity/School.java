package peaksoft.oneToOne.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "school")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class School {
    @Id
    long id;
    String name;
    String Location;
@OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH}, mappedBy = "school")
    Director director;
}
