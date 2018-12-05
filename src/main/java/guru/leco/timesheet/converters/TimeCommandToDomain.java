package guru.leco.timesheet.converters;

import guru.leco.timesheet.command.TimeCommand;
import guru.leco.timesheet.commons.StringToUUID;
import guru.leco.timesheet.domain.Times;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TimeCommandToDomain implements Converter<TimeCommand, Times> {

    @Nullable
    @Override
    public Times convert(TimeCommand source) {
        Times time = new Times();

        if(source.getId() != null){
            time.setId(StringToUUID.convert(source.getId()));
        }

        time.setStart(source.getStart());
        time.setFinish(source.getEnd());
        return time;
    }
}
