package pl.kurs.finaltest.models;

import org.springframework.stereotype.Component;
import pl.kurs.finaltest.commands.CreateShapeCommand;
import pl.kurs.finaltest.dto.CircleDto;
import pl.kurs.finaltest.dto.ShapeDto;
import java.util.Locale;

@Component
public class CircleFactory implements IShapeFactory {


    @Override
    public Shape createShape(CreateShapeCommand command) {
        if ("CIRCLE".equalsIgnoreCase(command.getType())) {
            if (command.getParameters().size() == 1) {
                double radius = command.getParameters().get(0);
                Circle circle = new Circle();
                circle.setType(command.getType().toUpperCase(Locale.ROOT));
                circle.setRadius(radius);
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

//    @Override
//    public ShapeDto createShapeDto(Shape shape) {
//        return new CircleDto();
//    }

    @Override
    public Class<? extends ShapeDto> createShapeDto(Shape shape) {
        return CircleDto.class;
    }

}
