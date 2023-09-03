package pl.kurs.finaltest.services;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.kurs.finaltest.models.Shape;
import pl.kurs.finaltest.respositories.predicates.IShapePredicate;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ShapeSpecificationService {

    private final List<IShapePredicate> shapePredicates;


    public ShapeSpecificationService(List<IShapePredicate> shapePredicates) {
        this.shapePredicates = shapePredicates;
    }

    public Specification<Shape> getCombinedSpecification(Map<String, String> queryParams) {
        return ((root, query, cb) -> {
            List<Predicate> orPredicates = new ArrayList<>();
            for (IShapePredicate shapePredicate : shapePredicates) {
                if (!shapePredicate.supportedParams(queryParams)) {
                    Predicate buildPredicate = shapePredicate.buildPredicate(root, cb, queryParams);
                    orPredicates.add(buildPredicate);
                }
            }
            return cb.or(orPredicates.toArray(new Predicate[0]));
        });
    }


}







