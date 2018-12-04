package guru.leco.timesheet.converters;

import guru.leco.timesheet.command.TimeCommand;
import guru.leco.timesheet.commons.StringToUUID;
import guru.leco.timesheet.domain.Time;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TimeCommandToDomain implements Converter<TimeCommand, Time> {

    @Nullable
    @Override
    public Time convert(TimeCommand source) {
        Time time = new Time();

        if(source.getId() != null){
            time.setId(StringToUUID.convert(source.getId()));
        }

        time.setStart(source.getStart());
        time.setEnd(source.getEnd());
        return time;
    }
}
