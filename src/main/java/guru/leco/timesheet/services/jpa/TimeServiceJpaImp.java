package guru.leco.timesheet.services.jpa;

import guru.leco.timesheet.domain.Time;
import guru.leco.timesheet.domain.User;
import guru.leco.timesheet.repositories.TimeRepository;
import guru.leco.timesheet.repositories.UserRepository;
import guru.leco.timesheet.services.contracts.TimeService;
import guru.leco.timesheet.services.contracts.UserService;
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
    public Time saveOrUpdate(Time object) {
        return this.timeRepository.save(object);
    }

    @Override
    public Time findById(UUID uuid) {
        return this.timeRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<Time> findAll() {
        return (List<Time>) this.timeRepository.findAll();
    }

    @Override
    public void delete(Time object) {
        this.timeRepository.delete(object);
    }

    @Override
    public void deleteById(UUID uuid) {
        this.timeRepository.deleteById(uuid);
    }
}
