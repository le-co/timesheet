package guru.leco.timesheet.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Times {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pointing_id")
    private Pointing pointing;

    private LocalTime start;

    private LocalTime finish;
}
