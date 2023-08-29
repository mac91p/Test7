package pl.kurs.finaltest.services;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kurs.finaltest.models.*;
import pl.kurs.finaltest.respositories.ShapeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ShapeManagementService extends AbstractGenericManagementService<Shape, ShapeRepository> {

    private final List<IShapeProviderService> shapeProviderServices;
    private final JPAQueryFactory queryFactory;

    @Autowired
    public ShapeManagementService(ShapeRepository repository, List<IShapeProviderService> shapeProviderServices, JPAQueryFactory queryFactory) {
        super(repository);
        this.shapeProviderServices = shapeProviderServices;
        this.queryFactory = queryFactory;
    }


    public List<Shape> getAllShapes(Map<String, String> queryParams) {
        List<Shape> allShapes = new ArrayList<>();
        for (IShapeProviderService shapeProviderService : shapeProviderServices) {
            List<? extends Shape> shapes = shapeProviderService.getShapes(queryParams, queryFactory);
            allShapes.addAll(shapes);
        }
        return allShapes;
    }

}







