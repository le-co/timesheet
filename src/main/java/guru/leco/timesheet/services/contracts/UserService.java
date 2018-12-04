package guru.leco.timesheet.services.contracts;

import guru.leco.timesheet.domain.User;

import java.util.UUID;

public interface UserService extends CrudService<User, UUID> {

    User authentication(String username, String password);
}
