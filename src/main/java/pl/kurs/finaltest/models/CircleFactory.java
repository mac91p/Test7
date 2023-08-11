package pl.kurs.finaltest.models;

import org.springframework.stereotype.Component;
import pl.kurs.finaltest.commands.CreateShapeCommand;
import pl.kurs.finaltest.dto.CircleDto;
import pl.kurs.finaltest.dto.ShapeDto;
import java.time.LocalDateTime;
import java.util.Locale;

@Component
public class CircleFactory implements ShapeFactory{
    @Override
    public Shape createShape(CreateShapeCommand command, String userName) {
        if ("CIRCLE".equalsIgnoreCase(command.getType())) {
            if (command.getParameters().size() == 1) {
                double radius = command.getParameters().get(0);
                Circle circle = new Circle();
                circle.setType(command.getType().toUpperCase(Locale.ROOT));
                circle.setCreatedBy(userName);
                circle.setLastModifiedBy(userName);
                circle.setRadius(radius);
                circle.setCreatedAt(LocalDateTime.now());
                circle.setLastModifiedAt(LocalDateTime.now());
                circle.setArea(circle.calculateArea());
                circle.setPerimeter(circle.calculatePerimeter());
                return circle;
            }
            throw new IllegalArgumentException("Invalid parameters for this shape");
        }
        return null;
    }

    @Override
    public String getSupportedType() {
        return "CIRCLE";
    }

    @Override
    public ShapeDto createShapeDto(Shape shape) {
        return new CircleDto();
    }

}
