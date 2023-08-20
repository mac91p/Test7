package pl.kurs.finaltest.generated.pl.kurs.finaltest.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import pl.kurs.finaltest.models.Shape;


/**
 * QShape is a Querydsl query type for Shape
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShape extends EntityPathBase<Shape> {

    private static final long serialVersionUID = 571902804L;

    public static final QShape shape = new QShape("shape");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath createdBy = createString("createdBy");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> lastModifiedAt = createDateTime("lastModifiedAt", java.time.LocalDateTime.class);

    public final StringPath lastModifiedBy = createString("lastModifiedBy");

    public final StringPath type = createString("type");

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QShape(String variable) {
        super(Shape.class, forVariable(variable));
    }

    public QShape(Path<? extends Shape> path) {
        super(path.getType(), path.getMetadata());
    }

    public QShape(PathMetadata metadata) {
        super(Shape.class, metadata);
    }

}

