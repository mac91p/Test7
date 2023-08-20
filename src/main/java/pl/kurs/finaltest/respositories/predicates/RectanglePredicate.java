package pl.kurs.finaltest.respositories.predicates;

import com.querydsl.core.BooleanBuilder;
import pl.kurs.finaltest.generated.pl.kurs.finaltest.models.QRectangle;
import pl.kurs.finaltest.models.*;

public class RectanglePredicate {


    public static com.querydsl.core.types.Predicate createRectanglePredicate(ShapeParameters parameters) {
        QRectangle qRectangle = QRectangle.rectangle;
        BooleanBuilder builder = new BooleanBuilder();

        if (parameters.getHeightFrom() != null) {
            builder.and(qRectangle.height.goe(parameters.getHeightFrom()));
        }
        if (parameters.getHeightTo() != null) {
            builder.and(qRectangle.height.loe(parameters.getHeightTo()));
        }
        if (parameters.getWidthFrom() != null) {
            builder.and(qRectangle.width.goe(parameters.getWidthFrom()));
        }
        if (parameters.getWidthTo() != null) {
            builder.and(qRectangle.width.loe(parameters.getWidthTo()));
        }
        if (parameters.getAreaFrom() != null) {
            builder.and(qRectangle.area.goe(parameters.getAreaFrom()));
        }
        if (parameters.getAreaTo() != null) {
            builder.and(qRectangle.area.loe(parameters.getAreaTo()));
        }
        if (parameters.getPerimeterFrom() != null) {
            builder.and(qRectangle.perimeter.goe(parameters.getPerimeterFrom()));
        }
        if (parameters.getPerimeterTo() != null) {
            builder.and(qRectangle.perimeter.loe(parameters.getPerimeterTo()));
        }
        if (parameters.getType() != null) {
            builder.and(qRectangle.type.eq(parameters.getType()));
        }
        if (parameters.getCreatedBy() != null) {
            builder.and(qRectangle.createdBy.eq(parameters.getCreatedBy()));
        }
        if (parameters.getCreatedAtFrom() != null) {
            builder.and(qRectangle.createdAt.goe(parameters.getCreatedAtFrom()));
        }
        if (parameters.getCreatedAtTo() != null) {
            builder.and(qRectangle.createdAt.loe(parameters.getCreatedAtTo()));
        }
        return builder.getValue();
    }
}