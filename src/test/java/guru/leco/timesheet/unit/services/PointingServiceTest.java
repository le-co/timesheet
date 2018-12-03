package guru.leco.timesheet.unit.services;

import guru.leco.timesheet.domain.Pointing;
import guru.leco.timesheet.domain.User;
import guru.leco.timesheet.repositories.PointingRepository;
import guru.leco.timesheet.services.contracts.PointingService;
import guru.leco.timesheet.services.jpa.PointingServiceJpaImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class PointingServiceTest {

    @Mock
    private PointingRepository pointingRepository;

    private PointingService pointingService;

    private Pointing pointing;

    @Before
    public void setUp() throws Exception {

        this.pointing = new Pointing();
        this.pointing.setId(UUID.randomUUID());
        this.pointing.setDate(LocalDate.now());

        this.pointingService = new PointingServiceJpaImp(this.pointingRepository);
    }

    @Test
    public void createUser() {
        this.pointingService.saveOrUpdate(this.pointing);

        Mockito.verify(this.pointingRepository, Mockito.times(1)).save(this.pointing);
    }

    @Test
    public void findById() {
        when(this.pointingRepository.findById(this.pointing.getId())).thenReturn(java.util.Optional.ofNullable(this.pointing));

        Pointing pointing = this.pointingService.findById(this.pointing.getId());

        assertEquals(this.pointing.getDate(), pointing.getDate());
    }

    @Test
    public void findAll() {
        when(this.pointingRepository.findAll()).thenReturn(Arrays.asList(this.pointing));

        List<Pointing> pointing = this.pointingService.findAll();

        assertEquals(1, pointing.size());
    }

    @Test
    public void deleteById() {
        this.pointingService.deleteById(this.pointing.getId());

        Mockito.verify(this.pointingRepository, times(1)).deleteById(this.pointing.getId());
    }

    @Test
    public void deleteUser() {
        this.pointingService.delete(this.pointing);
        Mockito.verify(this.pointingRepository, times(1)).delete(this.pointing);
    }

}