package pl.kurs.finaltest.generated.pl.kurs.finaltest.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import pl.kurs.finaltest.models.Circle;


/**
 * QCircle is a Querydsl query type for Circle
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCircle extends EntityPathBase<Circle> {

    private static final long serialVersionUID = 92469117L;

    public static final QCircle circle = new QCircle("circle");

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

    public final NumberPath<Double> perimeter = createNumber("perimeter", Double.class);

    public final NumberPath<Double> radius = createNumber("radius", Double.class);

    //inherited
    public final StringPath type = _super.type;

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QCircle(String variable) {
        super(Circle.class, forVariable(variable));
    }

    public QCircle(Path<? extends Circle> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCircle(PathMetadata metadata) {
        super(Circle.class, metadata);
    }

}

