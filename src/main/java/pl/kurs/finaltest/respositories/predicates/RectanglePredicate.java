package pl.kurs.finaltest.respositories.predicates;

import org.springframework.stereotype.Component;
import pl.kurs.finaltest.models.Rectangle;
import pl.kurs.finaltest.models.Shape;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class RectanglePredicate implements IShapePredicate {

    @Override
    public List<String> supportedParameters() {
        return List.of("heightFrom", "heightTo", "widthFrom", "widthTo", "areaFrom", "areaTo", "perimeterFrom", "perimeterTo");
    }


    @Override
    public Boolean supportedParams(Map<String, String> parameters) {
        return parameters.keySet().stream()
                .anyMatch(x -> !supportedParameters().contains(x));
    }

    @Override
    public Predicate buildPredicate(Root<Shape> root, CriteriaBuilder cb, Map<String, String> queryParams) {
        Root<Rectangle> rectangleRoot = cb.treat(root, Rectangle.class);
        Expression<Double> width = rectangleRoot.get("width").as(Double.class);
        Expression<Double> height = rectangleRoot.get("height").as(Double.class);
        Expression<Double> area = cb.prod(width, height);
        Expression<Double> perimeter = cb.prod(cb.literal(2.0), cb.sum(width, height));
        List<Predicate> predicates = new ArrayList<>();

        if (queryParams.containsKey("widthFrom")) {
            predicates.add(cb.greaterThanOrEqualTo(width.as(Double.class), Double.valueOf(queryParams.get("widthFrom"))));
        }
        if (queryParams.containsKey("widthTo")) {
            predicates.add(cb.lessThanOrEqualTo(width.as(Double.class), Double.valueOf(queryParams.get("widthTo"))));
        }
        if (queryParams.containsKey("heightFrom")) {
            predicates.add(cb.greaterThanOrEqualTo(height.as(Double.class), Double.valueOf(queryParams.get("heightFrom"))));
        }
        if (queryParams.containsKey("heightTo")) {
            predicates.add(cb.lessThanOrEqualTo(height.as(Double.class), Double.valueOf(queryParams.get("heightTo"))));
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


