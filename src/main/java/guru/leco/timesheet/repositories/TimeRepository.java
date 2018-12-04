package guru.leco.timesheet.repositories;

import guru.leco.timesheet.domain.Time;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TimeRepository extends CrudRepository<Time, UUID> {
}
