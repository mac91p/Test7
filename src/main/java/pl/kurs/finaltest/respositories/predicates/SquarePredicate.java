package pl.kurs.finaltest.respositories.predicates;

import com.querydsl.core.BooleanBuilder;
import pl.kurs.finaltest.generated.pl.kurs.finaltest.models.QSquare;
import pl.kurs.finaltest.models.*;

public class SquarePredicate {

    public static com.querydsl.core.types.Predicate createSquarePredicate(ShapeParameters parameters) {
        QSquare qqSquare = QSquare.square;
        BooleanBuilder builder = new BooleanBuilder();

        if (parameters.getLengthFrom() != null) {
            builder.and(qqSquare.length.goe(parameters.getLengthFrom()));
        }
        if (parameters.getLengthTo() != null) {
            builder.and(qqSquare.length.loe(parameters.getLengthTo()));
        }
        if (parameters.getAreaFrom() != null) {
            builder.and(qqSquare.area.goe(parameters.getAreaFrom()));
        }
        if (parameters.getAreaTo() != null) {
            builder.and(qqSquare.area.loe(parameters.getAreaTo()));
        }
        if (parameters.getPerimeterFrom() != null) {
            builder.and(qqSquare.perimeter.goe(parameters.getPerimeterFrom()));
        }
        if (parameters.getPerimeterTo() != null) {
            builder.and(qqSquare.perimeter.loe(parameters.getPerimeterTo()));
        }
        if (parameters.getType() != null) {
            builder.and(qqSquare.type.eq(parameters.getType()));
        }
        if (parameters.getCreatedBy() != null) {
            builder.and(qqSquare.createdBy.eq(parameters.getCreatedBy()));
        }
        if (parameters.getCreatedAtFrom() != null) {
            builder.and(qqSquare.createdAt.goe(parameters.getCreatedAtFrom()));
        }
        if (parameters.getCreatedAtTo() != null) {
            builder.and(qqSquare.createdAt.loe(parameters.getCreatedAtTo()));
        }
        return builder.getValue();
    }
}