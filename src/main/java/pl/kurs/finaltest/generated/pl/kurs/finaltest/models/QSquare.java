package pl.kurs.finaltest.generated.pl.kurs.finaltest.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import pl.kurs.finaltest.generated.pl.kurs.finaltest.models.QShape;
import pl.kurs.finaltest.models.Square;


/**
 * QSquare is a Querydsl query type for Square
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSquare extends EntityPathBase<Square> {

    private static final long serialVersionUID = 558011338L;

    public static final QSquare square = new QSquare("square");

    public final QShape _super = new QShape(this);

    public final NumberPath<Double> area = createNumber("area", Double.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedAt = _super.lastModifiedAt;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    public final NumberPath<Double> length = createNumber("length", Double.class);

    public final NumberPath<Double> perimeter = createNumber("perimeter", Double.class);

    //inherited
    public final StringPath type = _super.type;

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QSquare(String variable) {
        super(Square.class, forVariable(variable));
    }

    public QSquare(Path<? extends Square> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSquare(PathMetadata metadata) {
        super(Square.class, metadata);
    }

}

