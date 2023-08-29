package pl.kurs.finaltest.respositories.predicates;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Component;
import pl.kurs.finaltest.models.QRectangle;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@Component
public class RectanglePredicate implements IShapePredicate {

    @Override
    public List<String> supportedParameters() {
        return List.of("heightFrom", "heightTo", "widthFrom", "widthTo", "areFrom", "areaTo", "perimeterFrom", "perimeterTo",
                "createdBy", "createdAtFrom", "createdAtTo", "type");
    }

    @Override
    public Predicate createPredicate(Map<String, String> queryParams) {
        QRectangle qRectangle = QRectangle.rectangle;
        BooleanBuilder builder = new BooleanBuilder();
        boolean hasUnsupportedParameters = queryParams.keySet().stream()
                .anyMatch(x -> !supportedParameters().contains(x));
        if (hasUnsupportedParameters) {
            return qRectangle.isNull();
        } else {
            if (queryParams.containsKey("widthFrom")) {
                builder.and(qRectangle.width.goe(Double.parseDouble(queryParams.get("widthFrom"))));
            }
            if (queryParams.containsKey("widthTo")) {
                builder.and(qRectangle.width.loe(Double.parseDouble(queryParams.get("widthTo"))));
            }
            if (queryParams.containsKey("heightFrom")) {
                builder.and(qRectangle.height.goe(Double.parseDouble(queryParams.get("heightFrom"))));
            }
            if (queryParams.containsKey("heightTo")) {
                builder.and(qRectangle.height.loe(Double.parseDouble(queryParams.get("heightTo"))));
            }
            if (queryParams.containsKey("areaFrom")) {
                builder.and(qRectangle.area.goe(Double.parseDouble(queryParams.get("areaFrom"))));
            }
            if (queryParams.containsKey("areaTo")) {
                builder.and(qRectangle.area.loe(Double.parseDouble(queryParams.get("areaTo"))));
            }
            if (queryParams.containsKey("perimeterFrom")) {
                builder.and(qRectangle.perimeter.goe(Double.parseDouble(queryParams.get("perimeterFrom"))));
            }
            if (queryParams.containsKey("perimeterTo")) {
                builder.and(qRectangle.perimeter.goe(Double.parseDouble(queryParams.get("perimeterTo"))));
            }
            if (queryParams.containsKey("type")) {
                builder.and(qRectangle.type.eq(queryParams.get("type")));
            }
            if (queryParams.containsKey("createdBy")) {
                builder.and(qRectangle.createdBy.eq(queryParams.get("createdBy")));
            }
            if (queryParams.containsKey("createdAtFrom")) {
                String createdAtFromString = queryParams.get("createdAtFrom");
                Instant createdAtFrom = Instant.parse(createdAtFromString);
                builder.and(qRectangle.createdAt.goe(createdAtFrom));
            }
            if (queryParams.containsKey("createdAtTo")) {
                String createdAtFromString = queryParams.get("createdAtTo");
                Instant createdAtFrom = Instant.parse(createdAtFromString);
                builder.and(qRectangle.createdAt.loe(createdAtFrom));
            }
            return builder.getValue();
        }
    }
}

