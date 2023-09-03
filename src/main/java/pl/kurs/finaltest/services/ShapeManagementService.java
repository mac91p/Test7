package pl.kurs.finaltest.services;

import org.springframework.stereotype.Service;
import pl.kurs.finaltest.models.*;
import pl.kurs.finaltest.respositories.ShapeRepository;
import pl.kurs.finaltest.respositories.predicates.IShapePredicate;
import java.util.List;
import java.util.Map;

@Service
public class ShapeManagementService extends AbstractGenericManagementService<Shape, ShapeRepository> {


    private final List<IShapePredicate> shapePredicates;
    private ShapeSpecificationService shapeSpecificationService;

    public ShapeManagementService(ShapeRepository repository, List<IShapePredicate> shapePredicates, ShapeSpecificationService shapeSpecificationService) {
        super(repository);
        this.shapePredicates = shapePredicates;
        this.shapeSpecificationService = shapeSpecificationService;
    }

    public List<Shape> getAllShapes(Map<String,String> parameters) {
        return repository.findAll(shapeSpecificationService.getCombinedSpecification(parameters));
    }

}







