package pl.kurs.finaltest.services;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;
import pl.kurs.finaltest.generated.pl.kurs.finaltest.models.QSquare;
import pl.kurs.finaltest.models.ShapeParameters;
import pl.kurs.finaltest.models.Square;
import pl.kurs.finaltest.respositories.predicates.SquarePredicate;
import java.util.List;

@Component
public class SquareProviderService implements IShapeProviderService{

    @Override
    public List<Square> getShapes(ShapeParameters parameters, JPAQueryFactory queryFactory) {
        return queryFactory
                .selectFrom(QSquare.square)
                .where(createShapePredicate(parameters))
                .fetch();
    }

    @Override
    public Predicate createShapePredicate(ShapeParameters parameters) {
        return SquarePredicate.createShapePredicate(parameters);
    }





}
