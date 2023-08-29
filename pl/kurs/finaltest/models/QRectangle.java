package pl.kurs.finaltest.generated.pl.kurs.finaltest.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import pl.kurs.finaltest.models.Rectangle;


/**
 * QRectangle is a Querydsl query type for Rectangle
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRectangle extends EntityPathBase<Rectangle> {

    private static final long serialVersionUID = 1999361954L;

    public static final QRectangle rectangle = new QRectangle("rectangle");

    public final QShape _super = new QShape(this);

    public final NumberPath<Double> area = createNumber("area", Double.class);

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Double> height = createNumber("height", Double.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.time.Instant> lastModifiedAt = _super.lastModifiedAt;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    public final NumberPath<Double> perimeter = createNumber("perimeter", Double.class);

    //inherited
    public final StringPath type = _super.type;

    //inherited
    public final NumberPath<Long> version = _super.version;

    public final NumberPath<Double> width = createNumber("width", Double.class);

    public QRectangle(String variable) {
        super(Rectangle.class, forVariable(variable));
    }

    public QRectangle(Path<? extends Rectangle> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRectangle(PathMetadata metadata) {
        super(Rectangle.class, metadata);
    }

}

