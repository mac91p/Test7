package pl.kurs.finaltest.respositories.predicates;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Component;
import pl.kurs.finaltest.models.QCircle;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@Component
public class CirclePredicate implements IShapePredicate {

    @Override
    public List<String> supportedParameters() {
        return List.of("radiusFrom", "radiusTo", "areFrom", "areaTo", "perimeterFrom", "perimeterTo",
                "createdBy", "createdAtFrom", "createdAtTo", "type");
    }

    @Override
    public Predicate createPredicate(Map<String, String> queryParams) {
        QCircle qCircle = QCircle.circle;
        BooleanBuilder builder = new BooleanBuilder();
        boolean hasUnsupportedParameters = queryParams.keySet().stream()
                .anyMatch(x -> !supportedParameters().contains(x));
        if (hasUnsupportedParameters) {
            return qCircle.isNull();
        } else {
            if (queryParams.containsKey("radiusFrom")) {
                builder.and(qCircle.radius.goe(Double.parseDouble(queryParams.get("radiusFrom"))));
            }
            if (queryParams.containsKey("radiusTo")) {
                builder.and(qCircle.radius.loe(Double.parseDouble(queryParams.get("radiusTo"))));
            }
            if (queryParams.containsKey("areaFrom")) {
                builder.and(qCircle.area.goe(Double.parseDouble(queryParams.get("areaFrom"))));
            }
            if (queryParams.containsKey("areaTo")) {
                builder.and(qCircle.area.loe(Double.parseDouble(queryParams.get("areaTo"))));
            }
            if (queryParams.containsKey("perimeterFrom")) {
                builder.and(qCircle.perimeter.goe(Double.parseDouble(queryParams.get("perimeterFrom"))));
            }
            if (queryParams.containsKey("perimeterTo")) {
                builder.and(qCircle.perimeter.goe(Double.parseDouble(queryParams.get("perimeterTo"))));
            }
            if (queryParams.containsKey("type")) {
                builder.and(qCircle.type.eq(queryParams.get("type")));
            }
            if (queryParams.containsKey("createdBy")) {
                builder.and(qCircle.createdBy.eq(queryParams.get("createdBy")));
            }
            if (queryParams.containsKey("createdAtFrom")) {
                String createdAtFromString = queryParams.get("createdAtFrom");
                Instant createdAtFrom = Instant.parse(createdAtFromString);
                builder.and(qCircle.createdAt.goe(createdAtFrom));
            }
            if (queryParams.containsKey("createdAtTo")) {
                String createdAtFromString = queryParams.get("createdAtTo");
                Instant createdAtFrom = Instant.parse(createdAtFromString);
                builder.and(qCircle.createdAt.goe(createdAtFrom));
            }
            return builder.getValue();
        }
    }
}


