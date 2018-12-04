package guru.leco.timesheet.commons;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class StringToUUID {

    @NotBlank
    public static UUID convert(String id) {
        return UUID.fromString(id);
    }
}
