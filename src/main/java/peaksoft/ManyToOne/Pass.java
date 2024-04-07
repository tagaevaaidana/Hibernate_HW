package peaksoft.ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "pass")
@Getter
@Setter
@NoArgsConstructor
public class Pass {
    @Id
    Long id;
    int number;
    LocalDate date;
    boolean itsTrue;
}
