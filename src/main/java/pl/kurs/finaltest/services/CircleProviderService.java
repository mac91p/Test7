package pl.kurs.finaltest.services;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;
import pl.kurs.finaltest.generated.pl.kurs.finaltest.models.QCircle;
import pl.kurs.finaltest.models.Circle;
import pl.kurs.finaltest.models.ShapeParameters;
import pl.kurs.finaltest.respositories.predicates.CirclePredicate;
import java.util.List;

@Component
public class CircleProviderService implements IShapeProviderService {


    @Override
    public List<Circle> getShapes(ShapeParameters parameters, JPAQueryFactory queryFactory) {
        return queryFactory
                .selectFrom(QCircle.circle)
                .where(createShapePredicate(parameters))
                .fetch();
    }

    @Override
    public Predicate createShapePredicate(ShapeParameters parameters) {
        return CirclePredicate.createShapePredicate(parameters);
    }


}
