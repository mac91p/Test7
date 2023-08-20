package pl.kurs.finaltest.services;

import org.springframework.stereotype.Service;
import pl.kurs.finaltest.exceptionhandling.exceptions.BadEntityException;
import pl.kurs.finaltest.models.IShapeFactory;
import java.util.List;

@Service
public class ShapeFactoryService {

    private List<IShapeFactory> shapeFactories;

    public ShapeFactoryService(List<IShapeFactory> shapeFactories) {
        this.shapeFactories = shapeFactories;
    }

    public IShapeFactory getFactory(String type) {
        return shapeFactories.stream()
                .filter(x -> x.getSupportedType().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new BadEntityException("No such entity type"));
    }

}

