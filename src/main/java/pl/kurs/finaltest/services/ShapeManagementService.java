package pl.kurs.finaltest.services;

import org.springframework.stereotype.Service;
import pl.kurs.finaltest.models.*;
import pl.kurs.finaltest.respositories.ShapeRepository;
import java.util.List;
import java.util.Map;

@Service
public class ShapeManagementService extends AbstractGenericManagementService<Shape, ShapeRepository> {


    private ShapeSpecificationService shapeSpecificationService;

    public ShapeManagementService(ShapeRepository repository, ShapeSpecificationService shapeSpecificationService) {
        super(repository);
        this.shapeSpecificationService = shapeSpecificationService;
    }

    public List<Shape> getAllShapes(Map<String,String> parameters) {
        return repository.findAll(shapeSpecificationService.getCombinedSpecification(parameters));
    }

}







