package guru.leco.timesheet.services.jpa;

import guru.leco.timesheet.domain.User;
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
    public User saveOrUpdate(User object) {
        return this.userRepository.save(object);
    }

    @Override
    public User findById(UUID uuid) {
        return this.userRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) this.userRepository.findAll();
    }

    @Override
    public void delete(User object) {
        this.userRepository.delete(object);
    }

    @Override
    public void deleteById(UUID uuid) {
        this.userRepository.deleteById(uuid);
    }

    @Override
    public User authentication(String username, String password) {
        return null;
    }
}
