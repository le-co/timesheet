package guru.leco.timesheet.controllers;

import guru.leco.timesheet.domain.Pointing;
import guru.leco.timesheet.domain.Professionals;
import guru.leco.timesheet.domain.Times;
import guru.leco.timesheet.services.contracts.ProfessionalsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.collections.Sets;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
public class ProfessionalsControllerTest {

    @Mock
    private ProfessionalsService professionalsService;

    @InjectMocks
    private ProfessionalsController professionalsController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(professionalsController).build();
    }

    @Test
    public void pointing() throws Exception {

        Professionals user = new Professionals();
        user.setUsername("test");
        user.setPassword("test-password");

        Times time1 = new Times();
        time1.setStart(LocalTime.now());
        time1.setFinish(LocalTime.now().plusHours(12));

        Times time2 = new Times();
        time2.setStart(LocalTime.now());
        time2.setFinish(LocalTime.now().plusHours(12));


        Pointing pointing = new Pointing();
        pointing.setDate(LocalDate.now());
        pointing.setTimes(Sets.newSet(time1, time2));

        user.setPointing(Arrays.asList(pointing));
        when(this.professionalsService.findById(Mockito.any(UUID.class))).thenReturn(user);

        mockMvc.perform(get("/user/" + UUID.randomUUID() +"/pointing"))
                .andExpect(status().isOk())
                .andExpect(view().name("/pointing/index"))
                .andExpect(model().attributeExists("pointing"));
    }

}
