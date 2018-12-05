package guru.leco.timesheet.unit.services;

import guru.leco.timesheet.domain.Times;
import guru.leco.timesheet.repositories.TimeRepository;
import guru.leco.timesheet.services.contracts.TimeService;
import guru.leco.timesheet.services.jpa.TimeServiceJpaImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TimeServiceTest {

    @Mock
    private TimeRepository timeRepository;

    private TimeService timeService;

    private Times time;

    @Before
    public void setUp() throws Exception {

        this.time = new Times();
        this.time.setId(UUID.randomUUID());
        this.time.setStart(LocalTime.now());
        this.time.setFinish(LocalTime.now());

        this.timeService = new TimeServiceJpaImp(this.timeRepository);
    }

    @Test
    public void createUser() {
        this.timeService.saveOrUpdate(this.time);

        Mockito.verify(this.timeRepository, Mockito.times(1)).save(this.time);
    }

    @Test
    public void findById() {
        when(this.timeRepository.findById(this.time.getId())).thenReturn(java.util.Optional.ofNullable(this.time));

        Times time = this.timeService.findById(this.time.getId());

        assertEquals(this.time.getStart(), time.getStart());
    }

    @Test
    public void findAll() {
        when(this.timeRepository.findAll()).thenReturn(Arrays.asList(this.time));

        List<Times> pointing = this.timeService.findAll();

        assertEquals(1, pointing.size());
    }

    @Test
    public void deleteById() {
        this.timeService.deleteById(this.time.getId());

        Mockito.verify(this.timeRepository, times(1)).deleteById(this.time.getId());
    }

    @Test
    public void deleteUser() {
        this.timeService.delete(this.time);

        Mockito.verify(this.timeRepository, times(1)).delete(this.time);
    }

}