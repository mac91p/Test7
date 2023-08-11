package pl.kurs.finaltest.models;

import pl.kurs.finaltest.commands.CreateShapeCommand;
import pl.kurs.finaltest.dto.ShapeDto;


public interface ShapeFactory {

    Shape createShape(CreateShapeCommand command, String userName);
    String getSupportedType();
    ShapeDto createShapeDto(Shape shape);

}
