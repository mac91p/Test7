package pl.kurs.finaltest.respositories.predicates;

import com.querydsl.core.types.Predicate;
import java.util.List;
import java.util.Map;

public interface IShapePredicate {

    List<String> supportedParameters();
    Predicate createPredicate(Map<String, String> queryParams);

}
