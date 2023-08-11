package pl.kurs.finaltest.services;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.kurs.finaltest.models.Shape;
import pl.kurs.finaltest.respositories.ShapeRepository;
import pl.kurs.finaltest.respositories.specifications.ShapeSpecifications;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShapeManagementService extends AbstractGenericManagementService<Shape, ShapeRepository> {

    public ShapeManagementService(ShapeRepository repository) {
        super(repository);
    }


    public List<Shape> getAllBySpec(Specification<Shape> specification) {
        return repository.findAll(specification);
    }

    public Specification<Shape> createShapeSpecification(
            String type,
            String createdBy,
            Double areaFrom,
            Double areaTo,
            Double perimeterFrom,
            Double perimeterTo,
            Double widthFrom,
            Double widthTo,
            Double heightFrom,
            Double heightTo,
            Double radiusFrom,
            Double radiusTo,
            Double lengthFrom,
            Double lengthTo,
            LocalDateTime createdAtFrom,
            LocalDateTime createdAtTo) {

        Specification<Shape> specification = Specification.where(null);

        if (type != null) {
            specification = specification.and(ShapeSpecifications.byType(type));
        }
        if (createdBy != null) {
            specification = specification.and(ShapeSpecifications.byCreatedBy(createdBy));
        }

        if (createdAtFrom != null || createdAtTo != null) {
            specification = specification.and(ShapeSpecifications.byCreatedAt(createdAtFrom, createdAtTo));
        }

        if (areaFrom != null || areaTo != null) {
            specification = specification.and(ShapeSpecifications.byArea(areaFrom, areaTo));
        }

        if (perimeterFrom != null || perimeterTo != null) {
            specification = specification.and(ShapeSpecifications.byPerimeter(perimeterFrom, perimeterTo));
        }

        if (radiusFrom != null || radiusTo != null) {
            specification = specification.and(ShapeSpecifications.byRadius(radiusFrom,radiusTo));
        }

        if (heightFrom != null || heightTo != null) {
            specification = specification.and(ShapeSpecifications.byHeight(heightFrom,heightTo));
        }

        if (widthFrom != null || widthTo != null) {
            specification = specification.and(ShapeSpecifications.byWidth(widthFrom,widthTo));
        }

        if (lengthFrom != null || lengthTo != null) {
            specification = specification.and(ShapeSpecifications.byLength(lengthFrom,lengthTo));
        }
        return specification;
    }
}





