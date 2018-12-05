package guru.leco.timesheet.services.jpa;

import guru.leco.timesheet.domain.Professionals;
import guru.leco.timesheet.repositories.UserRepository;
import guru.leco.timesheet.services.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Profile("jpa")
public class UserServiceJpaImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceJpaImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Professionals saveOrUpdate(Professionals object) {
        return this.userRepository.save(object);
    }

    @Override
    public Professionals findById(UUID uuid) {
        return this.userRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<Professionals> findAll() {
        return (List<Professionals>) this.userRepository.findAll();
    }

    @Override
    public void delete(Professionals object) {
        this.userRepository.delete(object);
    }

    @Override
    public void deleteById(UUID uuid) {
        this.userRepository.deleteById(uuid);
    }

    @Override
    public Professionals authentication(String username, String password) {
        return null;
    }
}
