package guru.leco.timesheet.repositories;

import guru.leco.timesheet.domain.Professionals;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<Professionals, UUID> {
}
