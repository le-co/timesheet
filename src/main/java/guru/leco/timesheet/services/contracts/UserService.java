package guru.leco.timesheet.services.contracts;

import guru.leco.timesheet.domain.Professionals;

import java.util.UUID;

public interface UserService extends CrudService<Professionals, UUID> {

    Professionals authentication(String username, String password);
}
