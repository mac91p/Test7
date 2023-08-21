package pl.kurs.finaltest.services;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;
import pl.kurs.finaltest.generated.pl.kurs.finaltest.models.QRectangle;
import pl.kurs.finaltest.models.Rectangle;
import pl.kurs.finaltest.models.ShapeParameters;
import pl.kurs.finaltest.respositories.predicates.RectanglePredicate;
import java.util.List;

@Component
public class RectangleProviderService implements IShapeProviderService{

    @Override
    public List<Rectangle> getShapes(ShapeParameters parameters, JPAQueryFactory queryFactory) {
        return queryFactory
                .selectFrom(QRectangle.rectangle)
                .where(createShapePredicate(parameters))
                .fetch();
    }

    @Override
    public Predicate createShapePredicate(ShapeParameters parameters) {
        return RectanglePredicate.createRectanglePredicate(parameters);
    }



}
