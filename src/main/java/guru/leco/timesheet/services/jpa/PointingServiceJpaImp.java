package guru.leco.timesheet.services.jpa;

import guru.leco.timesheet.domain.Pointing;
import guru.leco.timesheet.repositories.PointingRepository;
import guru.leco.timesheet.services.contracts.PointingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Profile("jpa")
public class PointingServiceJpaImp implements PointingService {


    private PointingRepository pointingRepository;

    @Autowired
    public PointingServiceJpaImp(PointingRepository pointingRepository) {
        this.pointingRepository = pointingRepository;
    }

    @Override
    public Pointing saveOrUpdate(Pointing object) {
        return this.pointingRepository.save(object);
    }

    @Override
    public Pointing findById(UUID uuid) {
        return this.pointingRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<Pointing> findAll() {
        return (List<Pointing>) this.pointingRepository.findAll();
    }

    @Override
    public void delete(Pointing object) {
        this.pointingRepository.delete(object);
    }

    @Override
    public void deleteById(UUID uuid) {
        this.pointingRepository.deleteById(uuid);
    }
}
