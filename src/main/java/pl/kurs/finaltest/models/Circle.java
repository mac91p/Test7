package pl.kurs.finaltest.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "circles")
@EntityListeners(AuditingEntityListener.class)
public class Circle extends Shape implements Serializable {

    private double radius;

    public Circle(){
    }

    public Circle(String type, String createdBy, Instant createdAt, String lastModifiedBy, Instant lastModifiedAt, double radius) {
        super(type, createdBy, createdAt, lastModifiedBy, lastModifiedAt);
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }



}
