package pl.kurs.finaltest.services;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;
import pl.kurs.finaltest.models.QSquare;
import pl.kurs.finaltest.models.Square;
import pl.kurs.finaltest.respositories.predicates.SquarePredicate;
import java.util.List;
import java.util.Map;

@Component
public class SquareProviderService implements IShapeProviderService{

    private final SquarePredicate squarePredicate;

    public SquareProviderService(SquarePredicate squarePredicate) {
        this.squarePredicate = squarePredicate;
    }

    @Override
    public List<Square> getShapes(Map<String,String> queryParams, JPAQueryFactory queryFactory) {
        return queryFactory
                .selectFrom(QSquare.square)
                .where(createShapePredicate(queryParams))
                .fetch();
    }

    @Override
    public Predicate createShapePredicate(Map<String,String> queryParams) {
        return squarePredicate.createPredicate(queryParams);
    }



}
