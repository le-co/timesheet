package guru.leco.timesheet.converters;

import guru.leco.timesheet.command.ProfessionalsCommand;
import guru.leco.timesheet.commons.StringToUUID;
import guru.leco.timesheet.domain.Professionals;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProfessionalsCommandToDomain implements Converter<ProfessionalsCommand, Professionals> {

    private PointingCommandToDomain pointingCommandToDomain;

    public ProfessionalsCommandToDomain(PointingCommandToDomain pointingCommandToDomain) {
        this.pointingCommandToDomain = pointingCommandToDomain;
    }

    @Nullable
    @Override
    public Professionals convert(ProfessionalsCommand source) {
        Professionals user = new Professionals();

        if (source.getId() != null) {
            user.setId(StringToUUID.convert(source.getId()));
        }

        user.setMail(source.getMail());
        user.setCode(source.getCode());
        user.setPassword(source.getPassword());
        user.setUsername(source.getUsername());
        if (source.getPointing() != null && !source.getPointing().isEmpty()) {
            user.setPointing(source.getPointing().stream().map(p -> this.pointingCommandToDomain.convert(p)).collect(Collectors.toList()));
        }
        return user;
    }
}
