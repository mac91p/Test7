package pl.kurs.finaltest.respositories.predicates;

import org.springframework.stereotype.Component;
import pl.kurs.finaltest.models.Shape;
import pl.kurs.finaltest.models.Square;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class SquarePredicate implements IShapePredicate {

    @Override
    public List<String> supportedParameters() {
        return List.of("lengthFrom", "lengthTo", "areaFrom", "areaTo", "perimeterFrom", "perimeterTo");
    }

    @Override
    public Boolean supportedParams(Map<String, String> parameters) {
        return parameters.keySet().stream()
                .anyMatch(x -> !supportedParameters().contains(x));
    }

    @Override
    public Predicate buildPredicate(Root<Shape> root, CriteriaBuilder cb, Map<String, String> queryParams) {
        Root<Square> squareRoot = cb.treat(root, Square.class);
        Expression<Double> length = squareRoot.get("length").as(Double.class);
        Expression<Double> area = cb.prod(length, length);
        Expression<Double> perimeter = cb.prod(cb.literal(4.0), length);
        List<Predicate> predicates = new ArrayList<>();

        if (queryParams.containsKey("lengthFrom")) {
            predicates.add(cb.greaterThanOrEqualTo(squareRoot.get("length"), Double.valueOf(queryParams.get("lengthFrom"))));
        }
        if (queryParams.containsKey("lengthTo")) {
            predicates.add(cb.lessThanOrEqualTo(squareRoot.get("length"), Double.valueOf(queryParams.get("lengthTo"))));
        }
        if (queryParams.containsKey("areaFrom")) {
            predicates.add(cb.greaterThanOrEqualTo(area.as(Double.class), Double.valueOf(queryParams.get("areaFrom"))));
        }
        if (queryParams.containsKey("areaTo")) {
            predicates.add(cb.lessThanOrEqualTo(area.as(Double.class), Double.valueOf(queryParams.get("areaTo"))));
        }
        if (queryParams.containsKey("perimeterFrom")) {
            predicates.add(cb.greaterThanOrEqualTo(perimeter.as(Double.class), Double.valueOf(queryParams.get("perimeterFrom"))));
        }
        if (queryParams.containsKey("perimeterTo")) {
            predicates.add(cb.lessThanOrEqualTo(perimeter.as(Double.class), Double.valueOf(queryParams.get("perimeterTo"))));
        }
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
