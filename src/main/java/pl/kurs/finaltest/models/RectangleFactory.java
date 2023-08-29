package pl.kurs.finaltest.models;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import pl.kurs.finaltest.commands.CreateShapeCommand;
import pl.kurs.finaltest.dto.RectangleDto;
import pl.kurs.finaltest.dto.ShapeDto;
import pl.kurs.finaltest.exceptionhandling.exceptions.BadEntityException;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;

@Component
public class RectangleFactory implements IShapeFactory {

//    private final AuditorAware<String> auditorAware;
//
//    public RectangleFactory(AuditorAware<String> auditorAware) {
//        this.auditorAware = auditorAware;
//    }

    @Override
    public Shape createShape(CreateShapeCommand command) {
//        Optional<String> userName = Optional.ofNullable(auditorAware.getCurrentAuditor()
//                .orElseThrow(() -> new BadEntityException("Wrong user")));
        if ("RECTANGLE".equalsIgnoreCase(command.getType())) {
            if (command.getParameters().size() == 2) {
                double width = command.getParameters().get(0);
                double height = command.getParameters().get(1);
                Rectangle rectangle = new Rectangle();
                rectangle.setType(command.getType().toUpperCase(Locale.ROOT));
                rectangle.setWidth(width);
                rectangle.setHeight(height);
                rectangle.setArea(rectangle.calculateArea());
                rectangle.setPerimeter(rectangle.calculatePerimeter());
                return rectangle;
            }
            throw new IllegalArgumentException("Invalid parameters for this type of shape");
        }
        return null;
    }

    @Override
    public String getSupportedType() {
        return "RECTANGLE";
    }


    @Override
    public Class<? extends ShapeDto> createShapeDto(Shape shape) {
        return RectangleDto.class;
    }

}

