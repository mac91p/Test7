package pl.kurs.finaltest.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "circles")
@EntityListeners(AuditingEntityListener.class)
public class Circle extends Shape implements Serializable {

    private double radius;
    private double area;
    private double perimeter;

    public Circle(){
    }

    public Circle(String type, String createdBy, Instant createdAt, String lastModifiedBy, Instant lastModifiedAt, double radius, double area, double perimeter) {
        super(type, createdBy, createdAt, lastModifiedBy, lastModifiedAt);
        this.radius = radius;
        this.area = area;
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && Double.compare(circle.area, area) == 0 && Double.compare(circle.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius, area, perimeter);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
