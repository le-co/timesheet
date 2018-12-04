package guru.leco.timesheet.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pointing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
    private Set<Time> times;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
