package pl.kurs.finaltest.services;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import pl.kurs.finaltest.models.Shape;
import pl.kurs.finaltest.models.ShapeParameters;
import java.util.List;

public interface IShapeProviderService {

    List<? extends Shape> getShapes(ShapeParameters parameters, JPAQueryFactory queryFactory);
    Predicate createShapePredicate(ShapeParameters parameters);

}
