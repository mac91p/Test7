package pl.kurs.finaltest.services;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;
import pl.kurs.finaltest.models.QRectangle;
import pl.kurs.finaltest.models.Rectangle;
import pl.kurs.finaltest.respositories.predicates.RectanglePredicate;
import java.util.List;
import java.util.Map;

@Component
public class RectangleProviderService implements IShapeProviderService{

    private RectanglePredicate rectanglePredicate;

    public RectangleProviderService(RectanglePredicate rectanglePredicate) {
        this.rectanglePredicate = rectanglePredicate;
    }

    @Override
    public List<Rectangle> getShapes(Map<String,String> queryParams, JPAQueryFactory queryFactory) {
        return queryFactory
                .selectFrom(QRectangle.rectangle)
                .where(createShapePredicate(queryParams))
                .fetch();
    }

    @Override
    public Predicate createShapePredicate(Map<String,String> queryParams) {
        return rectanglePredicate.createPredicate(queryParams);
    }


}
