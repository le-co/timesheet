package guru.leco.timesheet.services.jpa;

import guru.leco.timesheet.domain.Times;
import guru.leco.timesheet.repositories.TimeRepository;
import guru.leco.timesheet.services.contracts.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Profile("jpa")
public class TimeServiceJpaImp implements TimeService {

    private TimeRepository timeRepository;

    @Autowired
    public TimeServiceJpaImp(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Override
    public Times saveOrUpdate(Times object) {
        return this.timeRepository.save(object);
    }

    @Override
    public Times findById(UUID uuid) {
        return this.timeRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<Times> findAll() {
        return (List<Times>) this.timeRepository.findAll();
    }

    @Override
    public void delete(Times object) {
        this.timeRepository.delete(object);
    }

    @Override
    public void deleteById(UUID uuid) {
        this.timeRepository.deleteById(uuid);
    }
}
