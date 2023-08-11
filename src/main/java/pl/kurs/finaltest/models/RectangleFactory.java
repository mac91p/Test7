package pl.kurs.finaltest.models;

import org.springframework.stereotype.Component;
import pl.kurs.finaltest.commands.CreateShapeCommand;
import pl.kurs.finaltest.dto.RectangleDto;
import pl.kurs.finaltest.dto.ShapeDto;
import java.time.LocalDateTime;
import java.util.Locale;

@Component
public class RectangleFactory implements ShapeFactory {

    @Override
    public Shape createShape(CreateShapeCommand command, String username) {
        if ("RECTANGLE".equalsIgnoreCase(command.getType())) {
            if (command.getParameters().size() == 2) {
                double width = command.getParameters().get(0);
                double height = command.getParameters().get(1);
                Rectangle rectangle = new Rectangle();
                rectangle.setType(command.getType().toUpperCase(Locale.ROOT));
                rectangle.setLastModifiedBy(username);
                rectangle.setCreatedBy(username);
                rectangle.setWidth(width);
                rectangle.setHeight(height);
                rectangle.setCreatedAt(LocalDateTime.now());
                rectangle.setLastModifiedAt(LocalDateTime.now());
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
    public ShapeDto createShapeDto(Shape shape) {
        return new RectangleDto();
    }

}

