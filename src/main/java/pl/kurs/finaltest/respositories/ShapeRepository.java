package pl.kurs.finaltest.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.kurs.finaltest.models.Shape;

public interface ShapeRepository extends JpaRepository<Shape, Long>, JpaSpecificationExecutor<Shape> {




}


