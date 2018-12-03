package guru.leco.timesheet.repositories;

import guru.leco.timesheet.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
