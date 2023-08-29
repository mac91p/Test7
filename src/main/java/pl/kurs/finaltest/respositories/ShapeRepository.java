package pl.kurs.finaltest.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.kurs.finaltest.models.Shape;



public interface ShapeRepository extends JpaRepository<Shape, Long>, QuerydslPredicateExecutor<Shape> {

}


