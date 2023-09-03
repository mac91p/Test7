package pl.kurs.finaltest.respositories.predicates;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import pl.kurs.finaltest.models.Shape;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class GeneralPredicate implements IShapePredicate {

    @Override
    public List<String> supportedParameters() {
        return List.of("type", "createdBy", "createAtFrom", "createdAtTo");
    }


    @Override
    public Boolean supportedParams(Map<String, String> parameters) {
        return parameters.keySet().stream()
                .anyMatch(x -> !supportedParameters().contains(x));
    }

    @Override
    public Predicate buildPredicate(Root<Shape> root, CriteriaBuilder cb, Map<String, String> queryParams) {
        List<Predicate> predicates = new ArrayList<>();

        if (queryParams.containsKey("createdBy")) {
            predicates.add(cb.equal(root.get("createdBy"), queryParams.get("createdBy")));
        }
        if (queryParams.containsKey("type")) {
            predicates.add(cb.equal(root.get("type"), queryParams.get("type")));
        }
        if (queryParams.containsKey("createdAtFrom")) {
            String createdAtFromString = queryParams.get("createdAtFrom");
            Instant createdAtFrom = Instant.parse(createdAtFromString);
            predicates.add(cb.greaterThanOrEqualTo(root.get("createdAt"), createdAtFrom));
        }
        if (queryParams.containsKey("createdAtTo")) {
            String createdAtToString = queryParams.get("createdAtTo");
            Instant createdAtTo = Instant.parse(createdAtToString);
            predicates.add(cb.greaterThanOrEqualTo(root.get("createdTo"), createdAtTo));
        }
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}

