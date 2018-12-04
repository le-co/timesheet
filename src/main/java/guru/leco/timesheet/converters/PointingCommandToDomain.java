package guru.leco.timesheet.converters;

import guru.leco.timesheet.command.PointingCommand;
import guru.leco.timesheet.commons.StringToUUID;
import guru.leco.timesheet.domain.Pointing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PointingCommandToDomain implements Converter<PointingCommand, Pointing> {

    private TimeCommandToDomain timeCommandToDomain;

    @Autowired
    public PointingCommandToDomain(TimeCommandToDomain timeCommandToDomain) {
        this.timeCommandToDomain = timeCommandToDomain;
    }

    @Nullable
    @Override
    public Pointing convert(PointingCommand source) {
        Pointing pointing = new Pointing();

        if (source.getId() != null) {
            pointing.setId(StringToUUID.convert(source.getId()));
        }

        if (source.getTimes() != null && !source.getTimes().isEmpty()) {
            pointing.setTimes(source.getTimes().stream().map(p -> this.timeCommandToDomain.convert(p)).collect(Collectors.toSet()));
        }

        pointing.setDate(source.getDate());

        return pointing;
    }
}
