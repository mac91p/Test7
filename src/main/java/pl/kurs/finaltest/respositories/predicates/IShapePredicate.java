package pl.kurs.finaltest.respositories.predicates;


import pl.kurs.finaltest.models.Shape;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

public interface IShapePredicate {

    List<String> supportedParameters();
    Boolean supportedParams(Map<String,String> parameters);
    Predicate buildPredicate(Root<Shape> root, CriteriaBuilder cb, Map<String,String> queryParams);

}
