package pl.kurs.finaltest.respositories.predicates;

import com.querydsl.core.BooleanBuilder;
import pl.kurs.finaltest.generated.pl.kurs.finaltest.models.QCircle;
import pl.kurs.finaltest.models.ShapeParameters;

public class CirclePredicate {

    public static com.querydsl.core.types.Predicate createCirclePredicate(ShapeParameters parameters) {
        QCircle qCircle = QCircle.circle;
        BooleanBuilder builder = new BooleanBuilder();

        if (parameters.getRadiusFrom() != null) {
            builder.and(qCircle.radius.goe(parameters.getRadiusFrom()));
        }
        if (parameters.getRadiusTo() != null) {
            builder.and(qCircle.radius.loe(parameters.getRadiusTo()));
        }
        if (parameters.getAreaFrom() != null) {
            builder.and(qCircle.area.goe(parameters.getAreaFrom()));
        }
        if (parameters.getAreaTo() != null) {
            builder.and(qCircle.area.loe(parameters.getAreaTo()));
        }
        if (parameters.getPerimeterFrom() != null) {
            builder.and(qCircle.perimeter.goe(parameters.getPerimeterFrom()));
        }
        if (parameters.getPerimeterTo() != null) {
            builder.and(qCircle.perimeter.loe(parameters.getPerimeterTo()));
        }
        if (parameters.getType() != null) {
            builder.and(qCircle.type.eq(parameters.getType()));
        }
        if (parameters.getCreatedBy() != null) {
            builder.and(qCircle.createdBy.eq(parameters.getCreatedBy()));
        }
        if (parameters.getCreatedAtFrom() != null) {
            builder.and(qCircle.createdAt.goe(parameters.getCreatedAtFrom()));
        }
        if (parameters.getCreatedAtTo() != null) {
            builder.and(qCircle.createdAt.loe(parameters.getCreatedAtTo()));
        }
        return builder.getValue();
    }
}

