package pl.kurs.finaltest.models;

import org.springframework.stereotype.Component;
import pl.kurs.finaltest.commands.CreateShapeCommand;
import pl.kurs.finaltest.dto.ShapeDto;
import pl.kurs.finaltest.dto.SquareDto;
import java.time.LocalDateTime;
import java.util.Locale;

@Component
public class SquareFactory implements ShapeFactory {

    @Override
    public Shape createShape(CreateShapeCommand command, String username) {
        if ("SQUARE".equalsIgnoreCase(command.getType())) {
            if (command.getParameters().size() == 1) {
                double width = command.getParameters().get(0);
                Square square = new Square();
                square.setType(command.getType().toUpperCase(Locale.ROOT));
                square.setCreatedBy(username);
                square.setLastModifiedBy(username);
                square.setLength(width);
                square.setArea(square.calculateArea());
                square.setPerimeter(square.calculatePerimeter());
                square.setCreatedAt(LocalDateTime.now());
                square.setLastModifiedAt(LocalDateTime.now());
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

    @Override
    public ShapeDto createShapeDto(Shape shape) {
        return new SquareDto();
    }

}
