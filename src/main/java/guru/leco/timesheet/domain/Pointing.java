package guru.leco.timesheet.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Pointing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(mappedBy = "day")
    private HashSet<Time> times;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
