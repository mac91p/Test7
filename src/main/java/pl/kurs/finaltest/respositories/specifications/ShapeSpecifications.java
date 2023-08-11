package pl.kurs.finaltest.respositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import pl.kurs.finaltest.models.Circle;
import pl.kurs.finaltest.models.Rectangle;
import pl.kurs.finaltest.models.Shape;
import pl.kurs.finaltest.models.Square;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShapeSpecifications {


    public static Specification<Shape> byCreatedBy(String createdBy) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("createdBy"), createdBy);
    }

    public static Specification<Shape> byType(String type) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("type"), type);
    }

    public static Specification<Shape> byRadius(Double from, Double to) {
        return (root, query, criteriaBuilder) -> {
            Root<Circle> circleRoot = criteriaBuilder.treat(root, Circle.class);
            Predicate radiusPredicate = createSpecificationForRange(from, to, "radius", circleRoot)
                    .toPredicate(root, query, criteriaBuilder);
            if (radiusPredicate != null) {
                query.distinct(true);
                return radiusPredicate;
            } else {
                return null;
            }
        };
    }

    public static Specification<Shape> byHeight(Double from, Double to) {
        return (root, query, criteriaBuilder) -> {
            Root<Rectangle> rectangleRoot = criteriaBuilder.treat(root, Rectangle.class);
            Predicate heightPredicate = createSpecificationForRange(from, to, "height", rectangleRoot)
                    .toPredicate(root, query, criteriaBuilder);
            if (heightPredicate != null) {
                query.distinct(true);
                return heightPredicate;
            } else {
                return null;
            }
        };
    }

    public static Specification<Shape> byLength(Double from, Double to) {
        return (root, query, criteriaBuilder) -> {
            Root<Square> squareRoot = criteriaBuilder.treat(root, Square.class);
            Predicate widthPredicate = createSpecificationForRange(from, to, "length", squareRoot)
                    .toPredicate(root, query, criteriaBuilder);
            if (widthPredicate != null) {
                query.distinct(true);
                return widthPredicate;
            } else {
                return null;
            }
        };
    }

    public static Specification<Shape> byWidth(Double from, Double to) {
        return (root, query, criteriaBuilder) -> {
            Root<Rectangle> rectangleRoot = criteriaBuilder.treat(root, Rectangle.class);
            Predicate widthPredicate = createSpecificationForRange(from, to, "width", rectangleRoot)
                    .toPredicate(root, query, criteriaBuilder);
            if (widthPredicate != null) {
                query.distinct(true);
                return widthPredicate;
            } else {
                return null;
            }
        };
    }

    public static Specification<Shape> byArea(Double from, Double to) {
        return (root, query, criteriaBuilder) ->
                createSpecificationForRange(from, to, "area", root)
                        .toPredicate(root, query, criteriaBuilder);
    }

    public static Specification<Shape> byPerimeter(Double from, Double to) {
        return (root, query, criteriaBuilder) ->
                createSpecificationForRange(from, to, "perimeter", root)
                        .toPredicate(root, query, criteriaBuilder);
    }

    public static Specification<Shape> byCreatedAt(LocalDateTime from, LocalDateTime to) {
        return (root, query, criteriaBuilder) ->
                createSpecificationForRange(from, to, "createdAt", root)
                        .toPredicate(root, query, criteriaBuilder);
    }

    private static <T extends Comparable<? super T>> Specification<Shape> createSpecificationForRange(
            T from,
            T to,
            String paramName,
            Root<? extends Shape> shapeRoot) {
        return (root, query, criteriaBuilder) -> {
            ;
            List<Predicate> predicates = new ArrayList<>();
            if (from != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(shapeRoot.get(paramName), from));
            }
            if (to != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(shapeRoot.get(paramName), to));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
