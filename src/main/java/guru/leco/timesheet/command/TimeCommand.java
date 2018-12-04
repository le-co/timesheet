package guru.leco.timesheet.command;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@Builder
public class TimeCommand {

    private String id;

    private LocalTime start;

    private LocalTime end;
}
