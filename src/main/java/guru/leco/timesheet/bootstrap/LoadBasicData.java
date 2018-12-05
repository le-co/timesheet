package guru.leco.timesheet.bootstrap;

import com.google.common.collect.Sets;
import guru.leco.timesheet.domain.Pointing;
import guru.leco.timesheet.domain.Professionals;
import guru.leco.timesheet.domain.Times;
import guru.leco.timesheet.services.contracts.ProfessionalsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@Slf4j
@Component
public class LoadBasicData implements CommandLineRunner {

    private ProfessionalsService professionalsService;

    @Autowired
    public LoadBasicData(ProfessionalsService professionalsService) {
        this.professionalsService = professionalsService;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("Starting bootstrap");

        Professionals leco = new Professionals();
        leco.setCode("010101");
        leco.setMail("test@test.com");
        leco.setPassword("abc1234");
        leco.setUsername("leco");

        Pointing pointing = new Pointing();
        pointing.setDate(LocalDate.now());
        pointing.setProfessionals(leco);

        Times day = new Times();
        day.setStart(LocalTime.of(8, 00, 00));
        day.setFinish(LocalTime.of(12, 00, 00));
        day.setPointing(pointing);

        Times evening = new Times();
        evening.setStart(LocalTime.of(13, 00, 00));
        evening.setFinish(LocalTime.of(18, 00, 00));
        evening.setPointing(pointing);

        pointing.setTimes(Sets.newHashSet(day, evening));

        leco.setPointing(Arrays.asList(pointing));

        this.professionalsService.saveOrUpdate(leco);

        log.info("Finish bootstrap load");
    }
}
