package guru.leco.timesheet.integration.controllers;

import guru.leco.timesheet.services.contracts.PointingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class PointingControllerTest {

    @Mock
    private PointingService pointingService;

    @InjectMocks
    private PointingController pointingController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(pointingController).build();
    }

    @Test
    public void findById() throws Exception {

//        when(this.pointingService.findAll()).thenReturn(Arrays.asList(new Pointing()));

//        mockMvc.perform(get("/user/pointing"))
    }
}