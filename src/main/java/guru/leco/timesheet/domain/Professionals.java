package guru.leco.timesheet.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Professionals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String mail;

    private String code;

    private String password;

    private String username;

    @OneToMany(mappedBy = "professionals")
    private List<Pointing> pointing;
}
