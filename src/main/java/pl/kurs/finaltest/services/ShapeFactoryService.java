package pl.kurs.finaltest.services;

import org.springframework.stereotype.Service;
import pl.kurs.finaltest.exceptionhandling.exceptions.BadEntityException;
import pl.kurs.finaltest.models.ShapeFactory;
import java.util.List;

@Service
public class ShapeFactoryService {

    private List<ShapeFactory> shapeFactories;

    public ShapeFactoryService(List<ShapeFactory> shapeFactories) {
        this.shapeFactories = shapeFactories;
    }

    public ShapeFactory getFactory(String type) {
        return shapeFactories.stream()
                .filter(x -> x.getSupportedType().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new BadEntityException("No such entity type"));
    }

}

