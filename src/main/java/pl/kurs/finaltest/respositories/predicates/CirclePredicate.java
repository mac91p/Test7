package pl.kurs.finaltest.respositories.predicates;

import org.springframework.stereotype.Component;
import pl.kurs.finaltest.models.Circle;
import pl.kurs.finaltest.models.Shape;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CirclePredicate implements IShapePredicate {

    @Override
    public List<String> supportedParameters() {
        return List.of("radiusFrom", "radiusTo", "areaFrom", "areaTo", "perimeterFrom", "perimeterTo");
    }


    @Override
    public Boolean supportedParams(Map<String, String> parameters) {
        return parameters.keySet().stream()
                .anyMatch(x -> !supportedParameters().contains(x));
    }

    @Override
    public Predicate buildPredicate(Root<Shape> root, CriteriaBuilder cb, Map<String, String> queryParams) {
        Root<Circle> circleRoot = cb.treat(root, Circle.class);
        Expression<Double> radius = circleRoot.get("radius").as(Double.class);
        Expression<Double> area = cb.prod(cb.literal(Math.PI), cb.prod(radius, radius));
        Expression<Double> perimeter = cb.prod(cb.literal(2 * Math.PI), radius);
        List<Predicate> predicates = new ArrayList<>();

        if (queryParams.containsKey("radiusFrom")) {
            predicates.add(cb.greaterThanOrEqualTo(circleRoot.get("radius"), Double.valueOf(queryParams.get("radiusFrom"))));
        }
        if (queryParams.containsKey("radiusTo")) {
            predicates.add(cb.lessThanOrEqualTo(circleRoot.get("radius"), Double.valueOf(queryParams.get("radiusTo"))));
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



