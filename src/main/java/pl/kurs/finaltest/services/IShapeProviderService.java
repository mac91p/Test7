package pl.kurs.finaltest.services;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import pl.kurs.finaltest.models.Shape;
import java.util.List;
import java.util.Map;

public interface IShapeProviderService {

    List<? extends Shape> getShapes(Map<String,String> queryParams, JPAQueryFactory queryFactory);
    Predicate createShapePredicate(Map<String,String> queryParams);


}
