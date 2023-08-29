package pl.kurs.finaltest.models;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import pl.kurs.finaltest.commands.CreateShapeCommand;
import pl.kurs.finaltest.dto.ShapeDto;
import pl.kurs.finaltest.dto.SquareDto;
import pl.kurs.finaltest.exceptionhandling.exceptions.BadEntityException;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;

@Component
public class SquareFactory implements IShapeFactory {

//    private final AuditorAware<String> auditorAware;
//
//    public SquareFactory(AuditorAware<String> auditorAware) {
//        this.auditorAware = auditorAware;
//    }

    @Override
    public Shape createShape(CreateShapeCommand command) {
//        Optional<String> userName = Optional.ofNullable(auditorAware.getCurrentAuditor()
//                .orElseThrow(() -> new BadEntityException("Wrong user")));
        if ("SQUARE".equalsIgnoreCase(command.getType())) {
            if (command.getParameters().size() == 1) {
                double width = command.getParameters().get(0);
                Square square = new Square();
                square.setType(command.getType().toUpperCase(Locale.ROOT));
                square.setLength(width);
                square.setArea(square.calculateArea());
                square.setPerimeter(square.calculatePerimeter());
                return square;
            }
            throw new IllegalArgumentException("Invalid parameters for this shape");
        }
        return null;
    }

    @Override
    public String getSupportedType() {
        return "SQUARE";
    }

//    @Override
//    public ShapeDto createShapeDto(Shape shape) {
//        return new SquareDto();
//    }

    @Override
    public Class<? extends ShapeDto> createShapeDto(Shape shape) {
        return SquareDto.class;
    }

}
