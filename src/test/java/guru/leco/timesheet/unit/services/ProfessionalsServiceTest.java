package guru.leco.timesheet.unit.services;


import guru.leco.timesheet.domain.Professionals;
import guru.leco.timesheet.repositories.ProfessionalsRepository;
import guru.leco.timesheet.services.contracts.ProfessionalsService;
import guru.leco.timesheet.services.jpa.ProfessionalsServiceJpaImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProfessionalsServiceTest {

    @Mock
    private ProfessionalsRepository userRepository;

    private ProfessionalsService professionalsService;

    private Professionals user;

    @Before
    public void init() {
        this.user = new Professionals();
        this.user.setId(UUID.randomUUID());
        user.setCode("0101");
        user.setMail("test@gmail.com");
        this.professionalsService = new ProfessionalsServiceJpaImp(userRepository);
    }

    @Test
    public void createUser() {
        this.professionalsService.saveOrUpdate(this.user);

        Mockito.verify(this.userRepository, Mockito.times(1)).save(this.user);
    }

    @Test
    public void findById() {
        when(this.userRepository.findById(this.user.getId())).thenReturn(java.util.Optional.ofNullable(this.user));

        Professionals user = this.professionalsService.findById(this.user.getId());

        assertEquals(this.user.getMail(), user.getMail());
    }

    @Test
    public void findAll() {
        when(this.userRepository.findAll()).thenReturn(Arrays.asList(this.user));

        List<Professionals> users = this.professionalsService.findAll();

        assertEquals(1, users.size());
    }

    @Test
    public void deleteById() {
        this.professionalsService.deleteById(this.user.getId());

        Mockito.verify(this.userRepository, times(1)).deleteById(this.user.getId());
    }

    @Test
    public void deleteUser(){
        this.professionalsService.delete(this.user);
        Mockito.verify(this.userRepository, times(1)).delete(this.user);
    }
}
