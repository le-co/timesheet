package guru.leco.timesheet.unit.services;


import guru.leco.timesheet.domain.User;
import guru.leco.timesheet.repositories.UserRepository;
import guru.leco.timesheet.services.contracts.UserService;
import guru.leco.timesheet.services.jpa.UserServiceJpaImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    private User user;

    @Before
    public void init() {
        this.user = new User();
        this.user.setId(UUID.randomUUID());
        user.setCode("0101");
        user.setMail("test@gmail.com");
        this.userService = new UserServiceJpaImp(userRepository);
    }

    @Test
    public void createUser() {
        this.userService.saveOrUpdate(this.user);

        Mockito.verify(this.userRepository, Mockito.times(1)).save(this.user);
    }

    @Test
    public void findById() {
        when(this.userRepository.findById(this.user.getId())).thenReturn(java.util.Optional.ofNullable(this.user));

        User user = this.userService.findById(this.user.getId());

        assertEquals(this.user.getMail(), user.getMail());
    }

    @Test
    public void findAll() {
        when(this.userRepository.findAll()).thenReturn(Arrays.asList(this.user));

        List<User> users = this.userService.findAll();

        assertEquals(1, users.size());
    }

    @Test
    public void deleteById() {
        this.userService.deleteById(this.user.getId());

        Mockito.verify(this.userRepository, times(1)).deleteById(this.user.getId());
    }
}
