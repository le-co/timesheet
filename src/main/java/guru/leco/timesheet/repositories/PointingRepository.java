package guru.leco.timesheet.repositories;

import guru.leco.timesheet.domain.Pointing;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PointingRepository extends CrudRepository<Pointing, UUID> {
}
