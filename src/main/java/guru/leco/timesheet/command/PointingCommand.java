package guru.leco.timesheet.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.UUID;

@Getter
@Builder
public class PointingCommand {

    private String id;

    private HashSet<TimeCommand> times;

    private LocalDate date;
}
