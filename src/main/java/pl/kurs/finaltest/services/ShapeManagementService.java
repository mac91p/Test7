package pl.kurs.finaltest.services;


import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;
import pl.kurs.finaltest.generated.pl.kurs.finaltest.models.QCircle;
import pl.kurs.finaltest.generated.pl.kurs.finaltest.models.QRectangle;
import pl.kurs.finaltest.generated.pl.kurs.finaltest.models.QSquare;
import pl.kurs.finaltest.models.*;
import pl.kurs.finaltest.respositories.ShapeRepository;
import java.util.List;

@Service
public class ShapeManagementService extends AbstractGenericManagementService<Shape, ShapeRepository> {

    private final JPAQueryFactory queryFactory;


    public ShapeManagementService(ShapeRepository repository, JPAQueryFactory queryFactory) {
        super(repository);
        this.queryFactory = queryFactory;
    }


    public List<Circle> getCircles(Predicate predicate) {
        return  queryFactory
                .selectFrom(QCircle.circle)
                .where(predicate)
                .fetch();
    }

    public List<Square> getSquares(Predicate predicate) {
        return  queryFactory
                .selectFrom(QSquare.square)
                .where(predicate)
                .fetch();
    }

    public List<Rectangle> getRectangles(Predicate predicate) {
        return  queryFactory
                .selectFrom(QRectangle.rectangle)
                .where(predicate)
                .fetch();
    }

}







