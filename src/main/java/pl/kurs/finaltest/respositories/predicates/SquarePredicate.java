package pl.kurs.finaltest.respositories.predicates;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Component;
import pl.kurs.finaltest.models.QSquare;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@Component
public class SquarePredicate implements IShapePredicate {

    @Override
    public List<String> supportedParameters() {
        return List.of("lengthFrom", "lengthTo", "areFrom", "areaTo", "perimeterFrom", "perimeterTo",
                "createdBy", "createdAtFrom", "createdAtTo", "type");
    }

    @Override
    public Predicate createPredicate(Map<String, String> queryParams) {
        QSquare qSquare = QSquare.square;
        BooleanBuilder builder = new BooleanBuilder();
        boolean hasUnsupportedParameters = queryParams.keySet().stream()
                .anyMatch(x -> !supportedParameters().contains(x));
        if (hasUnsupportedParameters) {
            return qSquare.isNull();
        } else {

            if (queryParams.containsKey("lengthFrom")) {
                builder.and(qSquare.length.goe(Double.parseDouble(queryParams.get("lengthFrom"))));
            }
            if (queryParams.containsKey("lengthTo")) {
                builder.and(qSquare.length.loe(Double.parseDouble(queryParams.get("lengthTo"))));
            }
            if (queryParams.containsKey("areaFrom")) {
                builder.and(qSquare.area.goe(Double.parseDouble(queryParams.get("areaFrom"))));
            }
            if (queryParams.containsKey("areaTo")) {
                builder.and(qSquare.area.loe(Double.parseDouble(queryParams.get("areaTo"))));
            }
            if (queryParams.containsKey("perimeterFrom")) {
                builder.and(qSquare.perimeter.goe(Double.parseDouble(queryParams.get("perimeterFrom"))));
            }
            if (queryParams.containsKey("perimeterTo")) {
                builder.and(qSquare.perimeter.goe(Double.parseDouble(queryParams.get("perimeterTo"))));
            }
            if (queryParams.containsKey("type")) {
                builder.and(qSquare.type.eq(queryParams.get("type")));
            }
            if (queryParams.containsKey("createdBy")) {
                builder.and(qSquare.createdBy.eq(queryParams.get("createdBy")));
            }
            if (queryParams.containsKey("createdAtFrom")) {
                String createdAtFromString = queryParams.get("createdAtFrom");
                Instant createdAtFrom = Instant.parse(createdAtFromString);
                builder.and(qSquare.createdAt.goe(createdAtFrom));
            }
            if (queryParams.containsKey("createdAtTo")) {
                String createdAtFromString = queryParams.get("createdAtTo");
                Instant createdAtFrom = Instant.parse(createdAtFromString);
                builder.and(qSquare.createdAt.loe(createdAtFrom));
            }
            return builder.getValue();
        }
    }
}