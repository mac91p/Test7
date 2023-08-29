package pl.kurs.finaltest.services;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;
import pl.kurs.finaltest.models.*;
import pl.kurs.finaltest.models.QCircle;
import pl.kurs.finaltest.respositories.predicates.CirclePredicate;
import java.util.List;
import java.util.Map;

@Component
public class CircleProviderService implements IShapeProviderService {

    private CirclePredicate circlePredicate;

    public CircleProviderService(CirclePredicate circlePredicate) {
        this.circlePredicate = circlePredicate;
    }

    @Override
    public List<? extends Shape> getShapes(Map<String,String> queryParams, JPAQueryFactory queryFactory) {
        return queryFactory
                .selectFrom(QCircle.circle)
                .where(createShapePredicate(queryParams))
                .fetch();
    }

    @Override
    public Predicate createShapePredicate(Map<String,String> queryParams) {
        return circlePredicate.createPredicate(queryParams);
    }




}
