package guru.leco.timesheet.command;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProfessionalsCommand {

    private String id;

    private String mail;

    private String code;

    private String password;

    private String username;

    private List<PointingCommand> pointing;
}
